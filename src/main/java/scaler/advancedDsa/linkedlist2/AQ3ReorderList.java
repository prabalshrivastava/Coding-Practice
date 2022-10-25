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
        LinkedListUtils.print_ll(aq3ReorderList.head = LinkedListUtils.addFromArray(new int[]{1, 2, 3, 4, 5, 6}, aq3ReorderList.head));
        LinkedListUtils.print_ll(aq3ReorderList.reorderList(aq3ReorderList.head));
//        System.out.println("------------------------------------------------------------------");

        AQ3ReorderList aq3ReorderList1 = new AQ3ReorderList();
        LinkedListUtils.print_ll(aq3ReorderList1.head = LinkedListUtils.addFromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, aq3ReorderList1.head));
        LinkedListUtils.print_ll(aq3ReorderList1.reorderList(aq3ReorderList1.head));
//        System.out.println("------------------------------------------------------------------");

        AQ3ReorderList aq3ReorderList2 = new AQ3ReorderList();
        LinkedListUtils.print_ll(aq3ReorderList2.head = LinkedListUtils.addFromArray(new int[]{1, 2, 3}, aq3ReorderList2.head));
        LinkedListUtils.print_ll(aq3ReorderList2.reorderList(aq3ReorderList2.head));
//        System.out.println("------------------------------------------------------------------");

        AQ3ReorderList aq3ReorderList3 = new AQ3ReorderList();
        LinkedListUtils.print_ll(aq3ReorderList3.head = LinkedListUtils.addFromArray(new int[]{1, 2, 3, 4}, aq3ReorderList3.head));
        LinkedListUtils.print_ll(aq3ReorderList3.reorderList(aq3ReorderList3.head));
//        System.out.println("------------------------------------------------------------------");

        AQ3ReorderList aq3ReorderList4 = new AQ3ReorderList();
        int[] arr = {90, 94, 25, 51, 45, 29, 55, 63, 48, 27, 72, 10, 36, 68, 16, 20, 31, 7, 95, 70, 89, 23, 22, 9, 74, 71, 35, 5, 80, 11, 49, 92, 69, 6, 37, 84, 78, 28, 43, 64, 96, 57,
                83, 13, 73, 97, 75, 59, 53, 52, 19, 18, 98, 12, 81, 24, 15, 60, 79, 34, 1, 54, 93, 65, 44, 4, 87, 14, 67, 26, 30, 77, 58, 85, 33, 21, 46, 82, 76, 88, 66, 101, 61, 47, 8};
        LinkedListUtils.print_ll(aq3ReorderList4.head = LinkedListUtils.addFromArray(arr, aq3ReorderList4.head));
        LinkedListUtils.print_ll(aq3ReorderList4.reorderList(aq3ReorderList4.head));//90 -> 8 -> 94 -> 47 -> 25 -> 61 -> 51 -> 101 -> 45 -> 66 -> 29 -> 88 -> 55 -> 76 -> 63 -> 82 -> 48 -> 46 -> 27 -> 21 -> 72 -> 33 -> 10 -> 85 -> 36 -> 58 -> 68 -> 77 -> 16 -> 30 -> 20 -> 26 -> 31 -> 67 -> 7 -> 14 -> 95 -> 87 -> 70 -> 4 -> 89 -> 44 -> 23 -> 65 -> 22 -> 93 -> 9 -> 54 -> 74 -> 1 -> 71 -> 34 -> 35 -> 79 -> 5 -> 60 -> 80 -> 15 -> 11 -> 24 -> 49 -> 81 -> 92 -> 12 -> 69 -> 98 -> 6 -> 18 -> 37 -> 19 -> 84 -> 52 -> 78 -> 53 -> 28 -> 59 -> 43 -> 75 -> 64 -> 97 -> 96 -> 73 -> 57 -> 13 -> 83
//        System.out.println("------------------------------------------------------------------");

        AQ3ReorderList aq3ReorderList5 = new AQ3ReorderList();
        LinkedListUtils.print_ll(aq3ReorderList5.head = LinkedListUtils.addFromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, aq3ReorderList5.head));
        LinkedListUtils.print_ll(aq3ReorderList5.reorderList(aq3ReorderList5.head));
//        System.out.println("------------------------------------------------------------------");

    }

    ListNode head;

    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null || A.next.next == null)
            return A;

        ListNode trav = A;
        int count = 0;
        while (trav != null) {
            trav = trav.next;
            count++;
        }
////        System.out.println("count : " + count);

        trav = A;
        int mid;
        if (count % 2 == 0) {
            mid = count / 2;
        } else {
            mid = (count + 1) / 2;
        }
//        System.out.println("mid : " + mid);

        if (count == 3) {
            ListNode one = A;
            ListNode two = A.next;
            ListNode three = A.next.next;
            one.next = three;
            three.next = two;
            two.next = null;
//            LinkedListUtils.print_ll(A);
            return A;
        }

        count = 0;
        ListNode prev = trav;
        while (count != mid) {
            prev = trav;
            trav = trav.next;
            count++;
        }
////        System.out.println("prev.val : " + prev.val);
////        System.out.println("trav.val : " + trav.val);
        ListNode start = prev;
////        System.out.println("start.val : " + start.val);
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


        //starting the reordering process
        ListNode c1 = A;
        ListNode n1 = c1.next;
        ListNode c2 = start.next;
        ListNode n2 = c2.next;
        start.next = null;
//        System.out.print("reversed : ");
//        LinkedListUtils.print_ll(A);
//        System.out.println("c1:" + c1 + " - n1:" + n1 + " - c2:" + c2 + " - n2:" + n2);
        while (n2 != null) {
//            System.out.println("c1:" + c1 + " - n1:" + n1 + " - c2:" + c2 + " - n2:" + n2);
            c1.next = c2;
            c2.next = n1;

            c1 = n1;
            c2 = n2;
            n1 = n1.next;
            n2 = n2.next;
//            System.out.println("---------->c1:" + c1 + " - n1:" + n1 + " - c2:" + c2 + " - n2:" + n2);
            if (n2 == null) {
                c1.next = c2;
                if (n1 != null)
                    c2.next = n1;
            }
////            System.out.println("---------->c1:" + c1.val + " - c2:" + c2.val + " - n1:" + n1.val + " - n2:" + n2.val);
        }
//        LinkedListUtils.print_ll(A);

        return A;
    }
}
