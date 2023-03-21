package scaler.advancedDsa.backtracking1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HWQ3RemoveInvalidParentheses1 {

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
    System.out.println(Arrays.toString(new HWQ3RemoveInvalidParentheses1().solve(input1A)));
    String input2A = "(a)())()";
    System.out.println(Arrays.toString(new HWQ3RemoveInvalidParentheses1().solve(input2A)));
  }

  public String[] solve(String A) {
    invalidParenthesis(A, 0, 0, new StringBuilder(""));
    System.out.println(list);
    return null;
  }

  List<String> list = new ArrayList<>();

  private void invalidParenthesis(String A, int i, int count, StringBuilder res) {
    System.out.println(i + " - " + count + " -> " + res);
    if (count < 0) {
//      System.out.println("removing : " + res);
      res.delete(res.length() - 2, res.length() - 1);
//      System.out.println("post removing : " + res);
      return;
    }
    if (i == A.length()) {
      if (count == 0) {
        //reached answer
        list.add(String.valueOf(res));
        return;
      }
    }
    res = res.append(A.charAt(i));
    if (A.charAt(i) == '(') {
      invalidParenthesis(A, i + 1, count + 1, res);
    } else if (A.charAt(i) == ')') {
      invalidParenthesis(A, i + 1, count - 1, res);
    }
  }
}