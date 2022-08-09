package scaler.module1.arrays.interviewproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HWQ1MaximumPositivity {
    //    Problem Description
//    Given an array of integers A, of size N.
//
//    Return the maximum size subarray of A having only non-negative elements. If there are more than one such subarray, return the one having the smallest starting index in A.
//
//            NOTE: It is guaranteed that an answer always exists.
//
//
//
//    Problem Constraints
//1 <= N <= 105
//
//            -109 <= A[i] <= 109
//
//
//
//    Input Format
//    The first and only argument given is the integer array A.
//
//
//
//            Output Format
//    Return maximum size subarray of A having only non-negative elements. If there are more than one such subarrays, return the one having earliest starting index in A.
//
//
//
//    Example Input
//    Input 1:
//
//    A = [5, 6, -1, 7, 8]
//    Input 2:
//
//    A = [1, 2, 3, 4, 5, 6]
//
//
//    Example Output
//    Output 1:
//
//            [5, 6]
//    Output 2:
//
//            [1, 2, 3, 4, 5, 6]
//
//
//    Example Explanation
//    Explanation 1:
//
//    There are two subarrays of size 2 having only non-negative elements.
//            1. [5, 6]  starting point  = 0
// 2. [7, 8]  starting point  = 3
//    As starting point of 1 is smaller, return [5, 6]
//    Explanation 2:
//
//    There is only one subarray of size 6 having only non-negative elements:
//            [1, 2, 3, 4, 5, 6]
    public static void main(String[] args) {
        int[] input1A = {5, 6, -1, 7, 8};
        System.out.println(Arrays.toString(new HWQ1MaximumPositivity().solve(input1A)));
        int[] input2A = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(new HWQ1MaximumPositivity().solve(input2A)));

    }

    public int[] solve(int[] A) {
        int finalStart = 0;
        int finalEnd = -1;
        int start = 0;
        int end = -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                end++;
            } else {
                if (end - start + 1 > finalEnd - finalStart + 1) {
                    finalEnd = end;
                    finalStart = start;
                }
                while (i < A.length && A[i] < 0) {
                    i++;
                }
                end = i;
                start = i;
            }
        }
        if (end - start + 1 > finalEnd - finalStart + 1) {
            finalEnd = end;
            finalStart = start;
        }
        for (int i = finalStart; i <= finalEnd; i++) {
            list.add(A[i]);
        }
        return list.stream().mapToInt(value -> value).toArray();
    }
}
