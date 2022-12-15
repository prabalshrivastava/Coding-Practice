package scaler.advancedDsa.trees3;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

public class AQ2LargestBSTSubtree {
    //    Problem Description
//    You are given a Binary Tree A with N nodes.
//    Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).
//    If the complete Binary Tree is BST, then return the size of the whole tree.
//    NOTE:
//    The largest subtree is the subtree with the most number of nodes.
//    Problem Constraints
//1 <= N <= 105
//    Input Format
//    First and only argument is an pointer to root of the binary tree A.
//    Output Format
//    Return an single integer denoting the size of the largest subtree which is also a BST.
//    Example Input
//    Input 1:
//            10
//            / \
//            5  15
//            / \   \
//            1   8   7
//    Input 2:
//            5
//            / \
//            3   8
//            / \ / \
//            1  4 7  9
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            7
//    Example Explanation
//    Explanation 1:
//    Largest BST subtree is
//                            5
//                                    / \
//                                    1   8
//    Explanation 2:
//    Given binary tree itself is BST.
    public static void main(String[] args) {
        System.out.println(new AQ2LargestBSTSubtree().solve(TreeUtils.mapArrayToTree(new int[]{10, 5, 15, 1, 8, -1, 7})));
        System.out.println(new AQ2LargestBSTSubtree().solve(TreeUtils.mapArrayToTree(new int[]{5, 3, 8, 1, 4, 7, 9})));

        int[] input1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(new AQ2LargestBSTSubtree().solve(TreeUtils.mapArrayToTree(input1)));
//        9 20 14 12 11 -1 -1 -1 -1 -1

    }

    int max = 1;

    public int solve(TreeNode A) {
        if (A == null)
            return 0;
        postorderWithSize(A);
        return max;
    }

    private int postorderWithSize(TreeNode A) {
        if (A == null)
            return 0;
        if (A.left == null && A.right == null)
            return 1;
        int left = postorderWithSize(A.left);
        int right = postorderWithSize(A.right);
        int size = left + right + 1;
        previous = null;
        boolean isValidLeft = isValid(A.left);
        previous = null;
        boolean isValidRight = isValid(A.right);
        previous = null;
        boolean isValidRoot = isValid(A);
//        System.out.println("A : " + A + isValidLeft + " - " + isValidRight + " - " + isValidRoot);
        if (isValidLeft && isValidRight && isValidRoot) {
//            System.out.println("A : " + A + "->" + size);
            max = Math.max(size, max);
        }
        return size;
    }


    TreeNode previous = null;


    private boolean isValid(TreeNode curr) {
        if (curr == null)
            return true;
        boolean isLeftValidBST = isValid(curr.left);
        if (previous != null && curr.val <= previous.val) {
            return false;
        }
        previous = curr;
        boolean isRightValidBST = isValid(curr.right);
        return isRightValidBST && isLeftValidBST;
    }
//    public int isValidBST(TreeNode A) {
//        return isValid(A) ? 1 : 0;
//    }

//    public int solve(TreeNode A) {
//        Map.Entry<Integer, Boolean> validBSTWithSize = isValidBSTWithSize(A);
//        max = Math.max(validBSTWithSize.getKey(), max);
//        return max;
//    }
//
//    TreeNode previous = null;
//    int max = Integer.MIN_VALUE;
//
//    private Map.Entry<Integer, Boolean> isValidBSTWithSize(TreeNode curr) {
//        if (curr == null)
//            return new AbstractMap.SimpleEntry<>(0, true);
//        if (curr.left == null && curr.right == null)
//            return new AbstractMap.SimpleEntry<>(1, true);
//
//        Map.Entry<Integer, Boolean> leftBST = isValidBSTWithSize(curr.left);
//        if (leftBST.getValue())
//            max = Math.max(leftBST.getKey(), max);
//
//        if (previous != null && curr.val <= previous.val) {
//            return new AbstractMap.SimpleEntry<>(leftBST.getKey(), false);
//        }
//        previous = curr;
//
//        Map.Entry<Integer, Boolean> rightBST = isValidBSTWithSize(curr.right);
//        System.out.println("leftBST:" + curr.left + "-" +  leftBST + " | rightBST:" + curr.right + " - " +  rightBST);
//        if (rightBST.getValue())
//            max = Math.max(rightBST.getKey(), max);
//
//        if (leftBST.getValue() && rightBST.getValue())
//            max = Math.max(leftBST.getKey() + rightBST.getKey() + 1, max);
//        return new AbstractMap.SimpleEntry<>(leftBST.getKey() + rightBST.getKey() + 1, leftBST.getValue() && rightBST.getValue());
//    }
}
