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
//        System.out.println(Arrays.deepToString(new AQ7SpiralOrderMatrixII().generateMatrix(1)));
//        System.out.println(Arrays.deepToString(new AQ7SpiralOrderMatrixII().generateMatrix(2)));
        System.out.println(Arrays.deepToString(new AQ7SpiralOrderMatrixII().generateMatrix(4)));
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
            System.out.printf("%s %s [%s][%s] iupper=%s,ilower=%s,jupper=%s,jlower=%s count=%s %n", isInc ? "increment" : "decrement", isJ ? "j" : "i", i, j, iUpperbound, iLowerbound, jUpperbound, jLowerbound, count);
            if (isJ) {
                if (isInc) j++;
                else j--;
            } else {
                if (isInc) i++;
                else i--;
            }
//            boolean isContinue = false;
            boolean isI = !isJ;
            boolean isDec = !isInc;
            if (iLowerbound > 4)
                break;
            if ((isJ && ((isInc && j >= jUpperbound) || (isDec && j <= jLowerbound)) || (isI && ((isInc && i >= iUpperbound || (isDec && i <= iLowerbound)))))) {
                switch (isJ + " - " + isInc) {
                    case "true - true":
                        System.out.printf("true - true => jUpperbound:%s jLowerbound:%s iUpperbound:%s iLowerbound:%s%n", jUpperbound, jLowerbound, iUpperbound, iLowerbound);
                        jUpperbound--;
                        System.out.println("jUpperbound-- = " + jUpperbound);
                        j = jUpperbound;
                        isJ = false;
                        continue;
                    case "false - true":
                        System.out.printf("false - true => jUpperbound:%s jLowerbound:%s iUpperbound:%s iLowerbound:%s%n", jUpperbound, jLowerbound, iUpperbound, iLowerbound);
                        iUpperbound--;
                        iLowerbound++;
                        System.out.println("iUpperbound-- = " + iUpperbound);
                        i = iUpperbound;
                        isJ = true;
                        isInc = false;
                        continue;
                    case "true - false":
                        System.out.printf("true - false => jUpperbound:%s jLowerbound:%s iUpperbound:%s iLowerbound:%s%n", jUpperbound, jLowerbound, iUpperbound, iLowerbound);
                        //ilowerbound should be incremented
                        jLowerbound++;
                        System.out.println("jLowerbound++ = " + jLowerbound);
                        j = jLowerbound;
                        isJ = false;
                        isInc = false;
                        continue;
                    case "false - false":
                        System.out.printf("false - false => jUpperbound:%s jLowerbound:%s iUpperbound:%s iLowerbound:%s%n", jUpperbound, jLowerbound, iUpperbound, iLowerbound);
                        iLowerbound++;
                        System.out.println("iLowerbound++ = " + iLowerbound);
                        i = iLowerbound;
                        isJ = true;
                        isInc = false;
                        continue;
                    default:
                        System.out.println("wrong place");
                        break;
                }
            }

            ans[i][j] = count;
            count++;
        }
        return ans;
    }
}

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
