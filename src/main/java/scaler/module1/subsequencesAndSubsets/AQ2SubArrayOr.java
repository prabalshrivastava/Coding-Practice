package scaler.module1.subsequencesAndSubsets;


import static scaler.common.CommonUtils.getModdedIntSum;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import scaler.common.CommonUtils;

public class AQ2SubArrayOr {

  //  Problem Description
//  You are given an array of integers A of size N.
//  The value of a subarray is defined as BITWISE OR of all elements in it.
//  Return the sum of value of all subarrays of A % 109 + 7.
//  Problem Constraints
//1 <= N <= 105
//      1 <= A[i] <= 108
//  Input Format
//  The first argument given is the integer array A.
//      Output Format
//  Return the sum of Value of all subarrays of A % 109 + 7.
//  Example Input
//  Input 1:
//  A = [1, 2, 3, 4, 5]
//  Input 2:
//  A = [7, 8, 9, 10]
//  Example Output
//  DocFinder.Output 1:
//      71
//  Output 2:
//      110
//  Example Explanation
//  Explanation 1:
//  Value([1]) = 1
//  Value([1, 2]) = 3
//  Value([1, 2, 3]) = 3
//  Value([1, 2, 3, 4]) = 7
//  Value([1, 2, 3, 4, 5]) = 7
//  Value([2]) = 2
//  Value([2, 3]) = 3
//  Value([2, 3, 4]) = 7
//  Value([2, 3, 4, 5]) = 7
//  Value([3]) = 3
//  Value([3, 4]) = 7
//  Value([3, 4, 5]) = 7
//  Value([4]) = 4
//  Value([4, 5]) = 5
//  Value([5]) = 5
//  Sum of all these values = 71
//  Explanation 2:
//  Sum of value of all subarray is 110.
  public static void main(String[] args) {
    int[] input1A = {1, 2, 3, 4, 5};
    System.out.println(new AQ2SubArrayOr().solve(input1A));
    int[] input2A = {7, 8, 9, 10};
    System.out.println(new AQ2SubArrayOr().solve(input2A));
  }

  public int solve(int[] A) {
    return 0;
  }

  public int solveBruteForce(int[] A) {
    int sum = 0;
    for (int slidingWindowSize = 1; slidingWindowSize <= A.length; slidingWindowSize++) {
      for (int startingPoints = 0; startingPoints < A.length - slidingWindowSize + 1;
          startingPoints++) {
        int subArrayOr = 0;
        for (int k = startingPoints; k < startingPoints + slidingWindowSize; k++) {
          subArrayOr = subArrayOr | A[k];
          System.out.printf("%s", A[k]);
        }
        sum = getModdedIntSum(sum + subArrayOr);
        System.out.println("->" + subArrayOr);
      }
    }
    return sum;
  }
}