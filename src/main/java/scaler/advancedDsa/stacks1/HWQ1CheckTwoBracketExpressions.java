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
//        String input1A = "-(a+b+c)";
//        String input1B = "-a-b-c";
//        System.out.println(new HWQ1CheckTwoBracketExpressions().solve(input1A, input1B));//1
//
//        String input2A = "a-b-(c-d)";
//        String input2B = "a-b-c-d";
//        System.out.println(new HWQ1CheckTwoBracketExpressions().solve(input2A, input2B));//0

        String input3A = "-(a+b-c)+(-d+e-f)-(-g-h-i+j)";
        String input3B = "-a-b+c-d+e-f+g+h+i-j";
        System.out.println(new HWQ1CheckTwoBracketExpressions().solve(input3A, input3B));//1

        //Write nested bracket case
    }

    public int solve(String A, String B) {
        //keep on pushing until we encounter
        //opening bracket '(' we need to store the sign in front of the bracket. if nothing we will consider it as '+' by default
        //opening bracket '(' followed by an operand eg:'a' should be prepended with a '+'
        //closing bracket ')' we need to pop and invert each operator so '+' becomes '-' and '-' becomes '+' and then re push into the stack without brackets.
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        boolean isLastOpeningBracketSignNegative = false;
        for (int i = 0; i < A.length(); i++) {
            switch (A.charAt(i)) {
                case '+':
                    if (!stackA.isEmpty() && stackA.peek().equals('-')) {
                        stackA.pop();
                        stackA.push('-');
                    } else if (!stackA.isEmpty() && stackA.peek().equals('+')) {

                    } else {
                        stackA.push(A.charAt(i));
                    }
                    break;
                case '-':
                    if (!stackA.isEmpty() && stackA.peek().equals('-')) {
                        stackA.pop();
                        stackA.push('+');
                    } else if (!stackA.isEmpty() && stackA.peek().equals('+')) {

                    } else {
                        stackA.push(A.charAt(i));
                    }
                    break;
                case '(':
//                    System.out.println("stackA.peek() : " + stackA.peek() + " | " + stackA.peek().equals('-'));
                    isLastOpeningBracketSignNegative = (stackA.peek().equals('-'));
                    stackA.push(A.charAt(i));
                    if ('a' <= A.charAt(i + 1) && A.charAt(i + 1) <= 'z') {
                        stackA.push('+');
                        i++;
                        stackA.push(A.charAt(i));
                    }
                    break;
                case ')':
                    Stack<Character> tempStack = new Stack<>();
                    while (!stackA.isEmpty()) {
                        if (!stackA.isEmpty() && stackA.peek().equals('(')) {
                            if (isLastOpeningBracketSignNegative) {
                                isLastOpeningBracketSignNegative = false;
                                stackA.pop();
                            }
                            stackA.pop();
                            break;
                        }
//                        System.out.println("entering  isLastOpeningBracketSignNegative : " + isLastOpeningBracketSignNegative);
                        if (isLastOpeningBracketSignNegative) {
//                            System.out.println("entered  isLastOpeningBracketSignNegative : " + isLastOpeningBracketSignNegative);
                            Character peek = stackA.peek();
//                            System.out.println("peek : " + peek);
                            if (peek.equals('-')) {
//                                System.out.println("pushing : +");
                                tempStack.push('+');
                                stackA.pop();
                            } else if (peek.equals('+')) {
//                                System.out.println("pushing : -");
                                tempStack.push('-');
                                stackA.pop();
                            } else {
                                tempStack.push(stackA.pop());
                            }
                        } else {
//                            System.out.println("elese called + " + stackA.peek());
                            tempStack.push(stackA.pop());
                        }
                    }
                    System.out.println("tempstack : " + tempStack);
                    while (!tempStack.isEmpty()) {
                        stackA.push(tempStack.pop());
                    }
                    System.out.println("StackA : " + stackA);
                    break;
                default://operand case
                    stackA.push(A.charAt(i));
            }
        }
        System.out.println(stackA);
        System.out.println(B);
        int i = B.length() - 1;
        while (!stackA.isEmpty()) {
            if (!stackA.pop().equals(B.charAt(i))) {
                return 0;
            }
            i--;
        }
        return 1;
    }
}
