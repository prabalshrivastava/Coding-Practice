package scaler.advancedDsa.dp2;

import java.util.ArrayList;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Output;

public class AQ3MinSumPathInTriangle {
//  Problem Description
//  Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//  Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is
//  Problem Constraints
//|A| <= 1000
//  A[i] <= 1000
//  Input Format
//  First and only argument is the vector of vector A defining the given triangle
//  Output Format
//  Return the minimum sum
//  Example Input
//  Input 1:
//  A = [
//      [2],
//      [3, 4],
//      [6, 5, 7],
//      [4, 1, 8, 3]
//      ]
//  Input 2:
//  A = [ [1] ]
//  Example Output
//  DocFinder.Output 1:
//      11
//  Output 2:
//      1
//  Example Explanation
//  Explanation 1:
//  The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//  Explanation 2:
//  Only 2 can be collected.

  public static void main(String[] args) {
    int[][] input1A = {
        {2},
        {3, 4},
        {6, 5, 7},
        {4, 1, 8, 3}
    };
    int[][] input2A = new int[0][];
    System.out.println(new AQ3MinSumPathInTriangle().minimumTotal(input1A));
//    input2A = new int[][]{{1}};
//    System.out.println(new AQ3MinSumPathInTriangle().minimumTotal(input2A));
  }

  public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
  }
}