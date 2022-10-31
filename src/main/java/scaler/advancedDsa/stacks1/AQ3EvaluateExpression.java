package scaler.advancedDsa.stacks1;

import org.w3c.dom.Notation;

import java.util.Map;
import java.util.Stack;

public class AQ3EvaluateExpression {
    //    Problem Description
//    An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation .
//    Valid operators are +, -, *, /. Each string may be an integer or an operator.
//            Problem Constraints
//1 <= N <= 105
//    Input Format
//    The only argument given is string array A.
//    Output Format
//    Return the value of arithmetic expression formed using reverse Polish Notation.
//            Example Input
//    Input 1:
//    A =   ["2", "1", "+", "3", "*"]
//    Input 2:
//    A = ["4", "13", "5", "/", "+"]
//    Example Output
//    Output 1:
//            9
//    Output 2:
//            6
//    Example Explanation
//    Explaination 1:
//    starting from backside:
//            * : () * ()
//            3 : () * (3)
//            + : (() + ()) * (3)
//            1 : (() + (1)) * (3)
//            2 : ((2) + (1)) * (3)
//            ((2) + (1)) * (3) = 9
//    Explaination 2:
//            + : () + ()
//            / : () + (() / ())
//            5 : () + (() / (5))
//            13 : () + ((13) / (5))
//            4 : (4) + ((13) / (5))
//            (4) + ((13) / (5)) = 6
    public static void main(String[] args) {
        String[] input1A = {"2", "1", "+", "3", "*"};
        System.out.println(new AQ3EvaluateExpression().evalRPN(input1A));
        String[] input2A = {"4", "13", "5", "/", "+"};
        System.out.println(new AQ3EvaluateExpression().evalRPN(input2A));
    }

    public int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            try {
                int x = Integer.parseInt(A[i]);
                stack.push(x);
            } catch (Exception exception) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = 0;
                switch (A[i]) {
                    case "+":
                        result = op1 + op2;
                        break;
                    case "-":
                        result = op1 - op2;
                        break;
                    case "/":
                        result = op1 / op2;
                        break;
                    case "*":
                        result = op1 * op2;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
