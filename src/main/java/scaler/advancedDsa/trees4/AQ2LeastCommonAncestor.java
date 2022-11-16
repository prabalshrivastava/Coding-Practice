package scaler.advancedDsa.trees4;

import scaler.common.TreeUtils;
import scaler.module1.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AQ2LeastCommonAncestor {
    //    Problem Description
//    Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
//    Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
//    Problem Constraints
//1 <= size of tree <= 100000
//            1 <= B, C <= 109
//    Input Format
//    First argument is head of tree A.
//    Second argument is integer B.
//    Third argument is integer C.
//            Output Format
//    Return the LCA.
//            Example Input
//    Input 1:
//            1
//            /  \
//            2    3
//    B = 2
//    C = 3
//    Input 2:
//            1
//            /  \
//            2    3
//            / \
//            4   5
//    B = 4
//    C = 5
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//    LCA is 1.
//    Explanation 2:
//    LCA is 2.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3};
        System.out.println(new AQ2LeastCommonAncestor().lca(TreeUtils.mapArrayToTree(input1A), 2, 3));//
        int[] input2A = {1, 2, 3, 4, 5};
        System.out.println(new AQ2LeastCommonAncestor().lca(TreeUtils.mapArrayToTree(input2A), 4, 5));//
        int[] input3A = {3, 1, -1, -1};
        System.out.println(new AQ2LeastCommonAncestor().lca(TreeUtils.mapArrayToTree(input3A), 1, 1));//
        int[] input4A = {27, 4, 8, 7, 13, 6, -1, -1, -1, -1, 9, 10, 12, -1, 2, 11, -1, -1, -1, -1, -1, 5, 1, -1, -1, 3, -1, -1};
        System.out.println(new AQ2LeastCommonAncestor().lca(TreeUtils.mapArrayToTree(input4A), 31, 39));//
        int[] input5A = {87, 14, 39, 13, 7, 16, 25, 11, 41, 1, -1, 26, -1, 36, 23, 12, 22, 43, 28, -1, -1, -1, 38, 31, 2, -1, -1, 32, 4, 20, -1, -1, 30, 34, -1, -1, 8, -1, -1, 29, -1, 27, 24, -1, 42, -1, 9, -1, -1, 37, -1, -1, -1, 3, -1, -1, 5, 17, -1, -1, 18, -1, 21, 40, -1, -1, 10, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, 19, 6, 33, -1, -1, -1, -1, -1, -1};
        System.out.println(new AQ2LeastCommonAncestor().lca(TreeUtils.mapArrayToTree(input5A), 31, 32));//
    }

//    public int lca(TreeNode A, int B, int C) {
    //will work with BST
//        TreeNode temp = A;
//        while (temp != null) {
//            System.out.print(temp.val + ",");
//            if (B < temp.val && C < temp.val) {
//                temp = temp.left;
//            } else if (B > temp.val && C > temp.val) {
//                temp = temp.right;
//            } else {
//                return temp.val;
//            }
//        }
//        System.out.println("---");
//        return -1;
//    }

    public int lca(TreeNode A, int B, int C) {
        Stack<TreeNode> treeNodeStack1 = new Stack<>();
        findElementPath(A, B, treeNodeStack1);
//        System.out.println(treeNodeStack1);
        Stack<TreeNode> treeNodeStack2 = new Stack<>();
        findElementPath(A, C, treeNodeStack2);
//        System.out.println(treeNodeStack2);

        List<Integer> list1 = new ArrayList<>();
        while (!treeNodeStack1.isEmpty()) {
            list1.add(treeNodeStack1.pop().val);
        }
        List<Integer> list2 = new ArrayList<>();
        while (!treeNodeStack2.isEmpty()) {
            list2.add(treeNodeStack2.pop().val);
        }

        int i = 0;
        int min = Math.min(list1.size(), list2.size());
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println("min " + min);

        if (list1.isEmpty() || list2.isEmpty()) {
            return -1;
        }
        while (i < min && list1.get(i).equals(list2.get(i))) {
            i++;
        }
//        if (i == min)
        i--;
        return list1.get(i);
    }

    private boolean findElementPath(TreeNode A, int B, Stack<TreeNode> treeNodeStack) {
        if (A == null) {
            return false;
        }
        if (A.val == B) {
            treeNodeStack.push(A);
            return true;
        }
        if (findElementPath(A.left, B, treeNodeStack) || findElementPath(A.right, B, treeNodeStack)) {
            treeNodeStack.push(A);
            return true;
        }
        return false;
    }
}
