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
    int[] input4A = {1, 1};
    System.out.println(new Q84LargestRectangleInHistogram().largestRectangleArea(input4A));
  }

  public int largestRectangleArea(int[] heights) {
    int[] nearestLeftSmallestArr = new int[heights.length];
    int[] nearestRightSmallestArr = new int[heights.length];

    Stack<Integer> nearestLeftSmallestStack = new Stack<>();
    Stack<Integer> nearestRightSmallestStack = new Stack<>();

    for (int i = 0; i < heights.length; i++) {
      if (nearestLeftSmallestStack.isEmpty()) {
        nearestLeftSmallestArr[i] = -1;
      } else {
        if (heights[nearestLeftSmallestStack.peek()] < heights[i]) {
          nearestLeftSmallestArr[i] = nearestLeftSmallestStack.peek();
        } else {
          while (!nearestLeftSmallestStack.isEmpty()
              && heights[nearestLeftSmallestStack.peek()] >= heights[i]) {
            nearestLeftSmallestStack.pop();
          }
          if (!nearestLeftSmallestStack.isEmpty()) {
            nearestLeftSmallestArr[i] = nearestLeftSmallestStack.peek();
          } else {
            nearestLeftSmallestArr[i] = -1;
          }
        }
      }
      nearestLeftSmallestStack.push(i);
    }
    for (int i = heights.length - 1; i >= 0; i--) {
      if (nearestRightSmallestStack.isEmpty()) {
        nearestRightSmallestArr[i] = heights.length;
      } else {
        if (heights[nearestRightSmallestStack.peek()] < heights[i]) {
          nearestRightSmallestArr[i] = nearestRightSmallestStack.peek();
        } else {
          while (!nearestRightSmallestStack.isEmpty()
              && heights[nearestRightSmallestStack.peek()] >= heights[i]) {
            nearestRightSmallestStack.pop();
          }
          if (nearestRightSmallestStack.isEmpty()) {
            nearestRightSmallestArr[i] = heights.length;
          } else {
            nearestRightSmallestArr[i] = nearestRightSmallestStack.peek();
          }
        }
      }
      nearestRightSmallestStack.push(i);
    }
//    System.out.println(Arrays.toString(heights));
//    System.out.println(Arrays.toString(nearestLeftSmallestArr));
//    System.out.println(Arrays.toString(nearestRightSmallestArr));
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < heights.length; i++) {
      int leftIndex = nearestLeftSmallestArr[i] + 1;
      int rightIndex = nearestRightSmallestArr[i] - 1;
      int width = rightIndex - leftIndex + 1;
//      System.out.printf("rightIndex(%s)-leftIndex(%s)+1=width(%s)", rightIndex, leftIndex, width);

      if (rightIndex >= leftIndex) {
        int height = heights[i];
//        int height = Math.min(heights[leftIndex], heights[rightIndex]);
//        System.out.printf(" | Math.min(heights[%s], heights[%s])=height(%s)%n", leftIndex,
//            rightIndex, height);
        ans = Math.max(ans, height * width);
      } else {
//        System.out.println("skipping");
      }
    }
    return ans;
  }
}