package scaler.arrays.bitmanipulation2;

import java.util.Arrays;

public class HWQ1SingleNumberIII {
    //    Problem Description
//    Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
//    Find the two integers that appear only once.
//
//
//
//    Problem Constraints
//2 <= |A| <= 100000
//            1 <= A[i] <= 109
//
//
//
//    Input Format
//    The first argument is an array of integers of size N.
//
//
//
//            Output Format
//    Return an array of two integers that appear only once.
//
//
//
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 1, 2, 4]
//    Input 2:
//
//    A = [1, 2]
//
//
//    Example Output
//    Output 1:
//            [3, 4]
//    Output 2:
//
//            [1, 2]
//
//
//    Example Explanation
//    Explanation 1:
//            3 and 4 appear only once.
//            Explanation 2:
//
//            1 and 2 appear only once.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 1, 2, 4};
        System.out.println(Arrays.toString(new HWQ1SingleNumberIII().solve(input1A)));
        int[] input2A = {1, 2};
        System.out.println(Arrays.toString(new HWQ1SingleNumberIII().solve(input2A)));
        int[] input3A = {2308, 1447, 1918, 1391, 2308, 216, 1391, 410, 1021, 537, 1825, 1021, 1729, 669, 216, 1825, 537, 1995, 805, 410, 805, 602, 1918, 1447, 90, 1995, 90, 1540, 1161, 1540, 2160, 1235, 1161, 602, 880, 2160, 1235, 669};
        System.out.println(Arrays.toString(new HWQ1SingleNumberIII().solve(input3A)));

    }

    public int[] solve(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans ^= A[i];
        }
        int i = 0;
        while (((ans >> i) & 1) != 1) {
            i++;
        }
//        System.out.println("Ans : " + ans + " - set bit : " + i);
        int set = 0;
        int unset = 0;
        for (int j = 0; j < A.length; j++) {
            if (((A[j] >> i) & 1) == 1) {
//                System.out.println("set :" + A[j]);
                //set
                set ^= A[j];
            } else {
//                System.out.println("unset :" + A[j]);
                //unset
                unset ^= A[j];
            }
        }
//        System.out.printf("%s - %s %n", set, unset);
        if (unset < set) {
            return new int[]{unset, set};
        } else {
            return new int[]{set, unset};
        }
    }
}
