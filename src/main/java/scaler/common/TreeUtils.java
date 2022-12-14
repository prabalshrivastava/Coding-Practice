package scaler.common;

import scaler.advancedDsa.trees5.TreeLinkNode;
import scaler.module1.trees.TreeNode;

import java.util.*;

public class TreeUtils {

    public static void postOrder(TreeNode A, List<Integer> list) {
        if (A == null)
            return;
        postOrder(A.left, list);
        postOrder(A.right, list);
        System.out.println(A.val);
    }

    private void inOrder(TreeNode A, List<Integer> list) {
        if (A == null)
            return;
        inOrder(A.left, list);
        System.out.println(A.val);
        inOrder(A.right, list);
    }

    private void preOrder(TreeNode A, List<Integer> list) {
        if (A == null)
            return;
        System.out.println(A.val);
        preOrder(A.left, list);
        preOrder(A.right, list);
    }

    public static int[][] levelOrder(TreeNode A) {
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


    public static int[][] levelOrderTreeLinkNode(TreeLinkNode A) {
        TreeLinkNode curr;
        Queue<TreeLinkNode> treeNodeQueue = new LinkedList<>();
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
        return ans;
    }



        public static TreeNode mapArrayToTree(int[] A) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(A[0]);
        TreeNode curr;
        queue.offer(root);
        for (int i = 1; i < A.length; i++) {
            curr = queue.peek();
            if (curr == null) {
                queue.poll();
                continue;
            }
            if (A[i] == -1)
                curr.left = null;
            else {
                curr.left = new TreeNode(A[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i >= A.length) {
                break;
            }
            if (A[i] == -1)
                curr.right = null;
            else {
                curr.right = new TreeNode(A[i]);
                queue.offer(curr.right);
            }
            queue.poll();
        }
        return root;
    }

    public static TreeLinkNode mapArrayToTreeLinkNode(int[] A) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode root = new TreeLinkNode(A[0]);
        TreeLinkNode curr;
        queue.offer(root);
        for (int i = 1; i < A.length; i++) {
            curr = queue.peek();
            if (curr == null) {
                queue.poll();
                continue;
            }
            if (A[i] == -1)
                curr.left = null;
            else {
                curr.left = new TreeLinkNode(A[i]);
                queue.offer(curr.left);
            }
            i++;

            if (i >= A.length) {
                break;
            }
            if (A[i] == -1)
                curr.right = null;
            else {
                curr.right = new TreeLinkNode(A[i]);
                queue.offer(curr.right);
            }
            queue.poll();
        }
        return root;
    }
}
