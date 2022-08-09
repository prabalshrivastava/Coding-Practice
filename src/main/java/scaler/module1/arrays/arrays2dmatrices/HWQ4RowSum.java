package scaler.module1.arrays.arrays2dmatrices;

import java.util.Arrays;

public class HWQ4RowSum {

  //  Problem Description
  //  You are given a 2D integer matrix A, return a 1D integer vector containing row-wise sums of
  // original matrix.
  //      Problem Constraints
  // 1 <= A.size() <= 103
  //    1 <= A[i].size() <= 103
  //      1 <= A[i][j] <= 103
  //  Input Format
  //  First argument is a vector of vector of integers.(2D matrix).
  //  Output Format
  //  Return a vector conatining row-wise sums of original matrix.
  //      Example Input
  //  Input 1:
  //      [1,2,3,4]
  //      [5,6,7,8]
  //      [9,2,3,4]
  //  Example Output
  //  Output 1:
  //  {10,26,18}
  //  Example Explanation
  //  Explanation 1
  //  Row 1 = 1+2+3+4 = 10
  //  Row 2 = 5+6+7+8 = 26
  //  Row 3 = 9+2+3+4 = 18
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new HWQ4RowSum().solve(new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 2, 3, 4},
    })));
  }

  public int[] solve(int[][] A) {
    int[] answer = new int[A.length];
    for (int i = 0; i < A.length; i++) {
      int sum = 0;
      for (int j = 0; j < A[i].length; j++) {
        sum = sum + A[i][j];
      }
      answer[i] = sum;
    }
    return answer;
  }
}
