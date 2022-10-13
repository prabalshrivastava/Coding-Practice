package scaler.advancedDsa.hashing2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AQ1CountRectangles {
//    Problem Description
//    Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
//    Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
//            Problem Constraints
//1 <= N <= 2000
//            0 <= A[i], B[i] <= 109
//    Input Format
//    The first argument given is the integer array A.
//    The second argument given is the integer array B.
//            Output Format
//    Return the number of unordered quadruplets that form a rectangle.
//    Example Input
//    Input 1:
//    A = [1, 1, 2, 2]
//    B = [1, 2, 1, 2]
//    Input 1:
//    A = [1, 1, 2, 2, 3, 3]
//    B = [1, 2, 1, 2, 1, 2]
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            3
//    Example Explanation
//    Explanation 1:
//    All four given points make a rectangle. So, the answer is 1.
//    Explanation 2:
//            3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
//            (1, 1), (3, 1), (3, 2), (1, 2)
//            (2, 1), (3, 1), (3, 2), (2, 2)

    public static void main(String[] args) {
        int[] input1A = {1, 1, 2, 2};
        int[] input1B = {1, 2, 1, 2};
        System.out.println(new AQ1CountRectangles().solve(input1A, input1B));//1
        int[] input2A = {1, 1, 2, 2, 3, 3};
        int[] input2B = {1, 2, 1, 2, 1, 2};
        System.out.println(new AQ1CountRectangles().solve(input2A, input2B));//3
    }

    public int solve(int[] A, int[] B) {
        Map<Integer, Long> freqMapX = new HashMap<>();
        Map<Integer, Long> freqMapY = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            freqMapX.put(A[i], freqMapX.getOrDefault(A[i], 0L) + 1);
            freqMapY.put(B[i], freqMapY.getOrDefault(B[i], 0L) + 1);
            hashSet.add(A[i] + "_" + B[i]);
        }

        long count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int x1 = A[i];
                int y2 = B[j];

                int x2 = A[j];
                int y1 = B[i];
//                boolean isExtraX1Exists = freqMapX.getOrDefault(x1, 0L) >= 2;
//                boolean isExtraX2Exists = freqMapX.getOrDefault(x2, 0L) >= 2;
//                boolean isExtraY1Exists = freqMapY.getOrDefault(y1, 0L) >= 2;
//                boolean isExtraY2Exists = freqMapY.getOrDefault(y2, 0L) >= 2;
                String coord1 = x1 + "_" + y2;
                String coord2 = x2 + "_" + y1;
                if (x1 == x2 || y1 == y2) {
                    continue;
                }
                if (hashSet.contains(coord1) && hashSet.contains(coord2)) {
//                    System.out.println(coord1 + " - " + coord2);
                    count++;
                }
//                if (isExtraX1Exists &&
//                        isExtraX2Exists &&
//                        isExtraY1Exists &&
//                        isExtraY2Exists) {
//                    System.out.println(coord1 + " - " + coord2);
//                    count++;
//                }
            }
        }
        return (int) count / 2;
    }
}
