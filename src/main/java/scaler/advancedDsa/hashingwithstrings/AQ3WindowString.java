package scaler.advancedDsa.hashingwithstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AQ3WindowString {
    //    Problem Description
//    Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
//    Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
//    Note:
//    If there is no such window in A that covers all characters in B, return the empty string.
//    If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
//    Problem Constraints
//1 <= size(A), size(B) <= 106
//    Input Format
//    The first argument is a string A.
//    The second argument is a string B.
//            Output Format
//    Return a string denoting the minimum window.
//            Example Input
//    Input 1:
//    A = "ADOBECODEBANC"
//    B = "ABC"
//    Input 2:
//    A = "Aa91b"
//    B = "ab"
//    Example Output
//    Output 1:
//            "BANC"
//    Output 2:
//            "a91b"
//    Example Explanation
//    Explanation 1:
//            "BANC" is a substring of A which contains all characters of B.
//            Explanation 2:
//            "a91b" is the substring of A which contains all characters of B.
    public static void main(String[] args) {
        String input1A = "ADOBECODEBANC";
        String input1B = "ABC";
        System.out.println(new AQ3WindowString().minWindow(input1A, input1B));
        String input2A = "Aa91b";
        String input2B = "ab";
        System.out.println(new AQ3WindowString().minWindow(input2A, input2B));
        String input3A = "AAAAAA";
        String input3B = "AA";
        System.out.println(new AQ3WindowString().minWindow(input3A, input3B));
    }

    public String minWindow(String A, String B) {
        HashSet<Character> hashSetB = new HashSet();
        for (int i = 0; i < B.length(); i++) {
            hashSetB.add(B.charAt(i));
        }
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (hashSetB.contains(A.charAt(i))) {
                int[] countAndIndex = map.getOrDefault(A.charAt(i), new int[]{0, Integer.MIN_VALUE});
                countAndIndex[0]++;
                countAndIndex[1] = i;
                map.put(A.charAt(i), countAndIndex);
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, int[]> characterCountAndIndexEntry : map.entrySet()) {
//            System.out.println(characterCountAndIndexEntry.getKey() + " -> " + Arrays.toString(characterCountAndIndexEntry.getValue()));
            min = Math.min(characterCountAndIndexEntry.getValue()[1], min);
            max = Math.max(characterCountAndIndexEntry.getValue()[1], max);
        }
        String ans = "";
        for (int i = min; i <= max; i++) {
            ans = ans + A.charAt(i);
        }
        return ans;
    }
}
