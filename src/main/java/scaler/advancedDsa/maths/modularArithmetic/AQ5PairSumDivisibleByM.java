package scaler.advancedDsa.maths.modularArithmetic;

import java.util.HashMap;
import java.util.Map;

import static scaler.common.CommonUtils.getModdedSum;

public class AQ5PairSumDivisibleByM {
//    Problem Description
//    Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
//    Since the answer may be large, return the answer modulo (109 + 7).
//    Problem Constraints
//1 <= length of the array <= 100000
//            1 <= A[i] <= 109
//            1 <= B <= 106
//    Input Format
//    The first argument given is the integer array A.
//    The second argument given is the integer B.
//    Output Format
//    Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    B = 2
//    Input 2:
//    A = [5, 17, 100, 11]
//    B = 28
//    Example Output
//    Output 1:
//            4
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
//    So total 4 pairs.

    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 4, 5};
        int input1B = 2;
        System.out.println(new AQ5PairSumDivisibleByM().solve(input1A, input1B));
        int[] input2A = {5, 17, 100, 11};
        int input2B = 28;
        System.out.println(new AQ5PairSumDivisibleByM().solve(input2A, input2B));
    }

    public int solve(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < A.length; i++) {
            int mod = A[i] % B;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
//        System.out.println(map);
        Integer zeroFreq = map.getOrDefault(0, 0);
        long ans = ((long) zeroFreq * (zeroFreq - 1)) / 2;
        ans = getModdedSum(ans);
        int l = 1;
        int r = B - 1;
        while (l < r) {
            long freqL = map.getOrDefault(l, 0);
            long freqR = map.getOrDefault(r, 0);
            ans = getModdedSum(getModdedSum(ans) + getModdedSum(freqL) * getModdedSum(freqR));
            l++;
            r--;
        }

        if (l == r) {
            long mid = map.getOrDefault(B / 2, 0);
//            System.out.println(mid);
            ans = getModdedSum(ans + ((mid * (mid - 1)) / 2));
        }
        return (int) getModdedSum(ans);
    }

}
