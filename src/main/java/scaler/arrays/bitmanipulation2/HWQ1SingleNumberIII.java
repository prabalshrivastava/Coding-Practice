package scaler.arrays.bitmanipulation2;

import java.util.Arrays;

public class HWQ1SingleNumberIII {
    //    Problem Description
//    Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
//    Find the two integers that appear only once.
//
//
//
//    Problem Constraints
//2 <= |A| <= 100000
//            1 <= A[i] <= 109
//
//
//
//    Input Format
//    The first argument is an array of integers of size N.
//
//
//
//            Output Format
//    Return an array of two integers that appear only once.
//
//
//
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 1, 2, 4]
//    Input 2:
//
//    A = [1, 2]
//
//
//    Example Output
//    Output 1:
//            [3, 4]
//    Output 2:
//
//            [1, 2]
//
//
//    Example Explanation
//    Explanation 1:
//            3 and 4 appear only once.
//            Explanation 2:
//
//            1 and 2 appear only once.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 1, 2, 4};
        System.out.println(Arrays.toString(new HWQ1SingleNumberIII().solve(input1A)));
        int[] input2A = {1, 2};
        System.out.println(Arrays.toString(new HWQ1SingleNumberIII().solve(input2A)));

    }

    public int[] solve(int[] A) {

        return A;
    }
}
