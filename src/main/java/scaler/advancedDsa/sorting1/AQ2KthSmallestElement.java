package scaler.advancedDsa.sorting1;

import java.util.Arrays;

public class AQ2KthSmallestElement {
//    Problem Description
//    Find the Bth smallest element in given array A .
//            NOTE: Users should try to solve it in less than equal to B swaps.
//    Problem Constraints
//1 <= |A| <= 100000
//            1 <= B <= min(|A|, 500)
//1 <= A[i] <= 109
//    Input Format
//    The first argument is an integer array A.
//    The second argument is integer B.
//    Output Format
//    Return the Bth smallest element in given array.
//    Example Input
//    Input 1:
//    A = [2, 1, 4, 3, 2]
//    B = 3
//    Input 2:
//    A = [1, 2]
//    B = 2
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//            3rd element after sorting is 2.
//    Explanation 2:
//            2nd element after sorting is 2.

    public static void main(String[] args) {
        int[] input1A = {2, 1, 4, 3, 2};
        int input1B = 3;
        System.out.println(new AQ2KthSmallestElement().kthsmallest(input1A, input1B));
        int[] input2A = {1, 2};
        int input2B = 2;
        System.out.println(new AQ2KthSmallestElement().kthsmallest(input2A, input2B));
    }

    public int kthsmallest(final int[] A, int B) {
        for (int i = 0; i < A.length; i++) {
            int minIndex = i;
            for (int j = i; j < A.length; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
        }
//        System.out.println(Arrays.toString(A));
        return A[B - 1];
    }
}
