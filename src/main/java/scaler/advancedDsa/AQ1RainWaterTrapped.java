package scaler.advancedDsa;

import java.util.Arrays;

public class AQ1RainWaterTrapped {
    //    Problem Description
//    Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//            Problem Constraints
//1 <= |A| <= 100000
//    Input Format
//    First and only argument is the vector A
//    Output Format
//    Return one integer, the answer to the question
//    Example Input
//    Input 1:
//    A = [0, 1, 0, 2]
//    Input 2:
//    A = [1, 2]
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//            1 unit is trapped on top of the 3rd element.
//    Explanation 2:
//    No water is trapped.
    public static void main(String[] args) {
        int[] input1A = {0, 1, 0, 2};
        System.out.println(new AQ1RainWaterTrapped().trap(input1A));
        int[] input2A = {1, 2};
        System.out.println(new AQ1RainWaterTrapped().trap(input2A));
        int[] input3A = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new AQ1RainWaterTrapped().trap(input3A));//6
    }

    public int trap(final int[] A) {
        int[] lm = new int[A.length];
        int[] rm = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                lm[i] = A[i];
            } else
                lm[i] = Math.max(A[i], lm[i - 1]);
        }
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                rm[i] = A[i];
            } else
                rm[i] = Math.max(A[i], rm[i + 1]);
        }
        int sumOfWaterTrapped = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || i == A.length - 1) {

            } else {
                sumOfWaterTrapped += (Math.min(lm[i], rm[i]) - A[i]);
            }
        }
//        System.out.println(Arrays.toString(lm));
//        System.out.println(Arrays.toString(rm));
        return sumOfWaterTrapped;
    }
}
