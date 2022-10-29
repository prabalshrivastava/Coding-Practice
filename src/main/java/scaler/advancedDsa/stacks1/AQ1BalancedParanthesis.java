package scaler.advancedDsa.stacks1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AQ1BalancedParanthesis {
//    Problem Description
//    Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
//    Refer to the examples for more clarity.
//    Problem Constraints
//1 <= |A| <= 100
//    Input Format
//    The first and the only argument of input contains the string A having the parenthesis sequence.
//    Output Format
//    Return 0 if the parenthesis sequence is not balanced.
//    Return 1 if the parenthesis sequence is balanced.
//            Example Input
//    Input 1:
//    A = {([])}
//    Input 2:
//    A = (){
//        Input 3:
//        A = ()[]
//        Example Output
//        Output 1:
//        1
//        Output 2:
//        0
//        Output 3:
//        1
//        Example Explanation
//        You can clearly see that the first and third case contain valid paranthesis.
//                In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.

    public static void main(String[] args) {
        String input1A = "{([])}";
        System.out.println(new AQ1BalancedParanthesis().solve(input1A));
        String input2A = "(){";
        System.out.println(new AQ1BalancedParanthesis().solve(input2A));
        String input3A = "()[]";
        System.out.println(new AQ1BalancedParanthesis().solve(input3A));
        System.out.println(new AQ1BalancedParanthesis().solve("{([])}"));
        System.out.println(new AQ1BalancedParanthesis().solve("))))))))"));
    }

    public int solve(String A) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('}', '{');
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
//        System.out.println("Starting with : " + A);
        for (int i = 0; i < A.length(); i++) {
//            System.out.printf("%s%n", A.charAt(i));
            if (bracketMap.containsValue(A.charAt(i))) {
                stack.push(A.charAt(i));
//                System.out.println(stack);
            } else {
                if (!stack.isEmpty() && stack.peek().equals(bracketMap.getOrDefault(A.charAt(i), Character.MAX_VALUE))) {
                    stack.pop();
                } else {
                    return 0;
                }
//                System.out.println("Popped : " + stack.pop());
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
