package scaler.advancedDsa.recursion2;


import java.util.ArrayList;

public class AQ2GrayCode {
//    Problem Description
//    The gray code is a binary numeral system where two successive values differ in only one bit.
//    Given a non-negative integer A representing the total number of bits in the code, print the sequence of gray code.
//    A gray code sequence must begin with 0.
//    Problem Constraints
//1 <= A <= 16
//    Input Format
//    The first argument is an integer A.
//            Output Format
//    Return an array of integers representing the gray code sequence.
//    Example Input
//    Input 1:
//    A = 2
//    Input 1:
//    A = 1
//    Example Output
//    output 1:
//            [0, 1, 3, 2]
//    output 2:
//            [0, 1]
//    Example Explanation
//    Explanation 1:
//            for A = 2 the gray code sequence is:
//            00 - 0
//            01 - 1
//            11 - 3
//            10 - 2
//    So, return [0,1,3,2].
//    Explanation 1:
//            for A = 1 the gray code sequence is:
//            00 - 0
//            01 - 1
//    So, return [0, 1].

    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> ansList = new ArrayList<>();
        if (a == 1) {
            ansList.add(0);
            ansList.add(1);
            return ansList;
        }
        ArrayList<Integer> tempList = grayCode(a - 1);
        ansList.addAll(tempList);
        for (int i = tempList.size() - 1; i >= 0; i--) {
            ansList.add((int) (tempList.get(i) + Math.pow(2, a - 1)));
        }
        return ansList;
    }


    public static void main(String[] args) {
        int input1A = 2;
        System.out.println(new AQ2GrayCode().grayCode(input1A));
        int input2A = 1;
        System.out.println(new AQ2GrayCode().grayCode(input2A));
        System.out.println(new AQ2GrayCode().grayCode(4));
        System.out.println(new AQ2GrayCode().grayCode(5));
    }
}
