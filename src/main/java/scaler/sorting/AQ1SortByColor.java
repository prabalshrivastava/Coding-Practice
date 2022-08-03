package scaler.sorting;

import java.util.Arrays;

public class AQ1SortByColor {
//    Problem Description
//    Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//    We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.
//    Note: Using the library sort function is not allowed.
//    Problem Constraints
//1 <= N <= 1000000
//            0 <= A[i] <= 2
//    Input Format
//    First and only argument of input contains an integer array A.
//            Output Format
//    Return an integer array in asked order
//    Example Input
//    Input 1 :
//    A = [0 1 2 0 1 2]
//    Input 2:
//    A = [0]
//    Example Output
//    Output 1:
//            [0 0 1 1 2 2]
//    Output 2:
//            [0]
//    Example Explanation
//    Explanation 1:
//            [0 0 1 1 2 2] is the required order.

    public int[] sortColorsOn(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    A[i] = A[i] + A[j];
                    A[j] = A[i] - A[j];
                    A[i] = A[i] - A[j];
                }
            }
        }
        return A;
    }

    public int[] sortColors(int[] A) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                zero++;
            if (A[i] == 1)
                one++;
            if (A[i] == 2)
                two++;
        }
        int i = 0;
        while (i < zero) {
            A[i] = 0;
            i++;
        }
        while (i < zero + one) {
            A[i] = 1;
            i++;
        }
        while (i < zero + one + two) {
            A[i] = 2;
            i++;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] input1A = {0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(new AQ1SortByColor().sortColors(input1A)));
        int[] input2A = {0};
        System.out.println(Arrays.toString(new AQ1SortByColor().sortColors(input2A)));
    }

}
