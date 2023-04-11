package scaler.module1.subsequencesAndSubsets;

public class HWQ2SpecialSubsequencesAG {
//  Problem Description
//  You have given a string A having Uppercase English letters.
//  You have to find how many times subsequence "AG" is there in the given string.
//  NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
//      Problem Constraints
//1 <= length(A) <= 105
//  Input Format
//  First and only argument is a string A.
//  Output Format
//  Return an integer denoting the answer.
//  Example Input
//  Input 1:
//  A = "ABCGAG"
//  Input 2:
//  A = "GAB"
//  Example Output
//  DocFinder.Output 1:
//      3
//  Output 2:
//      0
//  Example Explanation
//  Explanation 1:
//  Subsequence "AG" is 3 times in given string
//  Explanation 2:
//  There is no subsequence "AG" in the given string.

  public int solve(String A) {
    long countOfA = 0;
    long countOfAG = 0;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == 'A') {
        countOfA++;
      } else if (A.charAt(i) == 'G') {
        countOfAG = (countOfAG + countOfA) % 1000000007;
      }
    }
    return (int) (countOfAG % 1000000007);
  }

  public static void main(String[] args) {
    String input1A = "ABCGAG";
    System.out.println(new HWQ2SpecialSubsequencesAG().solve(input1A));
    String input2A = "GAB";
    System.out.println(new HWQ2SpecialSubsequencesAG().solve(input2A));
    System.out.println(new HWQ2SpecialSubsequencesAG().solve("ABCABCABCGAGGAG"));
  }
}