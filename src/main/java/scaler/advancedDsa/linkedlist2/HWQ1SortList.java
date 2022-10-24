package scaler.advancedDsa.linkedlist2;

import scaler.common.ListNode;

public class HWQ1SortList {
    //    Problem Description
//    Sort a linked list, A in O(n log n) time using constant space complexity.
//    Problem Constraints
//0 <= |A| = 105
//    Input Format
//    The first and the only arugment of input contains a pointer to the head of the linked list, A.
//    Output Format
//    Return a pointer to the head of the sorted linked list.
//            Example Input
//    Input 1:
//    A = [3, 4, 2, 8]
//    Input 2:
//    A = [1]
//    Example Output
//    Output 1:
//            [2, 3, 4, 8]
//    Output 2:
//            [1]
//    Example Explanation
//    Explanation 1:
//    The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
//    Explanation 2:
//    The sorted form of [1] is [1].
    public static void main(String[] args) {
        int[] input1A = {3, 4, 2, 8};
//        System.out.println(new HWQ2SortList().sortList(input1A));
        int[] input2A = {1};
//        System.out.println(new HWQ2SortList().sortList(input2A));
    }

    public ListNode sortList(ListNode A) {
        return A;
    }
}
