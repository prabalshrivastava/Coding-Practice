package scaler.advancedDsa.bitmanipulations2;

import scaler.advancedDsa.maths.gcd.HWQ3DivisorGame;

public class HWQ3SmallestXOR {
//    Problem Description
//    Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.
//    Problem Constraints
//0 <= A <= 109
//            0 <= B <= 30
//    Input Format
//    First argument contains a single integer A. Second argument contains a single integer B.
//            Output Format
//    Return a single integer X.
//            Example Input
//    Input 1:
//    A = 3
//    B = 3
//    Input 2:
//    A = 15
//    B = 2
//    Example Output
//    Output 1:
//            7
//    Output 2:
//            12
//    Example Explanation
//    Explanation 1:
//            3 xor 7 = 4 which is minimum
//    Explanation 2:
//            15 xor 12 = 3 which is minimum

    public int solve(int A, int B) {
        return A;
    }

    public static void main(String[] args) {
        int input1A = 3 ,input1B = 3;
        System.out.println(new HWQ3SmallestXOR().solve(input1A,input1B));
        int input2A = 15 ,input2B = 2;
        System.out.println(new HWQ3SmallestXOR().solve(input2A,input2B));
    }
}
