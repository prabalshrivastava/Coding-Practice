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
        AQ4ReverseLinkListII aQ4ReverseLinkListII = new AQ4ReverseLinkListII();
        aQ4ReverseLinkListII.addLastNode(1);
        aQ4ReverseLinkListII.addLastNode(2);
        aQ4ReverseLinkListII.addLastNode(3);
        aQ4ReverseLinkListII.addLastNode(4);
        aQ4ReverseLinkListII.addLastNode(5);
        aQ4ReverseLinkListII.print_ll(aQ4ReverseLinkListII.head);
        aQ4ReverseLinkListII.print_ll(aQ4ReverseLinkListII.reverseBetween(aQ4ReverseLinkListII.head, 2, 4));

        AQ4ReverseLinkListII aQ4ReverseLinkListII1 = new AQ4ReverseLinkListII();
        aQ4ReverseLinkListII1.addLastNode(1);
        aQ4ReverseLinkListII1.addLastNode(2);
        aQ4ReverseLinkListII1.addLastNode(3);
        aQ4ReverseLinkListII1.addLastNode(4);
        aQ4ReverseLinkListII1.addLastNode(5);
        aQ4ReverseLinkListII1.addLastNode(6);
        aQ4ReverseLinkListII1.addLastNode(7);
        aQ4ReverseLinkListII1.addLastNode(8);
        aQ4ReverseLinkListII1.addLastNode(9);
        aQ4ReverseLinkListII1.print_ll(aQ4ReverseLinkListII1.head);
        aQ4ReverseLinkListII1.print_ll(aQ4ReverseLinkListII1.reverseBetween(aQ4ReverseLinkListII1.head, 3, 7));

        AQ4ReverseLinkListII aQ4ReverseLinkListII2 = new AQ4ReverseLinkListII();
        aQ4ReverseLinkListII2.addLastNode(1);
        aQ4ReverseLinkListII2.addLastNode(2);
        aQ4ReverseLinkListII2.addLastNode(3);
        aQ4ReverseLinkListII2.addLastNode(4);
        aQ4ReverseLinkListII2.addLastNode(5);
        aQ4ReverseLinkListII2.addLastNode(6);
        aQ4ReverseLinkListII2.addLastNode(7);
        aQ4ReverseLinkListII2.addLastNode(8);
        aQ4ReverseLinkListII2.addLastNode(9);
        aQ4ReverseLinkListII2.print_ll(aQ4ReverseLinkListII2.head);
        aQ4ReverseLinkListII2.print_ll(aQ4ReverseLinkListII2.reverseBetween(aQ4ReverseLinkListII2.head, 1, 9));
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        int count = 1;
        ListNode start;
        ListNode prev;
        ListNode curr = A;
        ListNode next = null;
        if (A == null || A.next == null) {
            return A;
        }
        if (B != 1) {
            while (curr != null && count != B - 1) {
                count++;
                curr = curr.next;
            }
        }
//        System.out.println(count + " - " + curr.val);
        if (curr == null)
            return A;
        start = curr;
        prev = curr;
        curr = curr.next;
//        System.out.printf("prev(%s) - curr(%s) - next(%s)%n", prev, curr, next);
        while (curr != null && count != C) {
            count++;
            next = curr.next;
//            System.out.printf("count(%s) - prev(%s) - curr(%s) - next(%s)%n", count, prev, curr, next);
            curr.next = prev;
            prev = curr;
            curr = next;
        }
//        System.out.printf("prev(%s) - curr(%s) - next(%s)%n", prev, curr, next);
//        if (B == 1) {
//            start.next = null;
//            A = prev;
//            return A;
//        }
        if (B == 1) {
            start.next = curr;
            A = prev;
            return A;
        }

        if (start.next.next != null)
            start.next.next = next;
        start.next = prev;
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
