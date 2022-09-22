package scaler.advancedDsa.sorting2;


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
//        int[] input3A = {3, 4, 1, 9, 56, 7, 9, 12};
//        System.out.println(new AQ1InversionCountInAnArray().solve(input3A));

        int[] input3A = {10, 3, 8, 15, 6, 12, 2, 18, 7, 1};
        System.out.println(new AQ1InversionCountInAnArray().solve(input3A));
    }

    public int solve(int[] A) {
        int l = 0;
        int r = A.length - 1;
        long c = (long) (Math.pow(10, 9) + 7);
        return (int) getModdedNumber(mergeSort(A, l, r, c), c);
    }

    private long mergeSort(int[] a, int l, int r, long c) {
        if (l == r)
            return 0;
        int mid = (r + l) / 2;
        long x = mergeSort(a, l, mid, c);
        long y = mergeSort(a, mid + 1, r, c);
        long z = merge(a, l, r, mid + 1);
//        System.out.print("[");
//        for (int i = l; i <= r; i++) {
//            System.out.print(a[i] + ",");
//        }
//        System.out.println("] - x:" + x + " - y:" + y + " - z:" + z);
        return getModdedNumber(getModdedNumber(x, c) + getModdedNumber(y, c) + getModdedNumber(z, c), c);
    }

    private int merge(int[] a, int l, int r, int y) {
        int p1 = l;
        int p2 = y;
        int index = 0;
        int[] ans = new int[r - l + 1];
        int count = 0;
        while (p1 <= y - 1 && p2 <= r) {
            if (a[p1] <= a[p2]) {
                ans[index++] = a[p1++];
            } else {
                count = count + y - p1;
//                System.out.println("count:" + count + " - y:" + y + " - p1:" + p1);
                ans[index++] = a[p2++];
//                System.out.println("count:" + count);
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
        return count;
    }

    long getModdedNumber(long A, long C) {
        if (A < 0) {
//            System.out.println(A);
            return (A + C) % C;
        } else
            return A % C;
    }
}
