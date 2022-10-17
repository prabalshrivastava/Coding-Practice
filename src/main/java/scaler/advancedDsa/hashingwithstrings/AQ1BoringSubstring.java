package scaler.advancedDsa.hashingwithstrings;

import java.util.Map;

public class AQ1BoringSubstring {
    //    Problem Description
//    You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.
//    A boring substring has the following properties:
//    Its length is 2.
//    Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
//    Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
//    Problem Constraints
//1 <= |A| <= 105
//    Input Format
//    The only argument given is a string A.
//    Output Format
//    Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
//    Example Input
//    Input 1:
//    A = "abcd"
//    Input 2:
//    A = "aab"
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    String A can be rearranged into "cadb" or "bdac"
//    Explanation 2:
//    No arrangement of string A can make it free of boring substrings.
    public static void main(String[] args) {
        System.out.println(new AQ1BoringSubstring().solve("abcd"));
        System.out.println(new AQ1BoringSubstring().solve("aab"));
    }

    public int solve(String A) {
//        Map<Character,Character>
//        for (int i = 0; i < A.length(); i++) {
//            char ch = A.charAt(i);
//            for (int j = 0; j < A.length(); j++) {
//
//            }
//        }
        return 0;
    }
}
