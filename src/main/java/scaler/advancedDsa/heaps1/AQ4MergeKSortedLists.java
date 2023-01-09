package scaler.advancedDsa.heaps1;

import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AQ4MergeKSortedLists {
    //    Problem Description
//    Given a list containing head pointers of N sorted linked lists.
//    Merge these given sorted linked lists and return them as one sorted list.
//            Problem Constraints
//1 <= total number of elements in given linked lists <= 100000
//    Input Format
//    The first and only argument is a list containing N head pointers.
//    Output Format
//    Return a pointer to the head of the sorted linked list after merging all the given linked lists.
//    Example Input
//    Input 1:
//            1 -> 10 -> 20
//            4 -> 11 -> 13
//            3 -> 8 -> 9
//    Input 2:
//            10 -> 12
//            13
//            5 -> 6
//    Example Output
//    Output 1:
//            1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
//    Output 2:
//            5 -> 6 -> 10 -> 12 ->13
//    Example Explanation
//    Explanation 1:
//    The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
//    Explanation 2:
//    The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
    public static void main(String[] args) {
        AQ4MergeKSortedLists aq4MergeKSortedLists = new AQ4MergeKSortedLists();
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(LinkedListUtils.addFromArrayAndPrint(new int[]{10, 20}, new ListNode(1)));
        list.add(LinkedListUtils.addFromArrayAndPrint(new int[]{11, 13}, new ListNode(4)));
        list.add(LinkedListUtils.addFromArrayAndPrint(new int[]{8, 9}, new ListNode(3)));
        LinkedListUtils.print_ll(aq4MergeKSortedLists.mergeKLists(list));
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode head = null;
        ListNode tail = null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < a.size(); i++) {
            minHeap.add(a.get(i));
        }
        while (!minHeap.isEmpty()) {
            ListNode removedElement = minHeap.poll();
            if (removedElement.next != null) {
                minHeap.add(removedElement.next);
            }
            if (head == null) {
                head = removedElement;
                tail = head;
            } else {
                tail.next = removedElement;
                tail = tail.next;
            }
        }
        return head;
    }
}
