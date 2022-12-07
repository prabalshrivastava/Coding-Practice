package scaler.advancedDsa.binarysearch2;

import java.util.Arrays;

public class HWQ1KthPrice {
    //    Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight. kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n. In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).
//    NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.
//            Example:
//    A : [2 1 4 3 2]
//    k : 3
//    Answer : 2
//    Constraints :
//            1 <= number of elements in the price list <= 1000000
//            1 <= k <= number of elements in the price list
    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3, 2};
        int k = 3;
        System.out.println(new HWQ1KthPrice().solve(A, k));

        int[] A1 = {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
        int B1 = 9;
        System.out.println(new HWQ1KthPrice().solve(A1, B1));
//        Arrays.sort(A1);
//        System.out.println(Arrays.toString(A1));
    }

    public int solve(final int[] A, int B) {
        int ans = 0;
        int min = A[0];
        int max = A[0];
        for (int j = 0; j < A.length; j++) {
            if (A[j] < min) {
                min = A[j];
            }
            if (A[j] > max) {
                max = A[j];
            }
        }
        System.out.println("min :" + min);
        System.out.println("max :" + max);
        int l = min;
        int r = max;
        while (l <= r) {
            int mid = (l + r) / 2;
            System.out.printf("l:%s | r:%s | mid:%s", l, r, mid);
            if (calcCount(mid, A) >= B) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int calcCount(int mid, int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= mid)
                count++;
        }
        System.out.println(" -  count : " + count);
        return count;
    }

    private int countSmaller(int k, int[] a) {
        for (int i = 0; i < a.length; i++) {

        }
        return 0;
    }
//    public int solve(final int[] A, int B) {
//        int lastSmallest = A[0];
//        int elementCount = 0;
//        int equalCount = 0;
//
//        for (int i = 0; i < B; i++) {
//            int currSmallest = Integer.MAX_VALUE;
//            for (int j = 0; j < A.length; j++) {
//                if (A[j] < currSmallest && A[j] >= lastSmallest) {
//                    currSmallest = A[j];
//                    if (A[j] == lastSmallest)
//                        equalCount++;
//                    elementCount++;
//                }
////                if (elementCount == B)
////                    return
////                if (A[j] == lastSmallest) {
////                    equalCount++;
////                    elementCount++;
////                } else if (A[j] < lastSmallest) {
////                    elementCount++;
////                }
//            }
//            lastSmallest = currSmallest;
//        }
//    }
}
