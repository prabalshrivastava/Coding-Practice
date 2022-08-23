package scaler.module1.recursion2;

public class AQ1ImplementPowerFunction {
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
    public int pow(int A, int B, int C) {
        return (int) power(A, B, C);
    }

    private long powerStackOverflow(long A, long B, long C) {
        System.out.printf("%s - %s - %s %n", A, B, C);
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        if (A < 0)
            return ((A + C) % C * powerStackOverflow(A, --B, C) % C) % C;
        else
            return (A % C * powerStackOverflow(A, --B, C) % C) % C;
    }

    private long power(long A, long B, long C) {
//        System.out.printf("%s - %s - %s %n", A, B, C);
        if (A == 0)
            return 0;
        if (B == 0)
            return 1;
        if (B == 1) {
            if (A < 0)
                return (A + C) % C;
            else
                return A;
        }

        long x;
        x = power(A, B / 2, C);
        long l = ((x % C) * (x % C)) % C;
        if (B % 2 == 0) {
            return l;
        } else {
            return (A % C * l % C) % C;
        }
    }

    public static void main(String[] args) {
        int A = 2, B = 3, C = 3;
        System.out.println(new AQ1ImplementPowerFunction().pow(A, B, C));
        int A1 = 0, B1 = 0, C1 = 1;
        System.out.println(new AQ1ImplementPowerFunction().pow(A1, B1, C1));
        int A2 = -1, B2 = 1, C2 = 20;
        System.out.println(new AQ1ImplementPowerFunction().pow(A2, B2, C2));
//        System.out.println(-1 % 20);
        //A%m
        //(A+m)%m = A%m + m%m
        //(-1 + 20)%20

        int A3 = 71045970;
        int B3 = 41535484;
        int C3 = 64735492;
        System.out.println(new AQ1ImplementPowerFunction().pow(A3, B3, C3));

        int A4 = -1;
        int B4 = 2;
        int C4 = 20;
        System.out.println(new AQ1ImplementPowerFunction().pow(A4, B4, C4)); //1

        int A5 = 79161127;
        int B5 = 99046373;
        int C5 = 57263970;
        System.out.println(new AQ1ImplementPowerFunction().pow(A5, B5, C5));//        The expected return value: 47168647
    }
}
