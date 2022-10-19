package scaler.advancedDsa.linkedlist1;

public class AQ4ReverseLinkListII {
    //    Problem Description
//    Reverse a linked list A from position B to C.
//    NOTE: Do it in-place and in one-pass.
//            Problem Constraints
//1 <= |A| <= 106
//            1 <= B <= C <= |A|
//    Input Format
//    The first argument contains a pointer to the head of the given linked list, A.
//    The second arugment contains an integer, B.
//    The third argument contains an integer C.
//            Output Format
//    Return a pointer to the head of the modified linked list.
//            Example Input
//    Input 1:
//    A = 1 -> 2 -> 3 -> 4 -> 5
//    B = 2
//    C = 4
//    Input 2:
//    A = 1 -> 2 -> 3 -> 4 -> 5
//    B = 1
//    C = 5
//    Example Output
//    Output 1:
//            1 -> 4 -> 3 -> 2 -> 5
//    Output 2:
//            5 -> 4 -> 3 -> 2 -> 1
//    Example Explanation
//    Explanation 1:
//    In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
//    Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
//    Explanation 2:
//    In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
//    Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
    public static void main(String[] args) {
        AQ4ReverseLinkListII aQ5ReverseLinkedList = new AQ4ReverseLinkListII();
        aQ5ReverseLinkedList.addLastNode(1);
        aQ5ReverseLinkedList.addLastNode(2);
        aQ5ReverseLinkedList.addLastNode(3);
        aQ5ReverseLinkedList.addLastNode(4);
        aQ5ReverseLinkedList.addLastNode(5);
        aQ5ReverseLinkedList.print_ll(aQ5ReverseLinkedList.head);
//        aQ5ReverseLinkedList.print_ll(aQ5ReverseLinkedList.reverseBetween(aQ5ReverseLinkedList.head, 2, 4));
        aQ5ReverseLinkedList.reverseBetween(aQ5ReverseLinkedList.head, 2, 4);

//        AQ4ReverseLinkListII aQ5ReverseLinkedList1 = new AQ4ReverseLinkListII();
//        aQ5ReverseLinkedList1.addLastNode(1);
//        aQ5ReverseLinkedList1.addLastNode(2);
//        aQ5ReverseLinkedList1.addLastNode(3);
//        aQ5ReverseLinkedList1.addLastNode(4);
//        aQ5ReverseLinkedList1.addLastNode(5);
//        aQ5ReverseLinkedList1.print_ll(aQ5ReverseLinkedList.head);
//        aQ5ReverseLinkedList1.print_ll(aQ5ReverseLinkedList.reverseBetween(aQ5ReverseLinkedList.head, 1, 5));
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        int count = 1;
        ListNode start = null;
        ListNode end = null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null && count != B - 1) {
            count++;
            curr = curr.next;
        }
//        System.out.println(count + " - " + curr.val);
        start = curr;
        prev = curr;
        while (curr != null && count != C) {
            count++;
            System.out.printf("prev(%s) - curr(%s) - next(%s)%n", prev, curr, next);
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        System.out.printf("prev(%s) - curr(%s) - next(%s)%n", prev, curr, next);
        if (start != null) {
            if (start.next.next != null)
                start.next.next = next;
            start.next = curr;
        }

        return A;
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
