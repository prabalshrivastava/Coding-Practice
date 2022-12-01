package scaler.advancedDsa.trees2;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.*;

public class HWQ2ZigZagLevelOrderTraversalBT {
//    Problem Description
//    Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).
//    Problem Constraints
//1 <= number of nodes <= 105
//    Input Format
//    First and only argument is root node of the binary tree, A.
//            Output Format
//    Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.
//            Example Input
//    Input 1:
//            3
//            / \
//            9  20
//            /  \
//            15   7
//    Input 2:
//            1
//            / \
//            6   2
//            /
//            3
//    Example Output
//    Output 1:
//            [
//            [3],
//            [20, 9],
//            [15, 7]
//            ]
//    Output 2:
//            [
//            [1]
//            [2, 6]
//            [3]
//            ]
//    Example Explanation
//    Explanation 1:
//    Return the 2D array. Each row denotes the zigzag traversal of each level.

    public static void main(String[] args) {
        int[] input1 = new int[]{3, 9, 20, 15, -1, -1, 7};
        System.out.println(Arrays.deepToString(new HWQ2ZigZagLevelOrderTraversalBT().zigzagLevelOrder(TreeUtils.mapArrayToTree(input1))));
        int[] input2 = new int[]{1, 6, 2, 3};
        System.out.println(Arrays.deepToString(new HWQ2ZigZagLevelOrderTraversalBT().zigzagLevelOrder(TreeUtils.mapArrayToTree(input2))));
    }

    public int[][] zigzagLevelOrder(TreeNode A) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(A);
        treeNodeQueue.offer(null);
        List<List<Integer>> integerList = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        while (treeNodeQueue.size() > 1) {
            TreeNode curr = treeNodeQueue.poll();
            if (curr == null) {
                treeNodeQueue.offer(null);
//                System.out.print("treeNodeQueue : " + treeNodeQueue + "\tlist : " + list + "\n");
                integerList.add(list);
                list = new ArrayList<>();
                continue;
            }
            list.add(curr.val);
            if (curr.left != null) {
                treeNodeQueue.offer(curr.left);
            }
            if (curr.right != null) {
                treeNodeQueue.offer(curr.right);
            }
        }
        integerList.add(list);
//        System.out.println(integerList);
        int[][] ans = new int[integerList.size()][];
        for (int i = 0; i < integerList.size(); i++) {
            List<Integer> currList = integerList.get(i);
            int currSize = currList.size();
            int[] levelArr = new int[currSize];
            int idx = 0;
            if (i % 2 == 0) {
                for (int j = 0; j < currSize; j++) {
                    levelArr[idx++] = currList.get(j);
                }
            } else {
                for (int j = currSize - 1; j >= 0; j--) {
                    levelArr[idx++] = currList.get(j);
                }
            }
            ans[i] = levelArr;
        }
        return ans;
    }
}
