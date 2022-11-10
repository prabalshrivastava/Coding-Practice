package scaler.advancedDsa.trees1;

import scaler.module1.trees.TreeNode;

import java.util.Arrays;

public class AQ2BinaryTreeFromInorderAndPostorder {
    //    Problem Description
//    Given the inorder and postorder traversal of a tree, construct the binary tree.
//    NOTE: You may assume that duplicates do not exist in the tree.
//            Problem Constraints
//1 <= number of nodes <= 105
//    Input Format
//    First argument is an integer array A denoting the inorder traversal of the tree.
//    Second argument is an integer array B denoting the postorder traversal of the tree.
//    Output Format
//    Return the root node of the binary tree.
//    Example Input
//    Input 1:
//    A = [2, 1, 3]
//    B = [2, 3, 1]
//    Input 2:
//    A = [6, 1, 3, 2]
//    B = [6, 3, 2, 1]
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
        int[] input1A = {2, 1, 3};
        int[] input1B = {2, 3, 1};
        System.out.println(new AQ2BinaryTreeFromInorderAndPostorder().buildTree(input1A, input1B));
        int[] input2A = {6, 1, 3, 2};
        int[] input2B = {6, 3, 2, 1};
        System.out.println(new AQ2BinaryTreeFromInorderAndPostorder().buildTree(input2A, input2B));
    }

    public TreeNode buildTree(int[] A, int[] B) {
        buildTreeNodes(A, B, 0, A.length - 1, 0, A.length - 1);
        return null;
    }

    TreeNode buildTreeNodes(int[] inorder, int[] postorder, int pos, int poe, int ins, int ine) {
        System.out.println("inorder :" + Arrays.toString(inorder) + " postorder :" + Arrays.toString(postorder) + " pos :" + pos + " poe :" + poe + " ins :" + ins + " ine :" + ine);
        int rootVal = postorder[poe];
        int idx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                idx = i;
                break;
            }
        }
        int l = idx - ins;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeNodes(inorder, postorder, pos, pos + l - 1, ins, idx - 1);
        root.right = buildTreeNodes(inorder, postorder, pos + l, poe, idx + 1, ine);
        return root;
    }
}
