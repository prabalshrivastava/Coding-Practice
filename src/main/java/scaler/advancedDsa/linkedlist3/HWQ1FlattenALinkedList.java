package scaler.advancedDsa.linkedlist3;

import scaler.common.ListNode;

public class HWQ1FlattenALinkedList {
//    Problem Description
//    Given a linked list where every node represents a linked list and contains two pointers of its type:
//    Pointer to next node in the main list (right pointer)
//    Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
//    You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.
//    Problem Constraints
//1 <= Total nodes in the list <= 100000
//            1 <= Value of node <= 109
//    Input Format
//    The only argument given is head pointer of the doubly linked list.
//    Output Format
//    Return the head pointer of the Flattened list.
//    Example Input
//    Input 1:
//            3 -> 4 -> 20 -> 20 ->30
//            |    |    |     |    |
//            7    11   22    20   31
//            |               |    |
//            7               28   39
//            |               |
//            8               39
//    Input 2:
//            2 -> 4
//            |    |
//            7    11
//            |
//            7
//    Example Output
//    Output 1:
//            3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39
//    Output 2:
//            2 -> 4 -> 7 -> 7 -> 11
//    Example Explanation
//    Explanation 1:
//    The return linked list is the flatten sorted list.

    public static void main(String[] args) {
//        Input 1:
//        3 -> 4 -> 20 -> 20 ->30
//                |    |    |     |    |
//        7    11   22    20   31
//                |               |    |
//        7               28   39
//                |               |
//        8               39
//        Input 2:
//        2 -> 4
//                |    |
//        7    11
//                |
//                7
    }

    ListNode flatten(ListNode root) {
        ListNode ansList = root;
        ListNode right = root;
        while (right != null) {
            right = right.right;
            mergeTwoLists(ansList, right);
        }
        return root;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null)
            return B;
        if (B == null)
            return A;
        ListNode travA = A;
        ListNode travB = B;
        ListNode head = null;
        ListNode tail = null;
        if (A.val <= B.val) {
            head = A;
            tail = A;
            travA = travA.down;
        } else {
            head = B;
            tail = B;
            travB = travB.down;
        }
        while (travA != null && travB != null) {
            if (travA.val <= travB.val) {
                tail.down = travA;
                travA = travA.down;
                tail = tail.down;
            } else {
                tail.down = travB;
                travB = travB.down;
                tail = tail.down;
            }
        }
        if (travA != null) {
            tail.down = travA;
        }
        if (travB != null) {
            tail.down = travB;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode right, down;

        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }
}
