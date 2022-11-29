package scaler.advancedDsa.trees6;

import scaler.module1.trees.TreeNode;

import java.util.*;

public class HWQ2SerializeBinaryTree {
    //    Problem Description
//    Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
//    Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
//    NOTE:
//    In the array, the NULL/None child is denoted by -1.
//    For more clarification check the Example Input.
//            Problem Constraints
//1 <= number of nodes <= 105
//    Input Format
//    Only argument is a A denoting the root node of a Binary Tree.
//            Output Format
//    Return an integer array denoting the Level Order Traversal of the given Binary Tree.
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
//            [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
//    Output 2:
//            [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
//    Example Explanation
//    Explanation 1:
//    The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
//    Since 3, 4 and 5 each has both NULL child we had represented that using -1.
//    Explanation 2:
//    The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
//    Since 3 has left child as NULL while 4 and 5 each has both NULL child.
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(Arrays.toString(new HWQ2SerializeBinaryTree().solve(treeNode)));

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.left = new TreeNode(4);
        treeNode1.left.right = new TreeNode(5);
        treeNode1.right.right = new TreeNode(6);
        System.out.println(Arrays.toString(new HWQ2SerializeBinaryTree().solve(treeNode1)));
    }

    public int[] solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        TreeNode curr = A;
        List<Integer> ansList = new ArrayList<>();
        ansList.add(A.val);
        while (!queue.isEmpty()) {
            curr = queue.peek();
            if (curr != null) {
                if (curr.left != null) {
                    queue.offer(curr.left);
                    ansList.add(curr.left.val);
                } else {
                    ansList.add(-1);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    ansList.add(curr.right.val);
                } else {
                    ansList.add(-1);
                }
                queue.poll();
            } else {
                ansList.add(-1);
            }
        }
        System.out.println(queue);
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}
