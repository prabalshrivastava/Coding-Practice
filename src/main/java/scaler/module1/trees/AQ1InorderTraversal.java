package scaler.module1.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AQ1InorderTraversal {
//    Problem Description
//    Given a binary tree, return the inorder traversal of its nodes' values.
//    NOTE: Using recursion is not allowed.
//            Problem Constraints
//1 <= number of nodes <= 105
//    Input Format
//    First and only argument is root node of the binary tree, A.
//            Output Format
//    Return an integer array denoting the inorder traversal of the given binary tree.
//            Example Input
//    Input 1:
//            1
//            \
//            2
//            /
//            3
//    Input 2:
//            1
//            / \
//            6   2
//            /
//            3
//    Example Output
//    Output 1:
//            [1, 3, 2]
//    Output 2:
//            [6, 1, 3, 2]
//    Example Explanation
//    Explanation 1:
//    The Inorder Traversal of the given tree is [1, 3, 2].
//    Explanation 2:
//    The Inorder Traversal of the given tree is [6, 1, 3, 2].

    public int[] inorderTraversal(TreeNode A) {
        //left root right
        List<Integer> list = new ArrayList<>();
        inOrder(A, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inOrder(TreeNode A, List<Integer> list) {
        if (A == null)
            return;
        this.inOrder(A.left, list);
        list.add(A.val);
        this.inOrder(A.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(new AQ1InorderTraversal().inorderTraversal(treeNode)));

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        treeNode1.left = new TreeNode(6);
        treeNode1.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(new AQ1InorderTraversal().inorderTraversal(treeNode1)));
    }
}

//Definition for binary tree

