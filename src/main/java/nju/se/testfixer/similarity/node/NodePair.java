package nju.se.testfixer.similarity.node;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Objects;

public class NodePair {
    ImmutablePair<Node, Node> pair;

    public NodePair(Node left, Node right) {
        pair = new ImmutablePair<>(left, right);
    }

    public String toString() {
        return String.format("%s -> %s", pair.left, pair.right);
    }

    public Node getKey() {
        return pair.getKey();
    }

    public Node getValue() {
        return pair.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodePair xmlPair = (NodePair) o;
        return Objects.equals(pair, xmlPair.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pair);
    }
}
