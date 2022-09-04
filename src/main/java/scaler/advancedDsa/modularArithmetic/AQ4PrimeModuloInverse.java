package scaler.advancedDsa.modularArithmetic;

public class AQ4PrimeModuloInverse {
    //    Problem Description
//    Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
//    A-1 mod B is also known as modular multiplicative inverse of A under modulo B.
//    Problem Constraints
//1 <= A <= 109
//            1<= B <= 109
//    B is a prime number
//    Input Format
//    First argument is an integer A.
//    Second argument is an integer B.
//    Output Format
//    Return an integer denoting the modulor inverse
//    Example Input
//    Input 1:
//    A = 3
//    B = 5
//    Input 2:
//    A = 6
//    B = 23
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            4
//    Example Explanation
//    Explanation 1:
//    Let's say A-1 mod B = X, then (A * X) % B = 1.
//            3 * 2 = 6, 6 % 5 = 1.
//    Explanation 2:
//    Similarly, (6 * 4) % 23 = 1.
    public static void main(String[] args) {
        int input1A = 3, input1B = 5;
        System.out.println(new AQ4PrimeModuloInverse().solve(input1A, input1B));
        int input2A = 6, input2B = 23;
        System.out.println(new AQ4PrimeModuloInverse().solve(input2A, input2B));
        int input3A = 21;
        int input3B = 17;
        System.out.println(new AQ4PrimeModuloInverse().solve(input3A, input3B));
        int input4A = 10;
        int input4B = 3;
        System.out.println(new AQ4PrimeModuloInverse().solve(input4A, input4B));

//        The expected return value: 13
    }

    public int solve(int A, int B) {
        return (int) getPow(A, B - 2, B) % B;
        //return (int) (Math.pow(A % B, B - 2));
    }

    private long getPow(int A, int B, int C) {
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
}
