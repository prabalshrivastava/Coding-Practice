package scaler.advancedDsa.linkedlist3;

import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

import java.util.*;

public class HWQ2PartitionList {
    //    Problem Description
//    Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
//    You should preserve the original relative order of the nodes in each of the two partitions.
//    Problem Constraints
//1 <= |A| <= 106
//            1 <= A[i], B <= 109
//    Input Format
//    The first argument of input contains a pointer to the head to the given linked list.
//    The second argument of input contains an integer, B.
//    Output Format
//    Return a pointer to the head of the modified linked list.
//            Example Input
//    Input 1:
//    A = [1, 4, 3, 2, 5, 2]
//    B = 3
//    Input 2:
//    A = [1, 2, 3, 1, 3]
//    B = 2
//    Example Output
//    Output 1:
//            [1, 2, 2, 4, 3, 5]
//    Output 2:
//            [1, 1, 2, 3, 3]
//    Example Explanation
//    Explanation 1:
//            [1, 2, 2] are less than B whereas [4, 3, 5] are greater than or equal to B.
//            Explanation 2:
//            [1, 1] are less than B whereas [2, 3, 3] are greater than or equal to B.
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 3, 2, 5, 2};
        HWQ2PartitionList hwq2PartitionList = new HWQ2PartitionList();
        LinkedListUtils.print_ll(hwq2PartitionList.partition(LinkedListUtils.addFromArrayAndPrint(arr1, hwq2PartitionList.head), 3));

        int[] arr2 = {1, 2, 3, 1, 3};
        HWQ2PartitionList hwq2PartitionList1 = new HWQ2PartitionList();
        LinkedListUtils.print_ll(hwq2PartitionList1.partition(LinkedListUtils.addFromArrayAndPrint(arr2, hwq2PartitionList1.head), 2));
    }

    ListNode head;

    public ListNode partition_Approach2Pointers(ListNode A, int B) {
        if (A == null)
            return null;
        ListNode largeHead = null;
        ListNode largeTail = null;
        ListNode smallHead = A;
        ListNode smallTail = null;
        ListNode curr = A;
        ListNode next = curr.next;
        while (next != null) {
            if (next.val < B) {
//                if (smallTail == null) {
//                    smallHead = curr;
//                    smallTail = curr;
//                } else {
//                    smallTail.next = curr;
//                }
            } else {
                curr.next = next.next;
                next.next = null;
                if (largeHead == null) {
                    largeHead = next;
                    largeTail = next;
                } else {
                    largeTail.next = next;
                    largeTail = largeTail.next;
                }
            }
            curr = curr.next;
            next = next.next;
        }
        if (smallHead.val < B) {
            ListNode temp = smallHead;
            smallHead = smallHead.next;
            if (largeHead != null) {
                largeHead.next = smallHead;
                smallHead.next = null;
            }
        }
        System.out.print("small ");
        LinkedListUtils.print_ll(A);
        System.out.print("large ");
        LinkedListUtils.print_ll(largeHead);

        if (largeHead == null)
            return smallHead;
        if (smallHead == null)
            return largeHead;
        curr.next = largeHead;
        return smallHead;
    }

    public ListNode partition(ListNode A, int B) {
        Queue<Integer> largeQueue = new LinkedList<>();
        Queue<Integer> smallQueue = new LinkedList<>();
        ListNode curr = A;
        while (curr != null) {
            if (curr.val < B)
                smallQueue.offer(curr.val);
            else
                largeQueue.offer(curr.val);
            curr = curr.next;
        }
        curr = A;
        while (!smallQueue.isEmpty()) {
            curr.val = smallQueue.poll();
            curr = curr.next;
        }
        while (!largeQueue.isEmpty()) {
            curr.val = largeQueue.poll();
            curr = curr.next;
        }

        return A;
    }
}
