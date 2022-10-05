package scaler.advancedDsa.twopointers;

import java.util.Arrays;

public class AQ1SubarrayWithGivenSum {
    //    Problem Description
//    Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
//    If the answer does not exist return an array with a single element "-1".
//    First sub-array means the sub-array for which starting index in minimum.
//            Problem Constraints
//1 <= length of the array <= 100000
//            1 <= A[i] <= 109
//            1 <= B <= 109
//    Input Format
//    The first argument given is the integer array A.
//    The second argument given is integer B.
//            Output Format
//    Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    B = 5
//    Input 2:
//    A = [5, 10, 20, 100, 105]
//    B = 110
//    Example Output
//    Output 1:
//            [2, 3]
//    Output 2:
//            -1
//    Example Explanation
//    Explanation 1:
//            [2, 3] sums up to 5.
//    Explanation 2:
//    No subarray sums up to required number.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 4, 5};
        int input1B = 5;
        System.out.println(Arrays.toString(new AQ1SubarrayWithGivenSum().solve(input1A, input1B)));//[2, 3]
        int[] input2A = {5, 10, 20, 100, 105};
        int input2B = 110;
        System.out.println(Arrays.toString(new AQ1SubarrayWithGivenSum().solve(input2A, input2B)));//-1
    }

    private int[] solve(int[] A, int B) {
        int[] pf = new int[A.length];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            pf[i] = sum;
        }
        int i = 0;
        int j = 0;
        while (j < pf.length) {
            int subSum = 0;
            if (i == 0) {
                subSum = pf[j];
            } else {
                subSum = pf[j] - pf[i - 1];
            }
            if (subSum == B) {
                return returnAns(i, j, A);
            } else if (subSum > B) {
                i++;
            } else {
                j++;
            }
        }
        return new int[]{-1};
    }

    private int[] returnAns(int i, int j, int[] pf) {
        int[] ans = new int[j - i + 1];
        int count = 0;
        for (int k = i; k <= j; k++) {
            ans[count++] = pf[k];
        }
        return ans;
    }

}
