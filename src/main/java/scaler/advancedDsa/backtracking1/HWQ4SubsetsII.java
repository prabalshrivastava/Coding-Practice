package scaler.advancedDsa.backtracking1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class HWQ4SubsetsII {

//  Problem Description
//  Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
//      NOTE:
//  Elements in a subset must be in non-descending order.
//  The solution set must not contain duplicate subsets.
//  The subsets must be sorted lexicographically.
//  Problem Constraints
//0 <= N <= 16
//  Input Format
//  Only argument is an integer array A of size N.
//  Output Format
//  Return a 2-D vector denoting all the possible subsets.
//      Example Input
//  Input 1:
//  A = [1, 2, 2]
//  Input 2:
//  A = [1, 1]
//  Example Output
//  DocFinder.Output 1:
//      [
//      [],
//      [1],
//      [1, 2],
//      [1, 2, 2],
//      [2],
//      [2, 2]
//      ]
//  Output 2:
//      [
//      [],
//      [1],
//      [1, 1]
//      ]
//  Example Explanation
//  Explanation 1:
//  All the subsets of the array [1, 2, 2] in lexicographically sorted order.

  List<List<Integer>> ans = new ArrayList<>();
  Stack<Integer> tempList = new Stack<>();

  public int[][] subsetsWithDup(int[] A) {
    Arrays.sort(A);
    allPossibleSubsets(A, 0);
//    System.out.println(ans);
//    ans.stream().forEach(integers -> integers.stream().sorted(Comparator.comparingInt(o -> o)));
    for (List<Integer> an : ans) {
      Collections.sort(an);
    }
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
    int[][] arr = new int[ans.size()][];
    for (int i = 0; i < ans.size(); i++) {
      arr[i] = new int[ans.get(i).size()];
      for (int j = 0; j < ans.get(i).size(); j++) {
        arr[i][j] = ans.get(i).get(j);
      }
    }
    return arr;
  }

  private void allPossibleSubsets(int[] subsets, int idx) {
    if (idx == subsets.length) {
      ans.add(new ArrayList<>(tempList));
      return;
    }

    //include
    tempList.push(subsets[idx]);
    allPossibleSubsets(subsets, idx + 1);
    tempList.pop();

    //not include
    //make sure the current element is not included anytime
    int currentVal = subsets[idx];
    while (idx + 1 < subsets.length && subsets[idx + 1] == currentVal) {
      idx++;
      //keep checking if element is a duplicate and if it is keep on skipping the element.
    }
    allPossibleSubsets(subsets, idx + 1);
  }

  public static void main(String[] args) {
    int[] input1A = {1, 2, 2};
    System.out.println(Arrays.deepToString(new HWQ4SubsetsII().subsetsWithDup(input1A)));
    int[] input2A = {1, 1};
    System.out.println(Arrays.deepToString(new HWQ4SubsetsII().subsetsWithDup(input2A)));
  }

}