package scaler.advancedDsa.hashing2;

import java.util.HashMap;
import java.util.Map;

public class AQ2CountRightTriangles {
//    Problem Description
//    Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
//    Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
//    NOTE: The answer may be large so return the answer modulo (109 + 7).
//    Problem Constraints
//    1 <= N <= 105
//    0 <= A[i], B[i] <= 109
//    Input Format
//    The first argument given is an integer array A.
//    The second argument given is the integer array B.
//            Output Format
//    Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).
//    Example Input
//    Input 1:
//    A = [1, 1, 2]
//    B = [1, 2, 1]
//    Input 2:
//    A = [1, 1, 2, 3, 3]
//    B = [1, 2, 1, 2, 1]
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            6
//    Example Explanation
//    Explanation 1:
//    All three points make a right angled triangle. So return 1.
//    Explanation 2:
//            6 triplets which make a right angled triangle are:    (1, 1), (1, 2), (2, 2)
//            (1, 1), (3, 1), (1, 2)
//            (1, 1), (3, 1), (3, 2)
//            (2, 1), (3, 1), (3, 2)
//            (1, 1), (1, 2), (3, 2)
//            (1, 2), (3, 1), (3, 2)

    public int solve(int[] A, int[] B) {
        Map<Integer, Long> freqMapX = new HashMap<>();
        Map<Integer, Long> freqMapY = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            freqMapX.put(A[i], freqMapX.getOrDefault(A[i], 0L) + 1);
            freqMapY.put(B[i], freqMapY.getOrDefault(B[i], 0L) + 1);
        }
//        System.out.println(freqMapX);
//        System.out.println(freqMapY);

        long count = 0;
        for (int i = 0; i < A.length; i++) {
            long countX = freqMapX.get(A[i]);
            long countY = freqMapY.get(B[i]);
            count = count + getModdedSum(countX - 1) * getModdedSum(countY - 1);
            count = getModdedSum(count);
        }
        return (int) getModdedSum(count);
    }

    private long getModdedSum(long sum) {
        if (sum < 0)
            sum = (long) ((sum + (Math.pow(10, 9) + 7)) % (Math.pow(10, 9) + 7));
        else
            sum = (long) (sum % (Math.pow(10, 9) + 7));
        return sum;
    }

    public static void main(String[] args) {
        int[] input1A = {1, 1, 2};
        int[] input1B = {1, 2, 1};
        System.out.println(new AQ2CountRightTriangles().solve(input1B, input1A));
        int[] input2A = {1, 1, 2, 3, 3};
        int[] input2B = {1, 2, 1, 2, 1};
        System.out.println(new AQ2CountRightTriangles().solve(input2B, input2A));
    }

}
