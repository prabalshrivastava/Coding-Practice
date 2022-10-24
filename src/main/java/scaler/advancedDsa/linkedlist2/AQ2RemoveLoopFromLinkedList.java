package scaler.advancedDsa.linkedlist2;

import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

public class AQ2RemoveLoopFromLinkedList {
    //    Problem Description
//    You are given a linked list that contains a loop.
//    You need to find the node, which creates a loop and break it by making the node point to NULL.
//    Problem Constraints
//1 <= number of nodes <= 1000
//    Input Format
//    The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
//    The second line of the input contains an integer which denotes the position of node where cycle starts.
//    Output Format
//return the head of the updated linked list.
//            Example Input
//    Input 1:
//            1 -> 2
//            ^    |
//            | - -
//    Input 2:
//            3 -> 2 -> 4 -> 5 -> 6
//            ^         |
//            |         |
//            - - - - - -
//    Example Output
//    Output 1:
//            1 -> 2 -> NULL
//    Output 2:
//            3 -> 2 -> 4 -> 5 -> 6 -> NULL
//    Example Explanation
//    Explanation 1:
//    Chain of 1->2 is broken.
//    Explanation 2:
//    Chain of 4->6 is broken.
    public static void main(String[] args) {
        AQ2RemoveLoopFromLinkedList aq2RemoveLoopFromLinkedList = new AQ2RemoveLoopFromLinkedList();
        aq2RemoveLoopFromLinkedList.head = LinkedListUtils.addLastNode(aq2RemoveLoopFromLinkedList.head, 1);
        aq2RemoveLoopFromLinkedList.head = LinkedListUtils.addLastNode(aq2RemoveLoopFromLinkedList.head, 2);
        aq2RemoveLoopFromLinkedList.head = LinkedListUtils.addLastNode(aq2RemoveLoopFromLinkedList.head, 3);
        aq2RemoveLoopFromLinkedList.head = LinkedListUtils.addLastNode(aq2RemoveLoopFromLinkedList.head, 4);

        LinkedListUtils.print_ll(aq2RemoveLoopFromLinkedList.head);
        LinkedListUtils.applyLoop(aq2RemoveLoopFromLinkedList.head, 3);
//        LinkedListUtils.print_ll(aq2RemoveLoopFromLinkedList.head);
        LinkedListUtils.print_ll(aq2RemoveLoopFromLinkedList.solve(aq2RemoveLoopFromLinkedList.head));
    }

    ListNode head;

    public ListNode solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                break;
        }
        ListNode fromHead = A;
        ListNode fromMeetingPoint = fast;
        ListNode previous = fromMeetingPoint;
        boolean isFirst = true;
        while (fromHead != fromMeetingPoint) {
            fromHead = fromHead.next;
            fromMeetingPoint = fromMeetingPoint.next;
            if (isFirst) {
                isFirst = false;
            } else {
                previous = previous.next;
            }
        }
        previous.next = null;

        return A;
    }
}
