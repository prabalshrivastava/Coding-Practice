package scaler.advancedDsa.linkedlist2;

import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

public class AQ3ReorderList {
    //    Problem Description
//    Given a singly linked list A
//    A: A0 → A1 → … → An-1 → An
//    reorder it to:
//    A0 → An → A1 → An-1 → A2 → An-2 → …
//    You must do this in-place without altering the nodes' values.
//    Problem Constraints
//1 <= |A| <= 106
//    Input Format
//    The first and the only argument of input contains a pointer to the head of the linked list A.
//            Output Format
//    Return a pointer to the head of the modified linked list.
//            Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    Input 2:
//    A = [1, 2, 3, 4]
//    Example Output
//    Output 1:
//            [1, 5, 2, 4, 3]
//    Output 2:
//            [1, 4, 2, 3]
//    Example Explanation
//    Explanation 1:
//    The array will be arranged to [A0, An, A1, An-1, A2].
//    Explanation 2:
//    The array will be arranged to [A0, An, A1, An-1, A2].
    public static void main(String[] args) {
        AQ3ReorderList aq3ReorderList = new AQ3ReorderList();
        aq3ReorderList.head = LinkedListUtils.addLastNode(aq3ReorderList.head, 1);
        aq3ReorderList.head = LinkedListUtils.addLastNode(aq3ReorderList.head, 2);
        aq3ReorderList.head = LinkedListUtils.addLastNode(aq3ReorderList.head, 3);
        aq3ReorderList.head = LinkedListUtils.addLastNode(aq3ReorderList.head, 4);
        aq3ReorderList.head = LinkedListUtils.addLastNode(aq3ReorderList.head, 5);
        aq3ReorderList.head = LinkedListUtils.addLastNode(aq3ReorderList.head, 6);
        LinkedListUtils.print_ll(aq3ReorderList.head);
        LinkedListUtils.print_ll(aq3ReorderList.reorderList(aq3ReorderList.head));
//        aq3ReorderList.reorderList(aq3ReorderList.head);
        System.out.println("------------------------------------------------------------------");

        AQ3ReorderList aq3ReorderList1 = new AQ3ReorderList();
        aq3ReorderList1.head = LinkedListUtils.addLastNode(aq3ReorderList1.head, 1);
        aq3ReorderList1.head = LinkedListUtils.addLastNode(aq3ReorderList1.head, 2);
        aq3ReorderList1.head = LinkedListUtils.addLastNode(aq3ReorderList1.head, 3);
        aq3ReorderList1.head = LinkedListUtils.addLastNode(aq3ReorderList1.head, 4);
        aq3ReorderList1.head = LinkedListUtils.addLastNode(aq3ReorderList1.head, 5);
        aq3ReorderList1.head = LinkedListUtils.addLastNode(aq3ReorderList1.head, 6);
        aq3ReorderList1.head = LinkedListUtils.addLastNode(aq3ReorderList1.head, 7);
        aq3ReorderList1.head = LinkedListUtils.addLastNode(aq3ReorderList1.head, 8);
        aq3ReorderList1.head = LinkedListUtils.addLastNode(aq3ReorderList1.head, 9);
        aq3ReorderList1.head = LinkedListUtils.addLastNode(aq3ReorderList1.head, 10);
        LinkedListUtils.print_ll(aq3ReorderList1.head);
        LinkedListUtils.print_ll(aq3ReorderList1.reorderList(aq3ReorderList1.head));
//        aq3ReorderList1.reorderList(aq3ReorderList1.head);
        System.out.println("------------------------------------------------------------------");

        AQ3ReorderList aq4ReorderList = new AQ3ReorderList();
        aq4ReorderList.head = LinkedListUtils.addLastNode(aq4ReorderList.head, 1);
        aq4ReorderList.head = LinkedListUtils.addLastNode(aq4ReorderList.head, 2);
        aq4ReorderList.head = LinkedListUtils.addLastNode(aq4ReorderList.head, 3);
        LinkedListUtils.print_ll(aq4ReorderList.head);
        LinkedListUtils.print_ll(aq4ReorderList.reorderList(aq4ReorderList.head));
//        aq4ReorderList.reorderList(aq4ReorderList.head);
        System.out.println("------------------------------------------------------------------");


    }

    ListNode head;

    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null || A.next.next == null)
            return A;

        ListNode trav = A;
        int count = 0;
        while (trav != null) {
            System.out.println(trav.val);
            trav = trav.next;
            count++;
        }
        System.out.println("count : " + count);

        trav = A;
        int mid;
        if (count % 2 == 0) {
            mid = count / 2;
        } else {
            mid = (count + 1) / 2;
        }
        System.out.println("mid : " + mid);
        count = 0;
        ListNode prev = trav;
        while (count != mid) {
            prev = trav;
            trav = trav.next;
            count++;
        }
        System.out.println("prev.val : " + prev.val);
        System.out.println("trav.val : " + trav.val);
        ListNode start = prev;
        System.out.println("start.val : " + start.val);
        ListNode curr = prev.next;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        start.next.next = next;
        start.next = prev;


        ListNode c1 = A;
        ListNode n1 = c1.next;

        ListNode c2 = start.next;
        ListNode n2 = c2.next;
        LinkedListUtils.print_ll(A);
//        System.out.println("c1:" + c1.val + " - c2:" + c2.val + " - n1:" + n1.val + " - n2:" + n2.val);

        while (n2 != null) {
//            System.out.println("c1:" + c1.val + " - c2:" + c2.val + " - n1:" + n1.val + " - n2:" + n2.val);
            c1.next = c2;
            c2.next = n1;

            c1 = n1;
            c2 = n2;
            n1 = n1.next;
            n2 = n2.next;
            System.out.println("---------->c1:" + c1 + " - c2:" + c2 + " - n1:" + n1 + " - n2:" + n2);
            if (n2 == null)
                c2 = null;
//            System.out.println("---------->c1:" + c1.val + " - c2:" + c2.val + " - n1:" + n1.val + " - n2:" + n2.val);
//            LinkedListUtils.print_ll(A);
        }

        return A;
    }
}
