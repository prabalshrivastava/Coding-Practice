package scaler.module1.arrays.arrays2dmatrices;

public class HWQ3MinorDiagonalSum {
  //  Problem Description
  //  You are given a N X N integer matrix. You have to find the sum of all the minor diagonal
  // elements of A.
  //  Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1
  // (where i, j are 1-based).
  //  Problem Constraints
  // 1 <= N <= 103
  //      -1000 <= A[i][j] <= 1000
  //  Input Format
  //  First and only argument is a 2D integer matrix A.
  //      Output Format
  //  Return an integer denoting the sum of minor diagonal elements.
  //  Example Input
  //  Input 1:
  //  A = [[1, -2, -3],
  //      [-4, 5, -6],
  //      [-7, -8, 9]]
  //  Input 2:
  //  A = [[3, 2],
  //      [2, 3]]
  //  Example Output
  //  Output 1:
  //      -5
  //  Output 2:
  //      4
  //  Example Explanation
  //  Explanation 1:
  //  A[1][3] + A[2][2] + A[3][1] = (-3) + 5 + (-7) = -5
  //  Explanation 2:
  //  A[1][2] + A[2][1] = 2 + 2 = 4
  public static void main(String[] args) {
    int[][] input1A = {{1, -2, -3}, {-4, 5, -6}, {-7, -8, 9}};
    System.out.println(new HWQ3MinorDiagonalSum().solve(input1A));
    int[][] input2A = {{3, 2}, {2, 3}};
    System.out.println(new HWQ3MinorDiagonalSum().solve(input2A));
  }

  public int solve(final int[][] A) {
    int row = 0;
    int col = A.length - 1;

    int sum = 0;
    while (row < A.length && col >= 0) {
      sum = sum + A[row][col];
      row++;
      col--;
    }
    return sum;
  }
}
