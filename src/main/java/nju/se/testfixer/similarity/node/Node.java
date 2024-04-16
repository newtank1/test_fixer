package nju.se.testfixer.similarity.node;

import lombok.Data;
import lombok.ToString;

import java.util.*;

@Data
@ToString(of = {"node_id", "label", "textContent"})
public class Node {

    private Map<String, String> attributes = new HashMap<>();

    private String textContent;

    private List<Node> childNodes = new ArrayList<>();

    private Node parent;

    private String label;

    private String node_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(getLabel(), node.getLabel()) && Objects.equals(getNode_id(), node.getNode_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel(), getNode_id());
    }
}
