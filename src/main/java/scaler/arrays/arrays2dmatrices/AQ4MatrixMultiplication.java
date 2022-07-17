package scaler.arrays.arrays2dmatrices;

import java.util.Arrays;

public class AQ4MatrixMultiplication {
    //  Problem Description
    //  You are given two integer matrices A(having M X N size) and B(having N X P). You have to
    // multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).
    //  image
    //  Problem Constraints
    // 1 <= M, N, P <= 100
    //      -100 <= A[i][j], B[i][j] <= 100
    //  Input Format
    //  First argument is a 2D integer matrix A.
    //  Second argument is a 2D integer matrix B.
    //      Output Format
    //  Return a 2D integer matrix denoting AB.
    //  Example Input
    //  Input 1:
    //  A = [[1, 2],            B = [[5, 6],
    //      [3, 4]]                 [7, 8]]
    //  Input 2:
    //  A = [[1, 1]]            B = [[2],
    //      [3]]
    //  Example Output
    //  Output 1:
    //      [[19, 22],
    //      [43, 50]]
    //  Output 2:
    //      [[5]]
    //  Example Explanation
    //  Explanation 1:
    //  image
    //  Explanation 2:
    //      [[1, 1]].[[2, 3]] = [[1 * 2 + 1 * 3]] = [[5]]
    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        System.out.println(Arrays.deepToString(new AQ4MatrixMultiplication().solve(A, B)));
        A = new int[][]{{1, 1}};
        B = new int[][]{{2}, {3}};
        System.out.println(Arrays.deepToString(new AQ4MatrixMultiplication().solve(A, B)));
        A = new int[][]{
                {62, -37, -49, 18, -53, 14, 51},
                {62, -52, -11, -21, -62, -44, -95},
                {20, 78, -29, -49, -17, 21, 83},
                {-99, -69, -39, -47, 19, -50, -90},
                {91, -96, 63, -23, 5, 94, 49},
                {17, 1, 16, 63, -78, -13, -100},
                {-7, 72, 16, 86, -53, 94, 85},
                {-82, 78, 96, -45, -42, 38, 34},
                {-88, 37, 12, 31, -91, 51, 23}
        };
        B = new int[][]{
                {90, 68, 2, 54, -59},
                {78, -86, 8, -30, 24},
                {-92, 84, -62, 13, 2},
                {12, -73, -53, -91, -4},
                {74, 85, -51, -4, 37},
                {-30, -27, 10, -78, 29},
                {-96, 39, -42, 93, 78}
        };
        System.out.println(Arrays.deepToString(new AQ4MatrixMultiplication().solve(A, B)));
    }

    public int[][] solve(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            //0th row of A with 0th column of B
            //1st row of A with 1st column of B
            for (int j = 0; j < B[0].length; j++) {
                //00 01
                //10 11
                int sum = 0;
                for (int k = 0; k < B.length; k++) {
                    sum = sum + A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
            //varying col in A is varying row in B
        }
        return result;
    }
}
