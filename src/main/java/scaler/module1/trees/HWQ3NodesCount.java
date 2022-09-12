package scaler.module1.trees;

public class HWQ3NodesCount {
//    Problem Description
//    You are given the root node of a binary tree A. You have to find the number of nodes in this tree.
//            Problem Constraints
//1 <= Number of nodes in the tree <= 105
//            0 <= Value of each node <= 107
//    Input Format
//    The first and only argument is a tree node A.
//    Output Format
//    Return an integer denoting the number of nodes of the tree.
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
//            3
//    Output 2:
//            4
//    Example Explanation
//    Explanation 1:
//    Clearly, there are 3 nodes 1, 4 and 3.
//    Explanation 2:
//    Clearly, there are 4 nodes 1, 4, 3 and 2.

    public int solve(TreeNode A) {
        if (A == null)
            return 0;
        if (A.left == null && A.right == null) {
//            System.out.println("returning from " + A.val);
            return 1;
        }
        return solve(A.left) + solve(A.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        System.out.println(new HWQ3NodesCount().solve(treeNode));

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(4);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.left = new TreeNode(2);
        System.out.println(new HWQ3NodesCount().solve(treeNode1));
    }
}
