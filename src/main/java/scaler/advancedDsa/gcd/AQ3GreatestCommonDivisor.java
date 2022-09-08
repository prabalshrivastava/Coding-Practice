package scaler.advancedDsa.gcd;

public class AQ3GreatestCommonDivisor {
//    Problem Description
//    Given 2 non-negative integers A and B, find gcd(A, B)
//    GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.
//            Note: DO NOT USE LIBRARY FUNCTIONS.
//            Problem Constraints
//0 <= A, B <= 109
//    Input Format
//    First argument is an integer A.
//    Second argument is an integer B.
//    Output Format
//    Return an integer denoting the gcd(A, B).
//    Example Input
//    Input 1:
//    A = 4
//    B = 6
//    Input 2:
//    A = 6
//    B = 7
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//            2 divides both 4 and 6
//    Explanation 2:
//            1 divides both 6 and 7

    public static void main(String[] args) {
        int input1A = 4, input1B = 6;
        System.out.println(new AQ3GreatestCommonDivisor().gcd(input1A, input1B));
        int input2A = 6, input2B = 7;
        System.out.println(new AQ3GreatestCommonDivisor().gcd(input2A, input2B));
    }

    public int gcd(int A, int B) {
        if (A == 0)
            return B;
        if (B == 0)
            return A;
        if (A <= B) {
            return gcd(B % A, A);
        } else {
            return gcd(A % B, B);
        }
    }
}
