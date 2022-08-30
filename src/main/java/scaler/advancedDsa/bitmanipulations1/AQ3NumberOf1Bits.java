package scaler.advancedDsa.bitmanipulations1;

public class AQ3NumberOf1Bits {
    //    Problem Description
//    Write a function that takes an integer and returns the number of 1 bits it has.
//            Problem Constraints
//1 <= A <= 109
//    Input Format
//    First and only argument contains integer A
//    Output Format
//    Return an integer as the answer
//    Example Input
//    Input1:
//            11
//    Example Output
//    Output1:
//            3
//    Example Explanation
//    Explaination1:
//            11 is represented as 1011 in binary.
    public static void main(String[] args) {
        System.out.println(new AQ3NumberOf1Bits().numSetBits(11));//3
    }

    public int numSetBits(int A) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((A >> i & 1) != 0) {
                count++;
            }
        }
        return count;
    }
}

