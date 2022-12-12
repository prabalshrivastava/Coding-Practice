package scaler.advancedDsa.trees5;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HWQ3SumBinaryTreeOrNot {
    //    Problem Description
//    Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
//    Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
//    An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
//    Return 1 if it sum-binary tree else return 0.
//    Problem Constraints
//1 <= length of the array <= 100000
//            0 <= node values <= 50
//    Input Format
//    The only argument given is the root node of tree A.
//            Output Format
//    Return 1 if it is sum-binary tree else return 0.
//    Example Input
//    Input 1:
//            26
//            /    \
//            10     3
//            /  \     \
//            4   6      3
//    Input 2:
//            26
//            /    \
//            10     3
//            /  \     \
//            4   6      4
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    All leaf nodes are considered as SumTree.
//    Value of Node 10 = 4 + 6.
//    Value of Node 3 = 0 + 3
//    Value of Node 26 = 20 + 6
//    Explanation 2:
//    Sum of left subtree and right subtree is 27 which is not equal to the value of root node which is 26.
    public static void main(String[] args) {
        int[] input1A = {26, 10, 3, 4, 6, 3};
        System.out.println(new HWQ3SumBinaryTreeOrNot().solve(TreeUtils.mapArrayToTree(input1A)));

        int[] input2A = {26, 10, 3, 4, 6, 4};
        System.out.println(new HWQ3SumBinaryTreeOrNot().solve(TreeUtils.mapArrayToTree(input2A)));

        int[] input3A = {5, 1, 4, -1, -1, -1};
        System.out.println(new HWQ3SumBinaryTreeOrNot().solve(TreeUtils.mapArrayToTree(input3A)));
    }

    public int solve(TreeNode A) {
        sumBinaryTree(A);
        return sumBinaryTree ? 1 : 0;
    }

    boolean sumBinaryTree = true;

    private int sumBinaryTree(TreeNode A) {
        if (A == null)
            return Integer.MAX_VALUE;
        int left = sumBinaryTree(A.left);
        int right = sumBinaryTree(A.right);
        boolean isLeafNode = left == Integer.MAX_VALUE && right == Integer.MAX_VALUE;
        left = left == Integer.MAX_VALUE ? 0 : left;
        right = right == Integer.MAX_VALUE ? 0 : right;
        int sum = left + right;
//        System.out.println("left : " + left + " - right : " + right + " sumbinaryTree : " + sumBinaryTree);
        if (!isLeafNode) {
            if (sum != A.val) {
                //failure condition
                sumBinaryTree = false;
            }
        }
        return left + right + A.val;
    }


//level order traversal -> didnt work for me. -> we can try expanding the same
//    private boolean sumBinaryTree(TreeNode A) {
//        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
//        treeNodeQueue.offer(A);
//        boolean isSumBinaryTree = true;
//        while (!treeNodeQueue.isEmpty()) {
//            TreeNode curr = treeNodeQueue.poll();
//            int sum = 0;
//            boolean isNull = curr.left == null && curr.right == null;
//            if (curr.left != null) {
//                treeNodeQueue.offer(curr.left);
//                sum += curr.left.val;
//            }
//            if (curr.right != null) {
//                treeNodeQueue.offer(curr.right);
//                sum += curr.right.val;
//            }
//            System.out.println(sum + );
//            if (sum != curr.val) {
//                //wrong condition
//                System.out.println("making false");
//                isSumBinaryTree = false;
//            } else {
//                //correct condition
//            }
//        }
//        return isSumBinaryTree;
//    }

}
