package scaler.hashing;

import java.util.Arrays;

public class AQ3LargestContinuousSequenceZeroSum {
    //    Problem Description
//    Given an array A of N integers.
//    Find the largest continuous sequence in a array which sums to zero.
//    Problem Constraints
//1 <= N <= 106
//            -107 <= A[i] <= 107
//    Input Format
//    Single argument which is an integer array A.
//    Output Format
//    Return an array denoting the longest continuous sequence with total sum of zero.
//            NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
//    Example Input
//    A = [1,2,-2,4,-4]
//    Example Output
//[2,-2,4,-4]
//    Example Explanation
//[2,-2,4,-4] is the longest sequence with total sum of zero.
    public int[] lszero(int[] A) {

        return A;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -2, 4, -4};
        System.out.println(Arrays.toString(new AQ3LargestContinuousSequenceZeroSum().lszero(A)));
    }
}
