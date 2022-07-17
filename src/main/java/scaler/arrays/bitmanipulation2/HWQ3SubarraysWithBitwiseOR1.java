package scaler.arrays.bitmanipulation2;

public class HWQ3SubarraysWithBitwiseOR1 {
    //    Problem Description
//    Given an array B of length A with elements 1 or 0. Find the number of subarrays with bitwise OR 1.
//
//
//    Problem Constraints
//1 <= A <= 105
//
//
//    Input Format
//    The first argument is a single integer A.
//    The second argument is an integer array B.
//
//
//    Output Format
//    Return the number of subarrays with bitwise array 1.
//
//
//    Example Input
//    Input 1:
//    A = 3
//    B = [1, 0, 1]
//    Input 2:
//    A = 2
//    B = [1, 0]
//
//
//    Example Output
//    Output 1:
//            5
//    Output2:
//            2
//
//
//    Example Explanation
//    Explanation 1:
//    The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
//    Except the subarray [0] all the other subarrays has a Bitwise OR = 1
//    Explanation 2:
//    The subarrays are :- [1], [0], [1, 0]
//    Except the subarray [0] all the other subarrays has a Bitwise OR = 1
    public static void main(String[] args) {
        int input1A = 3;
        int[] input1B = {1, 0, 1};
        System.out.println(new HWQ3SubarraysWithBitwiseOR1().solve(input1A, input1B));
        int input2A = 2;
        int[] input2B = {1, 0};
        System.out.println(new HWQ3SubarraysWithBitwiseOR1().solve(input2A, input2B));
        int input3A = 5;
        int[] input3B = {0, 1, 1, 0, 1};
        System.out.println(new HWQ3SubarraysWithBitwiseOR1().solve(input3A, input3B));
    }

    public long solve1(int A, int[] B) {
        long count = 0;
        for (int i = 0; i < B.length; i++) {
            int or = B[i];
            for (int j = i; j < B.length; j++) {
                or = or | B[j];
                if (or >= 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public long solve(int A, int[] B) {
        long total = ((long) B.length * (B.length + 1)) / 2;
        long totalZero = 0;
        long zero = 0;
        for (int i = 0; i < B.length; i++) {
            if (B[i] == 0) {
                zero++;
                totalZero = totalZero + zero;
            } else {
                zero = 0;
            }
        }
        return total - totalZero;
    }
}
