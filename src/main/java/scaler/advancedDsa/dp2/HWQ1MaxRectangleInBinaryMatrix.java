package scaler.advancedDsa.dp2;

import java.util.Arrays;
import java.util.Stack;

//Problem Description
//    Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.
//    Problem Constraints
//    1 <= N, M <= 100
//    Input Format
//    The first argument is a 2-D binary array A.
//    Output Format
//    Return an integer denoting the area of the largest rectangle containing only ones.
//    Example Input
//    Input 1:
//    A = [
//    [1, 1, 1]
//    [0, 1, 1]
//    [1, 0, 0]
//    ]
//    Input 2:
//    A = [
//    [0, 1, 0]
//    [1, 1, 1]
//    ]
//    Example Output
//    Output 1:
//    4
//    Output 2:
//    3
//    Example Explanation
//    Explanation 1:
//    As the max area rectangle is created by the 2x2 rectangle created by (0, 1), (0, 2), (1, 1) and (1, 2).
//    Explanation 2:
//    As the max area rectangle is created by the 1x3 rectangle created by (1, 0), (1, 1) and (1, 2).
public class HWQ1MaxRectangleInBinaryMatrix {

  public static void main(String[] args) {
    int[][] input1A = {{0, 0, 1}, {0, 1, 1}, {1, 1, 1}};
    System.out.println(new HWQ1MaxRectangleInBinaryMatrix().maximalRectangle(input1A));

    int[][] input2A = {{0, 1, 0, 1}, {1, 0, 1, 0}};
    System.out.println(new HWQ1MaxRectangleInBinaryMatrix().maximalRectangle(input2A));

    int[][] input3A = {{0, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
    System.out.println(new HWQ1MaxRectangleInBinaryMatrix().maximalRectangle(input3A));
  }

  public int maximalRectangle(int[][] A) {
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