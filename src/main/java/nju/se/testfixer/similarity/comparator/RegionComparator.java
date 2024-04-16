package nju.se.testfixer.similarity.comparator;

import nju.se.testfixer.similarity.node.Node;

import java.util.List;
import java.util.Map;

public class RegionComparator {

    public double compare(Node old, Node neu, Map<Node, Node> workingMatchResult) {
        List<Node> oldChildNodes = old.getChildNodes();
        List<Node> neuChildNodes = neu.getChildNodes();
        int matchedCount = 0;
        for (Node oldChild : oldChildNodes) {
            for (Node newChild : neuChildNodes) {
                if (newChild.equals(workingMatchResult.getOrDefault(oldChild, null))) {
                    matchedCount++;
                    break;
                }
            }
        }
        return matchedCount * 1.0 / Math.max(oldChildNodes.size(), neuChildNodes.size());
    }
}
