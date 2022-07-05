package scaler.arrays.prefixsum;

import java.util.Arrays;

public class AQ2CountWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAnArrayElement {
  //  Problem Description
  //  Given an array, arr[] of size N, the task is to find the count of array indices such that
  // removing an element from these indices makes the sum of even-indexed and odd-indexed array
  // elements equal.
  //  Problem Constraints
  // 1 <= n <= 105
  //      -105 <= A[i] <= 105
  //  Input Format
  //  First argument contains an array A of integers of size N
  //  Output Format
  //  Return the count of array indices such that removing an element from these indices makes the
  // sum of even-indexed and odd-indexed array elements equal.
  //  Example Input
  //  Input 1:
  //  A=[2, 1, 6, 4]
  //  Input 2:
  //  A=[1, 1, 1]
  //  Example Output
  //  Output 1:
  //      1
  //  Output 2:
  //      3
  //  Example Explanation
  //  Explanation 1:
  //  Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] =
  // arr[1].
  //  Therefore, the required output is 1.
  //  Explanation 2:
  //  Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
  //  Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
  //  Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
  //  Therefore, the required output is 3.

  public int solve(int[] A) {
    // calculate the prefix sum of even and odd elements of A
    int[] pfse = new int[A.length];
    int[] pfso = new int[A.length];

    for (int i = 0; i < A.length; i++) {
      if (i == 0) {
        pfso[i] = 0;
        pfse[i] = A[i];
        continue;
      }
      if (i % 2 == 0) {
        // even element
        pfse[i] = pfse[i - 1] + A[i];
        pfso[i] = pfso[i - 1];
      } else {
        // odd element
        pfso[i] = pfso[i - 1] + A[i];
        pfse[i] = pfse[i - 1];
      }
    }
    System.out.println(Arrays.toString(pfse));
    System.out.println(Arrays.toString(pfso));

    int count = 0;
    for (int i = 0; i < A.length; i++) {
      int totalEven;
      int totalOdd;
      if (i == 0) {
        totalEven = pfso[A.length - 1] - pfso[i];
        totalOdd = pfse[A.length - 1] - pfse[i];
      } else {
        totalEven = pfse[i - 1] + pfso[A.length - 1] - pfso[i];
        totalOdd = pfso[i - 1] + pfse[A.length - 1] - pfse[i];
      }
      if (totalEven == totalOdd) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] A = {2, 1, 6, 4};
    System.out.println(
        new AQ2CountWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAnArrayElement()
            .solve(A));
    int[] B = {1, 1, 1};
    System.out.println(
        new AQ2CountWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAnArrayElement()
            .solve(B));
    int[] C = {1, 2, 3, 7, 1, 2, 3};
    System.out.println(
        new AQ2CountWaysToMakeSumOfOddAndEvenIndexedElementsEqualByRemovingAnArrayElement()
            .solve(C));
  }
}
