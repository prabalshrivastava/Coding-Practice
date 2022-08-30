package scaler.advancedDsa.bitmanipulations1;

public class AQ1SingleNumber {
//    Problem Description
//    Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
//    NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//    Problem Constraints
//2 <= |A| <= 2000000
//            0 <= A[i] <= INTMAX
//    Input Format
//    The first and only argument of input contains an integer array A.
//    Output Format
//    Return a single integer denoting the single element.
//    Example Input
//    Input 1:
//    A = [1, 2, 2, 3, 1]
//    Input 2:
//    A = [1, 2, 2]
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//            3 occurs once.
//    Explanation 2:
//            1 occurs once.

    public static void main(String[] args) {
        int[] input1A = {1, 2, 2, 3, 1};
        System.out.println(new AQ1SingleNumber().singleNumber(input1A));
        int[] input2A = {1, 2, 2};
        System.out.println(new AQ1SingleNumber().singleNumber(input2A));
    }
    public int singleNumber(final int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        return xor;
    }
}
