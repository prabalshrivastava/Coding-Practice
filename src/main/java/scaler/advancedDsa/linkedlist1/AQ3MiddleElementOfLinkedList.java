package scaler.advancedDsa.linkedlist1;

import scaler.advancedDsa.linkedlist2.ListNode;

public class AQ3MiddleElementOfLinkedList {
    //    Problem Description
//    Given a linked list of integers, find and return the middle element of the linked list.
//            NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
//    Problem Constraints
//1 <= length of the linked list <= 100000
//            1 <= Node value <= 109
//    Input Format
//    The only argument given head pointer of linked list.
//            Output Format
//    Return the middle element of the linked list.
//    Example Input
//    Input 1:
//            1 -> 2 -> 3 -> 4 -> 5
//    Input 2:
//            1 -> 5 -> 6 -> 2 -> 3 -> 4
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//    The middle element is 3.
//    Explanation 2:
//    The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.
    public static void main(String[] args) {
        AQ3MiddleElementOfLinkedList aQ3MiddleElementOfLinkedList = new AQ3MiddleElementOfLinkedList();
        aQ3MiddleElementOfLinkedList.addLastNode(1);
        aQ3MiddleElementOfLinkedList.addLastNode(2);
        aQ3MiddleElementOfLinkedList.addLastNode(3);
        aQ3MiddleElementOfLinkedList.addLastNode(4);
        aQ3MiddleElementOfLinkedList.addLastNode(5);
        aQ3MiddleElementOfLinkedList.print_ll(aQ3MiddleElementOfLinkedList.head);
        System.out.println(aQ3MiddleElementOfLinkedList.solve(aQ3MiddleElementOfLinkedList.head));

        AQ3MiddleElementOfLinkedList aQ3MiddleElementOfLinkedList1 = new AQ3MiddleElementOfLinkedList();
        aQ3MiddleElementOfLinkedList1.addLastNode(1);
        aQ3MiddleElementOfLinkedList1.addLastNode(2);
        aQ3MiddleElementOfLinkedList1.addLastNode(3);
        aQ3MiddleElementOfLinkedList1.addLastNode(4);
        aQ3MiddleElementOfLinkedList1.addLastNode(5);
        aQ3MiddleElementOfLinkedList1.addLastNode(6);
        aQ3MiddleElementOfLinkedList1.addLastNode(7);
        aQ3MiddleElementOfLinkedList1.addLastNode(8);
        aQ3MiddleElementOfLinkedList1.addLastNode(9);
        aQ3MiddleElementOfLinkedList1.print_ll(aQ3MiddleElementOfLinkedList1.head);
        System.out.println(aQ3MiddleElementOfLinkedList1.solve(aQ3MiddleElementOfLinkedList1.head));

        AQ3MiddleElementOfLinkedList aQ3MiddleElementOfLinkedList2 = new AQ3MiddleElementOfLinkedList();
        aQ3MiddleElementOfLinkedList2.addLastNode(1);
        aQ3MiddleElementOfLinkedList2.addLastNode(2);
        aQ3MiddleElementOfLinkedList2.addLastNode(3);
        aQ3MiddleElementOfLinkedList2.addLastNode(4);
        aQ3MiddleElementOfLinkedList2.addLastNode(5);
        aQ3MiddleElementOfLinkedList2.addLastNode(6);
        aQ3MiddleElementOfLinkedList2.addLastNode(7);
        aQ3MiddleElementOfLinkedList2.addLastNode(8);
        aQ3MiddleElementOfLinkedList2.print_ll(aQ3MiddleElementOfLinkedList2.head);
        System.out.println(aQ3MiddleElementOfLinkedList2.solve(aQ3MiddleElementOfLinkedList2.head));

    }

    public int solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        if (A == null)
            return 0;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            return slow.val;
        } else {
            return slow.next.val;
        }
    }

    ListNode head;

    void addLastNode(int value) {
        ListNode trav = head;
        if (head == null) {
            head = new ListNode(value);
            return;
        }
        while (trav.next != null) {
            trav = trav.next;
        }
        trav.next = new ListNode(value);
    }

    public void print_ll(ListNode headPassed) {
        // Output each element followed by a space
        ListNode trav = headPassed;
        if (trav == null)
            return;
        while (trav.next != null) {
            System.out.print(trav.val + "->");
            trav = trav.next;
        }
        System.out.print(trav.val);
        System.out.println();
    }
}
