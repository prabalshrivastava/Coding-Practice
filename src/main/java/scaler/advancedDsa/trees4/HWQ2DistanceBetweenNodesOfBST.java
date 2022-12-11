package scaler.advancedDsa.trees4;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class HWQ2DistanceBetweenNodesOfBST {
    //    Problem Description
//    Given a binary search tree.
//    Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.
//    NOTE: Distance between two nodes is number of edges between them.
//    Problem Constraints
//1 <= Number of nodes in binary tree <= 1000000
//            0 <= node values <= 109
//    Input Format
//    First argument is a root node of the binary tree, A.
//    Second argument is an integer B.
//    Third argument is an integer C.
//    Output Format
//    Return an integer denoting the distance between two nodes with given two keys B and C
//    Example Input
//    Input 1:
//            5
//            /   \
//            2     8
//            / \   / \
//            1   4 6   11
//    B = 2
//    C = 11
//    Input 2:
//            6
//            /   \
//            2     9
//            / \   / \
//            1   4 7   10
//    B = 2
//    C = 6
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
//    Explanation 2:
//    Path between 2 and 6 is: 2 -> 6. Distance will be 1
    public static void main(String[] args) {
        int[] input1A = {5, 2, 8, 1, 4, 6, 11};
        System.out.println(new HWQ2DistanceBetweenNodesOfBST().solve(TreeUtils.mapArrayToTree(input1A), 2, 11));

        int[] input2A = {6, 2, 9, 1, 4, 7, 10};
        System.out.println(new HWQ2DistanceBetweenNodesOfBST().solve(TreeUtils.mapArrayToTree(input2A), 2, 6));
    }

    public int solve(TreeNode A, int B, int C) {
        List<TreeNode> listB = findElementPath(A, B);
//        System.out.println(listB);
        List<TreeNode> listC = findElementPath(A, C);
//        System.out.println(listC);
        int minSize = Math.min(listB.size(), listC.size());
        int totalSize = listB.size() + listC.size();
        int i = 0;
        while (i < minSize && listB.get(i).val == listC.get(i).val) {
            i++;
        }
        return totalSize - 2 * i;
    }

    private List<TreeNode> findElementPath(TreeNode A, int B) {
//        System.out.println("Searching : " + B);
        List<TreeNode> treeNodesList = new ArrayList<>();
        TreeNode curr = A;
        if (curr == null)
            return treeNodesList;
        while (curr != null) {
            treeNodesList.add(curr);
            if (curr.val == B) {
//                System.out.println("found");
                return treeNodesList;
            } else if (B < curr.val) {
                //go to left
//                System.out.println("curr : " + curr.val + " going left");
                curr = curr.left;
            } else {
                //go to right
//                System.out.println("curr : " + curr.val + " going right");
                curr = curr.right;
            }
        }
        return treeNodesList;
    }
}
