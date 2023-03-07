package scaler.advancedDsa.backtracking1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class AQ2Permutations {

  //  Problem Description
//  Given an integer array A of size N denoting collection of numbers , return all possible permutations.
//      NOTE:
//  No two entries in the permutation sequence should be the same.
//  For the purpose of this problem, assume that all the numbers in the collection are unique.
//  Return the answer in any order
//  WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
//  Example : next_permutations in C++ / itertools.permutations in python.
//  If you do, we will disqualify your submission retroactively and give you penalty points.
//      Problem Constraints
//1 <= N <= 9
//  Input Format
//  Only argument is an integer array A of size N.
//  DocFinder.Output Format
//  Return a 2-D array denoting all possible permutation of the array.
//      Example Input
//  A = [1, 2, 3]
//  Example Output
//[ [1, 2, 3]
//    [1, 3, 2]
//    [2, 1, 3]
//    [2, 3, 1]
//    [3, 1, 2]
//    [3, 2, 1] ]
//  Example Explanation
//  All the possible permutation of array [1, 2, 3].


  public int[][] permute(int[] A) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      list.add(A[i]);
    }
    List<List<Integer>> res = permutations(list);
    int[][] arr = new int[res.size()][];
    for (int i = 0; i < res.size(); i++) {
      arr[i] = new int[res.get(i).size()];
      for (int j = 0; j < res.get(i).size(); j++) {
        arr[i][j] = res.get(i).get(j);
      }
    }
    return arr;
  }

  private List<List<Integer>> permutations(List<Integer> nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.size() == 1) {
      List<Integer> list = new ArrayList<>(nums);
//      System.out.println(list);
      return Collections.singletonList(list);
    }
    List<List<Integer>> permutations;
//    result.add(new ArrayList<>(nums));
    for (int i = 0; i < nums.size(); i++) {
      List<Integer> copy = new ArrayList<>(nums);
      Integer element = copy.get(i);
//      System.out.println("removing " + element + " from " + copy);
      copy.remove(element);
      permutations = permutations(copy);
      for (int j = 0; j < permutations.size(); j++) {
//        System.out.print("adding : " + element + " to " + permutations);
        permutations.get(j).add(element);
//        System.out.println(" -> permutations : " + permutations);
      }
      result.addAll(permutations);
//      System.out.print("adding " + element + " to " + copy);
      copy.add(element);
//      System.out.println(" originalList : " + copy);
    }

//    System.out.println("result : " + result);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(new AQ2Permutations().permute(new int[]{1, 2, 3})));
    System.out.println(Arrays.deepToString(new AQ2Permutations().permute(new int[]{1, 1, 2})));
  }
}