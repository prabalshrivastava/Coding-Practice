package scaler.maths.modulararithmeticintroduction;

public class AQ4ModString {
//    Problem Description
//    You are given a large number in the form of a string A where each character denotes a digit of the number.
//    You are also given a number B. You have to find out the value of A % B and return it.
//            Problem Constraints
//1 <= A.length() <= 105
//        0 <= Ai <= 9
//            1 <= B <= 109
//    Input Format
//    The first argument is a string A.
//    The second argument is an integer B.
//            Output Format
//    Return a single integer denoting the value of A % B.
//            Example Input
//    Input 1:
//    A = "143"
//    B = 2
//    Input 2:
//    A = "43535321"
//    B = 47
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            20
//    Example Explanation
//    Explanation 1:
//            143 is an odd number so 143 % 2 = 1.
//    Explanation 2:
//            43535321 % 47 = 20

    public static void main(String[] args) {
        String input1A = "143";
        int input1B = 2;
        System.out.println(new AQ4ModString().findMod(input1A, input1B));
        String input2A = "43535321";
        int input2B = 47;
        System.out.println(new AQ4ModString().findMod(input2A, input2B));
    }

    public int findMod(String A, int B) {

        return B;
    }
}
