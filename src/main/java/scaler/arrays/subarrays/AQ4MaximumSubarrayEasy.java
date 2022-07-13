package scaler.arrays.subarrays;

import java.util.Arrays;

public class AQ4MaximumSubarrayEasy {
    //    Problem Description
//    You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
//    But the sum must not exceed B.
//
//
//            Problem Constraints
//1 <= A <= 103
//            1 <= B <= 109
//            1 <= C[i] <= 106
//
//
//    Input Format
//    The first argument is the integer A.
//    The second argument is the integer B.
//    The third argument is the integer array C.
//
//
//    Output Format
//    Return a single integer which denotes the maximum sum.
//
//
//            Example Input
//    Input 1:
//    A = 5
//    B = 12
//    C = [2, 1, 3, 4, 5]
//    Input 2:
//
//    A = 3
//    B = 1
//    C = [2, 2, 2]
//
//
//    Example Output
//    Output 1:
//            12
//    Output 2:
//
//            0
//
//
//    Example Explanation
//    Explanation 1:
//    We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
//    Explanation 2:
//
//    All elements are greater than B, which means we cannot select any subarray.
//    Hence, the answer is 0.
//
    public static void main(String[] args) {
        int input1A = 5;
        int input1B = 12;
        int[] input1C = {2, 1, 3, 4, 5};
        System.out.println(new AQ4MaximumSubarrayEasy().maxSubarray(input1A, input1B, input1C));
        int input2A = 3;
        int input2B = 1;
        int[] input2C = {2, 2, 2};
        System.out.println(new AQ4MaximumSubarrayEasy().maxSubarray(input2A, input2B, input2C));
        int  input3A = 9;
        int  input3B = 78;
        int[] input3C = {7, 1, 8, 5, 8, 5, 3, 3, 5 };
        System.out.println(new AQ4MaximumSubarrayEasy().maxSubarray(input3A, input3B, input3C));
    }

    public int maxSubarrayIncomplete(int A, int B, int[] C) {
        int sum = C[0];
        int ans = 0;
        for (int i = 1; i < C.length; i++) {
            if (sum + C[i] > sum) {
                if (sum + C[i] <= 12) {
                    sum = sum + C[i];
                    ans = sum;
                } else {

                }
            }
        }
        return ans;
    }

    public int maxSubarray(int A, int B, int[] C) {
        int[] pf = new int[C.length];
        pf[0] = C[0];
        for (int i = 1; i < C.length; i++) {
            pf[i] = pf[i - 1] + C[i];
        }
//        System.out.println(Arrays.toString(pf));
        int ans = 0;
        for (int i = 0; i < C.length; i++) {
            int sum;
            for (int j = i; j < C.length; j++) {
                if (i == 0)
                    sum = pf[j];
                else
                    sum = pf[j] - pf[i - 1];
                if (sum <= B)
                    ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
