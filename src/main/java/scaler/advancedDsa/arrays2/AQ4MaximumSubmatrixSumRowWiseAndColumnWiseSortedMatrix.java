package scaler.advancedDsa.arrays2;

import java.util.Arrays;

public class AQ4MaximumSubmatrixSumRowWiseAndColumnWiseSortedMatrix {

  //    Problem Description
//    Given a row-wise and column-wise sorted matrix A of size N * M.
//    Return the maximum non-empty submatrix sum of this matrix.
//            Problem Constraints
//1 <= N, M <= 1000
//            -109 <= A[i][j] <= 109
//    Input Format
//    The first argument is a 2D integer array A.
//            Output Format
//    Return a single integer that is the maximum non-empty submatrix sum of this matrix.
//            Example Input
//    Input 1:-
//            -5 -4 -3
//    A = -1  2  3
//            2  2  4
//    Input 2:-
//            1 2 3
//    A = 4 5 6
//            7 8 9
//    Example Output
//    Output 1:-
//            12
//    Output 2:-
//            45
//    Example Explanation
//    Expanation 1:-
//    The submatrix with max sum is
//-1 2 3
//        2 2 4
//    Sum is 12.
//    Explanation 2:-
//    The largest submatrix with max sum is
//1 2 3
//        4 5 6
//        7 8 9
//    The sum is 45.
  public static void main(String[] args) {
    int[][] input1 = {{-5, -4, 3}, {-1, 2, 3}, {2, 2, 4}};
    System.out.println(new AQ4MaximumSubmatrixSumRowWiseAndColumnWiseSortedMatrix().solve(input1));
    int[][] input2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(new AQ4MaximumSubmatrixSumRowWiseAndColumnWiseSortedMatrix().solve(input2));
  }

  public long solve(int[][] A) {
    for (int i = 0; i < A.length; i++) {
      int prefix = 0;
      for (int j = 0; j < A[i].length; j++) {
        A[i][j] = A[i][j] + prefix;
        prefix = A[i][j];
      }
    }
    System.out.println(Arrays.deepToString(A));
    for (int j = 0; j < A[0].length; j++) {
      int prefix = 0;
      for (int i = 0; i < A.length; i++) {
        A[i][j] = A[i][j] + prefix;
        prefix = A[i][j];
      }
    }
    System.out.println(Arrays.deepToString(A));

    for (int si = 0; si < A.length; si++) {
      for (int sj = 0; sj < A[si].length; sj++) {
//        System.out.printf("[%s][%s] -> ", si, sj);
        long maxSum = 0;
        for (int ei = si; ei < A.length; ei++) {
          for (int ej = sj; ej < A[ei].length; ej++) {
//            System.out.printf("\t[%s][%s]", ei, ej);

          }
        }
//        System.out.println();
      }
    }
    return 0;
  }
}
