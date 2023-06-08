package scaler.module1.subsequencesAndSubsets;

public class HWQ4SubsequenceSumProblem {

  //  Problem Description
//  You are given an array of integers A of N size.
//  You have to find that there is any subsequence exists or not whose sum is equal to B.
//  Note: A subsequence is a sequence that can be derived from the given array by deleting zero or more elements without changing the order of the remaining elements.
//      Problem Constraints
//1 <= N <= 20
//      1 <= A[i] <= 100000
//      0 <= B <= 1e9
//  Input Format
//  First Argument is array of integers A
//  Second Argument is B
//  DocFinder.Output Format
//  Return 1 if any subsequence sum is equal to B otherwise return 0.
//  Example Input
//  Input 1:
//  A = [1, 20, 13, 4, 5]
//  B = 18
//  Input 2:
//  A = [2, 2, 2, 2]
//  B = 5
//  Example Output
//  Output 1:
//      1
//  Output 2:
//      0
//  Example Explanation
//  Explanation 1:
//  If we enumerate the sum of all the 2^5 = 32 subsequences of A,
//  we will see that the subsequence [1,13, 4] gives a sum of B = 18. Hence we return 1.
//  Explanation 2:
//  There is no possible subsequence whose sum is 5
  public static void main(String[] args) {
    int[] input1A = {1, 20, 13, 4, 5};
    int input1B = 18;
    System.out.println(new HWQ4SubsequenceSumProblem().solve(input1A, input1B));
    int[] input2A = {2, 2, 2, 2};
    int input2B = 5;
    System.out.println(new HWQ4SubsequenceSumProblem().solve(input2A, input2B));
  }

  public int solve(int[] A, int B) {
    for (int i = 0; i < 1 << A.length; i++) {
      long sum = 0;
      for (int j = 0; j < A.length; j++) {
        if ((1 << j & i) != 0) {
          sum = (sum + A[j]) % 1000000007;
        }
      }
      if (sum == B) {
        return 1;
      }
    }
    return 0;
  }
}