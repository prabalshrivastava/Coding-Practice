package scaler.advancedDsa.dp1;

public class HWQ1MaximumSumValue {

  //  Problem Description
//  You are given an array A of N integers and three integers B, C, and D.
//  You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
//      Problem Constraints
//1 <= N <= 105
//      -10000 <= A[i], B, C, D <= 10000
//  Input Format
//  First argument is an array A
//  Second argument is an integer B
//  Third argument is an integer C
//  Fourth argument is an integer D
//  Output Format
//  Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.
//      Example Input
//  Input 1:
//  A = [1, 5, -3, 4, -2]
//  B = 2
//  C = 1
//  D = -1
//  Input 2:
//  A = [3, 2, 1]
//  B = 1
//  C = -10
//  D = 3
//  Example Output
//  DocFinder.Output 1:
//      18
//  Output 2:
//      -4
//  Example Explanation
//  Explanation 1:
//  If you choose i = 2, j = 2, and k = 3 then we will get
//  A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18
//  Explanation 2:
//  If you choose i = 1, j = 3, and k = 3 then we will get
//  A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) = 3 - 10 + 3 = -4
  public static void main(String[] args) {

    int[] input3A = new int[]{1, 5, -3, 4, -2};
    int input3B = 2;
    int input3C = 1;
    int input3D = -1;
    System.out.println(new HWQ1MaximumSumValue().solve(input3A, input3B, input3C, input3D));

    int[] input2A = new int[]{3, 2, 1};
    int input2B = 1;
    int input2C = -10;
    int input2D = 3;
    System.out.println(new HWQ1MaximumSumValue().solve(input2A, input2B, input2C, input2D));

    int a[] = {-1, -2, -3, -4, -5};
    int x = 1, y = 2, z = -3;
    System.out.println(new HWQ1MaximumSumValue().solve(a, x, y, z));//12

    int[] A = {-21, 34, 3, 46, 8, -47, -47};
    int B = -13;
    int C = 10;
    int D = 9;
    System.out.println(new HWQ1MaximumSumValue().solve(A, B, C, D));//1147
  }

  public int solve_WrongSolution(int[] A, int B, int C, int D) {
    int[][] dp = new int[3][A.length];
    for (int i = 0; i < A.length; i++) {
      dp[0][i] = A[i] * B;
      dp[1][i] = A[i] * C;
      dp[2][i] = A[i] * D;
    }
    int max0 = Integer.MIN_VALUE;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    for (int i = 0; i < dp[0].length; i++) {
      max0 = Math.max(max0, dp[0][i]);
      max1 = Math.max(max1, dp[1][i]);
      max2 = Math.max(max2, dp[2][i]);
    }
    return max0 + max1 + max2;
  }

  public int solve_wrongSolution(int[] A, int B, int C, int D) {
    int max0 = Integer.MIN_VALUE;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      max0 = Math.max(max0, A[i] * B);
      max1 = Math.max(max1, A[i] * C);
      max2 = Math.max(max2, A[i] * D);
    }
    return max0 + max1 + max2;
  }

  public int solve(int[] A, int B, int C, int D) {
    int[][] dp = new int[3][A.length];
    dp[0][0] = A[0] * B;
    dp[1][0] = dp[0][0] + A[0] * C;
    dp[2][0] = dp[1][0] + A[0] * D;
    for (int i = 1; i < A.length; i++) {
      dp[0][i] = Math.max(dp[0][i - 1], A[i] * B);
      dp[1][i] = Math.max(dp[1][i - 1], dp[0][i] + A[i] * C);
      dp[2][i] = Math.max(dp[2][i - 1], dp[1][i] + A[i] * D);
    }
    return dp[2][A.length - 1];
  }
}