package nju.se.testfixer.similarity.node.parser;

import nju.se.testfixer.harmony.HypiumElement;
import nju.se.testfixer.similarity.node.Node;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JSONParser {

    public Node parseJSON(HypiumElement element) {
        if (element == null) return null;
        Node node = new Node();
        Map<String, String> elementAttributes = element.getAttributes();
        String text = elementAttributes.get("text");
        node.setTextContent(text);
        List<Node> children = element.getChildren().stream().map(this::parseJSON).peek(n -> n.setParent(node)).collect(Collectors.toList());
        node.setChildNodes(children);
        node.setAttributes(elementAttributes);
        node.setLabel(element.getLabel());
        node.setNode_id(element.getNode_id());
        return node;
    }
}
