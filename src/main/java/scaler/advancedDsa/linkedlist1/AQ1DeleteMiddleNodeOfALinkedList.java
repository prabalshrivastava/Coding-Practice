package scaler.advancedDsa.linkedlist1;

import scaler.common.ListNode;

public class AQ1DeleteMiddleNodeOfALinkedList {
    //    Given a singly linked list, delete middle of the linked list.
//    For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
//    If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
//    For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
//    Return the head of the linked list after removing the middle node.
//    If the input linked list has 1 node, then this node should be deleted and a null node should be returned.
//    Input Format
//    The only argument given is the node pointing to the head node of the linked list
    ListNode head;

    public static void main(String[] args) {
        AQ1DeleteMiddleNodeOfALinkedList aq1DeleteMiddleNodeOfALinkedList = new AQ1DeleteMiddleNodeOfALinkedList();
        aq1DeleteMiddleNodeOfALinkedList.addLastNode(1);
        aq1DeleteMiddleNodeOfALinkedList.addLastNode(2);
        aq1DeleteMiddleNodeOfALinkedList.addLastNode(3);
        aq1DeleteMiddleNodeOfALinkedList.addLastNode(4);
        aq1DeleteMiddleNodeOfALinkedList.addLastNode(5);
        aq1DeleteMiddleNodeOfALinkedList.print_ll();
        aq1DeleteMiddleNodeOfALinkedList.solve(aq1DeleteMiddleNodeOfALinkedList.head);
        aq1DeleteMiddleNodeOfALinkedList.print_ll();

        AQ1DeleteMiddleNodeOfALinkedList aq1DeleteMiddleNodeOfALinkedList1 = new AQ1DeleteMiddleNodeOfALinkedList();
        aq1DeleteMiddleNodeOfALinkedList1.addLastNode(1);
        aq1DeleteMiddleNodeOfALinkedList1.addLastNode(2);
        aq1DeleteMiddleNodeOfALinkedList1.addLastNode(3);
        aq1DeleteMiddleNodeOfALinkedList1.addLastNode(4);
        aq1DeleteMiddleNodeOfALinkedList1.addLastNode(5);
        aq1DeleteMiddleNodeOfALinkedList1.addLastNode(6);
        aq1DeleteMiddleNodeOfALinkedList1.print_ll();
        aq1DeleteMiddleNodeOfALinkedList1.solve(aq1DeleteMiddleNodeOfALinkedList1.head);
        aq1DeleteMiddleNodeOfALinkedList1.print_ll();
    }

    public ListNode solve(ListNode A) {
        return deleteMiddleNode(A);
    }
    ListNode deleteMiddleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            head = head.next;
            return head;
        }
        int length = 0;
        ListNode trav = head;
        while (trav != null) {
            length++;
            trav = trav.next;
        }
        trav = head;
        int traverseTill = length / 2;
        traverseTill--;
        while (traverseTill > 0) {
            trav = trav.next;
            traverseTill--;
        }
        trav.next = trav.next.next;
        return head;
    }

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

    public void print_ll() {
        // Output each element followed by a space
        ListNode trav = head;
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
