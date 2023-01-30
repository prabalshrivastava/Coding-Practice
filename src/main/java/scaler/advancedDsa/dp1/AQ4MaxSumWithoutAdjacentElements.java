package scaler.advancedDsa.dp1;

import java.util.Arrays;

public class AQ4MaxSumWithoutAdjacentElements {

  //  Problem Description
//  Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
//      Note: You can choose more than 2 numbers.
//      Problem Constraints
//1 <= N <= 20000
//      1 <= A[i] <= 2000
//  Input Format
//  The first and the only argument of input contains a 2d matrix, A.
//      Output Format
//  Return an integer, representing the maximum possible sum.
//      Example Input
//  Input 1:
//  A = [
//      [1]
//      [2]
//      ]
//  Input 2:
//  A = [
//      [1, 2, 3, 4]
//      [2, 3, 4, 5]
//      ]
//  Example Output
//  DocFinder.Output 1:
//      2
//  Output 2:
//      8
//  Example Explanation
//  Explanation 1:
//  We will choose 2.
//  Explanation 2:
//  We will choose 3 and 5.
  public static void main(String[] args) {
    int[][] input1A = {{1}, {2}};
    System.out.println(new AQ4MaxSumWithoutAdjacentElements().adjacent(input1A));
    int[][] input2A = {{1, 2, 3, 4}, {2, 3, 4, 5}};
    System.out.println(new AQ4MaxSumWithoutAdjacentElements().adjacent(input2A));

    int[][] input3A = {{16, 5, 54, 55, 36, 82, 61, 77, 66, 61},
        {31, 30, 36, 70, 9, 37, 1, 11, 68, 14}};
    System.out.println(new AQ4MaxSumWithoutAdjacentElements().adjacent(input3A));

    int[][] input4A = {
        {2, 6, 6, 1, 16, 6, 15},
        {9, 16, 5, 4, 20, 3, 3}
    };
    System.out.println(new AQ4MaxSumWithoutAdjacentElements().adjacent(input4A));
    int[][] input5A = {
        {14, 10},
        {14, 12}
    };
    System.out.println(new AQ4MaxSumWithoutAdjacentElements().adjacent(input5A));
  }

  public int adjacent(int[][] A) {
    for (int j = 0; j < A[0].length; j++) {
      A[0][j] = Math.max(A[0][j], A[1][j]);
      A[1][j] = -1;
    }
//    System.out.println(Arrays.toString(arr));
    int max;
//    max = findMaxRecursiveTopDown(A, A[0].length - 1);
    max = findMaxIterativeBottomUp(A, A[0].length - 1);
//    System.out.println(Arrays.deepToString(A));
    return max;
  }

  private int findMaxIterativeBottomUp(int[][] A, int n) {
    if (A[0].length == 1) {
      return A[0][0];
    }
    if (A[0].length == 2) {
      return Math.max(A[0][0], A[0][1]);
    }

    A[1][0] = A[0][0];
    int ans = Math.max(A[0][0], A[0][1]);
    A[1][1] = ans;
//    System.out.println(ans);
    for (int i = 2; i < A[0].length; i++) {
      int alone = A[0][i];
      int excluded = A[1][i - 2];
      int included = A[0][i] + A[1][i - 2];
      A[1][i] = Math.max(ans, Math.max(Math.max(alone, excluded), included));
      ans = A[1][i];
//      System.out.println("ans : " + ans);
    }
    return A[1][A[0].length - 1];
  }


  private int findMaxRecursiveTopDown(int[][] A, int n) {
    if (A[1][n] != -1) {
      return A[1][n];
    }
    int ans = Integer.MIN_VALUE;
    for (int i = n; i >= 0; i--) {
      if (i - 2 >= 0) {
        ans = Math.max(ans, Math.max(Math.max(A[0][i], A[0][i] + findMaxRecursiveTopDown(A, i - 2)),
            findMaxRecursiveTopDown(A, i - 2)));
      } else {
        ans = Math.max(ans, A[0][i]);
      }
      A[1][n] = ans;
    }
    System.out.println("n : " + n + " -> ans : " + ans);
    return ans;
  }

  public int adjacent_tle(int[][] A) {
    int[] arr = new int[A[0].length];
    for (int j = 0; j < A[0].length; j++) {
      arr[j] = Math.max(A[0][j], A[1][j]);
    }
//    System.out.println(Arrays.toString(arr));
    return max(arr, arr.length - 1);
  }

  private int max(int[] A, int n) {
    int ans = Integer.MIN_VALUE;
    for (int i = n; i >= 0; i--) {
      if (i - 2 >= 0) {
        ans = Math.max(ans, Math.max(Math.max(A[i], A[i] + max(A, i - 2)), max(A, i - 2)));
      } else {
        ans = Math.max(ans, A[i]);
      }
    }
    return ans;
  }

  public int adjacent_failing(int[][] A) {
    int[] maxArr = new int[A[0].length];
    for (int j = 0; j < A[0].length; j++) {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < A.length; i++) {
        max = Math.max(A[i][j], max);
      }
      maxArr[j] = max;
    }
    System.out.println(Arrays.toString(maxArr));
    int[] leftMax = new int[A[0].length];
    int[] rightMax = new int[A[0].length];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < maxArr.length; i++) {
      leftMax[i] = Math.max(max, maxArr[i]);
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < maxArr.length; i++) {
      rightMax[i] = Math.min(min, maxArr[i]);
    }
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < maxArr.length; i++) {
      if (i >= 2) {
        ans = Math.max(maxArr[i] + leftMax[i - 2], ans);
      }
      if (i < maxArr.length - 2) {
        ans = Math.max(maxArr[i] + rightMax[i + 2], ans);
      }
      ans = Math.max(maxArr[i], ans);
    }
    return ans;
  }

//  public int adjacent(int[][] A) {
//    int max = Integer.MIN_VALUE;
//    int prev = -2;
//    int curr = -1;
//    int ans = Integer.MIN_VALUE;
//    for (int next = 0; next < A[0].length; next++) {
//      int currentElement = Math.max(A[0][next], A[1][next]);
//      if (max != Integer.MIN_VALUE) {
//        //include and exclude currentElement
//        ans = Math.max(Math.max(currentElement, currentElement + max),
//            ans);
//        if (prev >= 0) {
//          max = Math.max(max, Math.max(A[0][prev], A[1][prev]));
//        }
//      } else {
//        ans = currentElement;
//        max = currentElement;
//      }
//    }
//    return ans;
//  }

  public int adjacent_withOnly2elements(int[][] A) {
    int firstIndexMax = Math.max(A[0][0], A[1][0]);
    System.out.println("firstIndexMax : " + firstIndexMax);
    if (A[0].length == 1) {
      return firstIndexMax;
    }

    int secondIndexMax = Math.max(A[0][1], A[1][1]);
    System.out.println("secondIndexMax : " + secondIndexMax);
    int ans = Math.max(firstIndexMax, secondIndexMax);
    if (A[0].length == 2) {
      return ans;
    }
    int currentIndexMax = Integer.MIN_VALUE;
    int max = firstIndexMax;
    for (int i = 2; i < A[0].length; i++) {
      currentIndexMax = Math.max(A[0][i], A[1][i]);
      ans = Math.max(Math.max(currentIndexMax, currentIndexMax + max), ans);
      int currPrevPrevIndexMax = Math.max(A[0][i - 2], A[1][i - 2]);
      max = Math.max(currPrevPrevIndexMax, max);

//      System.out.print(ans + " - ");
//      if (i == 3) {
      System.out.println(
          "currentIndexMax : " + currentIndexMax + " - max : " + max + " - ans : " + ans);
//      }
    }
    ans = Math.max(Math.max(currentIndexMax, currentIndexMax + max), ans);
    System.out.println();
    return ans;
  }
}