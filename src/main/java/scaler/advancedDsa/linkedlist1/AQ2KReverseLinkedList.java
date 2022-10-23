package scaler.advancedDsa.linkedlist1;

import scaler.advancedDsa.linkedlist2.ListNode;

public class AQ2KReverseLinkedList {
    //    Problem Description
//    Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
//    Problem Constraints
//1 <= |A| <= 103
//    B always divides A
//    Input Format
//    The first argument of input contains a pointer to the head of the linked list.
//    The second arugment of input contains the integer, B.
//    Output Format
//    Return a pointer to the head of the modified linked list.
//            Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5, 6]
//    B = 2
//    Input 2:
//    A = [1, 2, 3, 4, 5, 6]
//    B = 3
//    Example Output
//    Output 1:
//            [2, 1, 4, 3, 6, 5]
//    Output 2:
//            [3, 2, 1, 6, 5, 4]
//    Example Explanation
//    Explanation 1:
//    For the first example, the list can be reversed in groups of 2.
//            [[1, 2], [3, 4], [5, 6]]
//    After reversing the K-linked list
//    [[2, 1], [4, 3], [6, 5]]
//    Explanation 2:
//    For the second example, the list can be reversed in groups of 3.
//            [[1, 2, 3], [4, 5, 6]]
//    After reversing the K-linked list
//    [[3, 2, 1], [6, 5, 4]]
    public static void main(String[] args) {
        AQ2KReverseLinkedList aQ2KReverseLinkedList = new AQ2KReverseLinkedList();
        aQ2KReverseLinkedList.addLastNode(1);
        aQ2KReverseLinkedList.addLastNode(2);
        aQ2KReverseLinkedList.addLastNode(3);
        aQ2KReverseLinkedList.addLastNode(4);
        aQ2KReverseLinkedList.addLastNode(5);
        aQ2KReverseLinkedList.addLastNode(6);
        aQ2KReverseLinkedList.print_ll(aQ2KReverseLinkedList.head);
        aQ2KReverseLinkedList.print_ll(aQ2KReverseLinkedList.reverseList(aQ2KReverseLinkedList.head, 2));

        AQ2KReverseLinkedList aQ2KReverseLinkedList1 = new AQ2KReverseLinkedList();
        aQ2KReverseLinkedList1.addLastNode(1);
        aQ2KReverseLinkedList1.addLastNode(2);
        aQ2KReverseLinkedList1.addLastNode(3);
        aQ2KReverseLinkedList1.addLastNode(4);
        aQ2KReverseLinkedList1.addLastNode(5);
        aQ2KReverseLinkedList1.addLastNode(6);
        aQ2KReverseLinkedList1.addLastNode(7);
        aQ2KReverseLinkedList1.addLastNode(8);
        aQ2KReverseLinkedList1.addLastNode(9);
        aQ2KReverseLinkedList1.print_ll(aQ2KReverseLinkedList1.head);
        aQ2KReverseLinkedList1.print_ll(aQ2KReverseLinkedList1.reverseList(aQ2KReverseLinkedList1.head, 3));

        AQ2KReverseLinkedList aQ2KReverseLinkedList2 = new AQ2KReverseLinkedList();
        aQ2KReverseLinkedList2.addLastNode(1);
        aQ2KReverseLinkedList2.addLastNode(2);
        aQ2KReverseLinkedList2.addLastNode(3);
        aQ2KReverseLinkedList2.addLastNode(4);
        aQ2KReverseLinkedList2.addLastNode(5);
        aQ2KReverseLinkedList2.addLastNode(6);
        aQ2KReverseLinkedList2.addLastNode(7);
        aQ2KReverseLinkedList2.addLastNode(8);
        aQ2KReverseLinkedList2.addLastNode(9);
        aQ2KReverseLinkedList2.print_ll(aQ2KReverseLinkedList2.head);
        aQ2KReverseLinkedList2.print_ll(aQ2KReverseLinkedList2.reverseList(aQ2KReverseLinkedList2.head, 1));
    }

    public ListNode reverseList(ListNode A, int B) {
        if (B == 1)
            return A;
        ListNode trav = A;
        int count = 1;
        ListNode previous = A;
        boolean isFirst = true;
        while (trav != null) {
            ListNode start = trav;
            while (trav != null && count != B) {
                count++;
                trav = trav.next;
            }
            ListNode end = trav;
//            if (end != null)
//                System.out.println(start.val + " - " + end.val);
//            else
//                System.out.println(start.val + " - " + null);
            trav = trav.next;
            if (isFirst) {
                A = reverseRange(A, start, end, B);
                isFirst = false;
            } else {
                previous.next = reverseRange(A, start, end, B);
            }
//            print_ll(A);
//            System.out.println("");
            count = 1;
            previous = start;
        }
        return A;
    }

    private ListNode reverseRange(ListNode headNode, ListNode start, ListNode end, int b) {
//        System.out.printf("start(%s) - end(%s)%n", start, end);
        ListNode prev = end.next;
        ListNode curr = start;
        ListNode next;
        while (prev != end) {
            next = curr.next;
//            System.out.printf("prev(%s) - curr(%s) - next(%s)%n", prev, curr, next);
            curr.next = prev;
            prev = curr;
            curr = next;
//            System.out.printf("--------->prev(%s) - curr(%s) - next(%s)%n", prev, curr, next);
        }
//        System.out.printf("start.next(%s) - end.next(%s)%n", start.next, end.next);
        return end;
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
