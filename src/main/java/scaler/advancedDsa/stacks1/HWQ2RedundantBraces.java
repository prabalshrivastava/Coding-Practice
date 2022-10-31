package scaler.advancedDsa.stacks1;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HWQ2RedundantBraces {
    //    Problem Description
//    Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
//    Check whether A has redundant braces or not.
//    NOTE: A will be always a valid expression and will not contain any white spaces.
//    Problem Constraints
//1 <= |A| <= 105
//    Input Format
//    The only argument given is string A.
//            Output Format
//    Return 1 if A has redundant braces else, return 0.
//    Example Input
//    Input 1:
//    A = "((a+b))"
//    Input 2:
//    A = "(a+(a+b))"
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//            ((a+b)) has redundant braces so answer will be 1.
//    Explanation 2:
//            (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
    public static void main(String[] args) {
        System.out.println(new HWQ2RedundantBraces().braces("((a+b))"));//1
        System.out.println("--------------------------------------------");
        System.out.println(new HWQ2RedundantBraces().braces("(a+(a+b))"));//0
        System.out.println(new HWQ2RedundantBraces().braces("((a+b)+a)"));//0
        System.out.println("--------------------------------------------");
        System.out.println(new HWQ2RedundantBraces().braces("{{[((a+b))]}}"));//1
        System.out.println("--------------------------------------------");
    }

    public int bracesWithMap(String A) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('}', '{');
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        //key - closing
        //value - opening
        for (int i = 0; i < A.length(); i++) {
            char currChar = A.charAt(i);
            boolean isClosingBracket = bracketMap.containsKey(currChar);
            if (stackNotEmpty(stack) && isClosingBracket) {
                System.out.println("closing bracket : " + currChar);
                //if stack.peek() is an opening bracket
                boolean isOpeningBracket = isOpeningBracket(stack.peek(), bracketMap);
                if (isOpeningBracket) {
                    return 1;
                }
                //boolean isContinuousBraces = false;
                //Continue poping from stack until we encounter opening bracket.
                while (stackNotEmpty(stack) && !isOpeningBracket(stack.peek(), bracketMap)) {
                    System.out.println("poping : " + stack.pop());
                }
                if (stackNotEmpty(stack) && isOpeningBracket(stack.peek(), bracketMap)) {
                    System.out.println("poping opening bracket : " + stack.pop());
                }
//                int count = 0;
//                while (!stack.isEmpty() && stack.peek().equals(bracketMap.getOrDefault(currChar, '\n'))) {
//                    count++;
//                }
            } else if ((currChar < 'A' || currChar > 'Z') && (currChar < 'a' || currChar > 'z')) {
                stack.push(currChar);
            }
            System.out.println(stack);
        }
        return 0;
    }

    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char currChar = A.charAt(i);
            if (currChar == '}' || currChar == ')' || currChar == ']') {
                if (stackNotEmpty(stack) && (stack.peek() == '(' || stack.peek() == '{' || stack.peek() == '[')) {
                    return 1;
                }
                while (stackNotEmpty(stack) && !(stack.peek() == '(' || stack.peek() == '{' || stack.peek() == '[')) {
                    stack.pop();
                }
                if (stackNotEmpty(stack)) {
                    stack.pop();
                }
            } else if ((currChar < 'A' || currChar > 'Z') && (currChar < 'a' || currChar > 'z')) {
                stack.push(currChar);
            }
            System.out.println(stack);
        }
        return 0;
    }


    private boolean stackNotEmpty(Stack<Character> stack) {
        return !stack.isEmpty();
    }

    private boolean isOpeningBracket(char currChar, Map<Character, Character> bracketMap) {
        Character character = bracketMap.getOrDefault(currChar, '\n');
        return bracketMap.containsValue(character);
    }
}
