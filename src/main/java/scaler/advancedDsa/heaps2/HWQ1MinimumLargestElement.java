package scaler.advancedDsa.heaps2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HWQ1MinimumLargestElement {

  //  Problem Description
//  Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.
//  Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
//  Find the minimum possible largest element after B operations.
//      Problem Constraints
//1 <= N <= 106
//      0 <= B <= 105
//      -105 <= A[i] <= 105
//  Input Format
//  The first argument is an integer array A.
//  The second argument is an integer B.
//      Output Format
//  Return an integer denoting the minimum possible largest element after B operations.
//  Example Input
//  Input 1:
//  A = [1, 2, 3, 4]
//  B = 3
//  Input 2:
//  A = [5, 1, 4, 2]
//  B = 5
//  Example Output
//  DocFinder.Output 1:
//      4
//  Output 2:
//      5
//  Example Explanation
//  Explanation 1:
//  Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
//  Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
//  Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
//  Minimum possible largest element after 3 operations is 4.
//  Explanation 2:
//  Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
//  Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
//  Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
//  Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
//  Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
//  Minimum possible largest element after 5 operations is 5.
  public static void main(String[] args) {
    System.out.println(new HWQ1MinimumLargestElement().solve(new int[]{1, 2, 3, 4}, 4));//4
    System.out.println(new HWQ1MinimumLargestElement().solve(new int[]{1, 2, 3, 4}, 5));//5
    System.out.println(new HWQ1MinimumLargestElement().solve(new int[]{1, 2, 3, 4}, 6));//6
    System.out.println(new HWQ1MinimumLargestElement().solve(new int[]{1, 2, 3, 4}, 7));//6
    System.out.println(new HWQ1MinimumLargestElement().solve(new int[]{1, 2, 3, 4}, 8));

    int[] input2A = {5, 1, 4, 2};
    int input2B = 5;
    System.out.println(new HWQ1MinimumLargestElement().solve(input2A, input2B));
  }

  public int solve_tle(int[] A, int B) {
    int[] ans = new int[A.length];
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> {
      int index1 = o1[0];
      int value1 = o1[1];

      int index2 = o2[0];
      int value2 = o2[1];

      return value1 - value2;
    });
    for (int i = 0; i < A.length; i++) {
      ans[i] = A[i];
    }

    for (int i = 0; i < B; i++) {
      for (int j = 0; j < A.length; j++) {
        minHeap.add(new int[]{j, ans[j] + A[j]});
      }
      int[] peek = minHeap.peek();
//      System.out.println("peek : A[" + peek[0] + "] = " + peek[1]);
      ans[peek[0]] = peek[1];
//      System.out.println(Arrays.toString(ans));
      minHeap.clear();
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < ans.length; i++) {
      max = Math.max(ans[i], max);
    }
    return max;
  }


  public int solve(int[] A, int B) {
    int[] state = new int[A.length];
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> {
      int value1 = o1[1];
      int value2 = o2[1];
      if (value1 == value2) {
        return o1[0] - o2[0];
      }
      return value1 - value2;
    });
    for (int i = 0; i < A.length; i++) {
      minHeap.add(new int[]{i, 2 * A[i]});
      state[i] = A[i];
    }

    for (int i = 0; i < B; i++) {
      int[] poll = minHeap.poll();
      int index = poll[0];
      int value = poll[1];
      state[index] = value;
      minHeap.add(new int[]{index, state[index] + A[index]});
//      minHeap.forEach(ints -> System.out.print(ints[0]));
//      System.out.println(Arrays.toString(state));
    }
//    while (!minHeap.isEmpty()) {
//      System.out.println(Arrays.toString(minHeap.poll()));
//    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < state.length; i++) {
      max = Math.max(state[i], max);
    }
    return max;
  }
}
