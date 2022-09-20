package scaler.advancedDsa.sorting2;


import java.util.Arrays;

public class AQ1InversionCountInAnArray {
    //    Problem Description
//    Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
//    Problem Constraints
//1 <= length of the array <= 100000
//            1 <= A[i] <= 10^9
//    Input Format
//    The only argument given is the integer array A.
//            Output Format
//    Return the number of inversions of A modulo (109 + 7).
//    Example Input
//    Input 1:
//    A = [3, 2, 1]
//    Input 2:
//    A = [1, 2, 3]
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    All pairs are inversions.
//    Explanation 2:
//    No inversions.
    public static void main(String[] args) {
//        int[] input1A = {3, 2, 1};
//        System.out.println(new AQ1InversionCountInAnArray().solve(input1A));
//        int[] input2A = {1, 2, 3};
//        System.out.println(new AQ1InversionCountInAnArray().solve(input2A));
        int[] input3A = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(new AQ1InversionCountInAnArray().solve(input3A));
    }

    public int solve(int[] A) {
        int l = 0;
        int r = A.length - 1;
        mergeSort(A, l, r);
        return l;
    }

    private int mergeSort(int[] a, int l, int r) {
        if (l == r)
            return 0;
        int mid = (r + l) / 2;
        int x = mergeSort(a, l, mid);
        int y = mergeSort(a, mid + 1, r);
        merge(a, l, r, mid + 1);
        System.out.println(Arrays.toString(a));
    }

    private int merge(int[] a, int l, int r, int y) {
        int p1 = l;
        int p2 = y;
        int index = 0;
        int[] ans = new int[r - l + 1];
        while (p1 <= y - 1 && p2 <= r) {
            if (a[p1] <= a[p2]) {
                ans[index++] = a[p1++];
            } else {
                ans[index++] = a[p2++];
            }
        }
        while (p1 <= y - 1) {
            ans[index++] = a[p1++];
        }

        while (p2 <= r) {
            ans[index++] = a[p2++];
        }

        index = l;
        for (int i = 0; i < ans.length; i++) {
            a[index++] = ans[i];
        }
    }
}
