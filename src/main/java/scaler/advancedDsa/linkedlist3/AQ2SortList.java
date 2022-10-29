package scaler.advancedDsa.linkedlist3;

import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

public class AQ2SortList {
    //    Problem Description
//    Sort a linked list, A in O(n log n) time using constant space complexity.
//    Problem Constraints
//0 <= |A| = 105
//    Input Format
//    The first and the only arugment of input contains a pointer to the head of the linked list, A.
//    Output Format
//    Return a pointer to the head of the sorted linked list.
//            Example Input
//    Input 1:
//    A = [3, 4, 2, 8]
//    Input 2:
//    A = [1]
//    Example Output
//    Output 1:
//            [2, 3, 4, 8]
//    Output 2:
//            [1]
//    Example Explanation
//    Explanation 1:
//    The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
//    Explanation 2:
//    The sorted form of [1] is [1].
    public static void main(String[] args) {
//        int[] input1A = {3, 4, 2, 8};
//        AQ2SortList aq2SortList1 = new AQ2SortList();
//        LinkedListUtils.print_ll(aq2SortList1.sortList(LinkedListUtils.addFromArrayAndPrint(input1A, aq2SortList1.head)));
//        int[] input2A = {1};
//        AQ2SortList aq2SortList2 = new AQ2SortList();
//        LinkedListUtils.print_ll(aq2SortList2.sortList(LinkedListUtils.addFromArrayAndPrint(input2A, aq2SortList2.head)));

        int[] input3A = {3, 4, 2, 8, 7, 5, 4};
        AQ2SortList aq2SortList3 = new AQ2SortList();
        LinkedListUtils.print_ll(aq2SortList3.sortList(LinkedListUtils.addFromArrayAndPrint(input3A, aq2SortList3.head)));
    }

    ListNode head;

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null)
            return A;
        ListNode middle = findMiddle(A);
//        System.out.println("findmiddle returned : " + middle);
        ListNode h2 = middle.next;
        middle.next = null;
//        System.out.println("Passing A:" + A);
        A = sortList(A);
//        System.out.println("Passing h2:" + h2);
        h2 = sortList(h2);
//        System.out.println("calling mergeTwoLists(A, h2)");
        return mergeTwoLists(A, h2);
    }


    public ListNode findMiddle(ListNode A) {
//        LinkedListUtils.print_ll(A);
        ListNode slow = A;
        ListNode fast = A;
        if (A == null)
            return null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode h3;
        ListNode tail;
        ListNode travA = A;
        ListNode travB = B;
        if (A == null)
            return B;
        if (B == null)
            return A;

        if (travA.val < travB.val) {
            h3 = travA;
            tail = travA;
            travA = travA.next;
        } else {
            h3 = travB;
            tail = travB;
            travB = travB.next;
        }


        while (travA != null && travB != null) {
            if (travA.val < travB.val) {
                tail.next = travA;
                travA = travA.next;
                tail = tail.next;
            } else {
                tail.next = travB;
                travB = travB.next;
                tail = tail.next;
            }
        }
        if (travA != null) {
            tail.next = travA;
        }
        if (travB != null) {
            tail.next = travB;
        }
        return h3;
    }

}
