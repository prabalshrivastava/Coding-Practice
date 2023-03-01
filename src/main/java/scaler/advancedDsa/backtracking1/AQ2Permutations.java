package scaler.advancedDsa.backtracking1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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

  ArrayList<Integer> list = new ArrayList<>();

  public int[][] permute(int[] A) {
    HashSet<Integer> setOfIndexes = new HashSet<>();
    int fact = 1;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      list.add(A[i]);
      setOfIndexes.add(i);
      fact = fact * (i + 1);
    }
//    System.out.println(fact);
//    System.out.println(setOfIndexes);
    int[][] arr = new int[fact][A.length];

    permutations(list);
    return null;
  }

  private void permutations(List<Integer> a) {
//    if (a.size() == 1) {
//      System.out.println(a);
//      return;
//    }
    System.out.println("-->" + a);
    for (int i = 0; i < a.size(); i++) {
      Integer element = a.get(i);
      a.remove(element);
      permutations(a);
      a.add(element);
      System.out.println(a);
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(new AQ2Permutations().permute(new int[]{1, 2, 3})));
  }
}