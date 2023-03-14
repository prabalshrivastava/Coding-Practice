package scaler.advancedDsa.backtracking1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AQ2LetterPhone {

  //  Problem Description
//  Given a digit string A, return all possible letter combinations that the number could represent.
//  A mapping of digit to letters (just like on the telephone buttons) is given below.
//  The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
//      NOTE: Make sure the returned strings are lexicographically sorted.
//  Problem Constraints
//1 <= |A| <= 10
//  Input Format
//  The only argument is a digit string A.
//  Output Format
//  Return a string array denoting the possible letter combinations.
//      Example Input
//  Input 1:
//  A = "23"
//  Input 2:
//  A = "012"
//  Example Output
//  DocFinder.Output 1:
//      ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
//  Output 2:
//      ["01a", "01b", "01c"]
//  Example Explanation
//  Explanation 1:
//  There are 9 possible letter combinations.
//      Explanation 2:
//  Only 3 possible letter combinations.
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new AQ2LetterPhone().letterCombinations("23")));
    System.out.println(Arrays.toString(new AQ2LetterPhone().letterCombinations("012")));
  }

  public String[] letterCombinations(String A) {
    Map<Character, String> map = new HashMap<>();
    map.put('0', "0");
    map.put('1', "1");
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    combinations(A, map, 0, new char[A.length()]);
//    combinations(A, map, 0, new ArrayList<>());
//    System.out.println(result);
    return result.toArray(new String[0]);
  }

  List<String> result = new ArrayList<>();

  private void combinations(String A, Map<Character, String> map, int index,
      char[] characters) {
//      List<Character> characters) {
    if (index == A.length()) {
      result.add(String.valueOf(characters));
      return;
    }
    List<String> list = new ArrayList<>();
    char numberAtI = A.charAt(index);
//      System.out.printf("numberAt[%s] : %s\t", i, numberAtI);
    String elementsAssociatedWithNumber = map.get(numberAtI);
//      System.out.printf("index[%s] - elementsAssociatedWithNumber : %s%n",index, elementsAssociatedWithNumber);
    for (int j = 0; j < elementsAssociatedWithNumber.length(); j++) {
//      System.out.printf("index[%s]-j[%s] - before%s%n", index, j, characters);
      char a = elementsAssociatedWithNumber.charAt(j);
//      characters.add(a);
//      System.out.printf("index[%s]-j[%s] - after%s%n", index, j, characters);
      characters[index] = a;
      combinations(A, map, index + 1, characters);
//      characters.remove(Character.valueOf(a));
      characters[index] = a;
    }
  }
}