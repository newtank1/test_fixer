package nju.se.testfixer.similarity;

import nju.se.testfixer.similarity.node.Node;

import java.util.Objects;

public class SimilarityResult {
    Node from;

    Node to;

    double similarity;

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }

    public SimilarityResult(Node from, Node to, double similarity) {
        this.from = from;
        this.to = to;
        this.similarity = similarity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimilarityResult that = (SimilarityResult) o;
        return Double.compare(that.getSimilarity(), getSimilarity()) == 0 && Objects.equals(getFrom(), that.getFrom()) && Objects.equals(getTo(), that.getTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFrom(), getTo(), getSimilarity());
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", from, to);
    }
}
