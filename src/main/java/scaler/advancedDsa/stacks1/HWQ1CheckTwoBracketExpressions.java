package scaler.advancedDsa.stacks1;

import java.util.Stack;

public class HWQ1CheckTwoBracketExpressions {
    //    Problem Description
//    Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
//    The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
//    NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
//    Problem Constraints
//1 <= length of the each String <= 100
//    Input Format
//    The given arguments are string A and string B.
//            Output Format
//    Return 1 if they represent the same expression else return 0.
//    Example Input
//    Input 1:
//    A = "-(a+b+c)"
//    B = "-a-b-c"
//    Input 2:
//    A = "a-b-(c-d)"
//    B = "a-b-c-d"
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B.
//            Explanation 2:
//    Both the expression are different.
    public static void main(String[] args) {
        String input1A = "-(a+b+c)";
        String input1B = "-a-b-c";
//        System.out.println(new HWQ1CheckTwoBracketExpressions().solve(input1A, input1B));//1

        String input2A = "a-b-(c-d)";
        String input2B = "a-b-c-d";
//        System.out.println(new HWQ1CheckTwoBracketExpressions().solve(input2A, input2B));//0

        String input3A = "-(a+b-c)+(-d+e-f)-(-g-h-i+j)";
        String input3B = "-a-b+c-d+e-f+g+h+i-j";
        System.out.println(new HWQ1CheckTwoBracketExpressions().solve(input3A, input3B));//1

        String input4A = "(a+b-c-d+e-f+g+h+i)";
        String input4B = "a+b-c-d+e-f+g+h+i";
        System.out.println(new HWQ1CheckTwoBracketExpressions().solve(input4A, input4B));//1

        String input5A = "(a+b-c-d+e-f+g+h+i)";
        String input5B = "a+b-c-d+e-f+g+h+i";
        System.out.println(new HWQ1CheckTwoBracketExpressions().solve(input5A, input5B));//1
        //Write nested bracket case
    }

    public int solve(String A, String B) {

        return 0;
    }
}
