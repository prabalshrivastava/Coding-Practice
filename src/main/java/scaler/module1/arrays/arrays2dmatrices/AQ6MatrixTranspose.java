package scaler.module1.arrays.arrays2dmatrices;

import java.util.Arrays;

public class AQ6MatrixTranspose {
  //  Problem Description
  //  You are given a matrix A, you have to return another matrix which is the transpose of A.
  //  NOTE: Transpose of a matrix A is defined as - AT[i][j] = A[j][i] ; Where 1 ≤ i ≤ col and 1 ≤ j
  // ≤ row
  //  Problem Constraints
  // 1 <= A.size() <= 1000
  //    1 <= A[i].size() <= 1000
  //      1 <= A[i][j] <= 1000
  //  Input Format
  //  First argument is vector of vector of integers A representing matrix.
  //      Output Format
  //  You have to return a vector of vector of integers after doing required operations.
  //  Example Input
  //  Input 1:
  //  A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
  //  Input 2:
  //  A = [[1, 2],[1, 2],[1, 2]]
  //  Example Output
  //  Output 1:
  //      [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
  //  Output 2:
  //      [[1, 1, 1], [2, 2, 2]]
  //  Example Explanation
  //  Explanation 1:
  //  Cearly after converting rows to column and columns to rows of [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
  // we will get [[1, 4, 7], [2, 5, 8], [3, 6, 9]].
  public static void main(String[] args) {
    int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(Arrays.deepToString(new AQ6MatrixTranspose().solve(A)));
    int[][] B = {{1, 2}, {1, 2}, {1, 2}};
    System.out.println(Arrays.deepToString(new AQ6MatrixTranspose().solve(B)));
  }

  public int[][] solve(int[][] A) {
    int n = A.length;
    int m = A[0].length;
    int[][] result = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = A[j][i];
      }
    }
    return result;
  }
}
