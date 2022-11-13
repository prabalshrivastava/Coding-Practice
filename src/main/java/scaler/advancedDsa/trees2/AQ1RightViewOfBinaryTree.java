package scaler.advancedDsa.trees2;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import javax.management.Query;
import java.util.*;

public class AQ1RightViewOfBinaryTree {
    //    Problem Description
//    Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
//    Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
//    Problem Constraints
//1 <= Number of nodes in binary tree <= 100000
//            0 <= node values <= 10^9
//    Input Format
//    First and only argument is head of the binary tree A.
//            Output Format
//    Return an array, representing the right view of the binary tree.
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
//            [1, 3, 7, 8]
//    Output 2:
//            [1, 3, 4, 5]
//    Example Explanation
//    Explanation 1:
//    Right view is described.
//    Explanation 2:
//    Right view is described.
    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, -1, -1, -1, -1, -1, -1, -1};
        System.out.println(Arrays.toString(new AQ1RightViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input1))));
        int[] input2 = new int[]{1, 2, 3, -1, 4, -1, -1, -1, 5, -1, -1};
        System.out.println(Arrays.toString(new AQ1RightViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input2))));
    }

    public int[] solve(TreeNode A) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(A);
        treeNodeQueue.offer(null);
        TreeNode curr = A;
        List<Integer> ansList = new ArrayList<>();
        TreeNode prev = A;
        while (treeNodeQueue.size() > 1) {
            curr = treeNodeQueue.peek();
            if (curr != null) {
                if (curr.left != null) {
                    treeNodeQueue.offer(curr.left);
                }
                if (curr.right != null) {
                    treeNodeQueue.offer(curr.right);
                }
            } else {
                treeNodeQueue.offer(null);
                ansList.add(prev.val);
            }
            prev = treeNodeQueue.poll();
        }
        ansList.add(prev.val);
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}
