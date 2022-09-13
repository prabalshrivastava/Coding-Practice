package scaler.advancedDsa.maths.gcd;

import java.util.Arrays;
import java.util.HashSet;

public class HWQ4AllGCDPair {
//    Problem Description
//    Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
//    Find and return the original numbers used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.
//    Problem Constraints
//1 <= N <= 10000
//            1 <= A[i] <= 109
//    Input Format
//    The first and only argument given is the integer array A.
//            Output Format
//    Find and return the original numbers which are used to calculate the GCD array in any order.
//    Example Input
//    Input 1:
//    A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
//    Input 2:
//    A = [5, 5, 5, 15]
//    Example Output
//    Output 1:
//            [2, 8, 10]
//    Output 2:
//            [5, 15]
//    Example Explanation
//    Explanation 1:
//    Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
//            2 is the gcd between 2 and 8, 2 and 10.
//            8 and 10 are the gcds pair with itself.
//    Therefore, [2, 8, 10] is the original array.
//    Explanation 2:
//    Initially, array A = [5, 5, 5, 15].
//            5 is the gcd between 5 and 15.
//            15 is the gcds pair with itself.
//    Therefore, [5, 15] is the original array.

    public int[] solve(int[] A) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            hashSet.add(A[i]);
        }
        int[] B = new int[hashSet.size()];
        int count = 0;
        for (Integer element : hashSet) {
            B[count++] = element;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] input1A = {2, 2, 2, 2, 8, 2, 2, 2, 10};
        System.out.println(Arrays.toString(new HWQ4AllGCDPair().solve(input1A)));
        int[] input2A = {5, 5, 5, 15};
        System.out.println(Arrays.toString(new HWQ4AllGCDPair().solve(input2A)));
        int[] input3A = { 1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1, 11 };//11 14 22 23 31
        System.out.println(Arrays.toString(new HWQ4AllGCDPair().solve(input3A)));
    }
}
