package scaler.advancedDsa.hashing2;

import java.util.*;

public class HWQ2CompareSortedSubarrays {
    //    Problem Description
//    Given an array A of length N. You have to answer Q queries.
//    Each query will contain four integers l1, r1, l2, and r2. If sorted segment from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer is 1 else 0.
//    NOTE The queries are 0-indexed.
//            Problem Constraints
//0 <= A[i] <= 100000
//            1 <= N <= 100000
//            1 <= Q <= 100000
//    Input Format
//    The first argument is an array A.
//    The second is a 2D array B denoting queries with dimension Q * 4.
//    Consider ith query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].
//    Output Format
//    Return an array of length Q with answers to the queries in the same order as the input.
//    Example Input
//    Input 1:
//    A = [1, 7, 11, 8, 11, 7, 1]
//    B = [
//            [0, 2, 4, 6]
//            ]
//    Input 2:
//    A = [1, 3, 2]
//    B = [
//            [0, 1, 1, 2]
//            ]
//    Example Output
//    Output 1:
//            [1]
//    Output 2:
//            [0]
//    Example Explanation
//    Explanation 1:
//            (0, 2) -> [1, 7, 11]
//            (4, 6) -> [11, 7, 1]
//    Both are same when sorted hence 1.
//    Explanation 2:
//            (0, 1) -> [1, 3]
//            (1, 2) -> [3, 2]
//    Both are different when sorted hence 0.
    public static void main(String[] args) {
        int[] input1A = {1, 7, 11, 8, 11, 7, 1};
        int[][] input1B = {
                {0, 2, 4, 6}
        };
        System.out.println(Arrays.toString(new HWQ2CompareSortedSubarrays().solve(input1A, input1B)));
        int[] input2A = {1, 3, 2};
        int[][] input2B = {
                {0, 1, 1, 2}
        };
        System.out.println(Arrays.toString(new HWQ2CompareSortedSubarrays().solve(input2A, input2B)));
    }

    public int[] solve(int[] A, int[][] B) {
        int[] ans = new int[B.length];
        HashMap<Integer, Long> mapOfRandomNo = new HashMap<>();
        long[] randomPrefixSum = new long[A.length];
        
        for (int i = 0; i < A.length; i++) {
            Long randomNo = mapOfRandomNo.getOrDefault(A[i], (long) getModdedNumber(new Random().nextInt()));
            if (i == 0) randomPrefixSum[i] = getModdedNumber((randomPrefixSum[i] + randomNo));
            else
                randomPrefixSum[i] = getModdedNumber((randomPrefixSum[i - 1] + randomNo));
        }
//        System.out.println(Arrays.toString(randomPrefixSum));

        for (int i = 0; i < B.length; i++) {
            int l1 = B[i][0];
            int r1 = B[i][1];
            int l2 = B[i][2];
            int r2 = B[i][3];

            if (r1 - l1 != r2 - l2) {
                ans[i] = 0;
                continue;
            }
            long sum1 = 0;
            long sum2 = 0;
            if (l1 == 0) {
                sum1 = randomPrefixSum[r1];
            } else {
                sum1 = (randomPrefixSum[r1] - randomPrefixSum[l1]);
            }
            if (l2 == 0) {
                sum2 = randomPrefixSum[r2];
            } else {
                sum2 = (randomPrefixSum[r2] - randomPrefixSum[l2]);
            }
            System.out.println(sum1 + " - " + sum2);
            ans[i] = sum1 == sum2 ? 1 : 0;
        }
        return ans;
    }

    //tle
    public int[] solve_tle(int[] A, int[][] B) {
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            int l1 = B[i][0];
            int r1 = B[i][1];
            int l2 = B[i][2];
            int r2 = B[i][3];

            if (r1 - l1 != r2 - l2) {
                ans[i] = 0;
                continue;
            }
            HashSet<Integer> hashSet = new HashSet();
            while (l1 <= r1) {
                hashSet.add(A[l1]);
                l1++;
            }
            int tempAns = 1;
            while (l2 <= r2) {
                if (!hashSet.contains(A[l2])) {
                    tempAns = 0;
                    break;
                }
                l2++;
            }
            ans[i] = tempAns;
        }
        return ans;
    }

    long getModdedNumber(long A) {
        long C = (long) (Math.pow(10, 9) + 7);
        if (A < 0) {
//            System.out.println(A);
            return (A + C) % C;
        } else
            return A % C;
    }
}
