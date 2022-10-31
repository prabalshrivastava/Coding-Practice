package scaler.advancedDsa.linkedlist3;

import scaler.common.LinkedListUtils;
import scaler.common.ListNode;

import java.util.Map;

public class AQ4LongestPalindromicList {
    //    Problem Description
//    Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.
//    A palindrome list is a list that reads the same backward and forward.
//    Expected memory complexity : O(1)
//    Problem Constraints
//1 <= length of the linked list <= 2000
//            1 <= Node value <= 100
//    Input Format
//    The only argument given is head pointer of the linked list.
//            Output Format
//    Return the length of the longest palindrome list.
//    Example Input
//    Input 1:
//            2 -> 3 -> 3 -> 3
//    Input 2:
//            2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            5
//    Example Explanation
//    Explanation 1:
//            3 -> 3 -> 3 is largest palindromic sublist
//    Explanation 2:
//            2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.
    public static void main(String[] args) {
//        Input 1:
//        2 -> 3 -> 3 -> 3
//        Input 2:
//        2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2
        int[] arr1 = {2, 3, 3, 3};
        AQ4LongestPalindromicList aq4LongestPalindromicList1 = new AQ4LongestPalindromicList();
        System.out.println(aq4LongestPalindromicList1.solve(LinkedListUtils.addFromArrayAndPrint(arr1, aq4LongestPalindromicList1.head)));
        int[] arr2 = {2, 1, 2, 1, 2, 2, 1, 3, 2, 2};
        AQ4LongestPalindromicList aq4LongestPalindromicList2 = new AQ4LongestPalindromicList();
        System.out.println(aq4LongestPalindromicList2.solve(LinkedListUtils.addFromArrayAndPrint(arr2, aq4LongestPalindromicList2.head)));
    }

    ListNode head;

    public int solve(ListNode A) {
        if (A == null)
            return 0;
        if (A.next == null)
            return 1;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = A;
        A = dummy;
//        ListNode prev = dummy;
        ListNode prev = A;
        ListNode curr = prev.next;
        ListNode next = null;
        boolean isfirst = true;
        int ans = Integer.MIN_VALUE;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            if (isfirst) {
                dummy.next = null;
                isfirst = false;
            }
            System.out.print("curr : ");
            LinkedListUtils.print_ll(prev);
            System.out.print("next : ");
            LinkedListUtils.print_ll(curr);
            ListNode p1 = prev;
            ListNode p2 = curr;
            int count = 1;
            while (p1 != null && p2 != null && p1.val == p2.val) {
                count++;
                p1 = p1.next;
                p2 = p2.next;
            }
            ans = Math.max(count, ans);
            System.out.println("ans : " + ans);
            System.out.println("");

        }

        return ans * 2;
    }
}
