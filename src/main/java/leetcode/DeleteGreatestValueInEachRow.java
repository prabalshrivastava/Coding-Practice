package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class DeleteGreatestValueInEachRow {

  public static void main(String[] args) {
    int[][] grid = {{1, 2, 4}, {3, 3, 1}};
    System.out.println(deleteGreatestValue(grid));
  }

  public static int deleteGreatestValue(int[][] grid) {
    usingMaxHeap(grid);
    return usingSorting(grid);
  }

  private static int usingSorting(int[][] grid) {

    return 0;
  }

  private static int usingMaxHeap(int[][] grid) {
    List<PriorityQueue<Integer>> pqList = new ArrayList<PriorityQueue<Integer>>();
    for (int i = 0; i < grid.length; i++) {
      PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
      for (int j = 0; j < grid[i].length; j++) {
        pq.add(grid[i][j]);
      }
      pqList.add(pq);
    }
    System.out.println(pqList);
    int sum = 0;
    for (int i = 0; i < grid[0].length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < pqList.size(); j++) {
        max = Math.max(max, pqList.get(j).poll());
      }
      sum += max;
    }
    return sum;
  }
}