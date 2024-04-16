package nju.se.testfixer.similarity.comparator;

import nju.se.testfixer.similarity.node.Node;

import java.util.Map;


public class PropComparator {
    public double compare(Node old, Node neu) {
        if (!old.getLabel().equals(neu.getLabel())) return 0;
        Map<String, String> oldAttributes = old.getAttributes();
        Map<String, String> newAttributes = neu.getAttributes();
        if (oldAttributes == null || newAttributes == null) {
            return 0;
        }
        int total = Math.min(oldAttributes.size(), newAttributes.size());
        if (total == 0) return 0;
        int sameCount = 0;
        for (Map.Entry<String, String> oldAttribute : oldAttributes.entrySet()) {
            String oldAttributeNodeName = oldAttribute.getKey();
            String oldAttributeNodeValue = oldAttribute.getValue();
            for (Map.Entry<String, String> newAttribute : newAttributes.entrySet()) {
                String newAttributeNodeName = newAttribute.getKey();
                String newAttributeNodeValue = newAttribute.getValue();
                if (oldAttributeNodeName.equals(newAttributeNodeName) && oldAttributeNodeValue.equals(newAttributeNodeValue)) {
                    sameCount++;
                    break;
                }
            }
        }
        return sameCount * 1.0 / total;
    }
}
