package scaler.advancedDsa.bitmanipulations2;

public class HWQ5CountTotalSetBits {

  //    Problem Description
//    Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.
//    Return the count modulo 109 + 7.
//    Problem Constraints
//1 <= A <= 109
//    Input Format
//    First and only argument is an integer A.
//    Output Format
//    Return an integer denoting the ( Total number of set bits in the binary representation of all the numbers from 1 to A )modulo 109 + 7.
//    Example Input
//    Input 1:
//    A = 3
//    Input 2:
//    A = 1
//    Example Output
//    Output 1:
//            4
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    DECIMAL    BINARY  SET BIT COUNT
//    1          01        1
//            2          10        1
//            3          11        2
//            1 + 1 + 2 = 4
//    Answer = 4 % 1000000007 = 4
//    Explanation 2:
//    A = 1
//    DECIMAL    BINARY  SET BIT COUNT
//    1          01        1
//    Answer = 1 % 1000000007 = 1
  public int solveTLE(int A) {
    int count = 0;
    for (int i = 1; i <= A; i++) {
//      System.out.printf("i[%s]-> j", i);
      for (int j = 1; j <= 32; j++) {
        if ((1 << j & i) != 0) {
          count = (count + 1) % 1000000007;
//          System.out.printf("[%s]", j);
        }
      }
//      System.out.println("");
    }
    return count;
  }

  public int solve(int A) {
    if (A == 0) {
      return 0;
    }
    long x = largestPowerOf2InRange(A);
    long bitsUpto2RaiseToPower = x * (1L << (x - 1));
    long msb = A - (1L << x) + 1;
    long rest = A - (1L << x);
    return (int) ((bitsUpto2RaiseToPower + msb + solve((int) rest)) % 1000000007);
  }

  public static long largestPowerOf2InRange(int n) {
    long x = 0;
    while ((1 << x) <= n) {
      x++;
    }
    return x - 1;
  }

  public static void main(String[] args) {
    System.out.println(new HWQ5CountTotalSetBits().solve(3));
    System.out.println(new HWQ5CountTotalSetBits().solve(1));
    System.out.println(new HWQ5CountTotalSetBits().solve(20));
    System.out.println(new HWQ5CountTotalSetBits().solve(100000000));//314447109
  }
}