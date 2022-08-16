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
        return A;
    }

    public static void main(String[] args) {
        int A = 2, B = 3, C = 3;
        System.out.println(new AQ1ImplementPowerFunction().pow(A, B, C));
    }
}
