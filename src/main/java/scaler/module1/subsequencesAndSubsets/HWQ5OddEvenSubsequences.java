package scaler.module1.subsequencesAndSubsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HWQ5OddEvenSubsequences {
//  Given an array of integers A of size, N. Find the longest subsequence of A, which is odd-even.
//  A subsequence is said to be odd-even in the following cases:
//  The first element of the subsequence is odd; the second element is even, the third element is odd, and so on. For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]
//  The first element of the subsequence is even, the second element is odd, the third element is even, and so on. For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]
//  Return the maximum possible length of odd-even subsequence.
//  Note: An array B is a subsequence of an array A if B can be obtained from A by deleting several (possibly, zero, or all) elements.
//  Input Format
//  The only argument given is the integer array A.
//      Output Format
//  Return the maximum possible length of odd-even subsequence.
//  Constraints
//1 <= N <= 100000
//      1 <= A[i] <= 10^9
//  For Example
//  Input 1:
//  A = [1, 2, 2, 5, 6]
//  Output 1:
//      4
//  Explanation 1:
//  Maximum length odd even subsequence is [1, 2, 5, 6]
//  Input 2:
//  A = [2, 2, 2, 2, 2, 2]
//  Output 2:
//      1
//  Explanation 2:
//  Maximum length odd even subsequence is [2]

  public static void main(String[] args) {
    int[] input1A = {1, 2, 2, 5, 6};
    System.out.println(new HWQ5OddEvenSubsequences().solve(input1A));

    int[] input2A = {2, 2, 2, 2, 2, 2};
    System.out.println(new HWQ5OddEvenSubsequences().solve(input2A));
    System.out.println(
        new HWQ5OddEvenSubsequences().solve(new int[]{12, 10, 28, 37, 43, 40, 14, 12, 48}));
  }

//  public int solve(int[] A) {
//    Queue<Integer> oddList = new LinkedList<>();
//    Queue<Integer> evenList = new LinkedList<>();
//    for (int i = 0; i < A.length; i++) {
//      if (A[i] % 2 == 0) {
//        oddList.add(A[i]);
//      } else {
//        evenList.add(A[i]);
//      }
//    }
//    List<Integer> finalList = new ArrayList<>();
//    while (!oddList.isEmpty() && !evenList.isEmpty()) {
//      finalList.add(oddList.poll());
//      finalList.add(evenList.poll());
//    }
//    if (finalList.isEmpty()) {
//      return 1;
//    }
//    if (finalList.get(finalList.size() - 1) % 2 == 0) {
//      if (!oddList.isEmpty()) {
//        finalList.add(oddList.poll());
//      }
//    } else {
//      if (!evenList.isEmpty()) {
//        finalList.add(evenList.poll());
//      }
//    }
//    System.out.println(finalList);
//    return finalList.size();
//  }

  public int solve(int[] A) {
    List<Integer> oddEvenList = new ArrayList<>();
    boolean isOdd = A[0] % 2 != 0;
    if (isOdd) {
      oddEvenList.add(A[0]);
      isOdd = false;
    }
    for (int i = 0; i < A.length; i++) {
      if (A[i] % 2 != 0 && isOdd) {
        oddEvenList.add(A[i]);
        isOdd = false;
      } else if (A[i] % 2 == 0 && !isOdd) {
        oddEvenList.add(A[i]);
        isOdd = true;
      }
    }
//    System.out.println(oddEvenList);
    return oddEvenList.size();
  }
}