package scaler.module1.arrays.introductiontoarrays;

import java.util.Arrays;

public class AQ4ReverseArray {
  //  Problem Description
  //  You are given a constant array A.
  //  You are required to return another array which is the reversed form of the input array.
  //      Problem Constraints
  // 1 <= A.size() <= 10000
  //    1 <= A[i] <= 10000
  //  Input Format
  //  First argument is a constant array A.
  //      Output Format
  //  Return an integer array.
  //  Example Input
  //  Input 1:
  //  A = [1,2,3,2,1]
  //  Input 2:
  //  A = [1,1,10]
  //  Example Output
  //  Output 1:
  //      [1,2,3,2,1]
  //  Output 2:
  //      [10,1,1]
  //  Example Explanation
  //  Explanation 1:
  //  Reversed form of input array is same as original array
  //  Explanation 2:
  //  Clearly, Reverse of [1,1,10] is [10,1,1]
  public static void main(String[] args) {
//    int A[] = {1, 2, 3, 2, 1};
    int A[] = {1,1,10};
    System.out.println(Arrays.toString(A));
    System.out.println(Arrays.toString(new AQ4ReverseArray().solve(A)));
  }

  public int[] solve(final int[] A) {
    int i = 0, j = A.length - 1;

    while (i < j) {
      int temp = A[i];
      A[i] = A[j];
      A[j] = temp;
//      System.out.println(A[i] + " --- " + A[j]);
      i++;
      j--;
    }
    return A;
  }
}
