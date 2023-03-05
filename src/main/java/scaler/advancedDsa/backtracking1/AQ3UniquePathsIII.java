package scaler.advancedDsa.backtracking1;

import java.util.Arrays;
import java.util.HashSet;

public class AQ3UniquePathsIII {

  //  Problem Description
//  Given a matrix of integers A of size N x M . There are 4 types of squares in it:
//      1. 1 represents the starting square.  There is exactly one starting square.
//      2. 2 represents the ending square.  There is exactly one ending square.
//      3. 0 represents empty squares we can walk over.
//4. -1 represents obstacles that we cannot walk over.
//  Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
//  Note: Rows are numbered from top to bottom and columns are numbered from left to right.
//      Problem Constraints
//2 <= N * M <= 20
//      -1 <= A[i] <= 2
//  Input Format
//  The first argument given is the integer matrix A.
//      Output Format
//  Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
//  Example Input
//  Input 1:
//  A = [   [1, 0, 0, 0]
//      [0, 0, 0, 0]
//      [0, 0, 2, -1]   ]
//  Input 2:
//  A = [   [0, 1]
//      [2, 0]    ]
//  Example Output
//  DocFinder.Output 1:
//      2
//  Output 2:
//      0
//  Example Explanation
//  Explanation 1:
//  We have the following two paths:
//      1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//      2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
//  Explanation 1:
//  Answer is evident here.
  public static void main(String[] args) {
    int[][] A = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
    System.out.println(new AQ3UniquePathsIII().solve(A));
    int[][] B = {{0, 1}, {2, 0}};
    System.out.println(new AQ3UniquePathsIII().solve(B));
  }

  int ans = 0;

  public int solve(int[][] A) {
    HashSet<String> hashSet = new HashSet<>();
    int[][] dp = new int[A.length][];
    int startI = -1;
    int startJ = -1;
    int totalZeroes = 0, zeroCount = 0;
    for (int i = 0; i < A.length; i++) {
      dp[i] = new int[A[i].length];
      for (int j = 0; j < A[i].length; j++) {
        if (A[i][j] == 1) {
          startI = i;
          startJ = j;
        } else if (A[i][j] == 0) {
          totalZeroes++;
        }
        dp[i][j] = -1;
      }
    }
    ways(A, startI, startJ, totalZeroes, zeroCount);
//    System.out.println(Arrays.deepToString(A));
    return ans;
  }

  private int ways(int[][] A, int i, int j, int totalZeroes,
      int zeroCount) {
////    System.out.printf("A[%s][%s]\t", i, j);
    //base case's
    //boundary scenarios and blocked regions
    if (i >= A.length || j >= A[0].length || i < 0 || j < 0 || A[i][j] < 0) {
      return 0;
    }
    if (A[i][j] == 2) {
      if (totalZeroes == zeroCount) {
//        System.out.printf("totalZeroes[%s] == zeroCount[%s]%n", totalZeroes, zeroCount);
        ans++;
        return 1;
      }
      return 0;
    }
    if (A[i][j] == 0) {
      zeroCount++;
    }
    A[i][j] = -2;
//    System.out.printf("A[%s][%s]\t", i, j);
    int up;
    int left;
    int down;
    int right;
////    System.out.print("up : ");
    up = ways(A, i - 1, j, totalZeroes, zeroCount);
////    System.out.print("left : ");
    left = ways(A, i, j - 1, totalZeroes, zeroCount);
////    System.out.print("down : ");
    down = ways(A, i + 1, j, totalZeroes, zeroCount);
////    System.out.print("right : ");
    right = ways(A, i, j + 1, totalZeroes, zeroCount);
    A[i][j] = 0;
    return up + left + down + right;
  }
}