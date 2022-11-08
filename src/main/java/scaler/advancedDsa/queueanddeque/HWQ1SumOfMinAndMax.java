package scaler.advancedDsa.queueanddeque;

import com.google.gson.annotations.Since;

import java.util.ArrayList;

public class HWQ1SumOfMinAndMax {
    //    Problem Description
//    Given an array A of both positive and negative integers.
//    Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
//    NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
//    Problem Constraints
//1 <= size of array A <= 105
//            -109 <= A[i] <= 109
//            1 <= B <= size of array
//    Input Format
//    The first argument denotes the integer array A.
//    The second argument denotes the value B
//    Output Format
//    Return an integer that denotes the required value.
//    Example Input
//    Input 1:
//    A = [2, 5, -1, 7, -3, -1, -2]
//    B = 4
//    Input 2:
//    A = [2, -1, 3]
//    B = 2
//    Example Output
//    Output 1:
//            18
//    Output 2:
//            3
//    Example Explanation
//    Explanation 1:
//    Subarrays of size 4 are :
//            [2, 5, -1, 7],   min + max = -1 + 7 = 6
//            [5, -1, 7, -3],  min + max = -3 + 7 = 4
//            [-1, 7, -3, -1], min + max = -3 + 7 = 4
//            [7, -3, -1, -2], min + max = -3 + 7 = 4
//    Sum of all min & max = 6 + 4 + 4 + 4 = 18
//    Explanation 2:
//    Subarrays of size 2 are :
//            [2, -1],   min + max = -1 + 2 = 1
//            [-1, 3],   min + max = -1 + 3 = 2
//    Sum of all min & max = 1 + 2 = 3
    public static void main(String[] args) {
        int[] input1A = {2, 5, -1, 7, -3, -1, -2};
        int input1B = 4;
        System.out.println(new HWQ1SumOfMinAndMax().solve(input1A, input1B));
        int[] input2A = {2, -1, 3};
        int input2B = 2;
        System.out.println(new HWQ1SumOfMinAndMax().solve(input2A, input2B));
    }

    public int solve(int[] A, int B) {
        return B;
    }
}
