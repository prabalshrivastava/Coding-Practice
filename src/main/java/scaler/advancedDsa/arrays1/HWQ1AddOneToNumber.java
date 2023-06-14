package scaler.advancedDsa.arrays1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HWQ1AddOneToNumber {

  //    Problem Description
//    Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
//    The digits are stored such that the most significant digit is at the head of the list.
//            NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
//    Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
//    A: For the purpose of this question, YES
//    Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
//    A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
//            Problem Constraints
//1 <= size of the array <= 1000000
//    Input Format
//    First argument is an array of digits.
//            Output Format
//    Return the array of digits after adding one.
//    Example Input
//    Input 1:
//            [1, 2, 3]
//    Example Output
//    Output 1:
//            [1, 2, 4]
//    Example Explanation
//    Explanation 1:
//    Given vector is [1, 2, 3].
//    The returned vector should be [1, 2, 4] as 123 + 1 = 124.
  public int[] plusOne(int[] A) {
    if (A == null || A.length == 0) {
      return A;
    }
    int j = 0;
    if (A.length > 1) {
      while (j < A.length && A[j] == 0) {
        j++;
      }
    }
    int carry = 0;
    List<Integer> ans = new ArrayList<>();
    for (int i = A.length - 1; i >= 0; i--) {
      int add;
      if (i == A.length - 1) {
        add = A[i] + 1;
      } else {
        add = A[i] + carry;
      }
      carry = add / 10;
      A[i] = add % 10;
    }
    if (carry != 0) {
      ans.add(carry);
    }
    boolean isLeadingO = true;
    for (int i = j; i < A.length; i++) {
//      if (isLeadingO && A[i] == 0) {
//        continue;
//      } else {
//        isLeadingO = false;
//      }
      ans.add(A[i]);
    }
    return ans.stream().mapToInt(value -> value).toArray();
  }

  public static void main(String[] args) {
    int[] input1 = {1, 2, 3};
    System.out.println(Arrays.toString(new HWQ1AddOneToNumber().plusOne(input1)));
    System.out.println(Arrays.toString(new HWQ1AddOneToNumber().plusOne(new int[]{0})));
    System.out.println(Arrays.toString(new HWQ1AddOneToNumber().plusOne(new int[]{9, 9, 9, 9, 9})));
    System.out.println(
        Arrays.toString(new HWQ1AddOneToNumber().plusOne(new int[]{0, 3, 7, 6, 4, 0, 5, 5, 5})));
    System.out.println(Arrays.toString(
        new HWQ1AddOneToNumber().plusOne(new int[]{0, 0, 0, 0, 3, 7, 6, 4, 0, 5, 5, 5})));
  }
}