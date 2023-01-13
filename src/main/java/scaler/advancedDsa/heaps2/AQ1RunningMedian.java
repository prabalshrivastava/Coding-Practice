package scaler.advancedDsa.heaps2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class AQ1RunningMedian {

  //  Problem Description
//  Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
//  Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
//  Find and return the array C.
//      NOTE:
//  If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
//  If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
//  Problem Constraints
//1 <= length of the array <= 100000
//      1 <= A[i] <= 109
//  Input Format
//  The only argument given is the integer array A.
//      Output Format
//  Return an integer array C, C[i] denotes the median of the first i elements.
//  Example Input
//  Input 1:
//  A = [1, 2, 5, 4, 3]
//  Input 2:
//  A = [5, 17, 100, 11]
//  Example Output
//  DocFinder.Output 1:
//      [1, 1, 2, 2, 3]
//  Output 2:
//      [5, 5, 17, 11]
//  Example Explanation
//  Explanation 1:
//  stream          median
// [1]             1
//     [1, 2]          1
//     [1, 2, 5]       2
//     [1, 2, 5, 4]    2
//     [1, 2, 5, 4, 3] 3
//  Explanation 2:
//  stream          median
// [5]              5
//     [5, 17]          5
//     [5, 17, 100]     17
//     [5, 17, 100, 11] 11
  public static void main(String[] args) {
    int[] input1A = {1, 2, 5, 4, 3};
//    System.out.println(Arrays.toString(new AQ1RunningMedian().solve(input1A)));
//    int[] input2A = {5, 17, 100, 11};
//    System.out.println(Arrays.toString(new AQ1RunningMedian().solve(input2A)));
    int[] input3A = {9, 8, 15, 20, 22, 17, 12, 5, 1, 3};
    System.out.println(Arrays.toString(new AQ1RunningMedian().solve(input3A)));
  }

  public int[] solve(int[] A) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    int[] ans = new int[A.length];
    maxHeap.add(A[0]);
    ans[0] = maxHeap.peek();
    for (int i = 1; i < A.length; i++) {
      if (A[i] <= maxHeap.peek()) {
        //small elements in maxheap
        maxHeap.add(A[i]);
      } else {
        //large elements in minheap
        minHeap.add(A[i]);
      }
      if (maxHeap.size() - minHeap.size() > 1) {
        minHeap.add(maxHeap.poll());
      } else if (maxHeap.size() - minHeap.size() < 0) {
        maxHeap.add(minHeap.poll());
      }

//      System.out.println("maxHeap : " + maxHeap + " - minHeap : " + minHeap);
      ans[i] = maxHeap.peek();
    }
    return ans;
  }
}
