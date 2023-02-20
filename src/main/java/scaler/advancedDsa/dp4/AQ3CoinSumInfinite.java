package scaler.advancedDsa.dp4;

import java.util.Arrays;

public class AQ3CoinSumInfinite {

  //  Problem Description
//  You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.
//  NOTE:
//  Coins in set A will be unique. Expected space complexity of this problem is O(B).
//  The answer can overflow. So, return the answer % (106 + 7).
//  Problem Constraints
//1 <= A <= 500
//      1 <= A[i] <= 1000
//      1 <= B <= 50000
//  Input Format
//  First argument is an integer array A representing the set.
//  Second argument is an integer B.
//  Output Format
//  Return an integer denoting the number of ways.
//  Example Input
//  Input 1:
//  A = [1, 2, 3]
//  B = 4
//  Input 2:
//  A = [10]
//  B = 10
//  Example Output
//  DocFinder.Output 1:
//      4
//  Output 2:
//      1
//  Example Explanation
//  Explanation 1:
//  The 4 possible ways are:
//  {1, 1, 1, 1}
//  {1, 1, 2}
//  {2, 2}
//  {1, 3}
//  Explanation 2:
//  There is only 1 way to make sum 10.
  public static void main(String[] args) {
    int[] input1A = {1, 2, 3};
    int input1B = 4;
    System.out.println(new AQ3CoinSumInfinite().coinchange2(input1A, input1B));
    int[] input2A = {10};
    int input2B = 10;
    System.out.println(new AQ3CoinSumInfinite().coinchange2(input2A, input2B));
    int[] input3A = {18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8};
    int input3B = 458;
    System.out.println(new AQ3CoinSumInfinite().coinchange2(input3A, input3B));//867621
    int[] input4A = {22, 3, 15, 20, 9, 27, 28, 26, 30, 12, 6, 29, 21};
    int input4B = 270;
    System.out.println(new AQ3CoinSumInfinite().coinchange2(input4A, input4B));//198528s
  }


  public int coinchange2(int[] A, int B) {
    int[][] dp = new int[A.length + 1][B + 1];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], -1);
    }
//    int coinchangeWays = coinChangeWaysTopDown(A.length, B, A, dp);
    int coinchangeWays = coinChangeWaysBottomUp(A.length, B, A, dp);
//    System.out.println(Arrays.deepToString(dp));
    return coinchangeWays;
  }

  private int coinChangeWaysBottomUp(int noOfItems, int capacity, int[] weights, int[][] dp) {
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = 1;
    }
    for (int j = 0; j < dp[0].length; j++) {
      dp[0][j] = 0;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (j >= weights[i - 1]) {
          dp[i][j] = (dp[i][j - weights[i - 1]] % 1000007 + dp[i - 1][j] % 1000007) % 1000007;
        } else {
          dp[i][j] = dp[i - 1][j] % 1000007;
        }
      }
    }
//    System.out.println(Arrays.deepToString(dp));
    return dp[noOfItems][capacity];
  }

  private int coinChangeWaysTopDown(int noOfItems, int capacity, int[] weights, int[][] dp) {
    if (capacity == 0) {
      return 1;
    }
    if (noOfItems == 0) {
      return 0;
    }
    if (dp[noOfItems][capacity] != -1) {
      return dp[noOfItems][capacity];
    }
    int ans;
    if (capacity >= weights[noOfItems - 1]) {
      ans =
          coinChangeWaysTopDown(noOfItems, capacity - weights[noOfItems - 1], weights, dp) % 1000007
              + coinChangeWaysTopDown(
              noOfItems - 1, capacity, weights, dp) % 1000007;
      ans %= 1000007;
    } else {
      ans = coinChangeWaysTopDown(
          noOfItems - 1, capacity, weights, dp) % 1000007;
    }
    dp[noOfItems][capacity] = ans;
    return ans;
  }

}