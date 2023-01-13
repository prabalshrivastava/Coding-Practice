package scaler.advancedDsa.heaps1;

import java.util.PriorityQueue;

public class HWQ4KthSmallestElementInASortedMatrix {

  //  Problem Description
//  Given a sorted matrix of integers A of size N x M and an integer B.
//  Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.
//      NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.
//      Problem Constraints
//1 <= N, M <= 500
//      1 <= A[i] <= 109
//      1 <= B <= N * M
//  Input Format
//  The first argument given is the integer matrix A.
//  The second argument given is an integer B.
//  Output Format
//  Return the B-th smallest element in the matrix.
//  Example Input
//  Input 1:
//  A = [ [9, 11, 15],
//      [10, 15, 17] ]
//  B = 6
//  Input 2:
//  A = [  [5, 9, 11],
//      [9, 11, 13],
//      [10, 12, 15],
//      [13, 14, 16],
//      [16, 20, 21] ]
//  B = 12
//  Example Output
//  DocFinder.Output 1:
//      17x
//  Output 2:
//      16
//  Example Explanation
//  Explanation 1:
//      6th smallest element in the sorted matrix is 17.
//  Explanation 2:
//      12th smallest element in the sorted matrix is 16.
  public static void main(String[] args) {
    int[][] input1A = new int[][]{{9, 11, 15},
        {10, 15, 17}};
    int input1B = 6;
    System.out.println(new HWQ4KthSmallestElementInASortedMatrix().solve(input1A, input1B));
    int[][] input2A = new int[][]{{5, 9, 11},
        {9, 11, 13},
        {10, 12, 15},
        {13, 14, 16},
        {16, 20, 21}};
    int input2B = 12;
    System.out.println(new HWQ4KthSmallestElementInASortedMatrix().solve(input2A, input2B));
  }

  public int solve(int[][] A, int B) {
    PriorityQueue<Integer> minHeap = new PriorityQueue();
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        minHeap.add(A[i][j]);
      }
    }
    int ans = 0;
    for (int i = 0; i < B; i++) {
      ans = minHeap.poll();
    }
    return ans;
  }
}
