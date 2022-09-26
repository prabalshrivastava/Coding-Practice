package scaler.advancedDsa.binarysearch1;

public class AQ3RotatedSortedArraySearch {
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
        System.out.println(new AQ3RotatedSortedArraySearch().search(input1A, input1B));
        int[] input2A = {1};
        int input2B = 1;
        System.out.println(new AQ3RotatedSortedArraySearch().search(input2A, input2B));
        int[] input3A = {101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        int input3B = 202;
        System.out.println(new AQ3RotatedSortedArraySearch().search(input3A, input3B));
    }

    public int search(final int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        int pivot = getMinima(A);
//        System.out.println("pivot : " + pivot);
        int index = binarySearch(l, pivot - 1, A, B);
        if (index == Integer.MIN_VALUE)
            index = binarySearch(pivot, r, A, B);
        if (index == Integer.MIN_VALUE)
            return -1;
        return index;
    }

    int binarySearch(int l, int r, int[] A, int B) {
        if (l < 0 || r < 0 || l >= A.length || r >= A.length)
            return Integer.MIN_VALUE;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (B == A[mid]) {
                return mid;
            } else if (B > A[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    public int getMinima(int[] A) {
        int l = 0;
        int r = A.length - 1;
        if (A.length <= 1 || A[l] < A[r])
            return 0;

        //4, 5, 6, 7, 0, 1, 2, 3
        //4, 5, 6, 7, 0, 1, 2, 3
        while (l <= r) {
            int mid = (l + r) / 2;
//            int mid = l + ((r - l) / 2);
//            System.out.println(mid);
//            System.out.println(A[mid] > A[mid + 1]);
            if (A[mid] > A[mid + 1]) {
//                System.out.println("returning");
                return mid + 1;
            } else if (A[mid] >= A[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }
}


//            if (A[mid] == B)
//                return mid;
//            if (A[prev] <= A[mid] && A[mid] <= A[next]) {
//                if (B < A[mid]) {
//                    r = mid - 1;
//                } else {
//                    l = mid + 1;
//                }
//            } else {
//                if (A[mid - 1] > A[mid]) {
//                    r1 = mid - 1;
//                    l2 = mid;
//                } else if (A[mid] > A[mid + 1]) {
//                    r1 = mid;
//                    l2 = mid + 1;
//                }
//                break;
//            }