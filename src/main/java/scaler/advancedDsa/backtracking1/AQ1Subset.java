package scaler.advancedDsa.backtracking1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AQ1Subset {

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
  public int[][] subsets(int[] A) {
    List<List<Integer>> ans = allPossibleSubsets(A, A.length, new ArrayList<>());
//    System.out.println(ans);
//    ans.stream().forEach(integers -> integers.stream().sorted(Comparator.comparingInt(o -> o)));
    ans.forEach(Collections::sort);
    ans.sort((o1, o2) -> {
      int size1 = o1.size();
      int size2 = o2.size();
      int minSize = Math.min(size1, size2);
      for (int i = 0; i < minSize; i++) {
        int result = o1.get(i).compareTo(o2.get(i));
        if (result != 0) {
          return result;
        }
      }
      return size1 - size2;
    });
    int[][] arr = new int[(int) Math.pow(2, A.length)][];
    for (int i = 0; i < ans.size(); i++) {
      arr[i] = new int[ans.get(i).size()];
      for (int j = 0; j < ans.get(i).size(); j++) {
        arr[i][j] = ans.get(i).get(j);
      }
    }
    return arr;
  }

  private List<List<Integer>> allPossibleSubsets(int[] subsets, int noOfElements,
      List<Integer> elementList) {
    List<List<Integer>> ans = new ArrayList<>();
    if (noOfElements == 0) {
      ans.add(elementList);
      return ans;
    }
    //include
    List<Integer> includeList = new ArrayList<>(elementList);
    includeList.add(subsets[noOfElements - 1]);
    ans.addAll(allPossibleSubsets(subsets, noOfElements - 1, includeList));

    List<Integer> excludeList = new ArrayList<>(elementList);
    ans.addAll(allPossibleSubsets(subsets, noOfElements - 1, excludeList));

    return ans;
  }

  public static void main(String[] args) {
    int[] input1A = {1};
    System.out.println(Arrays.deepToString(new AQ1Subset().subsets(input1A)));
    int[] input2A = {1, 2, 3};
    System.out.println(Arrays.deepToString(new AQ1Subset().subsets(input2A)));
    int[] input3A = {9, -20, -11, -8, -4, 2, -12, 14, 1, -18};
    System.out.println(Arrays.deepToString(new AQ1Subset().subsets(input3A)));
  }
}