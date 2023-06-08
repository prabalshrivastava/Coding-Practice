package scaler.module1.subsequencesAndSubsets;

import java.util.Arrays;

public class HWQ1SumTheDifference {

  //    Problem Description
//    Given an integer array, A of size N.
//    You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.
//    As the number may be large, output the number modulo 1e9 + 7 (1000000007).
//    NOTE: Subsequence can be non-contiguous.
//            Problem Constraints
//1 <= N <= 10000
//            1<= A[i] <=1000
//    Input Format
//    First argument is an integer array A.
//            Output Format
//    Return an integer denoting the output.
//    Example Input
//    Input 1:
//    A = [1, 2]
//    Input 2:
//    A = [1]
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    All possible non-empty subsets are:
//            [1]    largest-smallest = 1 - 1 = 0
//            [2]    largest-smallest = 2 - 2 = 0
//            [1 2]  largest-smallest = 2 - 1 = 1
//    Sum of the differences = 0 + 0 + 1 = 1
//    So, the resultant number is 1
//    Explanation 2:
//    Only 1 subsequence of 1 element is formed.
  public static void main(String[] args) {
    int[] input1A = {1, 2};
    System.out.println(new HWQ1SumTheDifference().solve(input1A));
    int[] input2A = {1};
    System.out.println(new HWQ1SumTheDifference().solve(input2A));
    System.out.println(new HWQ1SumTheDifference().solve(new int[]{3, 5, 10}));
    System.out.println(new HWQ1SumTheDifference().solve(new int[]{5, 4, 2}));
  }

  public int solve(int[] A) {
    Arrays.sort(A);
    long sum = 0;
    for (int i = 0; i < A.length; i++) {
      double max = Math.pow(2, i) % 1000000007;
      double min = Math.pow(2, A.length - 1 - i) % 1000000007;
      sum = (long) ((sum + (A[i] * ((max - min) % 1000000007)) % 1000000007) % 1000000007);
    }
    return (int) (sum % 1000000007);
  }

  public int solveBF(int[] A) {
    long sum = 0;
    for (int i = 0; i < Math.pow(2, A.length); i++) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < A.length; j++) {
        if ((i & (1 << j)) != 0) {
          min = Math.min(min, A[j]);
          max = Math.max(max, A[j]);
        }
      }
      if (max == Integer.MIN_VALUE && min == Integer.MAX_VALUE) {
      } else {
        int diff = max - min;
//        System.out.println(min + "-" + max + "=" + diff);
        sum = (sum + diff) % 1000000007;
      }
    }
    return (int) sum;
  }
}