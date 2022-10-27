package scaler.advancedDsa.linkedlist2;

import scaler.advancedDsa.linkedlist1.AQ6LinkedList;
import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

public class HWQ2MergeTwoSortedLists {
    //    Problem Description
//    Merge two sorted linked lists, A and B, and return it as a new list.
//            The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
//            Problem Constraints
//0 <= |A|, |B| <= 105
//    Input Format
//    The first argument of input contains a pointer to the head of linked list A.
//    The second argument of input contains a pointer to the head of linked list B.
//            Output Format
//    Return a pointer to the head of the merged linked list.
//            Example Input
//    Input 1:
//    A = 5 -> 8 -> 20
//    B = 4 -> 11 -> 15
//    Input 2:
//    A = 1 -> 2 -> 3
//    B = Null
//    Example Output
//    Output 1:
//            4 -> 5 -> 8 -> 11 -> 15 -> 20
//    Output 2:
//            1 -> 2 -> 3
//    Example Explanation
//    Explanation 1:
//    Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
//    Explanation 2:
//    We don't need to merge as B is empty.
    public static void main(String[] args) {
        HWQ2MergeTwoSortedLists hwq2MergeTwoSortedListsA = new HWQ2MergeTwoSortedLists();
        HWQ2MergeTwoSortedLists hwq2MergeTwoSortedListsB = new HWQ2MergeTwoSortedLists();
        hwq2MergeTwoSortedListsA.head = LinkedListUtils.addFromArray(new int[]{5, 8, 20}, hwq2MergeTwoSortedListsA.head);
        System.out.print("hwq2MergeTwoSortedListsA.head : ");
        LinkedListUtils.print_ll(hwq2MergeTwoSortedListsA.head);
        hwq2MergeTwoSortedListsB.head = LinkedListUtils.addFromArray(new int[]{4, 11, 15}, hwq2MergeTwoSortedListsB.head);
        System.out.print("hwq2MergeTwoSortedListsB.head : ");
        LinkedListUtils.print_ll(hwq2MergeTwoSortedListsB.head);
        System.out.print("Merged : ");
        LinkedListUtils.print_ll(hwq2MergeTwoSortedListsA.mergeTwoLists(hwq2MergeTwoSortedListsA.head, hwq2MergeTwoSortedListsB.head));


        HWQ2MergeTwoSortedLists hwq2MergeTwoSortedLists1A = new HWQ2MergeTwoSortedLists();
        HWQ2MergeTwoSortedLists hwq2MergeTwoSortedLists1B = new HWQ2MergeTwoSortedLists();
        hwq2MergeTwoSortedLists1A.head = LinkedListUtils.addFromArray(new int[]{1, 2, 3}, hwq2MergeTwoSortedLists1A.head);
        System.out.print("hwq2MergeTwoSortedLists1A.head : ");
        LinkedListUtils.print_ll(hwq2MergeTwoSortedLists1A.head);
        hwq2MergeTwoSortedLists1B.head = null;
        System.out.print("hwq2MergeTwoSortedLists1B.head : ");
        LinkedListUtils.print_ll(hwq2MergeTwoSortedLists1B.head);
        System.out.print("Merged : ");
        LinkedListUtils.print_ll(hwq2MergeTwoSortedLists1A.mergeTwoLists(hwq2MergeTwoSortedLists1A.head, hwq2MergeTwoSortedLists1B.head));

    }

    ListNode head;

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
