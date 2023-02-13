package scaler.advancedDsa.dp2;

import java.util.Arrays;

public class HWQ2MinSumPathInMatrix {

  //  Problem Description
//  Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//  Return the minimum sum of the path.
//      NOTE: You can only move either down or right at any point in time.
//      Problem Constraints
//1 <= M, N <= 2000
//      -1000 <= A[i][j] <= 1000
//  Input Format
//  First and only argument is a 2-D grid A.
//      Output Format
//  Return an integer denoting the minimum sum of the path.
//  Example Input
//  Input 1:
//  A = [
//      [1, 3, 2]
//      [4, 3, 1]
//      [5, 6, 1]
//      ]
//  Input 2:
//  A = [
//      [1, -3, 2]
//      [2, 5, 10]
//      [5, -5, 1]
//      ]
//  Example Output
//  DocFinder.Output 1:
//      8
//  Output 2:
//      -1
//  Example Explanation
//  Explanation 1:
//  The path will be: 1 -> 3 -> 2 -> 1 -> 1.
//  Input 2:
//  The path will be: 1 -> -3 -> 5 -> -5 -> 1.
  public static void main(String[] args) {
    int[][] input1A = {
        {1, 3, 2},
        {4, 3, 1},
        {5, 6, 1}
    };
    System.out.println(new HWQ2MinSumPathInMatrix().minPathSum(input1A));
    int[][] input2A = {
        {1, -3, 2},
        {2, 5, 10},
        {5, -5, 1}
    };
    System.out.println(new HWQ2MinSumPathInMatrix().minPathSum(input2A));
  }

  public int minPathSum(int[][] A) {
    int[][] dp = new int[A.length][A[0].length];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    return minPathSumRecursive(A, dp, A.length - 1, A[0].length - 1);
  }

  private int minPathSumRecursive(int[][] A, int[][] dp, int i, int j) {
    if (dp[i][j] != Integer.MAX_VALUE) {
      return dp[i][j];
    }
    if (i == 0 && j == 0) {
      return A[i][j];
    }
    int minPath = 0;
    if (i - 1 >= 0 && j - 1 >= 0) {
      minPath =
          A[i][j] + Math.min(minPathSumRecursive(A, dp, i - 1, j),
              minPathSumRecursive(A, dp, i, j - 1));
    } else if (i - 1 >= 0) {
      minPath = A[i][j] + minPathSumRecursive(A, dp, i - 1, j);
    } else if (j - 1 >= 0) {
      minPath = A[i][j] + minPathSumRecursive(A, dp, i, j - 1);
    }
    dp[i][j] = minPath;
    return minPath;
  }
}