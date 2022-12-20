package scaler.advancedDsa.queueanddeque;

import java.awt.*;
import java.util.*;
import java.util.concurrent.DelayQueue;

public class AQ2SlidingWindowMaximum {
//    Problem Description
//    Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.
//    Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
//    Refer to the given example for clarity.
//            NOTE: If B > length of the array, return 1 element with the max of the array.
//            Problem Constraints
//1 <= |A|, B <= 106
//    Input Format
//    The first argument given is the integer array A.
//    The second argument given is the integer B.
//    Output Format
//    Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
//    Example Input
//    Input 1:
//    A = [1, 3, -1, -3, 5, 3, 6, 7]
//    B = 3
//    Input 2:
//    A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
//    B = 6
//    Example Output
//    Output 1:
//            [3, 3, 5, 5, 6, 7]
//    Output 2:
//            [7, 7, 7, 7]
//    Example Explanation
//    Explanation 1:
//    Window position     | Max
// --------------------|-------
//         [1 3 -1] -3 5 3 6 7 | 3
//         1 [3 -1 -3] 5 3 6 7 | 3
//         1 3 [-1 -3 5] 3 6 7 | 5
//         1 3 -1 [-3 5 3] 6 7 | 5
//         1 3 -1 -3 [5 3 6] 7 | 6
//         1 3 -1 -3 5 [3 6 7] | 7
//    Explanation 2:
//    Window position     | Max
// --------------------|-------
//         [1 2 3 4 2 7] 1 3 6 | 7
//         1 [2 3 4 2 7 1] 3 6 | 7
//         1 2 [3 4 2 7 1 3] 6 | 7
//         1 2 3 [4 2 7 1 3 6] | 7

    public static void main(String[] args) {
        int[] input1A = {1, 3, -1, -3, 5, 3, 6, 7};
        int input1B = 3;
        System.out.println(Arrays.toString(new AQ2SlidingWindowMaximum().slidingMaximum(input1A, input1B)));
        int[] input2A = {1, 2, 3, 4, 2, 7, 1, 3, 6};
        int input2B = 6;
        System.out.println(Arrays.toString(new AQ2SlidingWindowMaximum().slidingMaximum(input2A, input2B)));
        int[] input3A = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int input3B = 2;
        System.out.println(Arrays.toString(new AQ2SlidingWindowMaximum().slidingMaximum(input3A, input3B)));//10 9 8 7 6 5 4 3 2
    }

    public int[] slidingMaximum(final int[] A, int B) {
        Deque<Integer> dequeue = new ArrayDeque<>();
        int[] ans = new int[A.length - B + 1];
        int count = 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < B; i++) {
//            max = Math.max(max,A[i]);
//        }
//        ans[count++] = max;
        for (int i = 0; i < A.length; i++) {
            if (i - B >= 0 && dequeue.peekFirst() == A[i - B]) {
                dequeue.pollFirst();
            }
            Integer lastElement = dequeue.peekLast();
            if (dequeue.isEmpty()) {
                dequeue.offerLast(A[i]);
            } else {
                if (A[i] < lastElement) {
                    dequeue.offerLast(A[i]);
                } else {
                    while (!dequeue.isEmpty() && dequeue.peekLast() < A[i]) {
                        dequeue.pollLast();
                    }
                    dequeue.offerLast(A[i]);
                }
            }
            if (i + 1 >= B) {
                ans[count++] = dequeue.peekFirst();
            }
        }
        return ans;
    }
}
