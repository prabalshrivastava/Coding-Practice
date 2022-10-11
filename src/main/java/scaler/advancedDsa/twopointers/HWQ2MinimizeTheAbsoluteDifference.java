package scaler.advancedDsa.twopointers;

import scaler.advancedDsa.sorting3.HWQ2MaximumAndMinimumMagic;

public class HWQ2MinimizeTheAbsoluteDifference {
    //    Given three sorted arrays A, B and Cof not necessarily same sizes.
//    Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.
//    Example :
//    Input:
//    A : [ 1, 4, 5, 8, 10 ]
//    B : [ 6, 9, 15 ]
//    C : [ 2, 3, 6, 6 ]
//    Output:
//            1
//    Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
    public int solve(int[] A, int[] B, int[] C) {

        return 0;
    }

    public static void main(String[] args) {
        int[] inputA = {1, 4, 5, 8, 10};
        int[] inputB = {6, 9, 15};
        int[] inputC = {2, 3, 6, 6};
        System.out.println(new HWQ2MinimizeTheAbsoluteDifference().solve(inputA, inputB, inputC));
    }
}
