package scaler.advancedDsa.hashing2;

import java.util.Arrays;

public class HWQ3CommonElements {
    //        Problem Description
//        Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
//                NOTE:
//        Each element in the result should appear as many times as it appears in both arrays.
//        The result can be in any order.
//                Problem Constraints
//1 <= N, M <= 105
//                1 <= A[i] <= 109
//        Input Format
//        First argument is an integer array A of size N.
//        Second argument is an integer array B of size M.
//        Output Format
//        Return an integer array denoting the common elements.
//        Example Input
//        Input 1:
//        A = [1, 2, 2, 1]
//        B = [2, 3, 1, 2]
//        Input 2:
//        A = [2, 1, 4, 10]
//        B = [3, 6, 2, 10, 10]
//        Example Output
//        Output 1:
//                [1, 2, 2]
//        Output 2:
//                [2, 10]
//        Example Explanation
//        Explanation 1:
//        Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
//        Explantion 2:
//        Elements (2, 10) appears in both the array.
    public int[] solve(int[] A, int[] B) {
        return A;
    }

    public static void main(String[] args) {
        int[] input1A = {1, 2, 2, 1};
        int[] input1B = {2, 3, 1, 2};
        System.out.println(Arrays.toString(new HWQ3CommonElements().solve(input1A, input1B)));
        int[] input2A = {2, 1, 4, 10};
        int[] input2B = {3, 6, 2, 10, 10};
        System.out.println(Arrays.toString(new HWQ3CommonElements().solve(input2A, input2B)));

    }
}
