package scaler.advancedDsa.backtracking1;

import static scaler.common.CommonUtils.arrayToList;
import static scaler.common.CommonUtils.swap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import scaler.common.CommonUtils;

public class HWQ1NumberOfSquarefulArrays2 {


  //  Problem Description
//  Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
//  Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
//  Problem Constraints
//1 <= length of the array <= 12
//      1 <= A[i] <= 109
//  Input Format
//  The only argument given is the integer array A.
//      Output Format
//  Return the number of permutations of A that are squareful.
//  Example Input
//  Input 1:
//  A = [2, 2, 2]
//  Input 2:
//  A = [1, 17, 8]
//  Example Output
//  DocFinder.Output 1:
//      1
//  Output 2:
//      2
//  Example Explanation
//  Explanation 1:
//  Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
//      Explanation 2:
//  Permutation are [1, 8, 17] and [17, 8, 1].
  public static void main(String[] args) {
    int[] input1A = {2, 2, 2};
    System.out.println(new HWQ1NumberOfSquarefulArrays2().solve(input1A));
    int[] input2A = {1, 17, 8};
    System.out.println(new HWQ1NumberOfSquarefulArrays2().solve(input2A));
    int[] input3A = {41};
    System.out.println(new HWQ1NumberOfSquarefulArrays2().solve(input3A));
    int[] input4A = {2262, 238, 123, 21, 15, 21, 4, 60, 40, 60, 40};
    System.out.println(new HWQ1NumberOfSquarefulArrays2().solve(input4A));
  }

  public int solve(int[] A) {
    permutation(A, 0);
    System.out.println(result);
    return result.size();
  }

  private int ans;
  List<List<Integer>> result = new ArrayList<>();


  private void permutation(int[] A, int idx) {
    Map<Integer, Integer> map = new HashMap<>();
    if (idx == A.length) {
      result.add(arrayToList(A));
      return;
    }
    for (int i = idx; i < A.length; i++) {
      if (map.containsKey(A[i])) {
        continue;
      }
      map.put(A[i], 1);
      if (isSquareFull(A[i], A[idx])) {
        swap(A, idx, i);
        permutation(A, idx + 1);
        swap(A, i, idx);
      }
    }
  }

  private boolean isSquareFull(long Ai, long Aidx) {
    long sum = Ai + Aidx;
    boolean isSquareFull = Math.sqrt(sum) == (long) Math.sqrt(sum);
//    System.out.printf("Ai=%s and Aidx=%s -> %s%n", Ai, Aidx, isSquareFull);
    return isSquareFull;
  }
}