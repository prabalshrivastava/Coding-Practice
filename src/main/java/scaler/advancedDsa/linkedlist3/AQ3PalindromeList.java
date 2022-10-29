package scaler.advancedDsa.linkedlist3;

import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

public class AQ3PalindromeList {
    //    Problem Description
//    Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
//            Problem Constraints
//1 <= |A| <= 105
//    Input Format
//    The first and the only argument of input contains a pointer to the head of the given linked list.
//            Output Format
//    Return 0, if the linked list is not a palindrome.
//            Return 1, if the linked list is a palindrome.
//    Example Input
//    Input 1:
//    A = [1, 2, 2, 1]
//    Input 2:
//    A = [1, 3, 2]
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
//    Explanation 2:
//    The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
    public static void main(String[] args) {
        int[] input1AEvenLength = {1, 2, 2, 1};
        AQ3PalindromeList aq3PalindromeListEven = new AQ3PalindromeList();
        System.out.println(aq3PalindromeListEven.lPalin(LinkedListUtils.addFromArrayAndPrint(input1AEvenLength, aq3PalindromeListEven.head)));

        int[] input1AOddLength = {1, 2, 5, 2, 1};
        AQ3PalindromeList aq3PalindromeListOdd = new AQ3PalindromeList();
        System.out.println(aq3PalindromeListOdd.lPalin(LinkedListUtils.addFromArrayAndPrint(input1AOddLength, aq3PalindromeListOdd.head)));

        int[] input2AEvenLength = {1, 3, 2, 4};
        AQ3PalindromeList aq3PalindromeList2Even = new AQ3PalindromeList();
        System.out.println(aq3PalindromeList2Even.lPalin(LinkedListUtils.addFromArrayAndPrint(input2AEvenLength, aq3PalindromeList2Even.head)));

        int[] input2AOddLength = {1, 3, 2};
        AQ3PalindromeList aq3PalindromeList2Odd = new AQ3PalindromeList();
        System.out.println(aq3PalindromeList2Odd.lPalin(LinkedListUtils.addFromArrayAndPrint(input2AOddLength, aq3PalindromeList2Odd.head)));


        int[] input2BaseCase3 = {1, 2, 1};
        AQ3PalindromeList aq3PalindromeListBasecase3 = new AQ3PalindromeList();
        System.out.println(aq3PalindromeListBasecase3.lPalin(LinkedListUtils.addFromArrayAndPrint(input2BaseCase3, aq3PalindromeListBasecase3.head)));

        int[] input2BaseCase2 = {1, 1};
        AQ3PalindromeList aq3PalindromeListBasecase2 = new AQ3PalindromeList();
        System.out.println(aq3PalindromeListBasecase2.lPalin(LinkedListUtils.addFromArrayAndPrint(input2BaseCase2, aq3PalindromeListBasecase2.head)));

        int[] input2BaseCase1 = {1};
        AQ3PalindromeList aq3PalindromeListBasecase1 = new AQ3PalindromeList();
        System.out.println(aq3PalindromeListBasecase1.lPalin(LinkedListUtils.addFromArrayAndPrint(input2BaseCase1, aq3PalindromeListBasecase1.head)));

        int[] input2BaseCase2NotPalindrome = {8, 1};
        AQ3PalindromeList aq3PalindromeListBasecase2NotPalindrome = new AQ3PalindromeList();
        System.out.println(aq3PalindromeListBasecase2NotPalindrome.lPalin(LinkedListUtils.addFromArrayAndPrint(input2BaseCase2NotPalindrome, aq3PalindromeListBasecase2NotPalindrome.head)));

        AQ3PalindromeList aq3PalindromeList4 = new AQ3PalindromeList();
        System.out.println(aq3PalindromeList4.lPalin(LinkedListUtils.addFromArrayAndPrint(new int[]{6, 3, 7, 3, 6}, aq3PalindromeList4.head)));
    }

    ListNode head;

    public int lPalin(ListNode A) {
        if (A == null || A.next == null)
            return 1;
        if (A.next.next == null) {
            if (A.val == A.next.val)
                return 1;
            else
                return 0;
        }
//        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
//        dummyNode.next = A;
//        A = dummyNode;
        ListNode prevOfMiddle = findMiddle(A);
//        if (prevOfMiddle != null)
//        System.out.println("prevOfMiddle : " + prevOfMiddle + "\tMiddle : " + prevOfMiddle.next);
//        else
//            System.out.println("prevOfMiddle : " + prevOfMiddle + "\tMiddle : " + null);
        ListNode start = prevOfMiddle.next;
        ListNode previous = start;
        ListNode current = previous.next;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        //prevOfMiddle.next = previous;
        if (start.next != null)
            start.next.next = current;
        start.next = previous;
        System.out.print("postprocessing : ");
        LinkedListUtils.print_ll(A);

        ListNode p1 = A;
        ListNode p2 = start.next;
        System.out.println("p1 :" + p1 + " - p2 :" + p2);
        while (p2 != null) {
//        System.out.println("p1 :" + p1 + " - p2 :" + p2);
            if (p1.val != p2.val) {
                return 0;
            }
            p2 = p2.next;
            p1 = p1.next;
        }
        return 1;
    }

    ListNode findMiddle(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        if (A == null || A.next == null)
            return A;
        ListNode previous = null;
        while (fast.next != null && fast.next.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return previous;
    }
}
