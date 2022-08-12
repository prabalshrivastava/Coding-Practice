package scaler.module1.hashing1;

import java.util.HashMap;

public class AQ4SubArrayWith0Sum {
    //    Problem Description
//    Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
//    If the given array contains a sub-array with sum zero return 1, else return 0.
//    Problem Constraints
//1 <= |A| <= 100000
//            -10^9 <= A[i] <= 10^9
//    Input Format
//    The only argument given is the integer array A.
//            Output Format
//    Return whether the given array contains a subarray with a sum equal to 0.
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    Input 2:
//    A = [-1, 1]
//    Example Output
//    Output 1:
//            0
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    No subarray has sum 0.
//    Explanation 2:
//    The array has sum 0.
    public int solve(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (sum == 0)
                return 1;
            if (map.containsKey(sum)) {
                return 1;
            } else {
                map.put(sum, i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 4, 5};
        System.out.println(new AQ4SubArrayWith0Sum().solve(input1A));
        int[] input2A = {-1, 1};
        System.out.println(new AQ4SubArrayWith0Sum().solve(input2A));
    }
}
