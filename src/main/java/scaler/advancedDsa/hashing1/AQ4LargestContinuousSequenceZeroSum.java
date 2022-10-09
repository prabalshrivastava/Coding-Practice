package scaler.advancedDsa.hashing1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AQ4LargestContinuousSequenceZeroSum {
    //    Problem Description
//    Given an array A of N integers.
//    Find the largest continuous sequence in a array which sums to zero.
//    Problem Constraints
//1 <= N <= 106
//            -107 <= A[i] <= 107
//    Input Format
//    Single argument which is an integer array A.
//    Output Format
//    Return an array denoting the longest continuous sequence with total sum of zero.
//            NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
//    Example Input
//    A = [1,2,-2,4,-4]
//    Example Output
//[2,-2,4,-4]
//    Example Explanation
//[2,-2,4,-4] is the longest sequence with total sum of zero.
    public int[] lszero(int[] A) {
        Map<Long, Integer> map = new HashMap();
        long sum = 0;
        int start = -1;
        int end = -1;
        long maxDistance = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (sum == 0 || map.containsKey(sum)) {
                int distance = 0;
                int s = 0;
                int e = 0;
                if (sum == 0) {
                    s = -1;
                } else {
                    s = map.get(sum);
                }
                e = i;
                distance = e - s;
                if (distance > maxDistance) {
                    maxDistance = distance;
                    start = s;
                    end = e;
                }
            } else {
                map.put(sum, i);
            }
        }
        int[] ans = new int[end - start];
        int index = 0;
//        System.out.println("start : " + start + " | end : " + end);
        for (int i = start + 1; i <= end; i++) {
            ans[index++] = A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -2, 4, -4};
        System.out.println(Arrays.toString(new AQ4LargestContinuousSequenceZeroSum().lszero(A)));
        int[] B = {1, 2, -3, 3};
        System.out.println(Arrays.toString(new AQ4LargestContinuousSequenceZeroSum().lszero(B)));
//        The expected return value:
//        1 2 -3

        int[] C = {1, 2, -2, 4, -4};
//        The expected return value:
//        2 -2 4 -4
        System.out.println(Arrays.toString(new AQ4LargestContinuousSequenceZeroSum().lszero(C)));

        int[] D = {-19, 8, 2, -8, 19, 5, -2, -23};
        System.out.println(Arrays.toString(new AQ4LargestContinuousSequenceZeroSum().lszero(D)));
    }
}
