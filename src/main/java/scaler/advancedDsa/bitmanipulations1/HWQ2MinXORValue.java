package scaler.advancedDsa.bitmanipulations1;

import java.util.Arrays;

public class HWQ2MinXORValue {
    //    Problem Description
//    Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
//            Problem Constraints
//2 <= length of the array <= 100000
//            0 <= A[i] <= 109
//    Input Format
//    First and only argument of input contains an integer array A.
//            Output Format
//    Return a single integer denoting minimum xor value.
//    Example Input
//    Input 1:
//    A = [0, 2, 5, 7]
//    Input 2:
//    A = [0, 4, 7, 9]
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            3
//    Example Explanation
//    Explanation 1:
//            0 xor 2 = 2
    public static void main(String[] args) {
        int[] input1A = {0, 2, 5, 7};
        System.out.println(new HWQ2MinXORValue().findMinXor(input1A));
        int[] input2A = {0, 4, 7, 9};
        System.out.println(new HWQ2MinXORValue().findMinXor(input2A));
    }

    public int findMinXor(int[] A) {
        int minXor = Integer.MAX_VALUE;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            minXor = Math.min(A[i] ^ A[i + 1], minXor);
        }
        return minXor;
    }

    public int findMinXorOn2(int[] A) {
        int minXor = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                minXor = Math.min(A[i] ^ A[j], minXor);
            }
        }
        return minXor;
    }
}
