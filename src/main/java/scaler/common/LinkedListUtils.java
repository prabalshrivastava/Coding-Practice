package scaler.common;

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
        // Output each element followed by an arrow
        ListNode trav = headPassed;
        if (trav == null)
            return;
        int count = 1;
        while (trav.next != null) {
            System.out.print("(" + count + ")" + trav.val + "->");
            count++;
            trav = trav.next;
        }
        System.out.print("(" + count + ")" + trav.val);
        System.out.println();
    }

    public static ListNode addFromArray(int[] arr, ListNode head) {
        for (int i = 0; i < arr.length; i++) {
            head = addLastNode(head, arr[i]);
        }
        return head;
    }

    public static ListNode addFromArrayAndPrint(int[] arr, ListNode head) {
        for (int i = 0; i < arr.length; i++) {
            head = addLastNode(head, arr[i]);
        }
        print_ll(head);
        return head;
    }

    public static ListNode applyLoop(ListNode head1, int i) {
        if (head1 == null) {
            System.out.println("head : " + head1);
            return head1;
        }
        ListNode trav = head1;
        int count = 1;
        ListNode loopElement = null;
        while (trav.next != null) {
            if (count == i) {
                loopElement = trav;
            }
            count++;
            trav = trav.next;
        }
        if (loopElement == null)
            System.out.println(trav.val + " - " + null);
        else
            System.out.println(trav.val + " - " + loopElement.val);
        trav.next = loopElement;
        return head1;
    }
}
