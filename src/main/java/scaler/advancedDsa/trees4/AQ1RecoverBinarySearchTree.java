package scaler.advancedDsa.trees4;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.Arrays;

public class AQ1RecoverBinarySearchTree {
//    Problem Description
//    Two elements of a binary search tree (BST), represented by root A are swapped by mistake. Tell us the 2 values swapping which the tree will be restored.
//    A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
//    Problem Constraints
//1 <= size of tree <= 100000
//    Input Format
//    First and only argument is the head of the tree,A
//    Output Format
//    Return the 2 elements which need to be swapped.
//    Example Input
//    Input 1:
//            1
//            / \
//            2   3
//    Input 2:
//            2
//            / \
//            3   1
//    Example Output
//    Output 1:
//            [2, 1]
//    Output 2:
//            [3, 1]
//    Example Explanation
//    Explanation 1:
//    Swapping 1 and 2 will change the BST to be
//         2
//                 / \
//                 1   3
//    which is a valid BST
//    Explanation 2:
//    Swapping 1 and 3 will change the BST to be
//         2
//                 / \
//                 1   3
//    which is a valid BST

    public static void main(String[] args) {
        int[] input1A = {1, 3, 2};
        System.out.println(Arrays.toString(new AQ1RecoverBinarySearchTree().recoverTree(TreeUtils.mapArrayToTree(input1A))));

        int[] input2A = {2, 3, 1};
        System.out.println(Arrays.toString(new AQ1RecoverBinarySearchTree().recoverTree(TreeUtils.mapArrayToTree(input2A))));

        int[] input3A = {15, 10, 13, 5, 24, 18, 35, 3, 8, 11, 16, 20};
        System.out.println(Arrays.toString(new AQ1RecoverBinarySearchTree().recoverTree(TreeUtils.mapArrayToTree(input3A))));
    }

    public int[] recoverTree(TreeNode A) {
        TreeNode[] culprits = recover(A, null);
        return new int[]{culprits[0] == null ? 0 : culprits[0].val, culprits[1] == null ? 0 : culprits[1].val};
    }

    private TreeNode[] recover(TreeNode curr, TreeNode previous) {
        TreeNode firstCulprit = null;
        TreeNode secondCulprit = null;
        if (curr == null) return null;
        recover(curr.left, curr);
        if (previous != null && previous.val > curr.val) {
            if (firstCulprit == null)
                firstCulprit = previous;
            secondCulprit = curr;
        }
        recover(curr.right, curr);
        return new TreeNode[]{firstCulprit, secondCulprit};
    }
}
