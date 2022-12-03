package scaler.advancedDsa.trees6;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HWQ3OddAndEvenLevels {
    //    Q3. Odd and Even Levels
//    Unsolved
//    character backgroundcharacter
//    Stuck somewhere?
//    Ask for help from a TA and get it resolved.
//    Get help from TA.
//    Problem Description
//    Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.
//    NOTE: Consider the level of root node as 1.
//    Problem Constraints
//1 <= Number of nodes in binary tree <= 100000
//            0 <= node values <= 109
//    Input Format
//    First and only argument is a root node of the binary tree, A
//    Output Format
//    Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.
//            Example Input
//    Input 1:
//            1
//            /   \
//            2     3
//            / \   / \
//            4   5 6   7
//            /
//            8
//    Input 2:
//            1
//            / \
//            2   10
//            \
//            4
//    Example Output
//    Output 1:
//            10
//    Output 2:
//            -7
//    Example Explanation
//    Explanation 1:
//    Sum of nodes at odd level = 23
//    Sum of ndoes at even level = 13
//    Explanation 2:
//    Sum of nodes at odd level = 5
//    Sum of ndoes at even level = 12
    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(new HWQ3OddAndEvenLevels().solve(TreeUtils.mapArrayToTree(input1)));
        int[] input2 = new int[]{1, 2, 10, -1, 4};
        System.out.println(new HWQ3OddAndEvenLevels().solve(TreeUtils.mapArrayToTree(input2)));
    }

    public int solve(TreeNode A) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(A);
        treeNodeQueue.offer(null);
        TreeNode curr = A;
        int level = 1;
        long oddSum = 0;
        long evenSum = 0;
        while (treeNodeQueue.size() > 1) {
            //1,null
            //null,2,3
            //2,3,null
            //3,null,4,5
            //null,4,5,6,7
            //4,5,6,7,null
            //5,6,7,null,8
            //6,7,null,8
            //7,null,8
            //null,8
            //8,null
            //null
            curr = treeNodeQueue.peek();
            treeNodeQueue.poll();
//            System.out.print(treeNodeQueue.poll() + " - ");
            if (curr == null) {
                treeNodeQueue.offer(null);
                level++;
//                System.out.print("\nlevel : " + level + " - ");
                continue;
            }
            if (level % 2 == 0) {
                evenSum = evenSum + curr.val;
            } else {
                oddSum = oddSum + curr.val;
            }
            if (curr.left != null) {
//                if (level % 2 == 0) {
//                    evenSum = evenSum + curr.left.val;
//                } else {
//                    oddSum = oddSum + curr.left.val;
//                }
                treeNodeQueue.offer(curr.left);
            }
            if (curr.right != null) {
//                if (level % 2 == 0) {
//                    evenSum = evenSum + curr.right.val;
//                } else {
//                    oddSum = oddSum + curr.right.val;
//                }
                treeNodeQueue.offer(curr.right);
            }
        }
//        System.out.println("evenSum : " + evenSum);
//        System.out.println("oddSum : " + oddSum);
        return (int) (oddSum - evenSum);
    }
}
