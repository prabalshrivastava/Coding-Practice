package scaler.advancedDsa.hashing1;

import java.util.HashMap;
import java.util.Map;

public class HWQ3CheckPalindromeII {
    //    Problem Description
//    Given a string A consisting of lowercase characters.
//    Check if characters of the given string can be rearranged to form a palindrome.
//    Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
//    Problem Constraints
//    1 <= |A| <= 105
//    A consists only of lower-case characters.
//    Input Format
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
    public static void main(String[] args) {
        System.out.println(new HWQ3CheckPalindromeII().solve("abcde"));//0
        System.out.println(new HWQ3CheckPalindromeII().solve("abbaee"));//1
    }

    public int solve(String A) {
        int length = A.length();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < length; i++) {
            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
        }
        int ans = 1;
        if (length % 2 == 0) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    ans = 0;
                }
            }
        } else {
            int oddFreq = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    oddFreq++;
                }
            }
            if (oddFreq > 1) {
                ans = 0;
            }
        }
        return ans;
    }
}
