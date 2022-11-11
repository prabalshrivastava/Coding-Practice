package scaler.advancedDsa.trees1;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.*;

public class HWQ1BinaryTreeFromInorderAndPreorder {
    //    Problem Description
//    Given preorder and inorder traversal of a tree, construct the binary tree.
//            NOTE: You may assume that duplicates do not exist in the tree.
//            Problem Constraints
//1 <= number of nodes <= 105
//    Input Format
//    First argument is an integer array A denoting the preorder traversal of the tree.
//    Second argument is an integer array B denoting the inorder traversal of the tree.
//    Output Format
//    Return the root node of the binary tree.
//    Example Input
//    Input 1:
//    A = [1, 2, 3]
//    B = [2, 1, 3]
//    Input 2:
//    A = [1, 6, 2, 3]
//    B = [6, 1, 3, 2]
//    Example Output
//    Output 1:
//            1
//            / \
//            2   3
//    Output 2:
//            1
//            / \
//            6   2
//            /
//            3
//    Example Explanation
//    Explanation 1:
//    Create the binary tree and return the root node of the tree.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3};
        int[] input1B = {2, 1, 3};
        System.out.println(Arrays.deepToString(TreeUtils.levelOrder(new HWQ1BinaryTreeFromInorderAndPreorder().buildTree(input1A, input1B))));
        int[] input2A = {1, 6, 2, 3};
        int[] input2B = {6, 1, 3, 2};
        System.out.println(Arrays.deepToString(TreeUtils.levelOrder(new HWQ1BinaryTreeFromInorderAndPreorder().buildTree(input2A, input2B))));
        int[] input3A = {1, 2, 3, 4, 5};
        int[] input3B = {3, 2, 4, 1, 5};
        System.out.println(Arrays.deepToString(TreeUtils.levelOrder(new HWQ1BinaryTreeFromInorderAndPreorder().buildTree(input3A, input3B))));
    }

    public TreeNode buildTree(int[] A, int[] B) {
        return buildTreeNodes(A, B, 0, A.length - 1, 0, B.length - 1);
    }

    private TreeNode buildTreeNodes(int[] preorder, int[] inorder, int prs, int pre, int ins, int ine) {
        System.out.println("inorder :" + Arrays.toString(inorder) + " preorder :" + Arrays.toString(preorder) + " prs :" + prs + " pre :" + pre + " ins :" + ins + " ine :" + ine);

        //initialize x
        if (prs > pre) {
            return null;
        }
        int x = preorder[prs];

        //find Root
        int idx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (x == inorder[i]) {
                idx = i;
                break;
            }
        }

        int l = idx - ins;
        TreeNode root = new TreeNode(x);
        root.left = buildTreeNodes(preorder, inorder, prs + 1, prs + l, ins, idx - 1);
        root.right = buildTreeNodes(preorder, inorder, prs + l + 1, pre, idx + 1, ine);
        return root;
    }

}
