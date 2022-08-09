package scaler.module1.modulararithmeticintroduction;

public class HWQ2ConcatenateThreeNumbers {
    //    Problem Description
//    Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.
//    Return the minimum result obtained.
//            Problem Constraints
//10 <= A, B, C <= 99
//    Input Format
//    The first argument of input contains an integer, A.
//    The second argument of input contains an integer, B.
//    The third argument of input contains an integer, C.
//    Output Format
//    Return an integer representing the answer.
//    Example Input
//    Input 1:
//    A = 10
//    B = 20
//    C = 30
//    Input 2:
//    A = 55
//    B = 43
//    C = 47
//    Example Output
//    Output 1:
//            102030
//    Output 2:
//            434755
//    Example Explanation
//    Explanation 1:
//            10 + 20 + 30 = 102030
//    Explanation 2:
//            43 + 47 + 55 = 434755
    public int solve(int A, int B, int C) {
//        String str = "";
//        if (A < B && A < C) {
//            s = s + A;
//            s = s + Math.min(B, C);
//            s = s + Math.max(B, C);
//        } else if (B < C && B < A) {
//            s = s + B;
//            s = s + Math.min(C, A);
//            s = s + Math.max(C, A);
//        } else if (C < A && C < B) {
////        } else if (C < A && C < B) {
//            s = s + C;
//            s = s + Math.min(A, B);
//            s = s + Math.max(A, B);
//        } else if (A == B && B == C) {
//            s = s + A + B + C;
//        } else if (A == B) {
//            if (A < C) {
//                s = s + A + B + C;
//            } else {
//                s = s + C + B + A;
//            }
//        }

        int f = Math.min(Math.min(A, B), C);
        int t = Math.max(Math.max(A, B), C);
        int sec = A + B + C - f - t;
        return Integer.parseInt("" + f + sec + t);
    }

    public static void main(String[] args) {
        int input1A = 10;
        int input1B = 20;
        int input1C = 30;
        System.out.println(new HWQ2ConcatenateThreeNumbers().solve(input1A, input1B, input1C));
        int input2A = 55;
        int input2B = 43;
        int input2C = 47;
        System.out.println(new HWQ2ConcatenateThreeNumbers().solve(input2A, input2B, input2C));
    }
}
