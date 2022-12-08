package scaler.advancedDsa.trees5;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

public class AQ4KthSmallestElementInBST {
//    Problem Description
//    Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
//    Problem Constraints
//1 <= Number of nodes in binary tree <= 100000
//            0 <= node values <= 10^9
//    Input Format
//    First and only argument is head of the binary tree A.
//            Output Format
//    Return an integer, representing the Bth element.
//    Example Input
//    Input 1:
//            2
//            /   \
//            1    3
//    B = 2
//    Input 2:
//            3
//            /
//            2
//            /
//            1
//    B = 1
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//            2nd element is 2.
//    Explanation 2:
//            1st element is 1.

    public static void main(String[] args) {
        int[] input1A = {2, 1, 3};
        System.out.println(new AQ4KthSmallestElementInBST().kthsmallest(TreeUtils.mapArrayToTree(input1A), 2));
        int[] input2A = {3, 2, -1, 1};
        System.out.println(new AQ4KthSmallestElementInBST().kthsmallest(TreeUtils.mapArrayToTree(input2A), 1));
    }

    public int kthsmallest(TreeNode A, int B) {
        return inorder(A, B);
    }

    int count = 0;

    private int inorder(TreeNode A, int k) {
        if (A == null)
            return Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        int left = inorder(A.left, k);
        if (left != Integer.MAX_VALUE)
            return left;
        count++;
        if (count == k)
            return A.val;
        int right = inorder(A.right, k);
        if (right != Integer.MAX_VALUE)
            return right;
        return Integer.MAX_VALUE;
    }
}
