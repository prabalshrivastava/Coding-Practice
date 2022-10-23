package scaler.advancedDsa.linkedlist1;

import scaler.advancedDsa.linkedlist2.LinkedListUtils;
import scaler.advancedDsa.linkedlist2.ListNode;

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
        HWQ1RemoveNthNodeFromListEnd hwq1RemoveNthNodeFromListEnd = new HWQ1RemoveNthNodeFromListEnd();
        hwq1RemoveNthNodeFromListEnd.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd.head, 1);
        hwq1RemoveNthNodeFromListEnd.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd.head, 2);
        hwq1RemoveNthNodeFromListEnd.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd.head, 3);
        hwq1RemoveNthNodeFromListEnd.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd.head, 4);
        hwq1RemoveNthNodeFromListEnd.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd.head, 5);
        hwq1RemoveNthNodeFromListEnd.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd.head, 6);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd.head);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd.removeNthFromEnd(hwq1RemoveNthNodeFromListEnd.head, 2));

        HWQ1RemoveNthNodeFromListEnd hwq1RemoveNthNodeFromListEnd1 = new HWQ1RemoveNthNodeFromListEnd();
        hwq1RemoveNthNodeFromListEnd1.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd1.head, 1);
        hwq1RemoveNthNodeFromListEnd1.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd1.head, 2);
        hwq1RemoveNthNodeFromListEnd1.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd1.head, 3);
        hwq1RemoveNthNodeFromListEnd1.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd1.head, 4);
        hwq1RemoveNthNodeFromListEnd1.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd1.head, 5);
        hwq1RemoveNthNodeFromListEnd1.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd1.head, 6);
        hwq1RemoveNthNodeFromListEnd1.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd1.head, 7);
        hwq1RemoveNthNodeFromListEnd1.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd1.head, 8);
        hwq1RemoveNthNodeFromListEnd1.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd1.head, 9);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd1.head);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd1.removeNthFromEnd(hwq1RemoveNthNodeFromListEnd1.head, 1));

        HWQ1RemoveNthNodeFromListEnd hwq1RemoveNthNodeFromListEnd2 = new HWQ1RemoveNthNodeFromListEnd();
        hwq1RemoveNthNodeFromListEnd2.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd2.head, 1);
        hwq1RemoveNthNodeFromListEnd2.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd2.head, 2);
        hwq1RemoveNthNodeFromListEnd2.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd2.head, 3);
        hwq1RemoveNthNodeFromListEnd2.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd2.head, 4);
        hwq1RemoveNthNodeFromListEnd2.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd2.head, 5);
        hwq1RemoveNthNodeFromListEnd2.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd2.head, 6);
        hwq1RemoveNthNodeFromListEnd2.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd2.head, 7);
        hwq1RemoveNthNodeFromListEnd2.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd2.head, 8);
        hwq1RemoveNthNodeFromListEnd2.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd2.head, 9);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd2.head);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd2.removeNthFromEnd(hwq1RemoveNthNodeFromListEnd2.head, 1));

        HWQ1RemoveNthNodeFromListEnd hwq1RemoveNthNodeFromListEnd3 = new HWQ1RemoveNthNodeFromListEnd();
        hwq1RemoveNthNodeFromListEnd3.head = LinkedListUtils.addLastNode(hwq1RemoveNthNodeFromListEnd3.head, 1);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd3.head);
        LinkedListUtils.print_ll(hwq1RemoveNthNodeFromListEnd3.removeNthFromEnd(hwq1RemoveNthNodeFromListEnd3.head, 1));

    }

    ListNode head;

    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode trav = A;
        int count = 1;
        while (trav != null && count != B - 1) {
            trav = trav.next;
            count++;
        }
        if (trav != null && trav.next != null)
            trav.next = trav.next.next;
        else {
            A = A.next;
            return A;
        }
        return A;
    }
}
