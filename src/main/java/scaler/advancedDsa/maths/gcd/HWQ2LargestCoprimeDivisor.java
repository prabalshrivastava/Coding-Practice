package scaler.advancedDsa.maths.gcd;

import java.util.ArrayList;
import java.util.List;

public class HWQ2LargestCoprimeDivisor {
//    Problem Description
//    You are given two positive numbers A and B . You need to find the maximum valued integer X such that:
//    X divides A i.e. A % X = 0
//    X and B are co-prime i.e. gcd(X, B) = 1
//    Problem Constraints
//1 <= A, B <= 109
//    Input Format
//    First argument is an integer A.
//    Second argument is an integer B.
//    Output Format
//    Return an integer maximum value of X as descibed above.
//    Example Input
//    Input 1:
//    A = 30
//    B = 12
//    Input 2:
//    A = 5
//    B = 10
//    Example Output
//    Output 1:
//            5
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    All divisors of A are (1, 2, 3, 5, 6, 10, 15, 30).
//    The maximum value is 5 such that A%5 == 0 and gcd(5,12) = 1
//    Explanation 2:
//            1 is the only value such that A%5 == 0 and gcd(1,10) = 1

    public static void main(String[] args) {
        int input1A = 30, input1B = 12;
        System.out.println(new HWQ2LargestCoprimeDivisor().cpFact(input1A, input1B));
        int input2A = 5, input2B = 10;
        System.out.println(new HWQ2LargestCoprimeDivisor().cpFact(input2A, input2B));
    }

    public int cpFact(int A, int B) {
        List<Integer> factorsList = new ArrayList<>();
        for (int i = 1; i * i <= A; i++) {
            if (A % i == 0) {
                factorsList.add(i);
                if (i * i != A)
                    factorsList.add(A / i);
            }
        }
        int ans = 1;
        for (int i = 0; i < factorsList.size(); i++) {
            Integer currentFactor = factorsList.get(i);
            if (gcd(currentFactor, B) == 1) {
                ans = Math.max(ans, currentFactor);
            }
        }
//        System.out.println(factorsList);
        return ans;
    }

    //    public int cpFact(int A, int B) {
//        int num = A;
//        int max = Integer.MIN_VALUE;
//        for (int i = 1; i <= A / 2; i++) {
//            if (A % i == 0) {
//                int gcd1 = gcd(i, B);
//                int gcd2 = gcd(A / i, B);
//                if (gcd1 == 1) {
//                    max = Math.max(i, max);
//                }
//                if (gcd2 == 1) {
//                    max = Math.max(A / i, max);
//                }
//            }
//        }
//        return A;
//    }
//
//    private int getMaxGCD(int max, int gcd) {
//        if (gcd == 1) {
//            max = Math.max(gcd, max);
//        }
//        return max;
//    }
//
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
