package scaler.advancedDsa.sorting3;

import java.util.Arrays;

public class AQ2QuickSort {
    //    Problem Description
//    Given an integer array A, sort the array using QuickSort.
//            Problem Constraints
//1 <= |A| <= 105
//            1 <= A[i] <= 109
//    Input Format
//    First argument is an integer array A.
//            Output Format
//    Return the sorted array.
//    Example Input
//    Input 1:
//    A = [1, 4, 10, 2, 1, 5]
//    Input 2:
//    A = [3, 7, 1]
//    Example Output
//    Output 1:
//            [1, 1, 2, 4, 5, 10]
//    Output 2:
//            [1, 3, 7]
//    Example Explanation
//    Explanation 1:
//    Return the sorted array.
    public static void main(String[] args) {
        int[] input1A = {1, 4, 10, 2, 1, 5};
        System.out.println(Arrays.toString(new AQ2QuickSort().solve(input1A)));
        int[] input2A = {3, 7, 1};
        System.out.println(Arrays.toString(new AQ2QuickSort().solve(input2A)));
    }

    public int[] solve(int[] A) {
        quickSort(A, 0, A.length - 1);
        return A;
    }

    private void quickSort(int[] A, int l, int r) {
        if (l >= r) {
            return;
        }
        int idx = rearrange(A, l, r);
        quickSort(A, l, idx - 1);
        quickSort(A, idx + 1, r);
    }

    private int rearrange(int[] A, int l, int r) {
        int p1 = l + 1;
        int p2 = r;
        while (p1 <= p2) {
            if (A[p1] <= A[l]) {
                p1++;
            } else if (A[p2] > A[l]) {
                p2--;
            } else {
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
                p1++;
                p2--;
            }
        }
        int temp = A[l];
        A[l] = A[p2];
        A[p2] = temp;
        return p2;
    }
}
