package scaler.arrays.arrays2dmatrices;

import java.util.Arrays;

public class AQ7SpiralOrderMatrixII {
    //    Problem Description
//    Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
//
//
//
//            Problem Constraints
//1 <= A <= 1000
//
//
//
//    Input Format
//    First and only argument is integer A
//
//
//    Output Format
//    Return a 2-D matrix which consists of the elements in spiral order.
//
//
//
//    Example Input
//    Input 1:
//
//            1
//    Input 2:
//
//            2
//
//
//    Example Output
//    Output 1:
//
//            [ [1] ]
//    Output 2:
//
//            [ [1, 2], [4, 3] ]
//
//
//    Example Explanation
//    Explanation 1:
//
//
//    Only 1 is to be arranged.
//    Explanation 2:
//
//            1 --> 2
//            |
//            |
//            4<--- 3
    public static void main(String[] args) {
        int input1 = 1;
        System.out.println(Arrays.deepToString(new AQ7SpiralOrderMatrixII().generateMatrix(input1)));
        int input2 = 2;
        System.out.println(Arrays.deepToString(new AQ7SpiralOrderMatrixII().generateMatrix(input2)));
    }

    public int[][] generateMatrix(int A) {
        int[][] ans = new int[A][A];
        int count = 1;
        int i = 0;
        int j = 0;
        int iLowerbound = -1;
        int jLowerbound = -1;
        int iUpperbound = A;
        int jUpperbound = A;

        boolean isJ = true;
        boolean isInc = true;
        while (count < A * A) {
//            if (isJ) {
//                if (isInc) {
//                    if (j < jUpperbound) {
//                        j++;
//                    } else {
//                        isJ = false;
//                        isInc = false;
//                        jUpperbound--;
//                    }
//                } else {
//                    if (j >= jLowerbound) {
//                        j--;
//                    } else {
//                        isJ = false;
//                        isInc = true;
//                        jLowerbound++;
//                    }
//                }
//            }
//            if (!isJ) {
//                if (isInc) {
//                    if (i < iUpperbound) {
//                        i++;
//                    } else {
//                        isJ = true;
//                        isInc = false;
//                        iUpperbound--;
//                    }
//                } else {
//                    if (i >= iLowerbound) {
//                        i--;
//                    } else {
//                        isJ = true;
//                        isInc = true;
//                        iLowerbound++;
//                    }
//                }
//            }
            if (isJ) {
                if (isInc) j++;
                else j--;
            } else {
                if (isInc) i++;
                else i--;
            }

            switch (isJ + " - " + isInc) {
                case "true - true":
                    isJ = false;
                    break;
                case "false - true":
                    isJ = true;
                    isInc = false;
                    break;
                case "true - false":
                    isJ = false;
                    isInc = false;
                    break;
                case "false - false":
                    isJ = true;
                    isInc = false;
                    break;
                default:
                    System.out.println("wrong place");
                    break;
            }


            ans[i][j] = count;
            count++;
        }
        return ans;
    }
}
