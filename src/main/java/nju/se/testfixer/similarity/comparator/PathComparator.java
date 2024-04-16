package nju.se.testfixer.similarity.comparator;

import nju.se.testfixer.similarity.node.Node;

import java.util.Map;

import static nju.se.testfixer.similarity.node.NodeUtils.getDepth;


public class PathComparator {

    public double compare(Node old, Node neu, Map<Node, Node> workingMatchResult) {
        Node deepestMatchedOld = old;
        while (deepestMatchedOld != null && deepestMatchedOld.getParent() != null) {
            if (workingMatchResult.containsKey(deepestMatchedOld)) {
                Node deepestMatchedNew = workingMatchResult.get(deepestMatchedOld);
                return Math.min(getDepth(deepestMatchedOld) * 1.0 / getDepth(old), getDepth(deepestMatchedNew) * 1.0 / getDepth(neu));
            }
            deepestMatchedOld = deepestMatchedOld.getParent();
        }
        return 0;
    }


}
