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
        int[] input3A = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};//3 and 8
        System.out.println(Arrays.toString(new HWQ1MaximumUnsortedSubarray().subUnsort(input3A)));
        int[] input4A = {0, 1, 15, 25, 6, 7, 30, 40, 50};//2 and 5
        System.out.println(Arrays.toString(new HWQ1MaximumUnsortedSubarray().subUnsort(input4A)));
    }

    public int[] subUnsort(int[] A) {
        int[] prefixMax = new int[A.length];
        int[] suffixMin = new int[A.length];
        prefixMax[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixMax[i] = Math.max(A[i], prefixMax[i - 1]);
        }
        suffixMin[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(A[i], suffixMin[i + 1]);
        }
        int i = 0;
        while (i < prefixMax.length && prefixMax[i] == suffixMin[i]) {
            i++;
        }
        int j = A.length - 1;
        while (j >= 0 && prefixMax[j] == suffixMin[j]) {
            j--;
        }
        if (i > j) {
            return new int[]{-1};
        }
//        System.out.println(Arrays.toString(prefixMax));
//        System.out.println(Arrays.toString(suffixMin));
        return new int[]{i, j};
    }
    //wrong approach
//    public int[] subUnsort(int[] A) {
//        int i = 0;
//        int j = A.length - 1;
//        while (i + 1 < A.length && A[i] < A[i + 1]) {
//            i++;
//        }
//        while (j - 1 >= 0 && A[j] > A[j - 1]) {
//            j--;
//        }
//        if (i > j) {
//            return new int[]{-1};
//        }
//
//        int min = A[i];
//        int max = A[j];
//        for (int k = i; k <= j; k++) {
//            min = Math.min(A[k], min);
//            max = Math.max(A[k], max);
//        }
////        System.out.println("Min : " + min + " - Max : " + max);
//        int r = -1;
//        int closestMin = Integer.MAX_VALUE;
//        int l = -1;
//        int closestMax = Integer.MIN_VALUE;
//        for (int k = 0; k < A.length; k++) {
//            if (A[k] < min) {
//                if (A[k] > closestMax) {
//                    closestMax = A[k];
//                    l = k;
//                }
////                closestMax = Math.max(closestMax, A[k]);
//            }
//            if (A[k] > max) {
////                closestMin = Math.min(closestMin, A[k]);
//                if (A[k] < closestMin) {
//                    closestMin = A[k];
//                    r = k;
//                }
//            }
//        }
////        System.out.println("r : " + r + " - l : " + l);
//        return new int[]{l + 1, r - 1};
//    }
}
