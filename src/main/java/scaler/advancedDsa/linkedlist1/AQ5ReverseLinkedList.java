package scaler.advancedDsa.linkedlist1;

import sun.security.util.Length;

public class AQ5ReverseLinkedList {
    //    Problem Description
//    You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
//            NOTE: You have to do it in-place and in one-pass.
//            Problem Constraints
//1 <= Length of linked list <= 105
//    Value of each node is within the range of a 32-bit integer.
//    Input Format
//    First and only argument is a linked-list node A.
//            Output Format
//    Return a linked-list node denoting the head of the reversed linked list.
//    Example Input
//    Input 1:
//    A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
//    Input 2:
//    A = 3 -> NULL
//    Example Output
//    Output 1:
//            5 -> 4 -> 3 -> 2 -> 1 -> NULL
//    Output 2:
//            3 -> NULL
//    Example Explanation
//    Explanation 1:
//    The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL
//    Expalantion 2:
//    The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL
    ListNode head;

    public static void main(String[] args) {
        AQ5ReverseLinkedList aQ5ReverseLinkedList = new AQ5ReverseLinkedList();
        aQ5ReverseLinkedList.addLastNode(1);
        aQ5ReverseLinkedList.addLastNode(2);
        aQ5ReverseLinkedList.addLastNode(3);
        aQ5ReverseLinkedList.addLastNode(4);
        aQ5ReverseLinkedList.addLastNode(5);
        aQ5ReverseLinkedList.print_ll();
        aQ5ReverseLinkedList.reverseList(aQ5ReverseLinkedList.head);
        aQ5ReverseLinkedList.print_ll();

        AQ5ReverseLinkedList aQ5ReverseLinkedList1 = new AQ5ReverseLinkedList();
        aQ5ReverseLinkedList1.addLastNode(1);
        aQ5ReverseLinkedList1.addLastNode(2);
        aQ5ReverseLinkedList1.addLastNode(3);
        aQ5ReverseLinkedList1.addLastNode(4);
        aQ5ReverseLinkedList1.addLastNode(5);
        aQ5ReverseLinkedList1.addLastNode(6);
        aQ5ReverseLinkedList1.print_ll();
        aQ5ReverseLinkedList1.reverseList(aQ5ReverseLinkedList1.head);
        aQ5ReverseLinkedList1.print_ll();
    }

    public ListNode reverseList(ListNode A) {
        ListNode trav = A;
        ListNode newHead = null;
        while (trav != null) {
            addLastNode(trav.val);//sc n with this
        }
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
