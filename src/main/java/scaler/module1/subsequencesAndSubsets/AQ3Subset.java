package scaler.module1.subsequencesAndSubsets;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AQ3Subset {

  //  Problem Description
//  Given a set of distinct integers A, return all possible subsets.
//      NOTE:
//  Elements in a subset must be in non-descending order.
//  The solution set must not contain duplicate subsets.
//  Also, the subsets should be sorted in ascending ( lexicographic ) order.
//  The list is not necessarily sorted.
//  Problem Constraints
//1 <= |A| <= 16
//  INTMIN <= A[i] <= INTMAX
//  Input Format
//  First and only argument of input contains a single integer array A.
//  DocFinder.Output Format
//  Return a vector of vectors denoting the answer.
//  Example Input
//  Input 1:
//  A = [1]
//  Input 2:
//  A = [1, 2, 3]
//  Example Output
//  Output 1:
//      [
//      []
//      [1]
//      ]
//  Output 2:
//      [
//      []
//      [1]
//      [1, 2]
//      [1, 2, 3]
//      [1, 3]
//      [2]
//      [2, 3]
//      [3]
//      ]
//  Example Explanation
//  Explanation 1:
//  You can see that these are all possible subsets.
//      Explanation 2:
//  You can see that these are all possible subsets.
  public static void main(String[] args) {
    int[] input1A = {1};
    System.out.println(Arrays.deepToString(new AQ3Subset().subsets(input1A)));
    int[] input2A = {1, 2, 3};
    System.out.println(Arrays.deepToString(new AQ3Subset().subsets(input2A)));
    int[] input3A = {9, -20, -11, -8, -4, 2, -12, 14, 1, -18};
    System.out.println(Arrays.deepToString(new AQ3Subset().subsets(input3A)));
  }

  public int[][] subsets(int[] A) {
    Arrays.sort(A);
    int noOfSubsets = (int) Math.pow(2, A.length);
    int[][] subsets = new int[noOfSubsets][];
    for (int i = 0; i < noOfSubsets; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < A.length; j++) {
        if (((1 << j) & i) != 0) {
          row.add(A[j]);
        }
      }
      subsets[i] = row.stream().mapToInt(value -> value).toArray();
    }
    Arrays.sort(subsets, (a, b) -> {
      for (int i = 0; i < Math.min(a.length, b.length); i++) {
        if (a[i] != b[i]) {
          return Integer.compare(a[i], b[i]);
        }
      }
      return Integer.compare(a.length, b.length);
    });
    return subsets;
  }
}