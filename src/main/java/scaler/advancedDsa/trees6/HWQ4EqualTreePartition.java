package scaler.advancedDsa.trees6;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

public class HWQ4EqualTreePartition {
    //    Problem Description
//    Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.
//            Problem Constraints
//1 <= size of tree <= 100000
//            0 <= value of node <= 109
//    Input Format
//    First and only argument is head of tree A.
//            Output Format
//    Return 1 if the tree can be partitioned into two trees of equal sum else return 0.
//    Example Input
//    Input 1:
//            5
//            /  \
//            3    7
//            / \  / \
//            4  6  5  6
//    Input 2:
//            1
//            / \
//            2   10
//            / \
//            20  2
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    Remove edge between 5(root node) and 7:
//    Tree 1 =                                               Tree 2 =
//            5                                                     7
//            /                                                     / \
//            3                                                     5   6
//            / \
//            4   6
//    Sum of Tree 1 = Sum of Tree 2 = 18
//    Explanation 2:
//    The given Tree cannot be partitioned.
    public static void main(String[] args) {
        int[] input1A = {5, 3, 7, 4, 6, 5, 6};
        System.out.println(new HWQ4EqualTreePartition().solve(TreeUtils.mapArrayToTree(input1A)) + "\n---------------------------------");

        int[] input2A = {1, 2, 10, 20, 2};
        System.out.println(new HWQ4EqualTreePartition().solve(TreeUtils.mapArrayToTree(input2A)) + "\n---------------------------------");

        int[] input3A = {11, 504, 742, 878, 148, -1, -1, -1, 392, -1, -1, -1};
        System.out.println(new HWQ4EqualTreePartition().solve(TreeUtils.mapArrayToTree(input3A)) + "\n---------------------------------");

    }

    public int solve(TreeNode A) {
        int totalSum = totalSum(A);
//        System.out.println("totalSum : " + totalSum);
        if (totalSum % 2 != 0)
            return 0;
        preorder(A,totalSum);
        return ans ? 1 : 0;
    }

    boolean ans = false;

    void preorder(TreeNode A, int totalSum) {
        if (A == null)
            return;
        int left = totalSum(A.left);
        int right = totalSum(A.right);
//        System.out.printf("left(%s) == right(%s)%n", left, right);
//        if (left == right) {
//            ans = true;
//            return;
//        }
        if (left == totalSum - left){
            ans = true;
        }
        if (right == totalSum - right){
            ans = true;
        }
        preorder(A.left, totalSum);
        preorder(A.right, totalSum);
    }

    private int totalSum(TreeNode A) {
        if (A == null)
            return 0;
        int left = totalSum(A.left);
        int right = totalSum(A.right);
        return left + right + A.val;
    }
}
