package scaler.advancedDsa.linkedlist1;

public class HWQ2RemoveDuplicatesFromSortedList {
    //    Problem Description
//    Given a sorted linked list, delete all duplicates such that each element appears only once.
//    Problem Constraints
//0 <= length of linked list <= 106
//    Input Format
//    First argument is the head pointer of the linked list.
//    Output Format
//    Return the head pointer of the linked list after removing all duplicates.
//    Example Input
//    Input 1:
//            1->1->2
//    Input 2:
//            1->1->2->3->3
//    Example Output
//    Output 1:
//            1->2
//    Output 2:
//            1->2->3
//    Example Explanation
//    Explanation 1:
//    Each element appear only once in 1->2.
    public static void main(String[] args) {
        HWQ2RemoveDuplicatesFromSortedList hwQ2RemoveDuplicatesFromSortedList = new HWQ2RemoveDuplicatesFromSortedList();
        hwQ2RemoveDuplicatesFromSortedList.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList.head, 1);
        hwQ2RemoveDuplicatesFromSortedList.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList.head, 1);
        hwQ2RemoveDuplicatesFromSortedList.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList.head, 2);
        hwQ2RemoveDuplicatesFromSortedList.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList.head, 3);
        hwQ2RemoveDuplicatesFromSortedList.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList.head, 3);
        LinkedListUtils.print_ll(hwQ2RemoveDuplicatesFromSortedList.head);
        LinkedListUtils.print_ll(hwQ2RemoveDuplicatesFromSortedList.deleteDuplicates(hwQ2RemoveDuplicatesFromSortedList.head));

        HWQ2RemoveDuplicatesFromSortedList hwQ2RemoveDuplicatesFromSortedList1 = new HWQ2RemoveDuplicatesFromSortedList();
        hwQ2RemoveDuplicatesFromSortedList1.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList1.head, 1);
        hwQ2RemoveDuplicatesFromSortedList1.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList1.head, 1);
        hwQ2RemoveDuplicatesFromSortedList1.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList1.head, 2);
        LinkedListUtils.print_ll(hwQ2RemoveDuplicatesFromSortedList1.head);
        LinkedListUtils.print_ll(hwQ2RemoveDuplicatesFromSortedList1.deleteDuplicates(hwQ2RemoveDuplicatesFromSortedList1.head));

        HWQ2RemoveDuplicatesFromSortedList hwQ2RemoveDuplicatesFromSortedList2 = new HWQ2RemoveDuplicatesFromSortedList();
        hwQ2RemoveDuplicatesFromSortedList2.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList2.head, 1);
        hwQ2RemoveDuplicatesFromSortedList2.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList2.head, 2);
        hwQ2RemoveDuplicatesFromSortedList2.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList2.head, 3);
        hwQ2RemoveDuplicatesFromSortedList2.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList2.head, 4);
        hwQ2RemoveDuplicatesFromSortedList2.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList2.head, 5);
        hwQ2RemoveDuplicatesFromSortedList2.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList2.head, 6);
        hwQ2RemoveDuplicatesFromSortedList2.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList2.head, 7);
        hwQ2RemoveDuplicatesFromSortedList2.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList2.head, 8);
        hwQ2RemoveDuplicatesFromSortedList2.head = LinkedListUtils.addLastNode(hwQ2RemoveDuplicatesFromSortedList2.head, 9);
        LinkedListUtils.print_ll(hwQ2RemoveDuplicatesFromSortedList2.head);
        LinkedListUtils.print_ll(hwQ2RemoveDuplicatesFromSortedList2.deleteDuplicates(hwQ2RemoveDuplicatesFromSortedList2.head));

    }

    ListNode head;

    public ListNode deleteDuplicates(ListNode A) {
        return A;
    }
}
