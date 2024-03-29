package scaler.module1.subsequencesAndSubsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AQ1LittlePonnyAnd2Subsequence {

  //    Problem Description
//    Little Ponny has been given a string A, and he wants to find out the lexicographically minimum subsequence from it of size >= 2. Can you help him?
//    A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a. For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c' which is smaller in "abc".
//    Problem Constraints
//1 <= |A| <= 105
//    A only contains lowercase alphabets.
//            Input Format
//    The first and the only argument of input contains the string, A.
//            Output Format
//    Return a string representing the answer.
//    Example Input
//    Input 1:
//    A = "abcdsfhjagj"
//    Input 2:
//    A = "ksdjgha"
//    Example Output
//    Output 1:
//            "aa"
//    Output 2:
//            "da"
//    Example Explanation
//    Explanation 1:
//            "aa" is the lexicographically minimum subsequence from A.
//            Explanation 2:
//            "da" is the lexicographically minimum subsequence from A.
  public String solveBruteForce(String A) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i <= Math.pow(2, A.length()); i++) {
      StringBuilder stringBuilder = new StringBuilder();
      for (int j = 0; j < A.length(); j++) {
        if ((1 << j & i) != 0) {
          stringBuilder.append(A.charAt(j));
        }
      }
      if (stringBuilder.length() >= 2) {
        list.add(stringBuilder.toString());
      }
    }
    Collections.sort(list);
    System.out.println(list);
    System.out.println(list.size());
    return list.get(0);
  }

  public String solve(String A) {
    char firstChar = Character.MAX_VALUE;
    int firstCharIndex = -1;
    char secondChar = Character.MAX_VALUE;
    for (int i = 0; i < A.length() - 1; i++) {
      if (A.charAt(i) < firstChar) {
        firstChar = A.charAt(i);
        firstCharIndex = i;
      }
    }
    for (int i = firstCharIndex + 1; i < A.length(); i++) {
      if (A.charAt(i) < secondChar && i != firstCharIndex) {
        secondChar = A.charAt(i);
      }
    }
    return firstChar + "" + secondChar;
  }

  public static void main(String[] args) {
    String input1A = "abcdsfhjagj";
    System.out.println(new AQ1LittlePonnyAnd2Subsequence().solve(input1A));
    String input2A = "ksdjgha";
    System.out.println(new AQ1LittlePonnyAnd2Subsequence().solve(input2A));
    System.out.println(new AQ1LittlePonnyAnd2Subsequence().solve("scsecugqsb"));
    System.out.println(new AQ1LittlePonnyAnd2Subsequence().solve("djjhibvetj"));
  }
}