package scaler.maths.modulararithmeticintroduction;

public class AQ2ABAndModulo {
    //    Problem Description
//    Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
//            Problem Constraints
//1 <= A, B <= 109
//    A != B
//    Input Format
//    The first argument is an integer A.
//    The second argument is an integer B.
//            Output Format
//    Return an integer denoting the greatest possible positive M.
//            Example Input
//    Input 1:
//    A = 1
//    B = 2
//    Input 2:
//    A = 5
//    B = 10
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            5
//    Example Explanation
//    Explanation 1:
//            1 is the largest value of M such that A % M == B % M.
//            Explanation 2:
//    For M = 5, A % M = 0 and B % M = 0.
//    No value greater than M = 5, satisfies the condition.
    public int solveOn(int A, int B) {
        int m = 1;
        int i = Math.max(A, B);
        while (i >= 1) {
            if (A % i == B % i) {
                m = i;
                break;
            }
            i--;
        }
        return m;
    }
    public int solve(int A, int B) {
        return Math.abs(A-B);
    }


    public static void main(String[] args) {
        int input1A = 1;
        int input1B = 2;
        System.out.println(new AQ2ABAndModulo().solve(input1A, input1B));
        int input2A = 5;
        int input2B = 10;
        System.out.println(new AQ2ABAndModulo().solve(input2A, input2B));
        int input3A = 106978;
        int input3B = 4487506;
        System.out.println(new AQ2ABAndModulo().solve(input3A, input3B));
        int input4A = 8131620;
        int input4B = 3649516;
        System.out.println(new AQ2ABAndModulo().solve(input4A, input4B));
    }
}
