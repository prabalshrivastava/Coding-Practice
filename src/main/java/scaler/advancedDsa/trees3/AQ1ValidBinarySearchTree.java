package scaler.advancedDsa.trees3;

import scaler.module1.trees.TreeNode;

public class AQ1ValidBinarySearchTree {
//    Problem Description
//    You are given a binary tree represented by root A.
//    Assume a BST is defined as follows:
//            1) The left subtree of a node contains only nodes with keys less than the node's key.
//            2) The right subtree of a node contains only nodes with keys greater than the node's key.
//            3) Both the left and right subtrees must also be binary search trees.
//    Problem Constraints
//1 <= Number of nodes in binary tree <= 105
//            0 <= node values <= 232-1
//    Input Format
//    First and only argument is head of the binary tree A.
//            Output Format
//    Return 0 if false and 1 if true.
//    Example Input
//    Input 1:
//            1
//            /  \
//            2    3
//    Input 2:
//            2
//            / \
//            1   3
//    Example Output
//    Output 1:
//            0
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//            2 is not less than 1 but is in left subtree of 1.
//    Explanation 2:
//    Satisfies all conditions.

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        System.out.println(new AQ1ValidBinarySearchTree().isValidBST(treeNode));

        TreeNode treeNode1 = new TreeNode(2);
        treeNode1.left = new TreeNode(3);
        treeNode1.right = new TreeNode(1);
        System.out.println(new AQ1ValidBinarySearchTree().isValidBST(treeNode1));

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);
        treeNode2.right.left = new TreeNode(4);
        treeNode2.right.left.right = new TreeNode(5);
        System.out.println(new AQ1ValidBinarySearchTree().isValidBST(treeNode2));

        TreeNode treeNode3 = new TreeNode(11);
        treeNode3.left = new TreeNode(4);
        treeNode3.right = new TreeNode(2);
        treeNode3.right.left = new TreeNode(5);
        treeNode3.left.left = new TreeNode(5);
        treeNode3.left.right = new TreeNode(1);
        System.out.println(new AQ1ValidBinarySearchTree().isValidBST(treeNode3));

    }

//    not working when passed using arguments.
//    public int isValidBST(TreeNode A) {
//        return isValid(A, null) ? 1 : 0;
//    }
//
//    private boolean isValid(TreeNode curr, TreeNode previous) {
//        if (curr == null)
//            return true;
//        boolean isLeftValidBST = isValid(curr.left, previous);
//        System.out.println("curr : " + curr + "             prev : " + previous);
//        if (previous != null && previous.val > curr.val) {
//            return false;
//        }
//        previous = curr;
//        boolean isRightValidBST = isValid(curr.right, previous);
//        return isRightValidBST && isLeftValidBST;
//    }

    TreeNode previous = null;

    public int isValidBST(TreeNode A) {
        return isValid(A) ? 1 : 0;
    }

    private boolean isValid(TreeNode curr) {
        if (curr == null)
            return true;
        boolean isLeftValidBST = isValid(curr.left);
        if (previous != null && previous.val >= curr.val) {
            return false;
        }
        previous = curr;
        boolean isRightValidBST = isValid(curr.right);
        return isRightValidBST && isLeftValidBST;
    }

}
