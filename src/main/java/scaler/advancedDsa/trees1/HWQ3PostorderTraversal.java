package scaler.advancedDsa.trees1;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class HWQ3PostorderTraversal {
    //    Problem Description
//    Given a binary tree, return the Postorder traversal of its nodes values.
//            NOTE: Using recursion is not allowed.
//            Problem Constraints
//1 <= number of nodes <= 105
//    Input Format
//    First and only argument is root node of the binary tree, A.
//            Output Format
//    Return an integer array denoting the Postorder traversal of the given binary tree.
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
//            [3, 2, 1]
//    Output 2:
//            [6, 3, 2, 1]
//    Example Explanation
//    Explanation 1:
//    The Preoder Traversal of the given tree is [3, 2, 1].
//    Explanation 2:
//    The Preoder Traversal of the given tree is [6, 3, 2, 1].
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(new HWQ3PostorderTraversal().postorderTraversal(treeNode)));

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.right = new TreeNode(2);
        treeNode1.left = new TreeNode(6);
        treeNode1.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(new HWQ3PostorderTraversal().postorderTraversal(treeNode1)));

        int[] input1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(Arrays.toString(new HWQ3PostorderTraversal().postorderTraversal(TreeUtils.mapArrayToTree(input1))));
    }

    public int[] postorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = A;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(A);
        while (curr != null) {
            curr = treeNodeStack.peek();
            if (curr.left != null || curr.right != null) {
                treeNodeStack.push(curr);
            }

            curr = curr.left;
            if (curr != null && (curr.left != null || curr.right != null)) {
                treeNodeStack.push(curr);
            }

            if (curr != null) {
                curr = curr.right;
                if (curr != null && (curr.left != null || curr.right != null)) {
                    treeNodeStack.push(curr);
                }
            }

            list.add(curr.val);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
