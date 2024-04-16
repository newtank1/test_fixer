package nju.se.testfixer.similarity.node;


import java.util.ArrayList;
import java.util.List;

public class NodeUtils {

    public static List<Node> flatNodes(Node node) {
        List<Node> nodes = new ArrayList<>();
        List<Node> childNodes = node.getChildNodes();
        for (Node childNode : childNodes) {
            if (childNode == null) continue;
            nodes.add(childNode);
            nodes.addAll(flatNodes(childNode));
        }

        return nodes;
    }

    public static int getDepth(Node node) {
        int depth = 0;
        while (node != null && node.getParent() != null) {
            node = node.getParent();
            depth++;
        }
        return depth;
    }

    public static boolean isNonLeaf(Node node) {
        return node != null && !node.getChildNodes().isEmpty();
    }
}
