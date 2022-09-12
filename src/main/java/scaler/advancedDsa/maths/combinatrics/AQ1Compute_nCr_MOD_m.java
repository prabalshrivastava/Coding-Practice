package scaler.advancedDsa.maths.combinatrics;

public class AQ1Compute_nCr_MOD_m {
    //    Problem Description
//    Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
//            x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
//            Problem Constraints
//1 <= A * B <= 106
//            1 <= B <= A
//1 <= C <= 106
//    Input Format
//    The first argument given is integer A ( = n).
//    The second argument given is integer B ( = r).
//    The third argument given is integer C ( = m).
//    Output Format
//    Return the value of nCr % m.
//            Example Input
//    Input 1:
//    A = 5
//    B = 2
//    C = 13
//    Input 2:
//    A = 6
//    B = 2
//    C = 13
//    Example Output
//    Output 1:
//            10
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//    The value of 5C2 % 11 is 10.
//    Explanation 2:
//    The value of 6C2 % 13 is 2.
    public static void main(String[] args) {
        int input1A = 5, input1B = 2, input1C = 13;
        System.out.println(new AQ1Compute_nCr_MOD_m().solve(input1A, input1B, input1C));//        10
        int input2A = 6, input2B = 2, input2C = 13;
        System.out.println(new AQ1Compute_nCr_MOD_m().solve(input2A, input2B, input2C));//        2
        int input3A = 5, input3B = 2, input3C = 5;
        System.out.println(new AQ1Compute_nCr_MOD_m().solve(input3A, input3B, input3C));//        0

        int input4A = 41, input4B = 27, input4C = 143;
        System.out.println(new AQ1Compute_nCr_MOD_m().solve(input4A, input4B, input4C));//        58

        int input5A = 38, input5B = 5, input5C = 81;
        System.out.println(new AQ1Compute_nCr_MOD_m().solve(input5A, input5B, input5C));//        66

        int input6A = 23, input6B = 8, input6C = 228;
        System.out.println(new AQ1Compute_nCr_MOD_m().solve(input6A, input6B, input6C));//        114
        int input7A = 96, input7B = 21, input7C = 123;
        System.out.println(new AQ1Compute_nCr_MOD_m().solve(input7A, input7B, input7C));//        0
    }

    public int solve(int A, int B, int C) {
        //nCr = (n-1)C(r-1) + (n-1)Cr
        return (int) (nCrI(A, B, C) % C);
    }

    long nCrI(long n, long r, long m) {
        if (n == r)
            return 1;
        if (r == 0)
            return 1;
        if (r == 1)
            return n % m;
        long max = Math.max(r, n - r);
        long min = Math.min(r, n - r);
        long upperTerm = n;
        long lowerTerm = min;
        double prod = 1;
        while (upperTerm > (n - min)) {
            System.out.println("upperTerm : " + upperTerm);
            if (lowerTerm >= 1) {
                prod = ((prod * upperTerm) / lowerTerm);
            } else {
                prod = (prod * upperTerm);
            }
            prod = prod%m;
            System.out.println("prod : " + prod);
            upperTerm--;
            lowerTerm--;
        }
        while (lowerTerm >= 1) {
            prod = prod / lowerTerm;
            lowerTerm--;
        }
        return ((long) Math.round(prod)) % m;
    }

    long nCr(long n, long r, long m) {
        if (n == r)
            return 1;
        if (r == 0)
            return 1;
        if (r == 1)
            return n % m;
        return (nCr(n - 1, r - 1, m) % m) + (nCr(n - 1, r, m) % m);
    }

}
