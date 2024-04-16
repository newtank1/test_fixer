package nju.se.testfixer.similarity;

import nju.se.testfixer.similarity.comparator.PathComparator;
import nju.se.testfixer.similarity.comparator.PropComparator;
import nju.se.testfixer.similarity.comparator.RegionComparator;
import nju.se.testfixer.similarity.comparator.TextComparator;
import nju.se.testfixer.similarity.node.Node;
import nju.se.testfixer.similarity.node.NodePair;
import nju.se.testfixer.similarity.node.NodeUtils;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.util.*;

import static nju.se.testfixer.similarity.node.NodeUtils.isNonLeaf;

public class NodeComparator {

    TextComparator textComparator = new TextComparator();

    PropComparator propComparator = new PropComparator();

    PathComparator pathComparator = new PathComparator();

    RegionComparator regionComparator = new RegionComparator();

    double alpha = 0.8;

    double beta = 0.5;

    double gamma = 0.5;

    double threshold = 0.7;

    public Map<Node, Node> matchElements(Node old, Node neu, int iteration) {
        List<Node> oldNodes = NodeUtils.flatNodes(old);
        List<Node> newNodes = NodeUtils.flatNodes(neu);

        Map<Node, Node> matchResult = new HashMap<>();
        Map<NodePair, SimilarityResult> initialSimilarityMap = new HashMap<>();
        //initial
        for (Node oldNode : new ArrayList<>(oldNodes)) {
            for (Node newNode : new ArrayList<>(newNodes)) {
                Optional<String> oldId = Optional.ofNullable(oldNode.getNode_id());
                Optional<String> newId = Optional.ofNullable(newNode.getNode_id());
                if (oldId.isPresent() && oldId.equals(newId)) {
                    matchResult.put(oldNode, newNode);
                    oldNodes.remove(oldNode);
                    newNodes.remove(newNode);
                    break;
                }
                double initialSimilarity = alpha * propComparator.compare(oldNode, newNode) + textComparator.compare(oldNode, newNode);
                initialSimilarityMap.put(new NodePair(oldNode, newNode), new SimilarityResult(oldNode, newNode, initialSimilarity));
            }
        }

        //iterate
        Map<Node, Node> workingMatchResult = new HashMap<>(matchResult);
        for (int it = 0; it < iteration; it++) {
            MultiValuedMap<Node, SimilarityResult> similarityMap = new HashSetValuedHashMap<>();
            //update similarity
            for (Node oldNode : oldNodes) {
                for (Node newNode : newNodes) {
                    NodePair pair = new NodePair(oldNode, newNode);
                    double initialSimilarity = initialSimilarityMap.get(pair).getSimilarity();
                    double similarity = initialSimilarity + beta * pathComparator.compare(oldNode, newNode, workingMatchResult);
                    if (isNonLeaf(oldNode) && isNonLeaf(newNode)) {
                        similarity += gamma * regionComparator.compare(oldNode, newNode, workingMatchResult);
                    }
                    similarityMap.put(oldNode, new SimilarityResult(oldNode, newNode, similarity));
                }
            }

            //update matching result
            for (Map.Entry<Node, Collection<SimilarityResult>> entry : similarityMap.asMap().entrySet()) {
                Node oldNode = entry.getKey();
                List<SimilarityResult> similarityResults = new ArrayList<>(entry.getValue());
                if (similarityResults.isEmpty()) continue;
                similarityResults.sort(Comparator.comparingDouble(SimilarityResult::getSimilarity).reversed());
                SimilarityResult similarity = similarityResults.get(0);
                if (similarity.getSimilarity() > threshold) {
                    workingMatchResult.put(oldNode, similarity.getTo());
                }
            }
        }
        return workingMatchResult;
    }

}
