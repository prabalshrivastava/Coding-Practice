package scaler.module1.arrays.prefixsum;

public class AQ1EquilibriumIndexOfAnArray {
  //  Problem Description
  //  You are given an array A of integers of size N.
  //  Your task is to find the equilibrium index of the given array
  //  The equilibrium index of an array is an index such that the sum of elements at lower indexes
  // is equal to the sum of elements at higher indexes.
  //  NOTE:
  //  Array indexing starts from 0.
  //  If there is no equilibrium index then return -1.
  //  If there are more than one equilibrium indexes then return the minimum index.
  //      Problem Constraints
  // 1 <= N <= 105
  //      -105 <= A[i] <= 105
  //  Input Format
  //  First arugment is an array A .
  //  Output Format
  //  Return the equilibrium index of the given array. If no such index is found then return -1.
  //  Example Input
  //  Input 1:
  //  A=[-7, 1, 5, 2, -4, 3, 0]
  //  Input 2:
  //  A=[1,2,3]
  //  Example Output
  //  Output 1:
  //      3
  //  Output 2:
  //      -1
  //  Example Explanation
  //  Explanation 1:
  //      3 is an equilibrium index, because:
  //  A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
  //  Explanation 1:
  //  There is no such index.

  public static void main(String[] args) {
    int[] A = {-7, 1, 5, 2, -4, 3, 0};
    //    System.out.println(new AQ1EquilibriumIndexOfAnArray().solve(A));
    int[] B = new int[] {1, 2, 3, 7, 1, 2, 3};
    System.out.println(new AQ1EquilibriumIndexOfAnArray().solve(B));
  }

  public int solve(int[] A) {

    int[] pfSum = new int[A.length];
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum = sum + A[i];
      pfSum[i] = sum;
    }
//    System.out.println(Arrays.toString(pfSum));

    int count = -1;
    for (int i = 0; i < pfSum.length; i++) {
      if (i == 0) {
        if (0 == pfSum[pfSum.length - 1] - pfSum[i]) {
          count = i;
        }
      } else {
//        System.out.println(
//            "pfSum[i-1] == pfSum[pfSum.length-1] - pfSum[i] :->  "
//                + pfSum[i - 1]
//                + " == "
//                + pfSum[pfSum.length - 1]
//                + " - "
//                + pfSum[i]
//                + "\t\t\t ->\t\t\t"
//                + +pfSum[i - 1]
//                + " == "
//                + (pfSum[pfSum.length - 1] - pfSum[i])
//                + " ==> "
//                + (pfSum[i - 1] == pfSum[pfSum.length - 1] - pfSum[i]));
        if (pfSum[i - 1] == pfSum[pfSum.length - 1] - pfSum[i]) {
          count = i;
        }
      }
    }

    //    System.out.println(count);
    return count;
  }
}
