package scaler.advancedDsa.backtracking1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    int ans = 0;
    List<List<Integer>> permute = permute(A);
    for (int i = 0; i < permute.size(); i++) {
      boolean isSquareFul = true;
      if (permute.get(i).size() == 1) {
        int sum = permute.get(i).get(0);
        double sqrt = Math.sqrt(sum);
        if (sqrt != Math.floor(sqrt)) {
          isSquareFul = false;
        }
      }
      for (int j = 0; j < permute.get(i).size() - 1; j++) {
        int sum = permute.get(i).get(j) + permute.get(i).get(j + 1);
        double sqrt = Math.sqrt(sum);
        if (sqrt != Math.floor(sqrt)) {
          isSquareFul = false;
          break;
        }
      }
      if (isSquareFul) {
        ans++;
      }
    }
    return ans;
  }

  public List<List<Integer>> permute(int[] A) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      list.add(A[i]);
    }
    Collections.sort(list);
    return permutation(list);
  }


  private List<List<Integer>> permutation(List<Integer> list) {
    List<List<Integer>> result = new ArrayList<>();
    if (list.size() == 1) {
      List<Integer> list1 = new ArrayList<>(list);
      return Collections.singletonList(list1);
    }
    List<List<Integer>> permutation;
    for (int i = 0; i < list.size(); i++) {
      List<Integer> copyList = new ArrayList<>(list);
      Integer element = copyList.get(i);
//      while (i + 1 < list.size() && list.get(i + 1).equals(element)) {
//        i++;
//      }
      if (i > 0 && list.get(i - 1).equals(element)) {
        continue;
      }
      copyList.remove(element);
      permutation = permutation(copyList);
      for (int j = 0; j < permutation.size(); j++) {
        permutation.get(j).add(element);
      }
      result.addAll(permutation);
      copyList.add(element);
    }
    return result;
  }
}