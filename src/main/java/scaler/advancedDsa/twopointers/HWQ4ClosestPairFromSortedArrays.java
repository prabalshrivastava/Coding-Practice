package scaler.advancedDsa.twopointers;

import java.util.Arrays;

public class HWQ4ClosestPairFromSortedArrays {
    //    Problem Description
//    Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.
//    More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
//    If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.
//    Return an array with two elements {A[i], B[j]}.
//    Problem Constraints
//1 <= length of both the arrays <= 100000
//            1 <= A[i], B[i] <= 109
//            1 <= C <= 109
//    Input Format
//    The first argument given is the integer array A.
//    The second argument given is the integer array B.
//    The third argument given is integer C.
//            Output Format
//    Return an array of size 2 denoting the pair which has sum closest to C.
//            Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    B = [2, 4, 6, 8]
//    C = 9
//    Input 2:
//    A = [5, 10, 20]
//    B = [1, 2, 30]
//    C = 13
//    Example Output
//    Output 1:
//            [1, 8]
//    Output 2:
//            [10, 2]
//    Example Explanation
//    Explanation 1:
//    There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
//    Since we have to return the value with minimum i and then with minimum j. We will return [1, 8].
//    Explanation 2:
//            [10, 2] is the only pair such abs(10+2-13) is minimum.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 4, 5};
        int[] input1B = {2, 4, 6, 8};
        int input1C = 9;
        System.out.println(Arrays.toString(new HWQ4ClosestPairFromSortedArrays().solve(input1A, input1B, input1C)));
        int[] input2A = {5, 10, 20};
        int[] input2B = {1, 2, 30};
        int input2C = 13;
        System.out.println(Arrays.toString(new HWQ4ClosestPairFromSortedArrays().solve(input2A, input2B, input2C)));
    }

    public int[] solve(int[] A, int[] B, int C) {
        return A;
    }
}
