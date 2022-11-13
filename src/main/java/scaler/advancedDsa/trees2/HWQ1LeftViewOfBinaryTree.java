package scaler.advancedDsa.trees2;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.*;

public class HWQ1LeftViewOfBinaryTree {
//    Problem Description
//    Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
//    Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
//    NOTE: The value comes first in the array which have lower level.
//            Problem Constraints
//1 <= Number of nodes in binary tree <= 100000
//            0 <= node values <= 109
//    Input Format
//    First and only argument is a root node of the binary tree, A.
//    Output Format
//    Return an integer array denoting the left view of the Binary tree.
//    Example Input
//    Input 1:
//            1
//            /   \
//            2    3
//            / \  / \
//            4   5 6  7
//            /
//            8
//    Input 2:
//            1
//            /  \
//            2    3
//            \
//            4
//            \
//            5
//    Example Output
//    Output 1:
//            [1, 2, 4, 8]
//    Output 2:
//            [1, 2, 4, 5]
//    Example Explanation
//    Explanation 1:
//    The Left view of the binary tree is returned.

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, -1, -1, -1, -1, -1, -1, -1};
        System.out.println(Arrays.toString(new HWQ1LeftViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input1))));
        int[] input2 = new int[]{1, 2, 3, -1, 4, -1, -1, -1, 5, -1, -1};
        System.out.println(Arrays.toString(new HWQ1LeftViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input2))));
    }

    public int[] solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = A;
        queue.add(curr);
        queue.add(null);
        //Queue = [1,null]
        List<Integer> ansList = new ArrayList<>();
        ansList.add(curr.val);
        while (queue.size() > 1) {
            curr = queue.peek();//1
            if (curr != null) {
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            } else {
                queue.offer(null);
            }
            if (queue.poll() == null) {
                assert queue.peek() != null;
                ansList.add(queue.peek().val);
            }
        }
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}
