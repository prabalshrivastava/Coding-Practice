package scaler.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AQ2NobleInteger {
    //    Problem Description
//    Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.
//            Problem Constraints
//1 <= |A| <= 2*105
//            1 <= A[i] <= 107
//    Input Format
//    First and only argument is an integer array A.
//            Output Format
//    Return 1 if any such integer p is present else, return -1.
//    Example Input
//    Input 1:
//    A = [3, 2, 1, 3]
//    Input 2:
//    A = [1, 1, 3, 3]
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            -1
//    Example Explanation
//    Explanation 1:
//    For integer 2, there are 2 greater elements in the array..
//    Explanation 2:
//    There exist no integer satisfying the required conditions.
    public int solve(int[] A) {
        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));
        int count = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                if (A[i] == 0)
                    return 1;
                else
                    count++;
            } else {
                if (A[i] == count && A[i] != A[i + 1]) {
//                    System.out.printf("i=%s A[i]=%s count=%s%n", i, A[i], count);
                    return 1;
                } else
                    count++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] input1A = {3, 2, 1, 3};
//        System.out.println(new AQ2NobleInteger().solve(input1A));
//        int[] input2A = {1, 1, 3, 3};
//        System.out.println(new AQ2NobleInteger().solve(input2A));
//        int[] input3A = {-4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5};
//        System.out.println(new AQ2NobleInteger().solve(input3A));
        int[] input4A = {5, 6, 2};
        System.out.println(new AQ2NobleInteger().solve(input4A));
    }
}
