package scaler.arrays.subarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HWQ3AlternatingSubarraysEasy {
    //    Problem Description
//    You are given an integer array A of length N comprising of 0's & 1's, and an integer B.
//
//    You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 alternating subarray.
//
//    A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.
//
//
//
//    Problem Constraints
//1 <= N <= 103
//
//    A[i] equals to 0 or 1.
//
//            0 <= B <= (N - 1) / 2
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
//    Return an integer array containing indices(0-based) in sorted order. If no such index exists, return an empty integer array.
//
//
//
//    Example Input
//    Input 1:
//
//    A = [1, 0, 1, 0, 1]
//    B = 1
//    Input 2:
//
//    A = [0, 0, 0, 1, 1, 0, 1]
//    B = 0
//
//
//    Example Output
//    Output 1:
//
//            [1, 2, 3]
//    Output 2:
//
//            [0, 1, 2, 3, 4, 5, 6]
//
//
//    Example Explanation
//    Explanation 1:
//
//    Index 1 acts as a centre of alternating sequence: [A0, A1, A2]
//    Index 2 acts as a centre of alternating sequence: [A1, A2, A3]
//    Index 3 acts as a centre of alternating sequence: [A2, A3, A4]
//    Explanation 2:
//
//    Each index in the array acts as the center of alternating sequences of lengt
    public static void main(String[] args) {
//        int[] input1A = {1, 0, 1, 0, 1};
//        int input1B = 1;
//        System.out.println(Arrays.toString(new HWQ3AlternatingSubarraysEasy().solve(input1A, input1B)));
//        int[] input2A = {0, 0, 0, 1, 1, 0, 1};
//        int input2B = 0;
//        System.out.println(Arrays.toString(new HWQ3AlternatingSubarraysEasy().solve(input2A, input2B)));
        int[] A = {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1};
        int B = 1;
        System.out.println(Arrays.toString(new HWQ3AlternatingSubarraysEasy().solve(A, B))); //3 7 8
    }

    public int[] solve(int[] A, int B) {
        List<Integer> res = new ArrayList<>();
        int k = 2 * B + 1;
        System.out.println(A.length - k);
        for (int i = 0; i < A.length - k + 1; i++) {
            int e = i + k;
            boolean isAlternatingSubArray = true;
//            System.out.printf("Start : %s ------ End : %s%n", i, e);
            for (int j = i; j < e; j++) {
                if (j == i) {
                    continue;
                }
//                System.out.printf("A[%d]==A[%d-1]-->A[%d]==A[%d]-->%d==%d : %s%n", j, j, j, j - 1, A[j], A[j - 1], (A[j] == A[j - 1]));
                if (A[j] == A[j - 1]) {
                    isAlternatingSubArray = false;
                    break;
                }
            }
            if (isAlternatingSubArray) {
//                System.out.println("adding : " + i + k/2);
                res.add(i + k/2);
            }
        }
        return res.stream().mapToInt(value -> value).toArray();
    }
}
