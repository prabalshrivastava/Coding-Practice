package scaler.advancedDsa.trees4;

import scaler.module1.trees.HWQ1IdenticalBinaryTrees;
import scaler.module1.trees.TreeNode;

public class HWQ3IdenticalBinaryTrees {
    //    Problem Description
//    Given two binary trees, check if they are equal or not.
//    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
//            Problem Constraints
//1 <= number of nodes <= 105
//    Input Format
//    The first argument is a root node of the first tree, A.
//    The second argument is a root node of the second tree, B.
//            Output Format
//    Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
//            Example Input
//    Input 1:
//            1       1
//            / \     / \
//            2   3   2   3
//    Input 2:
//            1       1
//            / \     / \
//            2   3   3   3
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    Both trees are structurally identical and the nodes have the same value.
//    Explanation 2:
//    Values of the left child of the root node of the trees are different.

    public int isSameTree(TreeNode A, TreeNode B) {
        return isSame(A, B) ? 1 : 0;
    }

    boolean isSame(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;
        if (A == null || B == null)
            return false;
        if (A.val == B.val)
            return isSame(A.left, B.left) && isSame(A.right, B.right);
        else
            return false;
    }

    public static void main(String[] args) {
        TreeNode treeNodeA1 = new TreeNode(1);
        treeNodeA1.left = new TreeNode(2);
        treeNodeA1.right = new TreeNode(3);
        TreeNode treeNodeB1 = new TreeNode(1);
        treeNodeB1.left = new TreeNode(2);
        treeNodeB1.right = new TreeNode(3);
        System.out.println(new HWQ1IdenticalBinaryTrees().isSameTree(treeNodeA1, treeNodeB1));

        TreeNode treeNodeA2 = new TreeNode(1);
        treeNodeA2.left = new TreeNode(2);
        treeNodeA2.right = new TreeNode(3);
        TreeNode treeNodeB2 = new TreeNode(1);
        treeNodeB2.left = new TreeNode(3);
        treeNodeB2.right = new TreeNode(3);
        System.out.println(new HWQ1IdenticalBinaryTrees().isSameTree(treeNodeA2, treeNodeB2));

        TreeNode treeNodeA3 = new TreeNode(5);
        treeNodeA3.left = new TreeNode(5);
        treeNodeA3.right = new TreeNode(10);
        TreeNode treeNodeB3 = new TreeNode(3);
        treeNodeB3.left = new TreeNode(5);
        System.out.println(new HWQ1IdenticalBinaryTrees().isSameTree(treeNodeA3, treeNodeB3));
    }
}
