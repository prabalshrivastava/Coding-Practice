package scaler.advancedDsa.sorting2;

import java.util.Arrays;

public class HWQ2ReversePairs {
    //    Problem Description
//    Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
//    Return the number of important reverse pairs in the given array A.
//    Problem Constraints
//1 <= length of the array <= 105
//            -2 * 109 <= A[i] <= 2 * 109
//    Input Format
//    The only argument given is the integer array A.
//            Output Format
//    Return the number of important reverse pairs in the given array A.
//    Example Input
//    Input 1:
//    A = [1, 3, 2, 3, 1]
//    Input 2:
//    A = [4, 1, 2]
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    There are two pairs which are important reverse i.e (3, 1) and (3, 1).
//    Explanation 2:
//    There is only one pair i.e (4, 1).
    public static void main(String[] args) {
        int[] input1A = {1, 3, 2, 3, 1};
        System.out.println(new HWQ2ReversePairs().solve(input1A));
        int[] input2A = {4, 1, 2};
        System.out.println(new HWQ2ReversePairs().solve(input2A));
//        A : [ 769, -71, 599, -1438, -530, -512, 1680, 1907, -301, 492, -844, 1765, -188, 685, -1879, -699, -990, 1022, 459, 528, -930, 1051, 1412, -1598, 245, -480, 1979, 1212, 1177, 447, -509, 881, 1968, -1603, -429, 1165, 405, 426, -1610, 931, -835, -1156, 1273, -143, -940, 199, -1886, -1646, 390, -1349, -256, -256, -103, -135, 637, -605, 55, -1805, -17, -229, 1162, 288, -818, -922, 32, -1032, -1823, -1874, -1650, 146, 721, 1586, 1969, 1720, -993, -1137, -1233, -1629, -879, -277, 444, -1191, -1273, 127, 1785, 1407, -1460, 414, -1578, -1348, 72, -794, 632, 877, 338, 1921, -650, -1314, 1187, -40 ]
//
//        Test As Custom Input
//        The expected return value:
//        2761
    }

    public int solve(int[] A) {
        int i = mergeSort(A, 0, A.length - 1);
//        System.out.println(Arrays.toString(A));
        return i;
    }

    private int mergeSort(int[] a, int l, int r) {
        if (l == r)
            return 0;
        int mid = (l + r) / 2;
        int x = mergeSort(a, l, mid);
        int y = mergeSort(a, mid + 1, r);
        int z = merge(a, l, r, mid + 1);
        //        System.out.print("[");
//        for (int i = l; i <= r; i++) {
//            System.out.print(a[i] + ",");
//        }
//        System.out.println("] - x:" + x + " - y:" + y + " - z:" + z);
        return x + y + z;
    }

    private int merge(int[] a, int l, int r, int y) {
//        System.out.printf("a:%s  l:%s  r:%s  y:%s%n", Arrays.toString(a), l, r, y);
        int p1 = l;
        int p2 = y;
        int index = 0;
        int[] ans = new int[r - l + 1];
        int count = 0;
        while (p1 <= y - 1 && p2 <= r) {
            if (a[p1] <= a[p2]) {
                ans[index++] = a[p1++];
            } else {
                int i = p1;
                while (i <= y - 1) {
                    if (a[i++] > 2 * a[p2]) {
                        count++;
//                        System.out.println("increased count =" + count);
                    }
                }
                ans[index++] = a[p2++];
            }
        }

        while (p1 <= y - 1) {
            ans[index++] = a[p1++];
        }
        while (p2 <= r) {
            ans[index++] = a[p2++];
        }
        int k = l;
        for (int i = 0; i < ans.length; i++) {
            a[k++] = ans[i];
        }
        return count;
    }
}
