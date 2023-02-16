package leetcode;

import java.util.Stack;

public class Q85MaximalRectangle {

  //  Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//  Example 1:
//  Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//  Output: 6
//  Explanation: The maximal rectangle is shown in the above picture.
//      Example 2:
//  Input: matrix = [["0"]]
//  Output: 0
//  Example 3:
//  Input: matrix = [["1"]]
//  Output: 1
//  Constraints:
//  rows == matrix.length
//  cols == matrix[i].length
//1 <= row, cols <= 200
//  matrix[i][j] is '0' or '1'.
  public static void main(String[] args) {
    char[][] input1A = {{'0', '0', '1'}, {'0', '1', '1'}, {'1', '1', '1'}};
    System.out.println(new Q85MaximalRectangle().maximalRectangle(input1A));

    char[][] input2A = {{'0', '1', '0', '1'}, {'1', '0', '1', '0'}};
    System.out.println(new Q85MaximalRectangle().maximalRectangle(input2A));

    char[][] input3A = {{'0', '1', '0', '1'}, {'1', '1', '1', '1'}, {'1', '1', '0', '0'}};
    System.out.println(new Q85MaximalRectangle().maximalRectangle(input3A));
  }

  public int maximalRectangle(char[][] matrix) {
    int[][] A = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        A[i][j] = matrix[i][j] - '0';
      }
    }
    int ans = largestRectangleArea(A[0]);
    for (int i = 1; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        if (A[i][j] != 0) {
          A[i][j] = A[i][j] + A[i - 1][j];
        }
      }
      ans = Math.max(ans, largestRectangleArea(A[i]));
    }
//    System.out.println(Arrays.deepToString(A));
    return ans;
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