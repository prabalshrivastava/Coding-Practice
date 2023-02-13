package scaler.advancedDsa.dp2;


import java.util.Arrays;
import scaler.common.CommonUtils;

public class AQ2NDigitNumbers {

  //  Problem Description
//  Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
//  Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
//  Since the answer can be large, output answer modulo 1000000007
//  Problem Constraints
//1 <= A <= 1000
//      1 <= B <= 10000
//  Input Format
//  First argument is the integer A
//  Second argument is the integer B
//  Output Format
//  Return a single integer, the answer to the problem
//  Example Input
//  Input 1:
//  A = 2
//  B = 4
//  Input 2:
//  A = 1
//  B = 3
//  Example Output
//  DocFinder.Output 1:
//      4
//  Output 2:
//      1
//  Example Explanation
//  Explanation 1:
//  Valid numbers are {22, 31, 13, 40}
//  Hence output 4.
//  Explanation 2:
//  Only valid number is 3
  public static void main(String[] args) {
    int input1A = 2;
    int input1B = 4;
    System.out.println(new AQ2NDigitNumbers().solve(input1A, input1B));
    int input2A = 1;
    int input2B = 3;
    System.out.println(new AQ2NDigitNumbers().solve(input2A, input2B));
    System.out.println(new AQ2NDigitNumbers().solve(3, 4));
  }

  public int solve(int A, int B) {
    int[][] dp = new int[A + 1][B + 1];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], -1);
    }
//    return findNoOfDigitsRecursive(A, B, dp);
    Arrays.fill(dp[0], 0);
    for (int i = 0; i < dp[1].length; i++) {
      if (i < 10) {
        dp[1][i] = 1;
      } else {
        dp[1][i] = 0;
      }
    }
    System.out.println(Arrays.deepToString(dp));
    return findNoOfDigitsIterative(A, B, dp);
  }

  private int findNoOfDigitsIterative(int noOfDigits, int sum, int[][] dp) {
    if (dp[noOfDigits][sum] != -1) {
      return dp[noOfDigits][sum];
    }
    for (int i = 0; i <= noOfDigits; i++) {
      for (int j = 0; j <= sum; j++) {
        dp[i][j] = dp[i - 1][sum - j];
      }
    }
    return dp[noOfDigits][sum];
  }

  private int findNoOfDigitsRecursive(int noOfDigits, int sum, int[][] dp) {
    if (noOfDigits == 1) {
      if (1 <= sum && sum < 10) {
        return 1;
      } else {
        return 0;
      }
    }
    if (sum < 0) {
      return 0;
    }
    if (dp[noOfDigits][sum] != -1) {
      return dp[noOfDigits][sum];
    }
    int ways = 0;
    for (int i = 0; i < 10; i++) {
      ways = CommonUtils.getModdedIntSum(
          ways + findNoOfDigitsRecursive(noOfDigits - 1, sum - i, dp));
    }
    dp[noOfDigits][sum] = ways;
    return ways;
  }
}