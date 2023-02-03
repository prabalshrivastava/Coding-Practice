package scaler.advancedDsa.dp1;


public class HWQ2MaxProductSubarray {

  //  Problem Description
//  Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.
//  Return an integer corresponding to the maximum product possible.
//      NOTE: Answer will fit in 32-bit integer value.
//      Problem Constraints
//1 <= N <= 5 * 105
//      -100 <= A[i] <= 100
//  Input Format
//  First and only argument is an integer array A.
//      Output Format
//  Return an integer corresponding to the maximum product possible.
//      Example Input
//  Input 1:
//  A = [4, 2, -5, 1]
//  Input 2:
//  A = [-3, 0, -5, 0]
//  Example Output
//  DocFinder.Output 1:
//      8
//  Output 2:
//      0
//  Example Explanation
//  Explanation 1:
//  We can choose the subarray [4, 2] such that the maximum product is 8.
//  Explanation 2:
//      0 will be the maximum product possible.
  public int maxProduct_(final int[] A) {
    int prod = 1;
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      ans = Math.max(ans, Math.max(A[i], A[i] * prod));
      if (A[i] * prod < prod) {
        prod = 1;
      } else {
        prod = prod * A[i];
      }
    }
    return ans;
  }

  public int maxProduct(final int[] A) {
    int prod = 1;
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      prod = prod * A[i];
      ans = Math.max(prod, ans);
      if (prod == 0) {
        prod = 1;
      }
    }
    int ans2 = Integer.MIN_VALUE;
    prod = 1;
    for (int i = A.length - 1; i >= 0; i--) {
      prod = prod * A[i];
      ans2 = Math.max(prod, ans2);
      if (prod == 0) {
        prod = 1;
      }
    }
    return Math.max(ans, ans2);
  }

  public static void main(String[] args) {
    int[] input1A = {4, 2, -5, 1};
    System.out.println(new HWQ2MaxProductSubarray().maxProduct(input1A));
    int[] input2A = {-3, 0, -5, 0};
    System.out.println(new HWQ2MaxProductSubarray().maxProduct(input2A));
    int[] input3A = {0, 0, -2, 0, 1, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, -3, 0, 0,
        0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 2, -3, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0,
        -3, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, -2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 1, 0, 0, -3, 0, -3, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 0, 0, -1, 0, 2, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 2, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -3, -2, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, -2, 0, 0, -2, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 3, 0, 0, 0, 0,
        1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, -3,
        0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 0,
        0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 2, 0, 0, 0, 0, 0, -1, 0, 0, 0, 1, 0, 0, 0, 0, 0,
        0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        2, 0, 0, 0, 0, 0, 0, -2, 0, -1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 1, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0,
        3, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, -3, 0, 0, 0, 0, 0,
        0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0};
    System.out.println(new HWQ2MaxProductSubarray().maxProduct(input3A));
  }
}