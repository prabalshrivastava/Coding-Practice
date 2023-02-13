package scaler.advancedDsa.dp2;

import java.util.Arrays;

public class HWQ3LetsParty {

  //  Problem Description
//  In Danceland, one person can party either alone or can pair up with another person.
//  Can you find in how many ways they can party if there are A people in Danceland?
//  Note: Return your answer modulo 10003, as the answer can be large.
//  Problem Constraints
//1 <= A <= 105
//  Input Format
//  Given only argument A of type Integer, number of people in Danceland.
//      Output Format
//  Return an integer denoting the number of ways people of Danceland can party.
//      Example Input
//  Input 1:
//  A = 3
//  Input 2:
//  A = 5
//  Example Output
//  DocFinder.Output 1:
//      4
//  Output 2:
//      26
//  Example Explanation
//  Explanation 1:
//  Let suppose three people are A, B, and C. There are only 4 ways to party
//      (A, B, C) All party alone
// (AB, C) A and B party together and C party alone
//      (AC, B) A and C party together and B party alone
// (BC, A) B and C party together and A
//  here 4 % 10003 = 4, so answer is 4.
//  Explanation 2:
//  Number of ways they can party are: 26.
  public static void main(String[] args) {
    System.out.println(new HWQ3LetsParty().solve(1));
    System.out.println(new HWQ3LetsParty().solve(2));
    System.out.println(new HWQ3LetsParty().solve(3));
    System.out.println(new HWQ3LetsParty().solve(4));
    System.out.println(new HWQ3LetsParty().solve(5));
    System.out.println(new HWQ3LetsParty().solve(17));//5793
  }

  public int solve(int A) {
    int[] dp = new int[A + 1];
    Arrays.fill(dp, -1);
    return letsParty(A, dp);
  }

  private int letsParty(int A, int[] dp) {
    if (dp[A] != -1) {
      return dp[A];
    }
    if (A == 0) {
      return 0;
    }
    if (A == 1) {
      return 1;
    }
    if (A == 2) {
      return 2;
    }
    int waysToParty = letsParty(A - 1, dp) % 10003 + (A - 1) % 10003 * letsParty(A - 2, dp) % 10003;
    waysToParty %= 10003;
    dp[A] = waysToParty;
    return waysToParty;
  }
}