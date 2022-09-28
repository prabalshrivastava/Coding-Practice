package scaler.advancedDsa.binarysearch2;

public class AQ4AthMagicalNumber {
    //    Problem Description
//    You are given three positive integers, A, B, and C.
//    Any positive integer is magical if divisible by either B or C.
//    Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
//    Problem Constraints
//1 <= A <= 109
//            2 <= B, C <= 40000
//    Input Format
//    The first argument given is an integer A.
//    The second argument given is an integer B.
//    The third argument given is an integer C.
//    Output Format
//    Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
//    Example Input
//    Input 1:
//    A = 1
//    B = 2
//    C = 3
//    Input 2:
//    A = 4
//    B = 2
//    C = 3
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            6
//    Example Explanation
//    Explanation 1:
//            1st magical number is 2.
//    Explanation 2:
//    First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
    public int solve(int A, int B, int C) {
        long l = Math.min(B, C);
        long r = A * l;
        long ans = l;
        long lcm = lcm(B, C);
        while (l <= r) {
            long mid = (l + r) / 2;
            long count = check(mid, B, C,lcm);
            System.out.println("count : " + count);
            if (count == A) {
                ans = mid;
                r = mid - 1;
            } else if (count < A) {
                l = mid + 1;
            } else
                r = mid - 1;
        }
        return (int) ans;
    }

    private long check(long mid, long a, long b, long lcm) {
        return mid / a + mid / b + mid / lcm;
    }

    private long lcm(long b, long c) {
        long lcm = b * c / gcd(b, c);
        System.out.println("lcm : " + lcm);
        return lcm;
    }

    public static void main(String[] args) {
        System.out.println(new AQ4AthMagicalNumber().solve(1, 2, 3));
        System.out.println(new AQ4AthMagicalNumber().solve(4, 2, 3));
    }

    long gcd(long a, long b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (b > a) {
            return gcd(b % a, a);
        } else {
            return gcd(a % b, b);
        }
    }
}
