package scaler.advancedDsa.linkedlist1;

import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

public class HWQ1RemoveNthNodeFromListEnd {
//    Problem Description
//    Given a linked list A, remove the B-th node from the end of the list and return its head.
//    For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.
//    NOTE: If B is greater than the size of the list, remove the first node of the list.
//    NOTE: Try doing it using constant additional space.
//            Problem Constraints
//1 <= |A| <= 106
//    Input Format
//    The first argument of input contains a pointer to the head of the linked list.
//    The second argument of input contains the integer B.
//            Output Format
//    Return the head of the linked list after deleting the B-th element from the end.
//            Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    B = 2
//    Input 2:
//    A = [1]
//    B = 1
//    Example Output
//    Output 1:
//            [1, 2, 3, 5]
//    Output 2:
//            []
//    Example Explanation
//    Explanation 1:
//    In the first example, 4 is the second last element.
//            Explanation 2:
//    In the second example, 1 is the first and the last element.

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        HWQ1RemoveNthNodeFromListEnd hwq1RemoveNthNodeFromListEnd = new HWQ1RemoveNthNodeFromListEnd();
        hwq1RemoveNthNodeFromListEnd.head = LinkedListUtils.addFromArrayAndPrint(arr, hwq1RemoveNthNodeFromListEnd.head);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd.removeNthFromEnd(hwq1RemoveNthNodeFromListEnd.head, 5));

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        HWQ1RemoveNthNodeFromListEnd hwq1RemoveNthNodeFromListEnd1 = new HWQ1RemoveNthNodeFromListEnd();
        hwq1RemoveNthNodeFromListEnd1.head = LinkedListUtils.addFromArrayAndPrint(arr1, hwq1RemoveNthNodeFromListEnd1.head);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd1.removeNthFromEnd(hwq1RemoveNthNodeFromListEnd1.head, 1));

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        HWQ1RemoveNthNodeFromListEnd hwq1RemoveNthNodeFromListEnd2 = new HWQ1RemoveNthNodeFromListEnd();
        hwq1RemoveNthNodeFromListEnd2.head = LinkedListUtils.addFromArrayAndPrint(arr2, hwq1RemoveNthNodeFromListEnd2.head);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd2.removeNthFromEnd(hwq1RemoveNthNodeFromListEnd2.head, 1));

        HWQ1RemoveNthNodeFromListEnd hwq1RemoveNthNodeFromListEnd3 = new HWQ1RemoveNthNodeFromListEnd();
        hwq1RemoveNthNodeFromListEnd3.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd3.head, 1);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd3.head);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd3.removeNthFromEnd(hwq1RemoveNthNodeFromListEnd3.head, 1));

        int[] arr4 = {20, 380, 349, 322, 389, 424, 429, 120, 64, 691, 677, 58, 327, 631, 916, 203, 484, 918, 596, 252, 509, 644, 33, 460};
        HWQ1RemoveNthNodeFromListEnd hwq1RemoveNthNodeFromListEnd4 = new HWQ1RemoveNthNodeFromListEnd();
        hwq1RemoveNthNodeFromListEnd4.head = LinkedListUtils.addFromArrayAndPrint(arr4, hwq1RemoveNthNodeFromListEnd4.head);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd4.removeNthFromEnd(hwq1RemoveNthNodeFromListEnd4.head, 82));

    }

    ListNode head;

    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode trav = A;
        int count = 0;
        if (A == null) {
            return A;
        }
        if (A.next == null && B == 1) {
            A = A.next;
            return A;
        }
        while (trav != null) {
            trav = trav.next;
            count++;
        }
//        System.out.println("count : " + count);
        int elementCount = count - B;
//        System.out.println("element : " + elementCount);
        if (B > count || elementCount == 0) {
            return A.next;
        }
        count = 1;
        trav = A;
        while (trav != null && count != elementCount) {
            trav = trav.next;
            count++;
        }
//        System.out.println("trav : " + trav);
        if (trav != null && trav.next != null) {
            trav.next = trav.next.next;
        }
        return A;
    }

//    public ListNode removeNthFromEnd(ListNode A, int B) {
//        ListNode trav = A;
//        int count = 1;
//        while (trav != null && count != B - 1) {
//            trav = trav.next;
//            count++;
//        }
//        if (trav != null && trav.next != null)
//            trav.next = trav.next.next;
//        else {
//            A = A.next;
//            return A;
//        }
//        return A;
//    }
}
