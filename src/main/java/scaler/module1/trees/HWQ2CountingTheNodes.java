package scaler.module1.trees;

public class HWQ2CountingTheNodes {
//    Problem Description
//    Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestor.
//            Problem Constraints
//1 <= Number of Nodes <= 200000
//            1 <= Value of Nodes <= 2000000000
//    Input Format
//    The first and only argument of input is a tree node.
//            Output Format
//    Return a single integer denoting the count of nodes that have more value than all of its ancestors.
//    Example Input
//    Input 1:
//            3
//    Input 2:
//            4
//            / \
//            5   2
//            / \
//            3   6
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            3
//    Example Explanation
//    Explanation 1:
//    There's only one node in the tree that is the valid node.
//    Explanation 2:
//    The valid nodes are 4, 5 and 6.

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        System.out.println(new HWQ2CountingTheNodes().solve(treeNode));

        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(2);
        treeNode1.right.left = new TreeNode(3);
        treeNode1.right.right = new TreeNode(6);
        System.out.println(new HWQ2CountingTheNodes().solve(treeNode1));
    }

    public int solve(TreeNode A) {
        if (A.left == null && A.right == null)
            return 1;
        return countNodes(A);
    }

    private int countNodes(TreeNode A) {
        if (A == null)
            return 0;
        int count = 0;
        if (A.left != null && A.left.val > A.val)
            count++;
        if (A.right != null && A.right.val > A.val)
            count++;
        return count + countNodes(A.left) + countNodes(A.right);
    }

//    int countNode(TreeNode A, TreeNode ancestor) {
//        if (A == null)
//            return 0;
//        if (ancestor != null && A.val > ancestor.val) {
//            return 1 + countNode(A.left, A) + countNode(A.right, A);
//        }
//        return countNode(A.left, A) + countNode(A.right, A);
//    }
}
