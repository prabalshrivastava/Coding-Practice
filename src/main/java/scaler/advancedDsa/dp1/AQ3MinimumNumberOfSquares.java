package scaler.advancedDsa.dp1;

import java.util.Arrays;

public class AQ3MinimumNumberOfSquares {

  //  Problem Description
//  Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
//  Problem Constraints
//1 <= A <= 105
//  Input Format
//  First and only argument is an integer A.
//  Output Format
//  Return an integer denoting the minimum count.
//      Example Input
//  Input 1:
//  A = 6
//  Input 2:
//  A = 5
//  Example Output
//  DocFinder.Output 1:
//      3
//  Output 2:
//      2
//  Example Explanation
//  Explanation 1:
//  Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
//  Minimum count of numbers, sum of whose squares is 6 is 3.
//  Explanation 2:
//  We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
  public static void main(String[] args) {
    System.out.println(new AQ3MinimumNumberOfSquares().countMinSquares(6));//3    2^2+1^2+1^2
    System.out.println(new AQ3MinimumNumberOfSquares().countMinSquares(5));//2    2^2+1^2
    System.out.println(new AQ3MinimumNumberOfSquares().countMinSquares(10));//2   3^2+1^2
    System.out.println(new AQ3MinimumNumberOfSquares().countMinSquares(13));//2   3^2+2^2
  }

  int[] dp;

  public int countMinSquares(int A) {
    dp = new int[A + 1];
    Arrays.fill(dp, -1);
//    int recursive = countMinSquaresRecursive(A);
//    System.out.println(recursive);
    Arrays.fill(dp, -1);
    return countMinSquaresIterative(A);
  }

  private int countMinSquaresIterative(int A) {
    if (A <= 1) {
      return A;
    }
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= A; i++) {
      for (int x = 1; x * x <= i; x++) {
        dp[i] = Math.min(dp[i], dp[i - x * x] + 1);
      }
    }
    System.out.println(Arrays.toString(dp));
    return dp[A];
  }

  private int countMinSquaresRecursive(int A) {
    if (A == 0) {
      return 0;
    }
    int ans = Integer.MAX_VALUE;
    if (dp[A] != -1) {
      return dp[A];
    }
    for (int i = 1; i * i <= A; i++) {
      ans = Math.min(ans, countMinSquaresRecursive(A - i * i)) + 1;
    }
    return ans;
  }
}