package scaler.advancedDsa.sorting3;

import java.util.Arrays;

public class HWQ1MaximumUnsortedSubarray {
    //    Problem Description
//    Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.
//    Problem Constraints
//1 <= N <= 1000000
//            1 <= A[i] <= 1000000
//    Input Format
//    First and only argument is an array of non-negative integers of size N.
//            Output Format
//    Return an array of length two where the first element denotes the starting index(0-based) and the second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.
//    Example Input
//    Input 1:
//    A = [1, 3, 2, 4, 5]
//    Input 2:
//    A = [1, 2, 3, 4, 5]
//    Example Output
//    Output 1:
//            [1, 2]
//    Output 2:
//            [-1]
//    Example Explanation
//    Explanation 1:
//    If we sort the sub-array A1, A2, then the whole array A gets sorted.
//    Explanation 2:
//    A is already sorted.
    public static void main(String[] args) {
        int[] input1A = {1, 3, 2, 4, 5};
        System.out.println(Arrays.toString(new HWQ1MaximumUnsortedSubarray().subUnsort(input1A)));
        int[] input2A = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new HWQ1MaximumUnsortedSubarray().subUnsort(input2A)));
    }

    public int[] subUnsort(int[] A) {
        return A;
    }
}
