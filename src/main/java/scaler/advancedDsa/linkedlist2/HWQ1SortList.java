package scaler.advancedDsa.linkedlist2;

import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

public class HWQ1SortList {
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
        int[] input1A = {3, 4, 2, 8};
        HWQ1SortList hwq1SortList1 = new HWQ1SortList();
        LinkedListUtils.print_ll(hwq1SortList1.sortList(LinkedListUtils.addFromArrayAndPrint(input1A, hwq1SortList1.head)));
        int[] input2A = {1};
        HWQ1SortList hwq1SortList2 = new HWQ1SortList();
        LinkedListUtils.print_ll(hwq1SortList2.sortList(LinkedListUtils.addFromArrayAndPrint(input2A, hwq1SortList2.head)));
    }

    ListNode head;

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null)
            return A;
        ListNode middle = findMiddle(A);
        ListNode h1 = A;
        ListNode h2 = middle.next;
        middle.next = null;
        h1 = sortList(h1);
        h2 = sortList(h2);
        return mergeTwoLists(h1, h2);
    }


    public ListNode findMiddle(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        if (A == null)
            return null;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
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
