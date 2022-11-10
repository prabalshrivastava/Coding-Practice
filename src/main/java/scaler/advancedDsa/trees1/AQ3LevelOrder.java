package scaler.advancedDsa.trees1;

import scaler.module1.trees.TreeNode;

import java.util.*;

public class AQ3LevelOrder {
//    Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
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
//            [9, 20],
//            [15, 7]
//            ]
//    Output 2:
//            [
//            [1]
//            [6, 2]
//            [3]
//            ]
//    Example Explanation
//    Explanation 1:
//    Return the 2D array. Each row denotes the traversal of each level.
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println(Arrays.deepToString(new AQ3LevelOrder().levelOrder(treeNode)));

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(6);
        treeNode1.right = new TreeNode(2);
        treeNode1.right.left = new TreeNode(3);
        System.out.println(Arrays.deepToString(new AQ3LevelOrder().levelOrder(treeNode1)));
    }

    public int[][] levelOrder(TreeNode A) {
        TreeNode curr;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(A);
        treeNodeQueue.offer(null);
        int level = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> elementsInALevel = new LinkedList<>();
        while (!treeNodeQueue.isEmpty() && treeNodeQueue.size() > 1) {
            curr = treeNodeQueue.peek();
            treeNodeQueue.poll();
            if (curr == null) {
                map.put(level, elementsInALevel);
                elementsInALevel = new LinkedList<>();
                level++;
                treeNodeQueue.offer(null);
                continue;
            } else {
//                System.out.println(curr.val);
                elementsInALevel.add(curr.val);
            }
            if (curr.left != null)
                treeNodeQueue.offer(curr.left);
            if (curr.right != null)
                treeNodeQueue.offer(curr.right);
        }
        map.put(level, elementsInALevel);
        int[][] ans = new int[map.entrySet().size()][];
        for (int i = 0; i <= level; i++) {
            ans[i] = map.getOrDefault(i, new ArrayList<>()).stream().mapToInt(Integer::intValue).toArray();
        }
//        System.out.println(map);
        return ans;
    }
}
