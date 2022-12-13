package scaler.advancedDsa.trees5;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

public class HWQ2PathSum {
    //    Problem Description
//    Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//    Problem Constraints
//1 <= number of nodes <= 105
//            -100000 <= B, value of nodes <= 100000
//    Input Format
//    First argument is a root node of the binary tree, A.
//    Second argument is an integer B denoting the sum.
//            Output Format
//    Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.
//    Example Input
//    Input 1:
//    Tree:    5
//            / \
//            4   8
//            /   / \
//            11  13  4
//            /  \      \
//            7    2      1
//    B = 22
//    Input 2:
//    Tree:    5
//            / \
//            4   8
//            /   / \
//            -11 -13  4
//    B = -1
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
//    Explanation 2:
//    There is no path which has sum -1.
    public int hasPathSum(TreeNode A, int B) {
        if(A == null)
            return 0;
        if(A.left == null && A.right == null && A.val == B){
            return 1;
        }
        if(hasPathSum(A.left,B-A.val) == 1 || hasPathSum(A.right,B-A.val) == 1 )
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        int[] input1A = {5, 4, 8, -11, -1, -13, 4};
        System.out.println(new HWQ2PathSum().hasPathSum(TreeUtils.mapArrayToTree(input1A), -1));

        int[] input2A = {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, 1};
        System.out.println(new HWQ2PathSum().hasPathSum(TreeUtils.mapArrayToTree(input2A), 22));
    }
}
