package scaler.advancedDsa.dp3;

import java.util.Arrays;

public class AQ2UnboundedKnapsack {

  //  Problem Description
//  Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
//  This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
//      Problem Constraints
//1 <= A <= 1000
//      1 <= |B| <= 1000
//      1 <= B[i] <= 1000
//      1 <= C[i] <= 1000
//  Input Format
//  First argument is the Weight of knapsack A
//  Second argument is the vector of values B
//  Third argument is the vector of weights C
//  Output Format
//  Return the maximum value that fills the knapsack completely
//  Example Input
//  Input 1:
//  A = 10
//  B = [5]
//  C = [10]
//  Input 2:
//  A = 10
//  B = [6, 7]
//  C = [5, 5]
//  Example Output
//  DocFinder.Output 1:
//      5
//  Output 2:
//      14
//  Example Explanation
//  Explanation 1:
//  Only valid possibility is to take the given item.
//      Explanation 2:
//  Take the second item twice.
  public static void main(String[] args) {
    int input1A = 10;
    int[] input1B = {5};
    int[] input1C = {10};
    System.out.println(new AQ2UnboundedKnapsack().solve(input1A, input1B, input1C));
    int input2A = 10;
    int[] input2B = {6, 7};
    int[] input2C = {5, 5};
    System.out.println(new AQ2UnboundedKnapsack().solve(input2A, input2B, input2C));
    int input3A = 999;
    int[] input3B = {7, 4, 7, 9, 12, 17, 12, 7, 19, 19, 5, 16, 7, 3, 8, 16, 9, 9, 19, 3, 15, 8, 18,
        10, 14, 18, 19, 11, 1, 12, 3, 10, 12, 17, 20, 5, 9, 8, 1, 13, 17, 11, 14, 1, 11, 18, 15, 13,
        1, 6, 18, 5, 1, 18, 13, 19, 3, 14, 14, 14, 12, 5, 7, 15, 4, 18, 16, 20, 20, 12, 13, 20, 11,
        7, 11, 6, 13, 2, 14, 18, 11, 6, 10, 4, 16, 8, 7, 8, 2, 10, 4, 16, 11, 8, 6, 13, 18, 5, 2, 8,
        20, 16, 18, 3, 15, 19, 7, 6, 5, 4, 17, 12, 6, 15, 9, 1, 10, 6, 4, 7, 13, 17, 20, 8, 4, 7, 5,
        18, 7, 19, 7, 6, 12, 6, 3, 3, 18, 4, 15, 3, 7, 8, 9, 17, 1, 9, 13, 6, 20, 19, 1, 14, 16, 6,
        16, 5, 18, 11, 7, 15, 8, 11, 13, 15, 11, 1, 15, 12, 3, 10, 1, 17, 5, 11, 11, 20, 12, 12, 9,
        6, 11, 2, 9, 4, 3, 19, 5, 3, 15, 1, 19, 9, 4, 5, 16, 9, 11, 9, 16, 8, 16, 15, 12, 19, 8, 18,
        16, 12, 20, 12, 5, 9, 7, 12, 7, 14, 12, 20, 19, 10, 14, 18, 5, 9, 9, 19, 15, 1, 5, 19, 17,
        18, 18, 7, 6, 12, 5, 2, 11, 18, 11, 17, 2, 16, 18, 19, 11, 19, 15, 12, 3, 20, 15, 7, 12, 8,
        10, 4, 11, 12, 13, 11, 13, 12, 4, 7, 13, 13, 3, 6, 20, 4, 14, 1, 17, 14, 7, 20, 2, 13, 16,
        5, 9, 15, 14, 3, 20, 11, 18, 16, 11, 19, 14, 1, 20, 7, 1, 4, 14, 2, 1, 4, 5, 17, 18, 9, 19,
        16, 20, 14, 9, 9, 7, 17, 20, 18, 4, 12, 4, 18, 6, 1, 13, 10, 14, 9, 18, 2, 9, 15, 19, 10, 8,
        1, 3, 6, 8, 4, 12, 16, 13, 10, 17, 3, 8, 20, 14, 3, 11, 3, 16, 2, 19, 10, 7, 1, 5, 2, 15,
        15, 16, 19, 6, 8, 5, 20, 15, 17, 7, 16, 16, 2, 8, 1, 4, 5, 15, 14, 11, 9, 18, 2, 5, 6, 7, 7,
        15, 11, 5, 9, 16, 18, 1, 5, 7, 5, 18, 11, 10, 20, 11, 8, 11, 4, 13, 8, 18, 5, 6, 4, 3, 20,
        11, 4, 15, 7, 8, 18, 4, 7, 18, 18, 5, 4, 13, 17, 18, 6, 14, 3, 3, 15, 8, 19, 9, 19, 3, 2,
        13, 16, 12, 8, 9, 8, 3, 6, 4, 7, 20, 17, 14, 6, 9, 13, 15, 3, 4, 12, 6, 12, 8, 6, 11, 11,
        13, 5, 17, 16, 12, 8, 5, 9, 2, 8, 11, 6, 11, 20, 8, 4, 1, 15, 11, 17, 10, 9, 9, 18, 12, 9,
        9, 12, 2, 20, 10, 12, 6, 1, 19, 6, 11, 15, 19, 3, 18, 12, 16, 10, 18, 15, 4, 14, 5, 19, 20,
        6, 5, 6, 9, 19, 17, 11, 11, 12, 16, 5, 17, 12, 4, 18, 8, 20, 15, 9, 2, 13, 19, 20, 4, 10,
        12, 7, 3, 2, 5, 12, 16, 3, 6, 4, 8, 2, 10, 18, 18, 3, 6, 11, 17, 5, 11, 18, 10, 5, 8, 2, 16,
        7, 2, 3, 4, 19, 9, 16, 11, 9, 10, 1, 4, 10, 12, 16, 20, 14, 12, 14, 9, 10, 15, 10, 11, 10,
        17, 17, 18, 19, 9, 9, 12, 8, 16, 15, 16, 7, 18, 20, 6, 13, 15, 11, 20, 14, 15, 14, 6, 16, 8,
        7, 2, 5, 15, 14, 2, 4, 1, 6, 11, 1, 11, 14, 15, 13, 20, 13, 9, 18, 7, 10, 14, 20, 18, 1, 2,
        4, 15, 3, 9, 1, 15, 3, 2, 13, 6, 12, 20, 16, 11, 18, 18, 18, 2, 1, 14, 11, 9, 10, 14, 18,
        20, 11, 17, 8, 7, 14, 3, 8, 4, 15, 15, 5, 2, 5, 6, 7, 18, 20, 8, 6, 7, 2, 10, 3, 10, 8, 20,
        9, 20, 6, 2, 6, 13, 14, 16, 12, 2, 2, 16, 3, 16, 4, 9, 15, 5, 5, 4, 8, 15, 11, 20, 16, 20,
        12, 5, 6, 8, 9, 19, 19, 10, 12, 19, 8, 18, 20, 1, 9, 4, 9, 11, 19, 4, 18, 15, 12, 16, 18, 1,
        4, 12, 10, 12, 14, 2, 1, 9, 14, 4, 16, 11, 19, 2, 18, 16, 19, 7, 16, 16, 12, 3, 16, 1, 14,
        9, 19, 20, 11, 12, 6, 18, 2, 17, 14, 4, 20, 15, 4, 5, 14, 14, 2, 1, 6, 2, 11, 13, 9, 8, 17,
        3, 10, 13, 9, 2, 9, 20, 15, 13, 4, 6, 2, 3, 4, 17, 5, 17, 20, 6, 8, 8, 8, 10, 7, 19, 15, 7,
        16, 17, 13, 1, 6, 5, 11, 15, 6, 18, 14, 11, 12, 2, 19, 9, 10, 18, 15, 17, 9, 6, 20, 16, 10,
        5, 2, 7, 10, 11, 1, 10, 10, 6, 9, 6, 4, 8, 10, 12, 8, 4, 4, 2, 3, 15, 20, 4, 7, 13, 11, 8,
        13, 7, 7, 3, 18, 19, 9, 10, 11, 14, 2, 19, 10, 17, 13, 2, 4, 2, 9, 8, 16, 6, 15, 14, 1, 7,
        6, 5, 13, 10, 3, 1, 7, 16, 15, 9, 11, 16, 13, 11, 16, 15, 8, 3, 3, 10, 18, 1, 13, 6, 17, 3,
        16, 7, 10, 5, 16, 8, 7, 5, 14, 17, 4, 6, 2, 4, 4, 16, 20, 10, 9, 6, 7, 17, 20, 2, 4, 9, 1,
        15, 4, 17, 15, 1, 13, 18, 3, 7, 7, 1, 10, 2, 14, 11, 14, 15, 10, 19, 3, 1, 1, 11, 14, 10, 3,
        15, 13, 6, 5, 13, 16, 6, 12, 11, 11, 12, 14, 15, 7, 19, 1, 13, 20};
    int[] input3C = {20, 1, 14, 8, 20, 6, 5, 10, 6, 17, 9, 5, 17, 13, 9, 10, 16, 8, 9, 12, 1, 4, 14,
        16, 14, 11, 10, 7, 16, 12, 8, 5, 3, 18, 20, 19, 12, 12, 14, 10, 20, 13, 11, 12, 2, 9, 18,
        12, 11, 8, 9, 4, 4, 10, 19, 18, 9, 1, 1, 5, 12, 16, 16, 13, 12, 10, 10, 16, 8, 20, 1, 15,
        16, 7, 17, 6, 18, 6, 6, 6, 2, 19, 11, 18, 4, 19, 11, 19, 13, 6, 1, 7, 3, 16, 17, 18, 2, 8,
        15, 3, 15, 3, 3, 15, 18, 7, 6, 19, 19, 3, 8, 9, 19, 10, 18, 20, 6, 5, 13, 8, 7, 3, 18, 2,
        10, 13, 9, 14, 11, 9, 8, 10, 16, 8, 19, 19, 4, 20, 1, 2, 17, 13, 13, 3, 20, 14, 8, 7, 5, 11,
        12, 11, 16, 10, 8, 16, 9, 20, 2, 2, 11, 4, 11, 15, 2, 10, 2, 10, 14, 9, 16, 15, 14, 2, 12,
        9, 10, 17, 16, 19, 8, 15, 13, 5, 19, 17, 5, 7, 15, 14, 3, 6, 11, 18, 19, 3, 7, 5, 11, 14,
        15, 2, 19, 16, 8, 2, 6, 20, 12, 15, 12, 19, 10, 7, 16, 2, 9, 19, 8, 16, 10, 17, 13, 20, 11,
        17, 4, 15, 11, 11, 12, 10, 3, 14, 20, 5, 20, 14, 11, 2, 9, 18, 15, 16, 11, 11, 12, 1, 20, 9,
        14, 11, 13, 14, 16, 2, 12, 13, 19, 10, 18, 18, 16, 2, 14, 2, 20, 2, 4, 4, 11, 16, 14, 16, 6,
        2, 9, 2, 12, 7, 1, 17, 19, 20, 20, 18, 8, 15, 5, 15, 19, 4, 10, 7, 11, 8, 3, 13, 15, 5, 10,
        16, 6, 15, 19, 10, 2, 3, 8, 11, 9, 19, 18, 8, 7, 5, 6, 16, 4, 9, 2, 15, 15, 12, 3, 8, 4, 1,
        20, 9, 1, 19, 15, 2, 13, 18, 1, 9, 20, 14, 9, 4, 20, 3, 16, 9, 8, 5, 17, 10, 16, 15, 16, 14,
        12, 12, 20, 10, 16, 15, 19, 6, 8, 10, 18, 13, 13, 4, 16, 12, 13, 14, 6, 4, 1, 9, 16, 10, 11,
        8, 1, 10, 15, 5, 10, 4, 10, 16, 18, 5, 5, 20, 1, 18, 14, 20, 14, 18, 11, 11, 20, 4, 10, 17,
        3, 4, 14, 17, 3, 2, 15, 5, 19, 15, 16, 3, 9, 20, 18, 6, 15, 6, 16, 6, 6, 7, 8, 9, 13, 5, 9,
        17, 2, 19, 13, 8, 14, 20, 4, 10, 2, 8, 17, 9, 8, 5, 3, 11, 4, 14, 1, 19, 14, 3, 20, 18, 20,
        4, 11, 19, 19, 19, 1, 10, 1, 18, 1, 13, 7, 13, 12, 20, 9, 11, 5, 10, 17, 19, 18, 18, 19, 6,
        5, 8, 17, 2, 14, 18, 15, 1, 7, 16, 17, 15, 5, 11, 3, 18, 6, 14, 2, 20, 19, 17, 4, 16, 15,
        15, 9, 5, 20, 19, 9, 4, 14, 19, 19, 3, 12, 7, 1, 4, 16, 8, 19, 1, 8, 10, 17, 5, 2, 10, 18,
        3, 1, 6, 14, 14, 3, 6, 19, 3, 8, 3, 5, 14, 7, 20, 7, 14, 16, 19, 7, 4, 20, 11, 10, 13, 8, 6,
        19, 20, 10, 3, 3, 2, 14, 18, 2, 1, 17, 5, 13, 7, 1, 5, 10, 5, 19, 1, 4, 14, 17, 16, 10, 14,
        19, 16, 12, 19, 19, 3, 5, 8, 6, 15, 4, 11, 11, 9, 1, 19, 9, 17, 12, 16, 12, 3, 5, 3, 7, 7,
        4, 13, 2, 2, 17, 10, 4, 5, 18, 16, 15, 17, 10, 14, 9, 16, 13, 11, 6, 18, 20, 12, 16, 19, 17,
        8, 16, 10, 5, 15, 13, 6, 3, 6, 12, 10, 14, 12, 20, 2, 11, 15, 18, 15, 9, 14, 20, 13, 1, 12,
        9, 11, 1, 14, 18, 3, 8, 8, 11, 5, 12, 11, 11, 14, 12, 1, 11, 16, 9, 19, 9, 1, 9, 5, 18, 1,
        11, 15, 3, 12, 5, 15, 15, 11, 5, 6, 16, 7, 20, 1, 9, 18, 4, 3, 3, 14, 4, 14, 14, 5, 9, 3, 1,
        9, 2, 1, 18, 7, 16, 17, 17, 4, 10, 3, 10, 2, 19, 13, 11, 3, 9, 13, 16, 3, 13, 5, 7, 20, 18,
        5, 6, 13, 10, 6, 15, 5, 1, 19, 20, 3, 18, 9, 16, 4, 14, 7, 16, 16, 10, 6, 19, 4, 9, 6, 2, 9,
        7, 13, 15, 18, 6, 5, 16, 10, 16, 14, 11, 1, 19, 13, 16, 2, 1, 6, 12, 3, 17, 20, 8, 16, 16,
        17, 16, 6, 2, 19, 5, 1, 12, 3, 14, 16, 15, 20, 12, 1, 19, 9, 18, 18, 10, 16, 18, 12, 7, 5,
        4, 8, 17, 10, 8, 12, 14, 13, 10, 12, 18, 9, 1, 17, 13, 5, 18, 20, 1, 4, 10, 3, 11, 1, 11, 5,
        7, 8, 5, 7, 15, 13, 9, 4, 10, 20, 4, 12, 7, 6, 2, 1, 19, 2, 19, 6, 9, 16, 9, 1, 4, 8, 10,
        16, 8, 1, 13, 6, 18, 1, 3, 4, 3, 13, 7, 9, 8, 14, 5, 10, 2, 2, 7, 9, 5, 13, 15, 20, 16, 11,
        1, 3, 2, 5, 18, 11, 13, 6, 8, 11, 17, 17, 3, 9, 11, 18, 3, 14, 4, 18, 14, 3, 15, 13, 2, 10,
        1, 3, 11, 9, 2, 5, 2, 14, 15, 2, 8, 18, 17, 9, 19, 6, 14, 7, 7, 3, 19, 11, 19, 8, 20, 2, 14,
        8, 13, 9, 15, 13, 1, 14, 4, 19, 12, 8, 6, 16, 20, 8, 1, 6, 9, 16, 13, 19, 17, 18, 7, 6, 12,
        11, 17, 8, 10, 9, 12, 6, 19, 8, 1, 4, 19, 11, 4, 2, 6, 9, 5, 15, 19, 6, 20, 11};
    System.out.println(new AQ2UnboundedKnapsack().solve(input3A, input3B, input3C));//18981
  }

  public int solve(int A, int[] B, int[] C) {
    int[] weight = C;
    int[] values = B;
    int capacity = A;
    int[][] dp = new int[weight.length + 1][capacity + 1];
    Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
//    System.out.println(Arrays.deepToString(dp));
//    return knapsackTopDown(weight, values, capacity, weight.length, dp);
    return knapsackBottomUp(weight, values, capacity, weight.length, dp);
  }

  private int knapsackBottomUp(int[] weight, int[] values, int capacity, int N, int[][] dp) {
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = 0;
    }
    for (int j = 0; j < dp[0].length; j++) {
      dp[0][j] = 0;
    }
//    System.out.println(Arrays.deepToString(dp));
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (j >= weight[i - 1]) {
          dp[i][j] = Math.max(values[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[N][capacity];
  }

  private int knapsackTopDown(int[] weight, int[] values, int capacity, int N, int[][] dp) {
    if (N == 0 || capacity == 0) {
      return 0;
    }
    if (dp[N][capacity] != -1) {
      return dp[N][capacity];
    }
    int ans;
    if (capacity >= weight[N - 1]) {
      ans = Math.max(values[N - 1] + knapsackTopDown(weight, values, capacity - weight[N - 1], N,
              dp),
          knapsackTopDown(weight, values, capacity, N - 1, dp)
      );
    } else {
      ans = knapsackTopDown(weight, values, capacity, N - 1, dp);
    }
    dp[N][capacity] = ans;
    return ans;
  }
}