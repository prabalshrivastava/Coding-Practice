package scaler.advancedDsa.trees5;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.Queue;

public class HWQ1SymmetricBinaryTree {
//    Problem Description
//    Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//    Problem Constraints
//1 <= number of nodes <= 105
//    Input Format
//    First and only argument is the root node of the binary tree.
//    Output Format
//    Return 0 / 1 ( 0 for false, 1 for true ).
//    Example Input
//    Input 1:
//            1
//            / \
//            2   2
//            / \ / \
//            3  4 4  3
//    Input 2:
//            1
//            / \
//            2   2
//            \   \
//            3    3
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    The above binary tree is symmetric.
//    Explanation 2:
//    The above binary tree is not symmetric.

    public static void main(String[] args) {
        int[] input1A = {1, 2, 2, 3, 4, 4, 3};
        System.out.println(new HWQ1SymmetricBinaryTree().isSymmetric(TreeUtils.mapArrayToTree(input1A)));
        int[] input2A = {1, 2, 2, 3, 3};
        System.out.println(new HWQ1SymmetricBinaryTree().isSymmetric(TreeUtils.mapArrayToTree(input2A)));
        int[] input3A = {67, 0, 4, 4, 10, 6, 6, 10, 16, 3, 14, 9, 9, 14, 3, 16, 13, -1, 7, 11, -1, -1, -1, 15, 15, -1, -1, -1, 11, 7, -1, 13, -1, 12, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, 12, -1, 8, -1, 5, 2, 2, 5, -1, 8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        System.out.println(new HWQ1SymmetricBinaryTree().isSymmetric(TreeUtils.mapArrayToTree(input3A)));
        int[] input4A = {1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 6, 5};
        System.out.println(new HWQ1SymmetricBinaryTree().isSymmetric(TreeUtils.mapArrayToTree(input4A)));
    }

//    public int isSymmetric(TreeNode A) {
//        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
//        treeNodeQueue.offer(A);
//        treeNodeQueue.offer(null);
//        StringBuilder str = new StringBuilder();
//        while (treeNodeQueue.size() > 1) {
//            TreeNode curr = treeNodeQueue.poll();
//            if (curr == null) {
//                if (!str.toString().equals(str.reverse().toString())) {
////                    System.out.println("str.toString().equals(str.reverse().toString()) : " + str.toString() + " - " + str.reverse().toString());
//                    return 0;
//                } else {
//                    str = new StringBuilder();
//                }
//                treeNodeQueue.offer(null);
//                continue;
//            }
//
//            if (curr.left != null) {
//                str.append(curr.left.val);
//                treeNodeQueue.offer(curr.left);
//            }
//            if (curr.right != null) {
//                str.append(curr.right.val);
//                treeNodeQueue.offer(curr.right);
//            }
//        }
//        return 1;
//    }

//    public int isSymmetric(TreeNode A) {
//        boolean left = preorder(A.left, A.right);
//        return left ? 1 : 0;
//    }
//
//    boolean preorder(TreeNode A, TreeNode B) {
//        if ((A == null && B != null) || (A != null && B == null))
//            return false;
//        if (A == B)
//            return true;
//        if (A.val == B.val)
//            return true;
//        boolean left = preorder(A.left, B.left);
//        boolean right = preorder(A.right, B.right);
//        return left && right;
//    }



    public int isSymmetric(TreeNode A) {
        Queue
    }
}
