package scaler.advancedDsa.sorting2;

public class AQ2LargestNumber {
    //    Problem Description
//    Given an array A of non-negative integers, arrange them such that they form the largest number.
//    Note: The result may be very large, so you need to return a string instead of an longeger.
//    Problem Constralongs
//1 <= len(A) <= 100000
//            0 <= A[i] <= 2*109
//    Input Format
//    The first argument is an array of integers.
//    Output Format
//    Return a string representing the largest number.
//            Example Input
//    Input 1:
//    A = [3, 30, 34, 5, 9]
//    Input 2:
//    A = [2, 3, 9, 0]
//    Example Output
//    Output 1:
//            "9534330"
//    Output 2:
//            "9320"
//    Example Explanation
//    Explanation 1:
//    Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
//            Explanation 2:
//    Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
    public static void main(String[] args) {
        int[] input1A = {3, 30, 34, 5, 9};
        System.out.println(new AQ2LargestNumber().largestNumber(input1A));
        int[] input2A = {2, 3, 9, 0};
        System.out.println(new AQ2LargestNumber().largestNumber(input2A));
        int[] input3A = {0, 0, 0, 0, 0};
        System.out.println(new AQ2LargestNumber().largestNumber(input3A));
    }

    public String largestNumber(final int[] A) {
        mergeSort(A, 0, A.length - 1);
//        System.out.println(Arrays.toString(A));
        String s = "";
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if ("".equals(s)) {
                    s = s + A[i];
                } else if ("0".equals(s)) {
                }
            } else
                s = s + A[i];
        }
        return s;
    }

    private void mergeSort(int[] a, int l, int r) {
        if (l == r)
            return;
        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, r, mid + 1);
    }

    private void merge(int[] a, int l, int r, int y) {
        int p1 = l;
        int p2 = y;
        int[] ans = new int[r - l + 1];
        int index = 0;
        while (p1 <= y - 1 && p2 <= r) {

            String first = "" + a[p1];
            String second = "" + a[p2];

            String firstSec = first + second;
            String secFirst = second + first;

            long firstSecInt = Long.parseLong(firstSec);
            long secFirstInt = Long.parseLong(secFirst);

            if (firstSecInt >= secFirstInt) {
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
