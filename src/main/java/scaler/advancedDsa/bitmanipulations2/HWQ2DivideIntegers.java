package scaler.advancedDsa.bitmanipulations2;

public class HWQ2DivideIntegers {
    //    Problem Description
//    Divide two integers without using multiplication, division and mod operator.
//    Return the floor of the result of the division.
//            Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
//            NOTE: INT_MAX = 2^31 - 1
//    Problem Constraints
//-231 <= A, B <= 231-1
//    B != 0
//    Input Format
//    The first argument is an integer A denoting the dividend.
//    The second argument is an integer B denoting the divisor.
//    Output Format
//    Return an integer denoting the floor value of the division.
//    Example Input
//    Input 1:
//    A = 5
//    B = 2
//    Input 2:
//    A = 7
//    B = 1
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            7
//    Example Explanation
//    Explanation 1:
//    floor(5/2) = 2
    public static void main(String[] args) {
        int input1A = 5, input1B = 2;
        System.out.println(new HWQ2DivideIntegers().divide(input1A, input1B));
        int input2A = 7, input2B = 1;
        System.out.println(new HWQ2DivideIntegers().divide(input2A, input2B));
    }

    public int divide(int A, int B) {
        return A;
    }
}
