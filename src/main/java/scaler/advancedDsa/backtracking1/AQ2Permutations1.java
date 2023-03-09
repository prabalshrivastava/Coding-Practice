package scaler.advancedDsa.backtracking1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import scaler.common.CommonUtils;

public class AQ2Permutations1 {

  //  Problem Description
//  Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
//  NOTE: No 2 entries in the permutation sequence should be the same.
//      WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
//  Example : next_permutations in C++ / itertools.permutations in python.
//  If you do, we will disqualify your submission retroactively and give you penalty points.
//      Problem Constraints
//1 <= |A| <= 9
//      0 <= A[i] <= 10
//  Input Format
//  Only argument is an integer array A of size N.
//  Output Format
//  Return a 2-D array denoting all possible unique permutation of the array.
//  Example Input
//  Input 1:
//  A = [1, 1, 2]
//  Input 2:
//  A = [1, 2]
//  Example Output
//  DocFinder.Output 1:
//      [ [1,1,2]
//      [1,2,1]
//      [2,1,1] ]
//  Output 2:
//      [ [1, 2]
//      [2, 1] ]
//  Example Explanation
//  Explanation 1:
//  All the possible unique permutation of array [1, 1, 2].
//  Explanation 2:
//  All the possible unique permutation of array [1, 2].
  public static void main(String[] args) {
    int[] input1A = {1, 1, 2};
    System.out.println(Arrays.deepToString(new AQ2Permutations1().permute(input1A)));
    int[] input2A = {1, 2};
    System.out.println(Arrays.deepToString(new AQ2Permutations1().permute(input2A)));
    int[] input3A = {10, 9, 10, 9, 10};
    System.out.println(Arrays.deepToString(new AQ2Permutations1().permute(input3A)));
    int[] input4A = {1, 2, 3};
    System.out.println(Arrays.deepToString(new AQ2Permutations1().permute(input4A)));
    System.out.println();
  }

  List<List<Integer>> result = new ArrayList<>();

  public int[][] permute(int[] A) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    }
    permutation(A, 0);
    int[][] resArr = new int[result.size()][];
    for (int i = 0; i < result.size(); i++) {
      resArr[i] = new int[result.get(i).size()];
      for (int j = 0; j < result.get(i).size(); j++) {
        resArr[i][j] = result.get(i).get(j);
      }
    }
    return resArr;
  }


  private void permutation(int[] A, int idx) {
    if (idx == A.length) {
      result.add(CommonUtils.arrayToList(A));
      return;
    }
//    System.out.println(Arrays.toString(A));
    for (int i = idx; i < A.length; i++) {
      CommonUtils.swap(A, idx, i);
      permutation(A, idx + 1);
      CommonUtils.swap(A, i, idx);
    }
  }
}