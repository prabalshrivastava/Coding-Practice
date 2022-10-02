package scaler.advancedDsa.binarysearch2;

import scaler.advancedDsa.binarysearch1.AQ3RotatedSortedArraySearch;

public class AQ2RotatedSortedArraySearch {
    //    Problem Description
//    Given a sorted array of integers A of size N and an integer B.
//    array A is rotated at some pivot unknown to you beforehand.
//            (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
//    You are given a target value B to search. If found in the array, return its index otherwise, return -1.
//    You may assume no duplicate exists in the array.
//            NOTE: Users are expected to solve this in O(log(N)) time.
//            Problem Constraints
//1 <= N <= 1000000
//            1 <= A[i] <= 10^9
//    all elements in A are distinct.
//    Input Format
//    The first argument given is the integer array A.
//    The second argument given is the integer B.
//    Output Format
//    Return index of B in array A, otherwise return -1
//    Example Input
//    Input 1:
//    A = [4, 5, 6, 7, 0, 1, 2, 3]
//    B = 4
//    Input 2:
//    A = [1]
//    B = 1
//    Example Output
//    Output 1:
//            0
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    Target 4 is found at index 0 in A.
//    Explanation 2:
//    Target 1 is found at index 0 in A.
    public static void main(String[] args) {
        int[] input1A = {4, 5, 6, 7, 0, 1, 2, 3};
        // 0, 1, 2, 3,4, 5, 6, 7
        int input1B = 4;
        System.out.println(new AQ2RotatedSortedArraySearch().search(input1A, input1B));
        int[] input2A = {1};
        int input2B = 1;
        System.out.println(new AQ2RotatedSortedArraySearch().search(input2A, input2B));
        int[] input3A = {101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        int input3B = 202;
        System.out.println(new AQ2RotatedSortedArraySearch().search(input3A, input3B));
        int[] input4A = {180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177 };
        int input4B = 42;
        System.out.println(new AQ2RotatedSortedArraySearch().search(input4A, input4B));
    }

    public int search(final int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == B) {
                return mid;
            }
            if (A[mid] > A[0]) {
                //mid-lies in left
                if (A[0] <= B && B < A[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //mid-lies in right
                if (A[mid] <= B && B < A[A.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
