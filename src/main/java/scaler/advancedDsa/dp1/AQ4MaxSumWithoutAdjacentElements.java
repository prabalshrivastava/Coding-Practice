package scaler.advancedDsa.dp1;

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Output;

public class AQ4MaxSumWithoutAdjacentElements {

  //  Problem Description
//  Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
//      Note: You can choose more than 2 numbers.
//      Problem Constraints
//1 <= N <= 20000
//      1 <= A[i] <= 2000
//  Input Format
//  The first and the only argument of input contains a 2d matrix, A.
//      Output Format
//  Return an integer, representing the maximum possible sum.
//      Example Input
//  Input 1:
//  A = [
//      [1]
//      [2]
//      ]
//  Input 2:
//  A = [
//      [1, 2, 3, 4]
//      [2, 3, 4, 5]
//      ]
//  Example Output
//  DocFinder.Output 1:
//      2
//  Output 2:
//      8
//  Example Explanation
//  Explanation 1:
//  We will choose 2.
//  Explanation 2:
//  We will choose 3 and 5.
  public static void main(String[] args) {
    int[][] input1A = {
        {1},
        {2}
    };
    System.out.println(new AQ4MaxSumWithoutAdjacentElements().adjacent(input1A));
    int[][] input2A = {
        {1, 2, 3, 4},
        {2, 3, 4, 5}
    };
    System.out.println(new AQ4MaxSumWithoutAdjacentElements().adjacent(input2A));
  }

  public int adjacent(int[][] A) {
    return 0;
  }
}