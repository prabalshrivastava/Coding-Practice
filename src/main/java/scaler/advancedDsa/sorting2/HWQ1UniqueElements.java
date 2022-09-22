package scaler.advancedDsa.sorting2;

import java.util.Arrays;

public class HWQ1UniqueElements {
//    Problem Description
//    You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.
//    Find the minimum number of steps.
//    Problem Constraints
//1 <= N <= 105
//            1 <= A[i] <= 109
//    Input Format
//    The only argument given is an Array A, having N integers.
//    Output Format
//    Return the minimum number of steps required to make all elements unique.
//    Example Input
//    Input 1:
//    A = [1, 1, 3]
//    Input 2:
//    A = [2, 4, 5]
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
//    Explanation 2:
//    All elements are distinct.

    public int solve(int[] A) {
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        int count = 0;
        int previousDup = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                previousDup = A[i];
                if (i + 2 < A.length) {
                    if (A[i + 1] + 1 == A[i + 2]) {
                    } else {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input1A = {1, 1, 3};
        System.out.println(new HWQ1UniqueElements().solve(input1A));
        int[] input2A = {2, 4, 5};
        System.out.println(new HWQ1UniqueElements().solve(input2A));
        int[] input3A = {1, 1, 1, 1, 3};
        System.out.println(new HWQ1UniqueElements().solve(input3A));
        int[] input4A = {51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62};
        System.out.println(new HWQ1UniqueElements().solve(input4A));
    }
}
//2, 5, 6, 6, 7, 8, 9, 10, 10, 13, 14, 14, 14, 14, 15, 16, 17, 18, 18, 18, 20, 21, 22, 22, 23, 23, 23, 24, 25, 26, 30, 31, 31, 32, 32, 34, 35, 36, 37, 39, 41, 45, 46, 47, 48, 48, 51, 51, 51, 53, 54, 54, 54, 55, 56, 56, 56, 60, 61, 62, 66, 66, 66, 67, 68, 69, 69, 71, 72, 73, 73, 75, 76, 76, 79, 80, 81, 81, 81, 83, 83, 85, 85, 85, 85, 86, 88, 92, 95, 97, 98, 99, 100, 100
