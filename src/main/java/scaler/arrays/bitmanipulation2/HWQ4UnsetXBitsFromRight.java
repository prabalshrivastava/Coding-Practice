package scaler.arrays.bitmanipulation2;

public class HWQ4UnsetXBitsFromRight {
    //    Problem Description
//    Given an integer A. Unset B bits from the right of A in binary.
//    For eg:-
//    A = 93, B = 4
//    A in binary = 1011101
//    A should become = 1010000 = 80. Therefore return 80.
//
//
//    Problem Constraints
//1 <= A <= 1018
//            1 <= B <= 60
//
//
//    Input Format
//    The first argument is a single integer A.
//    The second argument is a single integer B.
//
//
//    Output Format
//    Return the number with B unset bits from the right.
//
//
//    Example Input
//    Input 1:-
//    A = 25
//    B = 3
//    Input 2:-
//    A = 37
//    B = 3
//
//
//    Example Output
//    Output 1:-
//            24
//    Output 2:-
//            32
//
//
//    Example Explanation
//    Explanation 1:-
//    A = 11001 to 11000
//    Explantio 2:-
//    A = 100101 to 100000
    public static void main(String[] args) {
        int input1A = 25;
        int input1B = 3;
        System.out.println(new HWQ4UnsetXBitsFromRight().solve(input1A, input1B));
        int input2A = 37;
        int input2B = 3;
        System.out.println(new HWQ4UnsetXBitsFromRight().solve(input2A, input2B));
    }

    public long solve(long A, int B) {
        A = A >> B;
        return A << B;
    }
}
