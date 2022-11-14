package scaler.advancedDsa.trees2;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.*;

public class AQ2VerticalOrderTraversal {
    //    Problem Description
//    Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
//    NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
//    Problem Constraints
//0 <= number of nodes <= 105    Input Format
//    First and only arument is a pointer to the root node of binary tree, A.    Output Format
//    Return a 2D array denoting the vertical order traversal of tree as shown.    Example Input
//    Input 1:
//            6
//            /   \
//            3     7
//            / \     \
//            2   5     9
//    Input 2:            1
//            /   \
//            3     7
//            /       \
//            2         9
//    Example Output
//    Output 1:            [
//            [2],
//            [3],
//            [6, 5],
//            [7],
//            [9]
//            ]
//    Output 2:            [
//            [2],
//            [3],
//            [1],
//            [7],
//            [9]
//            ]
//    Example Explanation
//    Explanation 1:    First row represent the verical line 1 and so on.
    public static void main(String[] args) {
        int[] input1 = {8262, -1, 411, -1, -1};
        System.out.println(Arrays.deepToString(new AQ2VerticalOrderTraversal().verticalOrderTraversal(TreeUtils.mapArrayToTree(input1))));//[[8262], [411]]

        int[] input2 = {6, 3, 7, 2, 5, -1, 9, -1, -1, -1, -1, -1, -1};
        System.out.println(Arrays.deepToString(new AQ2VerticalOrderTraversal().verticalOrderTraversal(TreeUtils.mapArrayToTree(input2))));//[[2], [3], [6, 5], [7], [9]]

        int[] input3 = {1, 3, 7, 2, -1, -1, 9, -1, -1, -1, -1};
        System.out.println(Arrays.deepToString(new AQ2VerticalOrderTraversal().verticalOrderTraversal(TreeUtils.mapArrayToTree(input3))));//[[2], [3], [1], [7], [9]]
    }

    public int[][] verticalOrderTraversal(TreeNode A) {
        Map.Entry<TreeNode, Integer> curr = new AbstractMap.SimpleEntry<>(A, 0);
        Queue<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> initList = new ArrayList<>();
        initList.add(curr.getKey());
        map.put(0, initList);
        queue.offer(curr);
        int maxLevel = 0;
        int minLevel = 0;
        while (!queue.isEmpty()) {
            curr = queue.peek();
            if (curr != null) {
                TreeNode left = curr.getKey().left;
                if (left != null) {
                    int leftLevel = curr.getValue() - 1;
                    minLevel = Math.min(minLevel, leftLevel);
                    queue.offer(new AbstractMap.SimpleEntry<>(left, leftLevel));
                    List<TreeNode> list = map.getOrDefault(leftLevel, new ArrayList<>());
                    list.add(left);
                    map.put(leftLevel, list);
                }

                TreeNode right = curr.getKey().right;
                if (right != null) {
                    int rightLevel = curr.getValue() + 1;
                    maxLevel = Math.max(maxLevel, rightLevel);
                    queue.offer(new AbstractMap.SimpleEntry<>(right, rightLevel));
                    List<TreeNode> list = map.getOrDefault(rightLevel, new ArrayList<>());
                    list.add(right);
                    map.put(rightLevel, list);
                }
            }
            queue.poll();
        }
//        System.out.println(map);

        int[][] ans = new int[maxLevel - minLevel + 1][];
        int count = 0;
        for (int i = minLevel; i <= maxLevel; i++) {
            List<TreeNode> current = map.getOrDefault(i, new ArrayList<>());
            ans[count++] = current.stream().mapToInt(value -> value.val).toArray();
        }
        return ans;
    }
}
