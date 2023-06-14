package scaler.advancedDsa.arrays1;

import java.util.Arrays;

public class HWQ3Flip {
//    Problem Description
//    You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.
//    Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
//    If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
//    NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
//            Problem Constraints
//1 <= size of string <= 100000
//    Input Format
//    First and only argument is a string A.
//    Output Format
//    Return an array of integers denoting the answer.
//    Example Input
//    Input 1:
//    A = "010"
//    Input 2:
//    A = "111"
//    Example Output
//    Output 1:
//            [1, 1]
//    Output 2:
//            []
//    Example Explanation
//    Explanation 1:
//    A = "010"
//    Pair of [L, R] | Final string
//    _______________|_____________
//[1 1]          | "110"
//        [1 2]          | "100"
//        [1 3]          | "101"
//        [2 2]          | "000"
//        [2 3]          | "001"
//    We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
//    Explanation 2:
//    No operation can give us more than three 1s in final string. So, we return empty array [].

  public static void main(String[] args) {
    String input1A = "010";
    System.out.println(Arrays.toString(new HWQ3Flip().flip(input1A)));
    String input2A = "111";
    System.out.println(Arrays.toString(new HWQ3Flip().flip(input2A)));
    System.out.println(Arrays.toString(new HWQ3Flip().flip("1101010001")));
    System.out.println(Arrays.toString(new HWQ3Flip().flip("0111000100010")));
    System.out.println(Arrays.toString(new HWQ3Flip().flip("0101010100011101110100100100001001010111010")));
    //1234567890123456789012345678901234567890123
    //0101010100011101110100100100001001010111010
//    0100001001010111010 -> 11
//    0100100100001001010111010 -> 15
  }

  public int[] flip(String A) {
    int zero = 0;
    int one = 0;
    int bi = -1;//begin index
    int ei = -1;//end index
    int bbi = -1;//best begin index
    int bei = -1;//best end index
    int maxZeroCount = Integer.MIN_VALUE;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '0') {
        zero++;
        if (zero - one >= maxZeroCount) {
          if (bi == -1) {
            bi = i;
          }
          ei = i;
          if (zero - one > maxZeroCount) {
            bbi = bi;
            bei = ei;
          }
          maxZeroCount = zero - one;
        }
      } else {
        one++;
        if (zero - one < 0) {
          zero = 0;
          one = 0;
          bi = -1;
          ei = -1;
        } else {
          ei++;
        }
      }
    }
    if (bbi != -1) {
      return new int[]{bbi + 1, bei + 1};
    } else {
      return new int[]{};
    }
  }
}
