package scaler.advancedDsa.bitmanipulations2;

import java.util.Arrays;

public class AQ1SingleNumberIII {
    //    Problem Description
//    Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
//    Find the two integers that appear only once.
//    Note: Return the two numbers in ascending order.
//            Problem Constraints
//2 <= |A| <= 100000
//            1 <= A[i] <= 109
//    Input Format
//    The first argument is an array of integers of size N.
//            Output Format
//    Return an array of two integers that appear only once.
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 1, 2, 4]
//    Input 2:
//    A = [1, 2]
//    Example Output
//    Output 1:
//            [3, 4]
//    Output 2:
//            [1, 2]
//    Example Explanation
//    Explanation 1:
//            3 and 4 appear only once.
//            Explanation 2:
//            1 and 2 appear only once.
    public int[] solve(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((xor & 1 << i) != 0) {
                break;
            }
            count++;
        }
//        System.out.println(xor);
//        System.out.println(count);

        int setXor = 0;
        int unsetXor = 0;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1 << count) == 0) unsetXor ^= A[i];
            else
                setXor ^= A[i];
        }
        return new int[]{Math.min(setXor, unsetXor), Math.max(setXor, unsetXor)};
    }

    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 1, 2, 4};
        System.out.println(Arrays.toString(new AQ1SingleNumberIII().solve(input1A)));
        int[] input2A = {1, 2};
        System.out.println(Arrays.toString(new AQ1SingleNumberIII().solve(input2A)));
    }
}
