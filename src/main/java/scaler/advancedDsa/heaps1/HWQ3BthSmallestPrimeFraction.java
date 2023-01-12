package scaler.advancedDsa.heaps1;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.PriorityQueue;

public class HWQ3BthSmallestPrimeFraction {

  //    Problem Description
//    Given a sorted array of integers A which contains 1 and some number of primes.
//            Then, for every p < q in the list, we consider the fraction p / q.
//    What is the B-th smallest fraction considered?
//    Return your answer as an array of integers, where answer[0] = p and answer[1] = q.
//            Problem Constraints
//1 <= length(A) <= 2000
//            1 <= A[i] <= 30000
//            1 <= B <= length(A)*(length(A) - 1)/2
//    Input Format
//    The first argument of input contains the integer array, A.
//    The second argument of input contains an integer B.
//            Output Format
//    Return an array of two integers, where answer[0] = p and answer[1] = q.
//            Example Input
//    Input 1:
//    A = [1, 2, 3, 5]
//    B = 3
//    Input 2:
//    A = [1, 7]
//    B = 1
//    Example Output
//    Output 1:
//            [2, 5]
//    Output 2:
//            [1, 7]
//    Example Explanation
//    Explanation 1:
//    The fractions to be considered in sorted order are:
//            [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
//    The third fraction is 2/5.
//    Explanation 2:
//    The fractions to be considered in sorted order are:
//            [1/7]
//    The first fraction is 1/7.
  public static void main(String[] args) {
    int[] input1A = {1, 2, 3, 5};
    int input1B = 3;
    System.out.println(Arrays.toString(new HWQ3BthSmallestPrimeFraction().solve(input1A, input1B)));
    int[] input2A = {1, 7};
    int input2B = 1;
    System.out.println(Arrays.toString(new HWQ3BthSmallestPrimeFraction().solve(input2A, input2B)));
    int[] input3A = {1, 719, 983, 9293, 11321, 14447, 16411, 17881, 22079, 28297};
    int input3B = 42;
    System.out.println(Arrays.toString(
        new HWQ3BthSmallestPrimeFraction().solveUsingAbstractMap(input3A, input3B)));
  }

  public int[] solveUsingAbstractMap(int[] A, int B) {
    PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> minHeap = new PriorityQueue<>(
        (o1, o2) -> {
          return (o1.getKey() / o1.getValue()) - (o2.getKey() / o2.getValue());
        });
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        minHeap.add(new AbstractMap.SimpleEntry<Integer, Integer>(A[i], A[j]));
      }
    }
    System.out.println(minHeap);
    int[] ans = new int[2];
    for (int i = 0; i < B; i++) {
      SimpleEntry<Integer, Integer> poll = minHeap.poll();
      ans[0] = poll.getKey();
      ans[1] = poll.getValue();
    }
    return ans;
  }

  public int[] solve(int[] A, int B) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> {
      return (o1[0] * o2[1]) - (o2[0] * o1[1]);
    });
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        int[] arr = new int[2];
        arr[0] = A[i];
        arr[1] = A[j];
        minHeap.add(arr);
      }
    }
//    System.out.println(minHeap);
    int[] ans = new int[2];
    for (int i = 0; i < B; i++) {
      ans = minHeap.poll();
    }
    return ans;
  }
}

