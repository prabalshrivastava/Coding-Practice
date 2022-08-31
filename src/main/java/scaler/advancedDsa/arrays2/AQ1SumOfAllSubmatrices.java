package scaler.advancedDsa.arrays2;

import java.util.Arrays;

public class AQ1SumOfAllSubmatrices {
    //    Problem Description
    //    Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
    //    Problem Constraints
    //    1 <= N <=30
    //            0 <= A[i][j] <= 10
    //    Input Format
    //    Single argument representing a 2-D array A of size N x N.
    //    Output Format
    //    Return an integer denoting the sum of all possible submatrices in the given matrix.
    //    Example Input
    //    A = [ [1, 1]
    //            [1, 1] ]
    //    Example Output 16
    //    Example Explanation
    //    Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
    //    Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
    //    Number of submatrices with 3 elements = 0
    //    Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
    //    Total Sum = 4+8+4 = 16
    public int solve(int[][] A) {
        int sum = 0;
        int n = A.length;
        int m = A[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                sum = sum + (i + 1) * (j + 1) * (n - i) * (m - j) * A[i][j];
            }
        }
        return sum;
    }

    public int solveOn2m2(int[][] A) {
        int[][] pf = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            pf[i] = new int[A.length];
            for (int j = 0; j < A.length; j++) {
                sum = sum + A[i][j];
                pf[i][j] = sum;
            }
        }
        for (int j = 0; j < A.length; j++) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum = sum + pf[i][j];
                pf[i][j] = sum;
            }
        }
//        System.out.println(Arrays.deepToString(pf));
        int sum = 0;
        for (int a1 = 0; a1 < A.length; a1++) {
            for (int b1 = 0; b1 < A.length; b1++) {
                for (int a2 = a1; a2 < A.length; a2++) {
                    for (int b2 = b1; b2 < A.length; b2++) {
                        int currentSum = pf[a2][b2];
                        if (a1 > 0) currentSum = pf[a1 - 1][b2];
                        if (b1 > 0) currentSum = currentSum - pf[a2][b1 - 1];
                        if (a1 > 0 && b1 > 0) currentSum = currentSum + pf[a1 - 1][b1 - 1];

                        sum = sum + currentSum;
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1}, {1, 1}};
        System.out.println(new AQ1SumOfAllSubmatrices().solve(A));

        int[][] B = {{8, 9, 9, 1, 7}, {5, 5, 10, 1, 0}, {7, 7, 5, 8, 6}, {7, 3, 7, 9, 2}, {7, 7, 8, 10, 6}};
        System.out.println(new AQ1SumOfAllSubmatrices().solve(B));
    }
}
