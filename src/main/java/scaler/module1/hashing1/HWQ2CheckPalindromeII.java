package scaler.module1.hashing1;


import java.util.HashMap;
import java.util.Map;

public class HWQ2CheckPalindromeII {
    //    Problem Description
//    Given a string A consisting of lowercase characters.
//    Check if characters of the given string can be rearranged to form a palindrome.
//    Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
//    Problem Constraints
//    1 <= |A| <= 105
//    A consists only of lower-case characters.
//            Input Format
//    First argument is an string A.
//    Output Format
//    Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
//    Example Input
//    Input 1:
//    A = "abcde"
//    Input 2:
//    A = "abbaee"
//    Example Output
//    Output 1:
//            0
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    No possible rearrangement to make the string palindrome.
//    Explanation 2:
//    Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
    public int solve(String A) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
        }
//        System.out.println(map);
        if (A.length() % 2 == 0) {
            //every character should have even frequency for even length palindrome
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    return 0;
                }
            }
            return 1;
        } else {
            //every character should have even frequency for even length palindrome except for 1 odd length palindrome
            int countOfOdd = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    countOfOdd++;
                }
            }
            if (countOfOdd > 1) {
                return 0;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new HWQ2CheckPalindromeII().solve("abcde"));
        System.out.println(new HWQ2CheckPalindromeII().solve("abbaee"));
    }
}
