package scaler.advancedDsa.linkedlist3;

import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

public class AQ1MergeTwoSortedLists {
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
        AQ1MergeTwoSortedLists aq1MergeTwoSortedListsA = new AQ1MergeTwoSortedLists();
        AQ1MergeTwoSortedLists aq1MergeTwoSortedListsB = new AQ1MergeTwoSortedLists();
        aq1MergeTwoSortedListsA.head = LinkedListUtils.addFromArray(new int[]{5, 8, 20}, aq1MergeTwoSortedListsA.head);
        System.out.print("aq1MergeTwoSortedListsA.head : ");
        LinkedListUtils.print_ll(aq1MergeTwoSortedListsA.head);
        aq1MergeTwoSortedListsB.head = LinkedListUtils.addFromArray(new int[]{4, 11, 15}, aq1MergeTwoSortedListsB.head);
        System.out.print("aq1MergeTwoSortedListsB.head : ");
        LinkedListUtils.print_ll(aq1MergeTwoSortedListsB.head);
        System.out.print("Merged : ");
        LinkedListUtils.print_ll(aq1MergeTwoSortedListsA.mergeTwoLists(aq1MergeTwoSortedListsA.head, aq1MergeTwoSortedListsB.head));


        AQ1MergeTwoSortedLists aq1MergeTwoSortedLists1A = new AQ1MergeTwoSortedLists();
        AQ1MergeTwoSortedLists aq1MergeTwoSortedLists1B = new AQ1MergeTwoSortedLists();
        aq1MergeTwoSortedLists1A.head = LinkedListUtils.addFromArray(new int[]{1, 2, 3}, aq1MergeTwoSortedLists1A.head);
        System.out.print("aq1MergeTwoSortedLists1A.head : ");
        LinkedListUtils.print_ll(aq1MergeTwoSortedLists1A.head);
        aq1MergeTwoSortedLists1B.head = null;
        System.out.print("aq1MergeTwoSortedLists1B.head : ");
        LinkedListUtils.print_ll(aq1MergeTwoSortedLists1B.head);
        System.out.print("Merged : ");
        LinkedListUtils.print_ll(aq1MergeTwoSortedLists1A.mergeTwoLists(aq1MergeTwoSortedLists1A.head, aq1MergeTwoSortedLists1B.head));

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
