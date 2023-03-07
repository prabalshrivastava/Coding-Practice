package scaler.advancedDsa.backtracking1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AQ4AllUniquePermutations {

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
    System.out.println(Arrays.deepToString(new AQ4AllUniquePermutations().permute(input1A)));
    int[] input2A = {1, 2};
    System.out.println(Arrays.deepToString(new AQ4AllUniquePermutations().permute(input2A)));
    int[] input3A = {10, 9, 10, 9, 10};
    System.out.println(Arrays.deepToString(new AQ4AllUniquePermutations().permute(input3A)));
  }

  public int[][] permute(int[] A) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      list.add(A[i]);
    }
    Collections.sort(list);
    List<List<Integer>> res = permutation(list);
    int[][] arr = new int[res.size()][];
    for (int i = 0; i < res.size(); i++) {
      arr[i] = new int[res.get(i).size()];
      for (int j = 0; j < res.get(i).size(); j++) {
        arr[i][j] = res.get(i).get(j);
      }
    }
    return arr;
  }


  private List<List<Integer>> permutation(List<Integer> list) {
    List<List<Integer>> result = new ArrayList<>();
//    System.out.println(list);
    if (list.size() == 1) {
      List<Integer> list1 = new ArrayList<>(list);
      return Collections.singletonList(list1);
    }
    List<List<Integer>> permutation = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      List<Integer> copyList = new ArrayList<>(list);
      Integer element = copyList.get(i);
      while (i + 1 < list.size() && list.get(i + 1).equals(element)) {
        i++;
      }
//      System.out.println("removing : " + element + " -> " + copyList);
      copyList.remove(element);
      permutation = permutation(copyList);
//      System.out.println("permutation : " + permutation);
      for (int j = 0; j < permutation.size(); j++) {
        permutation.get(j).add(element);
      }
//      System.out.println("after adding permutation : " + permutation);
      result.addAll(permutation);
      copyList.add(element);
//      System.out.println("\n\n\n");
    }
    return result;
  }
}