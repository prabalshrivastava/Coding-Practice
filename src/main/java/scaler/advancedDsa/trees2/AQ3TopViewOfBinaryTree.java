package scaler.advancedDsa.trees2;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.*;

public class AQ3TopViewOfBinaryTree {
    //    Problem Description
//    Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.    The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.    Return the nodes in any order.    Problem Constraints
//1 <= Number of nodes in binary tree <= 100000            0 <= node values <= 10^9    Input Format
//    First and only argument is head of the binary tree A.            Output Format
//    Return an array, representing the top view of the binary tree.    Example Input
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
//    Output 1:            [1, 2, 4, 8, 3, 7]
//    Output 2:            [1, 2, 3]
//    Example Explanation
//    Explanation 1:    Top view is described.
//     Explanation 2:    Top view is described.
    public static void main(String[] args) {
        int[] input1 = {8262, -1, 411, -1, -1};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input1))));//[8262, 411]

        int[] input2 = {6, 3, 7, 2, 5, -1, 9, -1, -1, -1, -1, -1, -1};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input2))));//[6, 3, 2, 7, 9]

        int[] input3 = {1, 3, 7, 2, -1, -1, 9, -1, -1, -1, -1};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input3))));//[1, 3, 2, 7, 9]

        int[] input4 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input4))));//[1, 2, 4, 8, 3, 7]

        int[] input5 = {1, 2, 3, -1, 4, -1, -1, -1, 5};
        System.out.println(Arrays.toString(new AQ3TopViewOfBinaryTree().solve(TreeUtils.mapArrayToTree(input5))));//[1, 2, 3]
    }

    public int[] solve(TreeNode A) {
        Map.Entry<TreeNode, Integer> curr = new AbstractMap.SimpleEntry<>(A, 0);
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(A);
        map.put(0, list);

        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(curr);
        int minLevel = 0;
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            curr = queue.peek();
            if (curr != null) {
                TreeNode leftTreeNode = curr.getKey().left;
                int leftLevel = curr.getValue() - 1;
                if (leftTreeNode != null) {
                    minLevel = Math.min(minLevel, leftLevel);
                    queue.offer(new AbstractMap.SimpleEntry<>(leftTreeNode, leftLevel));
                    List<TreeNode> leftList = map.getOrDefault(leftLevel, new ArrayList<>());
                    leftList.add(leftTreeNode);
                    map.put(leftLevel, leftList);
                }

                TreeNode rightTreeNode = curr.getKey().right;
                int rightLevel = curr.getValue() + 1;
                if (rightTreeNode != null) {
                    maxLevel = Math.max(maxLevel, rightLevel);
                    queue.offer(new AbstractMap.SimpleEntry<>(rightTreeNode, rightLevel));
                    List<TreeNode> rightList = map.getOrDefault(rightLevel, new ArrayList<>());
                    rightList.add(rightTreeNode);
                    map.put(rightLevel, rightList);
                }
            }
            queue.poll();
        }
        int[] ans = new int[maxLevel - minLevel + 1];
        int count = 0;
        for (int i = 0; i >= minLevel; i--) {
            ans[count++] = map.getOrDefault(i, new ArrayList<>()).stream().findFirst().get().val;
        }
        for (int i = 1; i <= maxLevel; i++) {
            ans[count++] = map.getOrDefault(i, new ArrayList<>()).stream().findFirst().get().val;
        }
        return ans;
    }
}
