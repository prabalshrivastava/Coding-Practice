package scaler.advancedDsa.trees1;

import scaler.module1.trees.AQ2PreorderTraversal;
import scaler.module1.trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class HWQ2PreorderTraversal {
    //    Problem Description
//    Given a binary tree, return the preorder traversal of its nodes values.
//            NOTE: Using recursion is not allowed.
//            Problem Constraints
//1 <= number of nodes <= 105
//    Input Format
//    First and only argument is root node of the binary tree, A.
//            Output Format
//    Return an integer array denoting the preorder traversal of the given binary tree.
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
//            [1, 2, 3]
//    Output 2:
//            [1, 6, 2, 3]
//    Example Explanation
//    Explanation 1:
//    The Preoder Traversal of the given tree is [1, 2, 3].
//    Explanation 2:
//    The Preoder Traversal of the given tree is [1, 6, 2, 3].

    public int[] preorderTraversal(TreeNode A) {
        //root left right
        List<Integer> list = new ArrayList<>();
        preOrder(A, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preOrder(TreeNode A, List<Integer> list) {
        TreeNode curr = A;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (!treeNodeStack.isEmpty() || curr != null) {
            while (curr != null) {
                list.add(curr.val);
                treeNodeStack.push(curr);
                curr = curr.left;
            }
            curr = treeNodeStack.pop();
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(new HWQ2PreorderTraversal().preorderTraversal(treeNode)));

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        treeNode1.left = new TreeNode(6);
        treeNode1.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(new HWQ2PreorderTraversal().preorderTraversal(treeNode1)));
    }
}