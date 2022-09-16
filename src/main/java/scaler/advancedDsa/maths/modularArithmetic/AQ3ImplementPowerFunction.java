package scaler.advancedDsa.maths.modularArithmetic;

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
    }

    public int pow(int A, int B, int C) {
        long pow;
        if (A < 0) {
            if (B % 2 == 0) {
                pow = getPow(A, B, C);
            } else {
                pow = ((A + C) % C) * (getPow(Math.abs(A), B, C) % C);
            }
        } else
            pow = getPow(A, B, C);
        return (int) (pow % C);
    }

//    private long getPow(int A, int B, int C) {
//        long pow = 1;
//        for (int i = 0; i < B / 2; i++) {
//            pow = (pow * A) % C;
//        }
//        return (pow * pow) % C;
//    }

//    private long getPow(int A, int B, int C) {
//        long prod;
//        if (B <= 1)
//            return A;
//        long pow = getPow(A, B / 2, C);
//        if (B % 2 == 0) {
//            prod = ((pow % C) * (pow % C)) % C;
//        } else {
//            prod = ((A % C) * (pow % C) * (pow % C)) % C;
//        }
//        return prod % C;
//    }

    private long getPow(int A, int B, int C) {
        long prod;
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        if (B == 1)
            return A;
        long pow = getPow(A, B / 2, C);
        pow = pow % C;
        long l = (pow) * (pow);
        l = l % C;
        if (B % 2 == 0) {
            pow = l % C;
        } else {
            pow = ((A) * l) % C;
        }
        return pow;
    }
//    private long getPow(long A, long B, long C) {
////        System.out.printf("%s - %s - %s %n", A, B, C);
//        if (A == 0)
//            return 0;
//        if (B == 0)
//            return 1;
//        if (B == 1) {
//            if (A < 0)
//                return (A + C) % C;
//            else
//                return A;
//        }
//
//        long x;
//        x = getPow(A, B / 2, C);
//        long l = ((x % C) * (x % C)) % C;
//        if (B % 2 == 0) {
//            return l;
//        } else {
//            return (A % C * l % C) % C;
//        }
//    }
}
