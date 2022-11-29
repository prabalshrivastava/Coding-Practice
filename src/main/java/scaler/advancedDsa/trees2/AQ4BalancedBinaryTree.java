package scaler.advancedDsa.trees2;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println(new AQ4BalancedBinaryTree().isBalanced(TreeUtils.mapArrayToTree(input1)));//false - 0

        int[] input2 = {6, 3, 7, 2, 5, -1, 9, -1, -1, -1, -1, -1, -1};
        System.out.println(new AQ4BalancedBinaryTree().isBalanced(TreeUtils.mapArrayToTree(input2)));//false - 0

        int[] input3 = {1, 3, 7, 2, -1, -1, 9, -1, -1, -1, -1};
        System.out.println(new AQ4BalancedBinaryTree().isBalanced(TreeUtils.mapArrayToTree(input3)));//false - 0

        int[] input4 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(new AQ4BalancedBinaryTree().isBalanced(TreeUtils.mapArrayToTree(input4)));//true - 1

        int[] input5 = {1, 2, 3, -1, 4, -1, -1, -1, 5};
        System.out.println(new AQ4BalancedBinaryTree().isBalanced(TreeUtils.mapArrayToTree(input5)));//false - 0

        int[] input6 = {1, 2, 3};
        System.out.println(new AQ4BalancedBinaryTree().isBalanced(TreeUtils.mapArrayToTree(input6)));//true - 1

        int[] input7 = {1, 2, -1, 3};
        System.out.println(new AQ4BalancedBinaryTree().isBalanced(TreeUtils.mapArrayToTree(input7)));//false - 0

        int[] input8 = {135, 17, 28, 44, 48, -1, 12, 58, 7, 6, 23, 64, 20, 37, 45, 26, 36, 18, 27, -1, -1, 46, 54, -1, 56, 14, -1, -1, 47, 50, 67, -1, 2, 35, -1, -1, 60, 41, -1, -1, 10, 24, -1, 63, 61, 40, -1, -1, 4, 59, 1, -1, 29, -1, 52, 9, 21, 15, 33, -1, -1, -1, 55, -1, -1, -1, -1, 11, 38, 32, -1, -1, -1, 49, 8, -1, 51, 57, 13, 22, 62, -1, 53, 42, -1, 25, -1, -1, 43, 34, -1, -1, -1, -1, -1, -1, 31, 39, -1, -1, -1, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, 30, -1, -1, -1, -1, 5, -1, 66, -1, 19, -1, -1, 65, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        System.out.println(new AQ4BalancedBinaryTree().isBalanced(TreeUtils.mapArrayToTree(input8)));//false - 0
    }

    public int isBalanced(TreeNode A) {
        ArrayList<Boolean> list = new ArrayList<>();
        depthOfDifference(A, list);
        boolean isBalanced = true;
        for (Boolean bool : list) {
            isBalanced = isBalanced && bool;
        }
        return isBalanced ? 1 : 0;
    }

    private int depthOfDifference(TreeNode A, List<Boolean> booleanList) {
        if (A == null)
            return -1;
        int leftDepth = depthOfDifference(A.left, booleanList);
        int rightDepth = depthOfDifference(A.right, booleanList);
        int height = Math.max(leftDepth, rightDepth) + 1;
        boolean isBalanced = Math.abs(leftDepth - rightDepth) < 2;
        booleanList.add(isBalanced);
        return height;
    }
}
