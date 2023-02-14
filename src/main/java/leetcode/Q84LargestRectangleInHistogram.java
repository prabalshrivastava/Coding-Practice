package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Q84LargestRectangleInHistogram {

  //    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
//    Example 1:
//    Input: heights = [2,1,5,6,2,3]
//    Output: 10
//    Explanation: The above is a histogram where width of each bar is 1.
//    The largest rectangle is shown in the red area, which has an area = 10 units.
//        Example 2:
//    Input: heights = [2,4]
//    Output: 4
//    Constraints:
//        1 <= heights.length <= 105
//        0 <= heights[i] <= 104
  public static void main(String[] args) {
    int[] input1A = {2, 1, 5, 6, 2, 3};
    System.out.println(new Q84LargestRectangleInHistogram().largestRectangleArea(input1A));
    int[] input2A = {2};
    System.out.println(new Q84LargestRectangleInHistogram().largestRectangleArea(input2A));
    int[] input3A = {2, 1, 4, 7, 5, 2, 1, 3, 4, 5, 6, 4, 3, 2, 3, 1, 5, 6, 4, 2};
    System.out.println(new Q84LargestRectangleInHistogram().largestRectangleArea(input3A));
  }

  public int largestRectangleArea(int[] heights) {
    int leftSmallestIndex = 0;
    int rightSmallestIndex = heights.length - 1;
    int[] leftSmallestArr = new int[heights.length];
    int[] rightSmallestArr = new int[heights.length];
    for (int i = 0; i < heights.length; i++) {
      if (heights[leftSmallestIndex] > heights[i]) {
        leftSmallestIndex = i;
      }
      leftSmallestArr[i] = leftSmallestIndex;
    }
    for (int i = heights.length - 1; i >= 0; i--) {
      if (heights[rightSmallestIndex] > heights[i]) {
        rightSmallestIndex = i;
      }
      rightSmallestArr[i] = rightSmallestIndex;
    }
    System.out.println(Arrays.toString(leftSmallestArr));
    System.out.println(Arrays.toString(rightSmallestArr));
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < heights.length; i++) {
      max= Math.max(leftSmallestArr[i],leftSmallestArr[])
    }
    return 0;
  }
}