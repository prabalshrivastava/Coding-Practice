package scaler.advancedDsa.trees5;

import scaler.common.TreeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AQ3NextPointerBinaryTree {
//    Problem Description
//    Given a binary tree,
//    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//    Initially, all next pointers are set to NULL.
//    Assume perfect binary tree and try to solve this in constant extra space.
//    Problem Constraints
//1 <= Number of nodes in binary tree <= 100000
//            0 <= node values <= 10^9
//    Input Format
//    First and only argument is head of the binary tree A.
//            Output Format
//    Return the head of the binary tree after the changes are made.
//    Example Input
//    Input 1:
//            1
//            /  \
//            2    3
//    Input 2:
//            1
//            /  \
//            2    5
//            / \  / \
//            3  4  6  7
//    Example Output
//    Output 1:
//            1 -> NULL
//       /  \
//               2 -> 3 -> NULL
//    Output 2:
//            1 -> NULL
//       /  \
//               2 -> 5 -> NULL
//     / \  / \
//             3->4->6->7 -> NULL
//    Example Explanation
//    Explanation 1:
//    Next pointers are set as given in the output.
//            Explanation 2:
//    Next pointers are set as given in the output.

    public static void main(String[] args) {
        int[] input1A = {1, 2, 3};
        TreeLinkNode tree1A = TreeUtils.mapArrayToTreeLinkNode(input1A);
        new AQ3NextPointerBinaryTree().connect(tree1A);
        System.out.println(Arrays.deepToString(TreeUtils.levelOrderTreeLinkNode(tree1A)));

        int[] input2A = {1, 2, 5, 3, 4, 6, 7};
        TreeLinkNode tree2A = TreeUtils.mapArrayToTreeLinkNode(input2A);
        new AQ3NextPointerBinaryTree().connect(tree2A);
        System.out.println(Arrays.deepToString(TreeUtils.levelOrderTreeLinkNode(tree2A)));
    }

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeLinkNode previous = root;
        while (queue.size() > 1) {
            TreeLinkNode curr = queue.poll();
            if (previous != null && previous != root) {
                previous.next = curr;
//                System.out.println(previous + " -> " + previous.next);
            }
//            System.out.print(curr);
            if (curr == null) {
                queue.offer(null);
                continue;
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            previous = curr;
        }
    }
}
