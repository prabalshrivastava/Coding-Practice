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

        for (int i = 0; i < A.length; i++) {

        }
        System.out.println(Arrays.deepToString(pf));
        return 0;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1}, {1, 1}};
        System.out.println(new AQ1SumOfAllSubmatrices().solve(A));
    }
}
