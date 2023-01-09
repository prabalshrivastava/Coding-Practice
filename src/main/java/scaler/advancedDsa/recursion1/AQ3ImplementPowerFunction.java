package scaler.advancedDsa.recursion1;

import static scaler.common.CommonUtils.getModdedNumber;

public class AQ3ImplementPowerFunction {
//    Problem Description
//    Implement pow(A, B) % C.
//    In other words, given A, B and C, Find (AB % C).
//    Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
//            Problem Constraints
//-109 <= A <= 109
//            0 <= B <= 109
//            1 <= C <= 109
//    Input Format
//    Given three integers A, B, C.
//    Output Format
//    Return an integer.
//            Example Input
//    A = 2, B = 3, C = 3
//    Example Output
//2
//    Example Explanation
//23 % 3 = 8 % 3 = 2

    public static void main(String[] args) {
        int A = 2, B = 3, C = 3;
        System.out.println(new AQ3ImplementPowerFunction().pow(A, B, C));

        int input2A = 74582788;
        int input2B = 63740768;
        int input2C = 81447307;
        System.out.println(new AQ3ImplementPowerFunction().pow(input2A, input2B, input2C));//14025406

//        Test As Custom Input
//        The expected return value:
//        14025406
        System.out.println(new AQ3ImplementPowerFunction().pow(0, 0, 1));//0
        System.out.println(new AQ3ImplementPowerFunction().pow(-1, 2, 20));//1
        int input3A = 71045970;
        int input3B = 41535484;
        int input3C = 64735492;
        System.out.println(new AQ3ImplementPowerFunction().pow(input3A, input3B, input3C));
    }

    public int pow(int A, int B, int C) {
        return (int) power(A, B, C);
    }

    private long power(long A, long B, long C) {
        if (B == 1 || A == 0) {
            return getModdedNumber(A,C);
        }
        if (B == 0)
            return 1;
        long x = power(A, B / 2, C);
        long x2 = getModdedNumber(x * x, C);
        if (B % 2 == 0) {
            return x2;
        } else {
            return getModdedNumber(A * x2, C);
        }
    }
}
