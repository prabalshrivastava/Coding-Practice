package scaler.advancedDsa.modularArithmetic;

public class HWQ2VeryLargePower {
    //    Problem Description
//    Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
//            "^" means power,
//"%" means "mod", and
//"!" means factorial.
//    Problem Constraints
//1 <= A, B <= 5e5
//    Input Format
//    First argument is the integer A
//    Second argument is the integer B
//    Output Format
//    Return one integer, the answer to the problem
//    Example Input
//    Input 1:
//    A = 1
//    B = 1
//    Input 2:
//    A = 2
//    B = 2
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            4
//    Example Explanation
//    Explanation 1:
//            1! = 1. Hence 1^1 = 1.
//    Explanation 2:
//            2! = 2. Hence 2^2 = 4.
    public static void main(String[] args) {
        int input1A = 1, input1B = 1;
        System.out.println(new HWQ2VeryLargePower().solve(input1A, input1B));
        int input2A = 2, input2B = 2;
        System.out.println(new HWQ2VeryLargePower().solve(input2A, input2B));
    }

    public int solve(int A, int B) {

        return A;
    }

    long power(long a, long b) {
        if (b == 1)
            return a;
        if (b % 2 == 0) {

        } else {

        }
    }
}
