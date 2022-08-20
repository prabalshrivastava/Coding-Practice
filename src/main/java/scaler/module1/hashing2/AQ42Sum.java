package scaler.module1.hashing2;

import java.util.*;

public class AQ42Sum {
//    Problem Description
//    Given an array of integers, find two numbers such that they add up to a specific target number.
//    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
//    If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
//            Input: [2, 7, 11, 15], target=9
//    Output: index1 = 1, index2 = 2

    public static void main(String[] args) {
        int[] inputArr1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(new AQ42Sum().twoSum(inputArr1, target1)));
        int[] A = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        int B = -3;
        System.out.println(Arrays.toString(new AQ42Sum().twoSum(A, B)));
//        Output: index1 = 1, index2 = 2
    }

    public int[] twoSumIncomplete(final int[] A, int B) {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.get(A[i]).add(i);
            } else
                map.put(A[i], Collections.singletonList(i));
        }
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(B - A[i])) {
//                return new int[Math.min(i,map.get(B - A[i]))]
            }
        }
        return A;
    }

    public int[] twoSum(final int[] A, int B) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                if (B - A[i] == A[i]) {
                    return new int[]{map.get(A[i]), i};
                }
            } else
                map.put(A[i], i);
        }
//        System.out.println(map);
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(Math.abs(B - A[i]))) {
                return new int[]{Math.min(i, map.get(B - A[i])), Math.max(i, map.get(B - A[i]))};
            }
        }
        return A;
    }
}
