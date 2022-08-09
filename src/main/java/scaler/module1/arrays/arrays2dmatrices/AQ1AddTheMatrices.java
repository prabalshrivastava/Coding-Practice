package scaler.module1.arrays.arrays2dmatrices;

import java.util.Arrays;

public class AQ1AddTheMatrices {
  //  Problem Description
  //  You are given two matrices A & B of same size, you have to return another matrix which is the
  // sum of A and B.
  //  Problem Constraints
  // 1 <= A.size(), B.size() <= 1000
  //    1 <= A[i].size(), B[i].size() <= 1000
  //      1 <= A[i][j], B[i][j] <= 1000
  //  Input Format
  //  First argument is vector of vector of integers representing matrix A.
  //  Second argument is vecotor of vector of integers representing matrix B.
  //      Output Format
  //  You have to return a vector of vector of integers after doing required operations.
  //  Example Input
  //  Input 1:
  //  A = [[1, 2, 3],[4, 5, 6],[7, 8, 9]]
  //  B = [[9, 8, 7],[6, 5, 4],[3, 2, 1]]
  //  Example Output
  //  Output 1:
  //      [[10, 10, 10], [10, 10, 10], [10, 10, 10]]
  //  Example Explanation
  //  Explanation 1:
  //  A + B = [[1+9, 2+8, 3+7],[4+6, 5+5, 6+4],[7+3, 8+2, 9+1]] = [[10, 10, 10], [10, 10, 10], [10,
  // 10, 10]].
  public int[][] solve(int[][] A, int[][] B) {
    int[][] result = new int[A.length][A[0].length];
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        result[i][j] = A[i][j] + B[i][j];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] B = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
    System.out.println(Arrays.deepToString(new AQ1AddTheMatrices().solve(A, B)));

    A = new int[][]{{6, 2, 3, 10, 1, 3}};
    B = new int[][]{{6, 7, 3, 8, 1, 2}};
    System.out.println(Arrays.deepToString(new AQ1AddTheMatrices().solve(A, B)));
  }
}
