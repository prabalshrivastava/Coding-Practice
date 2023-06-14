package scaler.advancedDsa.arrays1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class HWQ2MaxNonNegativeSubArray {

  //    Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
//    The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
//    Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
//    Find and return the required subarray.
//            NOTE:
//            1. If there is a tie, then compare with segment's length and return segment which has maximum length.
//            2. If there is still a tie, then return the segment with minimum starting index.
//    Input Format:
//    The first and the only argument of input contains an integer array A, of length N.
//    Output Format:
//    Return an array of integers, that is a subarray of A that satisfies the given conditions.
//            Constraints:
//            1 <= N <= 1e5
//            -INT_MAX < A[i] <= INT_MAX
//    Examples:
//    Input 1:
//    A = [1, 2, 5, -7, 2, 3]
//    Output 1:
//            [1, 2, 5]
//    Explanation 1:
//    The two sub-arrays are [1, 2, 5] [2, 3].
//    The answer is [1, 2, 5] as its sum is larger than [2, 3].
//    Input 2:
//    A = [10, -1, 2, 3, -4, 100]
//    Output 2:
//            [100]
//    Explanation 2:
//    The three sub-arrays are [10], [2, 3], [100].
//    The answer is [100] as its sum is larger than the other two.
  public static void main(String[] args) {
    int[] input1A = new int[]{1, 2, 5, -7, 2, 3};
    System.out.println(Arrays.toString(new HWQ2MaxNonNegativeSubArray().maxset(input1A)));

    int[] input2A = new int[]{10, -1, 2, 3, -4, 100};
    System.out.println(Arrays.toString(new HWQ2MaxNonNegativeSubArray().maxset(input2A)));

    int[] input3A = new int[]{1, 2, 5, -7, 2, 5};
    System.out.println(Arrays.toString(new HWQ2MaxNonNegativeSubArray().maxset(input3A)));

    int[] input4A = new int[]{-1, -1, -1, -1, -1};
    System.out.println(Arrays.toString(new HWQ2MaxNonNegativeSubArray().maxset(input4A)));

    int[] input5A = new int[]{0, 0, -1, 0};
    System.out.println(Arrays.toString(new HWQ2MaxNonNegativeSubArray().maxset(input5A)));

    int[] input6A = new int[]{1967513926,1540383426,-1303455736,-521595368};
    System.out.println(Arrays.toString(new HWQ2MaxNonNegativeSubArray().maxset(input6A)));
  }

  public int[] maxset(int[] A) {
    long sum = 0;
    long maxSum = Integer.MIN_VALUE;
    int beginIndex = -1;
    int endIndex = -1;
    int bestBeginIndex = -1;
    int bestEndIndex = -1;
    int j = 0;
    while (j < A.length && A[j] < 0) {
      j++;
    }
    for (int i = j; i < A.length; i++) {
      long sumWithElement = sum + (long)A[i];
      if (A[i] < 0) {
        sum = 0;
        beginIndex = -1;
        endIndex = -1;
      } else {
        if (sumWithElement == maxSum) {
          System.out.println(" i " + i + "------------>sumWithElement : "  + sumWithElement);
          if (endIndex != -1) {
            if (A[i] == 0) {
              endIndex = i;
              bestEndIndex = endIndex;
            } else if (endIndex - beginIndex > bestBeginIndex - bestEndIndex) {
              bestBeginIndex = beginIndex;
              bestEndIndex = endIndex;
            } else if (endIndex - beginIndex == bestBeginIndex - bestEndIndex
                       && beginIndex < bestBeginIndex) {
              bestBeginIndex = beginIndex;
              bestEndIndex = endIndex;
            }
          }
        } else if (sumWithElement > maxSum) {
          System.out.println(" i " + i + "sumWithElement : "  + sumWithElement);
          maxSum = sumWithElement;
          if (beginIndex == -1) {
            beginIndex = i;
            bestBeginIndex = i;
          }
          endIndex = i;
          bestEndIndex = i;
        }
      }
    }
    List<Integer> list = new ArrayList<>();
    if (bestBeginIndex > -1) {
      for (int i = bestBeginIndex; i <= bestEndIndex; i++) {
        list.add(A[i]);
      }
    }
    return list.stream().mapToInt(value -> value).toArray();
  }
}

//        System.out.println(
//            "beginIndex = " + beginIndex + " endIndex = " + endIndex + " -- bestBeginIndex = "
//            + bestBeginIndex + " bestEndIndex = " + bestEndIndex);