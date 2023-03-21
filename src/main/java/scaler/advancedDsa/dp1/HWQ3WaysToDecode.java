package scaler.advancedDsa.dp1;


import static scaler.common.CommonUtils.getModdedSum;

import java.util.Arrays;
import scaler.common.CommonUtils;

public class HWQ3WaysToDecode {

  //  Problem Description
//  A message containing letters from A-Z is being encoded to numbers using the following mapping:
//      'A' -> 1
//      'B' -> 2
//      ...
//      'Z' -> 26
//  Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.
//  Problem Constraints
//1 <= length(A) <= 105
//  Input Format
//  The first and the only argument is a string A.
//  Output Format
//  Return an integer, representing the number of ways to decode the string modulo 109 + 7.
//  Example Input
//  Input 1:
//  A = "12"
//  Input 2:
//  A = "8"
//  Example Output
//  DocFinder.Output 1:
//      2
//  Output 2:
//      1
//  Example Explanation
//  Explanation 1:
//  Given encoded message "8", it could be decoded as only "H" (8).
//  The number of ways decoding "8" is 1.
//  Explanation 2:
//  Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
//  The number of ways decoding "12" is 2.
  public int numDecodings1(String A) {
    int[] dp = new int[27];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    return countWays(A, A.length(), dp);
//    return countWaysRecursive(A, A.length());
  }

  public int numDecodings(String A) {
    int[] dp = new int[A.length()];
    Arrays.fill(dp, -1);
    return countWaysImproved(A, A.length() - 1, dp);
//    return countWaysRecursive(A, A.length());
  }

  private int countWaysImproved(String A, int n, int[] dp) {
    if (dp[n] != -1) {
      return dp[n];
    }
    if (n == 0) {//single digit
      if (A.charAt(0) == '0') {
        return 0;
      } else {
        return 1;
      }
    }
    if (n == 1) {
      int twoDigit = Integer.parseInt(A.charAt(0) + "" + A.charAt(1));
      if (twoDigit == 10 || twoDigit == 20) {
        return 1;
      }
      if (10 <= twoDigit && twoDigit <= 26) {
        return 2;
      }
    }
    long pick1Digit = 0;
    long pick2Digit = 0;
    if (A.charAt(n) != '0') {
      pick1Digit = countWaysImproved(A, n - 1, dp);//if the number lies between 0-9
    }
    int twoDigit = Integer.parseInt(A.charAt(n - 1) + "" + A.charAt(n));
    if (10 <= twoDigit && twoDigit <= 26) {
      pick2Digit = countWaysImproved(A, n - 2, dp);//if the number lies between 10-26
    }
    dp[n] = (int) getModdedSum(pick1Digit + pick2Digit);
    return dp[n];
  }

  private int countWays(String A, int n, int[] dp) {
    int count = 0;
    if (n == 1) {
      if (A.charAt(0) == '0') {
        return 0;
      } else {
        return 1;
      }
    }
    if (n == 2) {
      int twoDigitNum = Integer.parseInt(A.charAt(0) + "" + A.charAt(1));
      if (twoDigitNum == 10 || twoDigitNum == 20) {
        return 1;
      }
      if (10 <= twoDigitNum && twoDigitNum <= 26) {
        return 2;
      }
    }

    int oneDigit = Integer.parseInt(A.charAt(n - 1) + "");
    if (dp[oneDigit] == -1) {
      dp[oneDigit] = countWays(A, n - 1, dp);
    }
    count += dp[oneDigit];
    int twoDigitNum = Integer.parseInt(A.charAt(n - 2) + "" + A.charAt(n - 1));
    if (10 <= twoDigitNum && twoDigitNum <= 26) {
      if (dp[twoDigitNum] == -1) {
        dp[twoDigitNum] = countWays(A, n - 2, dp);
      }
      count += dp[twoDigitNum];
    }
    return count;
  }

  private int countWaysRecursive(String A, int n) {
    int count = 0;
    if (n == 1) {
      if (A.charAt(0) == '0') {
        return 0;
      } else {
        return 1;
      }
    }
    if (n == 2) {
      int twoDigitNum = Integer.parseInt(A.charAt(0) + "" + A.charAt(1));
      if (twoDigitNum == 10 || twoDigitNum == 20) {
        return 1;
      }
      if (10 <= twoDigitNum && twoDigitNum <= 26) {
        return 2;
      }
    }
    if (A.charAt(n - 1) != '0') {
      count += countWaysRecursive(A, n - 1);
    }
    int twoDigitNum = Integer.parseInt(A.charAt(n - 2) + "" + A.charAt(n - 1));
    if (10 <= twoDigitNum && twoDigitNum <= 26) {
      count += countWaysRecursive(A, n - 2);
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println("8 ->" + new HWQ3WaysToDecode().numDecodings("8"));
    System.out.println("12 ->" + new HWQ3WaysToDecode().numDecodings("12"));
    System.out.println("123 ->" + new HWQ3WaysToDecode().numDecodings("123"));
    System.out.println("1234 ->" + new HWQ3WaysToDecode().numDecodings("1234"));
    System.out.println("12345 ->" + new HWQ3WaysToDecode().numDecodings("12345"));
    System.out.println("1234321 ->" + new HWQ3WaysToDecode().numDecodings("1234321"));
    System.out.println("123123 ->" + new HWQ3WaysToDecode().numDecodings("123123"));//9
    System.out.println("10 ->" + new HWQ3WaysToDecode().numDecodings("10"));
    System.out.println(
        "5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190 ->"
            + new HWQ3WaysToDecode().numDecodings(
            "5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190"));
  }
}