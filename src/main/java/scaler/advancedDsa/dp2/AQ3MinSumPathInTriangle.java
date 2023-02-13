package scaler.advancedDsa.dp2;

import java.util.ArrayList;


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
    ArrayList<ArrayList<Integer>> input1AList = new ArrayList();
    for (int i = 0; i < input1A.length; i++) {
      ArrayList<Integer> arrayList = new ArrayList();
      for (int j = 0; j < input1A[i].length; j++) {
        arrayList.add(input1A[i][j]);
      }
      input1AList.add(arrayList);
    }
    int[][] input2A;
    System.out.println(new AQ3MinSumPathInTriangle().minimumTotal(input1AList));
    input2A = new int[][]{{1}};
//    System.out.println(new AQ3MinSumPathInTriangle().minimumTotal(input2A));

    int[][] input3A = {
        {9},
        {3, 8},
        {0, 2, 4},
        {8, 3, 9, 0},
        {5, 2, 2, 7, 3},
        {7, 9, 0, 2, 3, 9},
        {9, 7, 0, 3, 9, 8, 6},
        {5, 7, 6, 2, 7, 0, 3, 9}
    };
  }

  public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
    ArrayList<ArrayList<Integer>> dp = new ArrayList();
    for (int i = 0; i < a.size(); i++) {
      ArrayList<Integer> list = new ArrayList<>();
      for (int j = 0; j < a.get(i).size(); j++) {
        list.add(Integer.MAX_VALUE);
      }
      dp.add(list);
    }
    return findMin(a, dp, 0, 0);
  }

  private int findMin(ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> dp,
      int i, int j) {
    if (i == a.size() - 1) {
      return a.get(i).get(j);
    }
    if (dp.get(i).get(j) != Integer.MAX_VALUE) {
      return dp.get(i).get(j);
    }
    int min = a.get(i).get(j) + Math.min(findMin(a, dp, i + 1, j), findMin(a, dp, i + 1, j + 1));
    dp.get(i).set(j, min);
    return min;
  }
}