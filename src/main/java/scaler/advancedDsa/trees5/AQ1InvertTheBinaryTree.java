package scaler.advancedDsa.trees5;

import scaler.advancedDsa.trees4.HWQ1CommonNodesInTwoBST;
import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

public class AQ1InvertTheBinaryTree {
//    Problem Description
//    Given a binary tree A, invert the binary tree and return it.
//    Inverting refers to making the left child the right child and vice versa.
//            Problem Constraints
//1 <= size of tree <= 100000
//    Input Format
//    First and only argument is the head of the tree A.
//            Output Format
//    Return the head of the inverted tree.
//            Example Input
//    Input 1:
//            1
//            /   \
//            2     3
//    Input 2:
//            1
//            /   \
//            2     3
//            / \   / \
//            4   5 6   7
//    Example Output
//    Output 1:
//            1
//            /   \
//            3     2
//    Output 2:
//            1
//            /   \
//            3     2
//            / \   / \
//            7   6 5   4
//    Example Explanation
//    Explanation 1:
//    Tree has been inverted.
//    Explanation 2:
//    Tree has been inverted.

    public static void main(String[] args) {
        int[] input1A = {1, 2, 3};
        System.out.println(new AQ1InvertTheBinaryTree().invertTree(TreeUtils.mapArrayToTree(input1A)));

        int[] input2A = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new AQ1InvertTheBinaryTree().invertTree(TreeUtils.mapArrayToTree(input2A)));
    }

    public TreeNode invertTree(TreeNode A) {
        return postOrder(A);
    }

    private TreeNode postOrder(TreeNode A) {
        if (A == null)
            return null;
        postOrder(A.left);
        postOrder(A.right);
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
        return A;
    }
}
