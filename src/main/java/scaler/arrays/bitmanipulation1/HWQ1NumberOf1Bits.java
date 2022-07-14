package scaler.arrays.bitmanipulation1;

public class HWQ1NumberOf1Bits {
    //    Problem Description
//    Write a function that takes an integer and returns the number of 1 bits it has.
//
//
//            Problem Constraints
//1 <= A <= 109
//
//
//    Input Format
//    First and only argument contains integer A
//
//
//    Output Format
//    Return an integer as the answer
//
//
//    Example Input
//    Input1:
//            11
//
//
//    Example Output
//    Output1:
//            3
//
//
//    Example Explanation
//    Explaination1:
//            11 is represented as 1011 in binary.
    public static void main(String[] args) {
        System.out.println(new HWQ1NumberOf1Bits().numSetBits(11));
        System.out.println(new HWQ1NumberOf1Bits().numSetBits(450676354));
    }

    public int numSetBits(int A) {
        int n = A;
        int count = 0;
        while (n != 0) {
            int remainder = n % 2;
            if (remainder == 1) count++;
            n = n / 2;
        }
        return count;
    }
}
