package scaler.advancedDsa.dp3;


import java.util.Arrays;

public class AQ101Knapsack {

  //  Problem Description
//  Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
//  Also given an integer C which represents knapsack capacity.
//  Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
//  NOTE:
//  You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
//  Problem Constraints
//1 <= N <= 103
//      1 <= C <= 103
//      1 <= A[i], B[i] <= 103
//  Input Format
//  First argument is an integer array A of size N denoting the values on N items.
//  Second argument is an integer array B of size N denoting the weights on N items.
//  Third argument is an integer C denoting the knapsack capacity.
//  DocFinder.Output Format
//  Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
//  Example Input
//  Input 1:
//  A = [60, 100, 120]
//  B = [10, 20, 30]
//  C = 50
//  Input 2:
//  A = [10, 20, 30, 40]
//  B = [12, 13, 15, 19]
//  C = 10
//  Example Output
//  Output 1:
//      220
//  Output 2:
//      0
//  Example Explanation
//  Explanation 1:
//  Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
//  Explanation 2:
//  Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
  public static void main(String[] args) {
    int[] input1A = {60, 100, 120};
    int[] input1B = {10, 20, 30};
    int input1C = 50;
    System.out.println(new AQ101Knapsack().solve(input1A, input1B, input1C));

    int[] input2A = {10, 20, 30, 40};
    int[] input2B = {12, 13, 15, 19};
    int input2C = 10;
    System.out.println(new AQ101Knapsack().solve(input2A, input2B, input2C));

    int[] A = {359, 963, 465, 706, 146, 282, 828, 962, 492};
    int[] B = {96, 43, 28, 37, 92, 5, 3, 54, 93};
    int C = 383;
    System.out.println(new AQ101Knapsack().solve(A, B, C));
  }

  public int solve(int[] A, int[] B, int C) {
    int[][] dp = new int[A.length + 1][C + 1];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], -1);
    }
//    int knapsack = knapsackTopDown(A, B, C, A.length, dp);
//    System.out.println(Arrays.deepToString(dp));
    int knapsack = knapsackBottomUp(A, B, C, A.length, dp);
//    System.out.println(Arrays.deepToString(dp));
    return knapsack;
  }

  private int knapsackBottomUp(int[] value, int[] weight, int capacity, int N, int[][] dp) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (j >= weight[i - 1]) {
          dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[N][capacity];
  }

  private int knapsackTopDown(int[] value, int[] weight, int capacity, int N, int[][] dp) {
    if (N == 0 || capacity == 0) {
      return 0;
    }
    if (dp[N][capacity] != -1) {
      return dp[N][capacity];
    }
    int ans;
    if (weight[N - 1] <= capacity) {
      ans = Math.max(
          value[N - 1] + knapsackTopDown(value, weight, capacity - weight[N - 1], N - 1, dp),
          knapsackTopDown(value, weight, capacity, N - 1, dp));
    } else {
      ans = knapsackTopDown(value, weight, capacity, N - 1, dp);
    }
    dp[N][capacity] = ans;
    return ans;
  }
}