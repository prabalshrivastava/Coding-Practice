package scaler.advancedDsa.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HWQ1ReversingElementsOfQueue {
//    Problem Description
//    Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array, leaving the other elements in the same relative order.
//            NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.
//            Problem Constraints
//1 <= B <= length of the array <= 500000
//            1 <= A[i] <= 100000
//    Input Format
//    The argument given is the integer array A and an integer B.
//    Output Format
//    Return an array of integer after reversing the first B elements of A using queue.
//            Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    B = 3
//    Input 2:
//    A = [5, 17, 100, 11]
//    B = 2
//    Example Output
//    Output 1:
//            [3, 2, 1, 4, 5]
//    Output 2:
//            [17, 5, 100, 11]
//    Example Explanation
//    Explanation 1:
//    Reverse first 3 elements so the array becomes [3, 2, 1, 4, 5]
//    Explanation 2:
//    Reverse first 2 elements so the array becomes [17, 5, 100, 11]

    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 4, 5};
        int input1B = 3;
        System.out.println(Arrays.toString(new HWQ1ReversingElementsOfQueue().solve(input1A, input1B)));
        int[] input2A = {5, 17, 100, 11};
        int input2B = 2;
        System.out.println(Arrays.toString(new HWQ1ReversingElementsOfQueue().solve(input2A, input2B)));
    }

    public int[] solve(int[] A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < B; i++) {
            queue.offer(A[i]);
        }
//        System.out.println(queue);
        for (int i = B - 1; i >= 0; i--) {
            A[i] = queue.poll();
        }
        return A;
    }
}
