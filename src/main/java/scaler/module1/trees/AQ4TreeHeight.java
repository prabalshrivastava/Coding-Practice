package scaler.module1.trees;

import java.util.Arrays;

public class AQ4TreeHeight {
    //    Problem Description
//    You are given the root node of a binary tree A. You have to find the height of the given tree.
//    A binary tree's height is the number of nodes along the longest path from the root node down to the farthest leaf node.
//    Problem Constraints
//1 <= Number of nodes in the tree <= 105
//            0 <= Value of each node <= 109
//    Input Format
//    The first and only argument is a tree node A.
//    Output Format
//    Return an integer denoting the height of the tree.
//            Example Input
//    Input 1:
//    Values =  1
//            / \
//            4   3
//    Input 2:
//    Values =  1
//            / \
//            4   3
//            /
//            2
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            3
//    Example Explanation
//    Explanation 1:
//    Distance of node having value 1 from root node = 1
//    Distance of node having value 4 from root node = 2 (max)
//    Distance of node having value 3 from root node = 2 (max)
//    Explanation 2:
//    Distance of node having value 1 from root node = 1
//    Distance of node having value 4 from root node = 2
//    Distance of node having value 3 from root node = 2
//    Distance of node having value 2 from root node = 3 (max)
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        System.out.println(new AQ4TreeHeight().solve(treeNode));

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(4);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.left = new TreeNode(2);
        System.out.println(new AQ4TreeHeight().solve(treeNode1));
    }

    public int solve(TreeNode A) {
        return maxDepth(A);
    }

    public int maxDepth(TreeNode A) {
        if (A == null)// || (A.left == null && A.right == null)
            return 0;
        return Math.max(maxDepth(A.left), maxDepth(A.right)) + 1;
    }
}
