package scaler.advancedDsa.trees5;

public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;

    public TreeLinkNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "T(" +
                val +
                ')';
    }
}