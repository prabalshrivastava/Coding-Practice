package scaler.advancedDsa.binarysearch2;

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
    }

    public int solve(final int[] A, int B) {
        int countSmaller = 0;
        int countEqual = 1;
        for (int i = 1; i <= B; i++) {
//            countSmaller = countSmaller(i, A);
            int min = A[0];
            for (int j = 0; j < A.length; j++) {
                if (A[j] < min)
                    min = A[j];
                else if (A[j] == min) countEqual++;
            }
            if (countSmaller >= B) {
            } else if (countSmaller < B && countSmaller + countEqual < B) {
            } else if (countSmaller < B && countSmaller + countEqual >= B) {
                return i;
            }
        }
        return countSmaller;
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
