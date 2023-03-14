package scaler.advancedDsa.backtracking1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class HWQ3RemoveInvalidParentheses {

  //  Problem Description
//  Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'. Remove the minimum number of invalid parentheses in order to make the input string valid.
//  Return all possible results.
//  You can return the results in any order.
//      Problem Constraints
//1 <= length of the string <= 20
//  Input Format
//  The only argument given is string A.
//      Output Format
//  Return all possible strings after removing the minimum number of invalid parentheses.
//  Example Input
//  Input 1:
//  A = "()())()"
//  Input 2:
//  A = "(a)())()"
//  Example Output
//  DocFinder.Output 1:
//      ["()()()", "(())()"]
//  Output 2:
//      ["(a)()()", "(a())()"]
//  Example Explanation
//  Explanation 1:
//  By removing 1 parentheses we can make the string valid.
//        1. Remove the parentheses at index 4 then string becomes : "()()()"
//      2. Remove the parentheses at index 2 then string becomes : "(())()"
//  Explanation 2:
//  By removing 1 parentheses we can make the string valid.
//        1. Remove the parentheses at index 5 then string becomes : "(a)()()"
//      2. Remove the parentheses at index 2 then string becomes : "(a())()"
  public static void main(String[] args) {
    String input1A = "()())()";
    System.out.println(Arrays.toString(new HWQ3RemoveInvalidParentheses().solve(input1A)));
    String input2A = "(a)())()";
    System.out.println(Arrays.toString(new HWQ3RemoveInvalidParentheses().solve(input2A)));
  }

  public String[] solve(String A) {
    int mra = getMinRemovalAllowed(A);
    findCombination(A, mra);
    return result.toArray(new String[0]);
  }

  HashSet<String> result = new HashSet<>();

  private void findCombination(String A, int mra) {
//    System.out.println("findCombination : " + A);
    if (mra == 0) {
      if (getMinRemovalAllowed(A) == 0) {
        result.add(A);
      }
      return;
    }
    for (int i = 0; i < A.length(); i++) {
      String str = A.substring(0, i) + A.substring(i + 1);
//      System.out.println(i + "->" + str);
      findCombination(str, mra - 1);
    }
  }

  private int getMinRemovalAllowed(String a) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < a.length(); i++) {
      char currCharacter = a.charAt(i);
      switch (currCharacter) {
        case ')':
          if (stack.isEmpty()) {
            stack.push(currCharacter);
          } else if (stack.peek().equals(')')) {
            stack.push(currCharacter);
          } else if (stack.peek().equals('(')) {
            stack.pop();
          }
          break;
        case '(':
          stack.push(currCharacter);
          break;
      }
    }
    return stack.size();
  }
}