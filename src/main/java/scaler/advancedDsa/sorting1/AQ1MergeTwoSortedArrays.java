package scaler.advancedDsa.sorting1;

import java.util.Arrays;

public class AQ1MergeTwoSortedArrays {
//    Problem Description
//    Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
//    Problem Constraints
//-1010 <= A[i], B[i] <= 1010
//    Input Format
//    First Argument is a 1-D array representing A.
//    Second Argument is also a 1-D array representing B.
//    Output Format
//    Return a 1-D vector which you got after merging A and B.
//    Example Input
//    Input 1:
//    A = [4, 7, 9 ]
//    B = [2, 11, 19 ]
//    Input 2:
//    A = [1]
//    B = [2]
//    Example Output
//    Output 1:
//            [2, 4, 7, 9, 11, 19]
//    Output 2:
//            [1, 2]
//    Example Explanation
//    Explanation 1:
//    Merging A and B produces the output as described above.
//    Explanation 2:
//    Merging A and B produces the output as described above.

    public int[] solve(final int[] A, final int[] B) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[A.length + B.length];
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                ans[k] = A[i];
                i++;
            } else {
                ans[k] = B[j];
                j++;
            }
            k++;
        }
        while (i < A.length) {
            ans[k++] = A[i++];
        }
        while (j < B.length) {
            ans[k++] = B[j++];
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] input1A = {4, 7, 9};
        int[] input1B = {2, 11, 19};
        System.out.println(Arrays.toString(new AQ1MergeTwoSortedArrays().solve(input1A, input1B)));

        int[] input2A = {1};
        int[] input2B = {2};
        System.out.println(Arrays.toString(new AQ1MergeTwoSortedArrays().solve(input2A, input2B)));
    }
}
