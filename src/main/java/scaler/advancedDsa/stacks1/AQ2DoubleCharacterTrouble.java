package scaler.advancedDsa.stacks1;

import java.util.Stack;

public class AQ2DoubleCharacterTrouble {
    //    Problem Description
//    You are given a string A.
//    An operation on the string is defined as follows:
//    Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
//    Therefore the string after this operation will be "acd".
//    Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.
//            Problem Constraints
//1 <= |A| <= 100000
//    Input Format
//    First and only argument is string A.
//            Output Format
//    Return the final string.
//            Example Input
//    Input 1:
//    A = abccbc
//    Input 2:
//    A = ab
//    Example Output
//    Output 1:
//            "ac"
//    Output 2:
//            "ab"
//    Example Explanation
//    Explanation 1:
//    Remove the first occurrence of same consecutive characters. eg for a string "abbc",
//    the first occurrence of same consecutive characters is "bb".
//    Therefore the string after this operation will be "ac".
//    Explanation 2:
//    No removals are to be done.
    public static void main(String[] args) {
        System.out.println(new AQ2DoubleCharacterTrouble().solve("abccbc"));       //ac
        System.out.println(new AQ2DoubleCharacterTrouble().solve("ab"));       //ab
        System.out.println(new AQ2DoubleCharacterTrouble().solve("abbd"));     //ad
        System.out.println(new AQ2DoubleCharacterTrouble().solve("abccbde"));      //ade
        System.out.println(new AQ2DoubleCharacterTrouble().solve("abbbd"));        //abd
        System.out.println(new AQ2DoubleCharacterTrouble().solve("abbcbbcacx"));       //cx
        System.out.println(new AQ2DoubleCharacterTrouble().solve("abcdccdcaabxxdad"));     //adad
    }

    public String solve(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if (!stack.isEmpty() && stack.peek().equals(A.charAt(i))) {
                stack.pop();
            } else {
                stack.push(A.charAt(i));
            }
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}
