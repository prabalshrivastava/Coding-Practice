package scaler.advancedDsa.trees4;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

public class AQ3DiameterOfBinaryTree {
    //    Problem Description
//    Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
//    The diameter of a tree is the number of edges on the longest path between two nodes in the tree.
//    Problem Constraints
//0 <= N <= 105
//    Input Format
//    First and only Argument represents the root of binary tree A.
//            Output Format
//    Return an single integer denoting the diameter of the tree.
//    Example Input
//    Input 1:
//            1
//            /   \
//            2     3
//            / \
//            4   5
//    Input 2:
//            1
//            /   \
//            2     3
//            / \     \
//            4   5     6
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            4
//    Example Explanation
//    Explanation 1:
//    Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges in this path is 3 so diameter is 3.
//    Explanation 2:
//    Longest Path in the tree is 4 -> 2 -> 1 -> 3 -> 6 and the number of edges in this path is 4 so diameter is 4.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 4, 5};
        System.out.println(new AQ3DiameterOfBinaryTree().solve(TreeUtils.mapArrayToTree(input1A)));

        int[] input2A = {1, 2, 3, 4, 5, -1, 6};
        System.out.println(new AQ3DiameterOfBinaryTree().solve(TreeUtils.mapArrayToTree(input2A)));
    }

    public int solve(TreeNode A) {
        diameter(A);
        return diameter;
    }

    int diameter = Integer.MIN_VALUE;

    private int diameter(TreeNode A) {
        if (A == null)
            return -1;
        int lh = diameter(A.left);
        int rh = diameter(A.right);
        int height = Math.max(lh, rh) + 1;
        int diameter = lh + rh + 2;
//        System.out.println(A + " lh : " + lh + " - rh : " + rh + " - height : " + height + " diameter : " + diameter);
        this.diameter = Math.max(this.diameter, diameter);
        return height;
    }
}
