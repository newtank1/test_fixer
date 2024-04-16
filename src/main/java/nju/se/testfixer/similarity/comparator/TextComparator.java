package nju.se.testfixer.similarity.comparator;

import nju.se.testfixer.similarity.node.Node;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class TextComparator {
    public double compare(Node old, Node neu) {
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        String oldTextContent = old.getTextContent();
        String neuTextContent = neu.getTextContent();
        if (StringUtils.isAllEmpty(oldTextContent, neuTextContent)) return 0;
        if (oldTextContent.equals(neuTextContent)) return 1;
        return 1.0 / levenshteinDistance.apply(oldTextContent, neuTextContent);
    }

}
