package scaler.advancedDsa.gcd;

import java.util.Arrays;

public class AQ1DeleteOne {
//    Problem Description
//    Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
//    Find the maximum value of GCD.
//    Problem Constraints
//2 <= N <= 105
//            1 <= A[i] <= 109
//    Input Format
//    First argument is an integer array A.
//            Output Format
//    Return an integer denoting the maximum value of GCD.
//            Example Input
//    Input 1:
//    A = [12, 15, 18]
//    Input 2:
//    A = [5, 15, 30]
//    Example Output
//    Output 1:
//            6
//    Output 2:
//            15
//    Example Explanation
//    Explanation 1:
//    If you delete 12, gcd will be 3.
//    If you delete 15, gcd will be 6.
//    If you delete 18, gcd will 3.
//    Maximum vallue of gcd is 6.
//    Explanation 2:
//    If you delete 5, gcd will be 15.
//    If you delete 15, gcd will be 5.
//    If you delete 30, gcd will be 5.

    public static void main(String[] args) {
        int[] input1A = {12, 15, 18};
        System.out.println(new AQ1DeleteOne().solve(input1A));
        int[] input2A = {5, 15, 30};
        System.out.println(new AQ1DeleteOne().solve(input2A));
    }

    public int solve(int[] A) {
        int[] pfGCD = new int[A.length];
        int[] sfGCD = new int[A.length];

        pfGCD[0] = A[0];
        for (int i = 1; i < A.length; i++) {
//            System.out.println(i + " - " + A[i] + " - " + pfGCD[i - 1]);
            pfGCD[i] = gcd(A[i], pfGCD[i - 1]);
        }
//        System.out.println(Arrays.toString(pfGCD));
        sfGCD[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            sfGCD[i] = gcd(A[i], sfGCD[i + 1]);
        }
//        System.out.println(Arrays.toString(sfGCD));

        int ans = sfGCD[1];
        for (int i = 1; i < A.length; i++) {
            int gcd;
            if (i == A.length - 1)
                gcd = pfGCD[i - 1];
            else
                gcd = gcd(pfGCD[i - 1], sfGCD[i + 1]);
            ans = Math.max(gcd, ans);
        }
        return ans;
    }

    int gcd(int a, int b) {
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
