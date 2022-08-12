package scaler.module1.hashing1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AQ3LargestContinuousSequenceZeroSum {
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
//        System.out.println(Arrays.toString(A));
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxDistance = Integer.MIN_VALUE;
        int endIndex = Integer.MIN_VALUE;
        int startIndex = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (sum == 0) {
                startIndex = -1;
                endIndex = i;
                maxDistance = endIndex - startIndex + 1;
                continue;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) + 1 > maxDistance) {
//                    System.out.println("before : startIndex : " + startIndex + " - endIndex : " + endIndex + " - maxDistance : " + maxDistance);
                    startIndex = map.get(sum);
                    endIndex = i;
                    maxDistance = endIndex - startIndex + 1;
//                    System.out.println("After : startIndex : " + startIndex + " - endIndex : " + endIndex + " - maxDistance : " + maxDistance);
                }
            } else {
                map.put(sum, i);
            }
        }
        System.out.println("startIndex : " + startIndex + " - endIndex : " + endIndex + " - maxDistance : " + maxDistance);

        if (maxDistance == Integer.MIN_VALUE) {
            return new int[0];
        }
        int[] arr = new int[maxDistance - 1];
        int count = 0;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            arr[count] = A[i];
            count++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -2, 4, -4};
        System.out.println(Arrays.toString(new AQ3LargestContinuousSequenceZeroSum().lszero(A)));
        int[] B = {1, 2, -3, 3};
        System.out.println(Arrays.toString(new AQ3LargestContinuousSequenceZeroSum().lszero(B)));
//        The expected return value:
//        1 2 -3

        int[] C = {1, 2, -2, 4, -4};
//        The expected return value:
//        2 -2 4 -4
        System.out.println(Arrays.toString(new AQ3LargestContinuousSequenceZeroSum().lszero(C)));

        int[] D = {-19, 8, 2, -8, 19, 5, -2, -23};
        System.out.println(Arrays.toString(new AQ3LargestContinuousSequenceZeroSum().lszero(D)));
    }
}
