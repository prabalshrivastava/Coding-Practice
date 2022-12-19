package scaler.advancedDsa.trees3;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.Arrays;

public class HWQ1CheckForBSTWithOneChild {
    //    Problem Description
//    Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.
//    Problem Constraints
//1 <= number of nodes <= 100000
//    Input Format
//    First and only argument is an integer array denoting the preorder traversal of binary tree.
//            Output Format
//    Return a string "YES" if true else "NO".
//    Example Input
//    Input 1:
//    A : [4, 10, 5, 8]
//    Input 2:
//    A : [1, 5, 6, 4]
//    Example Output
//    Output 1:
//            "YES"
//    Output 2:
//            "NO"
//    Example Explanation
//    Explanation 1:
//    The possible BST is:
//            4
//            \
//            10
//            /
//            5
//            \
//            8
//    Explanation 2:
//    There is no possible BST which have the above preorder traversal.
    public static void main(String[] args) {
        int[] input1A = new int[]{4, 10, 5, 8};
        System.out.println(new HWQ1CheckForBSTWithOneChild().solve(input1A));
        int[] input2A = new int[]{1, 5, 6, 4};
        System.out.println(new HWQ1CheckForBSTWithOneChild().solve(input2A));
        int[] input3A = new int[]{20, 10, 11, 13, 12};
        System.out.println(new HWQ1CheckForBSTWithOneChild().solve(input3A));

    }

    TreeNode previous = null;

    public String solve(int[] A) {
        TreeNode treeNode = new TreeNode(A[0]);
        TreeNode curr = treeNode;
        int i = 1;
        while (i < A.length) {
            if (A[i] < curr.val) {
                curr.left = new TreeNode(A[i]);
                curr = curr.left;
            } else {
                curr.right = new TreeNode(A[i]);
                curr = curr.right;
            }
            i++;
        }
//        System.out.println(Arrays.deepToString(TreeUtils.levelOrder(treeNode)));

        return isValidBST(treeNode) ? "YES" : "NO";
    }

    private boolean isValidBST(TreeNode A) {
        if (A == null)
            return true;
        boolean left = isValidBST(A.left);
        if (previous != null && previous.val > A.val)
            return false;
        previous = A;
        boolean right = isValidBST(A.right);
        return left && right;
    }
}
