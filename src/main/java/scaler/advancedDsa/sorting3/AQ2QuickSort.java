package scaler.advancedDsa.sorting3;

import java.util.Arrays;

public class AQ2QuickSort {
    //    Problem Description
//    Given an integer array A, sort the array using QuickSort.
//            Problem Constraints
//1 <= |A| <= 105
//            1 <= A[i] <= 109
//    Input Format
//    First argument is an integer array A.
//            Output Format
//    Return the sorted array.
//    Example Input
//    Input 1:
//    A = [1, 4, 10, 2, 1, 5]
//    Input 2:
//    A = [3, 7, 1]
//    Example Output
//    Output 1:
//            [1, 1, 2, 4, 5, 10]
//    Output 2:
//            [1, 3, 7]
//    Example Explanation
//    Explanation 1:
//    Return the sorted array.
    public static void main(String[] args) {
        int[] input1A = {1, 4, 10, 2, 1, 5};
        System.out.println(Arrays.toString(new AQ2QuickSort().solve(input1A)));
        int[] input2A = {3, 7, 1};
        System.out.println(Arrays.toString(new AQ2QuickSort().solve(input2A)));
    }

    private int[] solve(int[] input2A) {
        return new int[0];
    }
}
