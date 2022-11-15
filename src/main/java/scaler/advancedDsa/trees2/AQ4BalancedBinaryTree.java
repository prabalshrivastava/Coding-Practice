package scaler.advancedDsa.trees2;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.Arrays;

public class AQ4BalancedBinaryTree {
    //    Problem Description
//    Given a root of binary tree A, determine if it is height-balanced.
//    A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//    Problem Constraints
//1 <= size of tree <= 100000
//    Input Format
//    First and only argument is the root of the tree A.
//            Output Format
//    Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
//            Example Input
//    Input 1:
//            1
//            / \
//            2   3
//    Input 2:
//            1
//            /
//            2
//            /
//            3
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    It is a complete binary tree.
//    Explanation 2:
//    Because for the root node, left subtree has depth 2 and right subtree has depth 0.
//    Difference = 2 > 1.
    public static void main(String[] args) {
        int[] input1 = {8262, -1, 411, -1, -1};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input1))));//false - 0

        int[] input2 = {6, 3, 7, 2, 5, -1, 9, -1, -1, -1, -1, -1, -1};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input2))));//false - 0

        int[] input3 = {1, 3, 7, 2, -1, -1, 9, -1, -1, -1, -1};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input3))));//false - 0

        int[] input4 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input4))));//true - 1

        int[] input5 = {1, 2, 3, -1, 4, -1, -1, -1, 5};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input5))));//false - 0

        int[] input6 = {1, 2, 3};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input6))));//true - 1

        int[] input7 = {1, 2, -1, 3};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input7))));//false - 0
    }

    public int isBalanced(TreeNode A) {
        int leftDepth = depthOfDifference(A.left);
        int rightDepth = depthOfDifference(A.right);
        return leftDepth;
    }

    private int depthOfDifference(TreeNode A) {
        if (A == null)
            return -1;
        int leftDepth = depthOfDifference(A.left);
        int rightDepth = depthOfDifference(A.right);
        return Math.abs(leftDepth - rightDepth);
    }
}
