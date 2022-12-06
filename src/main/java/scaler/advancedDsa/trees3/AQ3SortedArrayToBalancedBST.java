package scaler.advancedDsa.trees3;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.Arrays;

public class AQ3SortedArrayToBalancedBST {
    //    Problem Description
//    Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
//    Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//    Problem Constraints
//1 <= length of array <= 100000
//    Input Format
//    First argument is an integer array A.
//            Output Format
//    Return a root node of the Binary Search Tree.
//            Example Input
//    Input 1:
//    A : [1, 2, 3]
//    Input 2:
//    A : [1, 2, 3, 5, 10]
//    Example Output
//    Output 1:
//            2
//            /   \
//            1     3
//    Output 2:
//            3
//            /   \
//            2     5
//            /       \
//            1         10
//    Example Explanation
//    Explanation 1:
//    You need to return the root node of the Binary Tree.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3};
        System.out.println(Arrays.deepToString(TreeUtils.levelOrder(new AQ3SortedArrayToBalancedBST().sortedArrayToBST(input1A))));
        int[] input2A = {1, 2, 3, 5, 10};
        System.out.println(Arrays.deepToString(TreeUtils.levelOrder(new AQ3SortedArrayToBalancedBST().sortedArrayToBST(input2A))));
        int[] input3A = {1, 2, 3, 4};
        System.out.println(Arrays.deepToString(TreeUtils.levelOrder(new AQ3SortedArrayToBalancedBST().sortedArrayToBST(input3A))));
        int[] input4A = {90, 228, 245, 290, 397, 471, 572, 649, 688, 710, 823, 829, 830, 859, 932, 939, 962};
        System.out.println(Arrays.deepToString(TreeUtils.levelOrder(new AQ3SortedArrayToBalancedBST().sortedArrayToBST(input4A))));
    }

    public TreeNode sortedArrayToBST(final int[] A) {
        int mid = A.length / 2;
        int i = mid;
        int j = mid;
        TreeNode treeNode = new TreeNode(A[mid]);
        TreeNode left = treeNode;
        TreeNode right = treeNode;
        i--;
        j++;
//        System.out.println(mid);
        while (j < A.length) {
//            System.out.printf("i:%s - j:%s%n", i, j);
            if (i != mid) {
                left.left = new TreeNode(A[i]);
                left = left.left;
                i--;
            }
            if (j != mid) {
                right.right = new TreeNode(A[j]);
                right = right.right;
                j++;
            }
        }
        if (i >= 0) {
            left.left = new TreeNode(A[i]);
        }
        return treeNode;
    }
}
