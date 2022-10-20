package scaler.advancedDsa.linkedlist1;

public class LinkedListUtils {
    public static ListNode addLastNode(ListNode head, int value) {
        ListNode trav = head;
        if (head == null) {
            head = new ListNode(value);
            return head;
        }
        while (trav.next != null) {
            trav = trav.next;
        }
        trav.next = new ListNode(value);
        return head;
    }

    public static void print_ll(ListNode headPassed) {
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
