package scaler.advancedDsa.backtracking1;

import java.util.Arrays;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Output;

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
  }

  public int[][] permute(int[] A) {
    return new int[0][];
  }
}