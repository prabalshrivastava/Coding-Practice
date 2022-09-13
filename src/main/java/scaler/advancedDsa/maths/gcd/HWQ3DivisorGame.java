package scaler.advancedDsa.maths.gcd;

public class HWQ3DivisorGame {
    //    Problem Description
//    Scooby has 3 three integers A, B, and C.
//    Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell the number of special integers less than or equal to A.
//            Problem Constraints
//1 <= A, B, C <= 109
//    Input Format
//    First argument is a positive integer A
//    Second argument is a positive integer B
//    Third argument is a positive integer C
//    Output Format
//    One integer corresponding to the number of special integers less than or equal to A.
//            Example Input
//    Input 1:
//    A = 12
//    B = 3
//    C = 2
//    Input 2:
//    A = 6
//    B = 1
//    C = 4
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
//    Explanation 2:
//    Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.
    public int solve(int A, int B, int C) {
        int lcm = (B * C) / gcd(B, C);
        int count = 1;
        while (lcm * count <= A) {
//            System.out.println("count : " + count + " -  prod : " + (lcm * count));
            count++;
        }
        return count - 1;
    }

    public int gcd(int A, int B) {
        if (A == 0)
            return B;
        if (B == 0)
            return A;
        if (A <= B) {
            return gcd(B % A, A);
        } else {
            return gcd(A % B, B);
        }
    }


    public static void main(String[] args) {
        int input1A = 12, input1B = 3, input1C = 2;
        System.out.println(new HWQ3DivisorGame().solve(input1A, input1B, input1C));
        int input2A = 6, input2B = 1, input2C = 4;
        System.out.println(new HWQ3DivisorGame().solve(input2A, input2B, input2C));
    }
}
