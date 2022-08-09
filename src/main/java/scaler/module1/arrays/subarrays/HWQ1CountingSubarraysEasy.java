package scaler.module1.arrays.subarrays;

public class HWQ1CountingSubarraysEasy {
    //    Problem Description
//    Given an array A of N non-negative numbers and a non-negative number B,
//    you need to find the number of subarrays in A with a sum less than B.
//    We may assume that there is no overflow.
//
//
//
//    Problem Constraints
//1 <= N <= 103
//
//            1 <= A[i] <= 1000
//
//            1 <= B <= 107
//
//
//
//    Input Format
//    First argument is an integer array A.
//
//    Second argument is an integer B.
//
//
//
//    Output Format
//    Return an integer denoting the number of subarrays in A having sum less than B.
//
//
//
//            Example Input
//    Input 1:
//
//    A = [2, 5, 6]
//    B = 10
//    Input 2:
//
//    A = [1, 11, 2, 3, 15]
//    B = 10
//
//
//    Example Output
//    Output 1:
//
//            4
//    Output 2:
//
//            4
//
//
//    Example Explanation
//    Explanation 1:
//
//    The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
//    Explanation 2:
//
//    The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
    public static void main(String[] args) {
        int[] input1A = {2, 5, 6};
        int input1B = 10;
        System.out.println(new HWQ1CountingSubarraysEasy().solve(input1A,input1B));
        int[] input2A = {1, 11, 2, 3, 15};
        int input2B = 10;
        System.out.println(new HWQ1CountingSubarraysEasy().solve(input2A,input2B));
        int[] input3A = { 3, 12, 11, 11, 11, 15 };
        int input3B = 12;
        System.out.println(new HWQ1CountingSubarraysEasy().solve(input3A,input3B));
    }

    public int solve(int[] A, int B) {
        int[] pf = new int[A.length];
        pf[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pf[i] = pf[i - 1] + A[i];
        }
//        System.out.println(Arrays.toString(pf));
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int sum;
            for (int j = i; j < A.length; j++) {
                if (i == 0)
                    sum = pf[j];
                else
                    sum = pf[j] - pf[i - 1];
                if (sum < B)
                    ans++;
            }
        }
        return ans;
    }
}
