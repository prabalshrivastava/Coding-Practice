package scaler.module1.trees;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" + val +
                '}';
    }
}