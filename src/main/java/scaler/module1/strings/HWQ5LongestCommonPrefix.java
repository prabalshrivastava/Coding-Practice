package scaler.module1.strings;

public class HWQ5LongestCommonPrefix {
//    Problem Description
//    Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
//    The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
//            Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
//    Problem Constraints
//0 <= sum of length of all strings <= 1000000
//    Input Format
//    The only argument given is an array of strings A.
//    Output Format
//    Return the longest common prefix of all strings in A.
//    Example Input
//    Input 1:
//    A = ["abcdefgh", "aefghijk", "abcefgh"]
//    Input 2:
//    A = ["abab", "ab", "abcd"];
//    Example Output
//    Output 1:
//            "a"
//    Output 2:
//            "ab"
//    Example Explanation
//    Explanation 1:
//    Longest common prefix of all the strings is "a".
//    Explanation 2:
//    Longest common prefix of all the strings is "ab".

    public static void main(String[] args) {
        String[] input1A = {"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println(new HWQ5LongestCommonPrefix().longestCommonPrefix(input1A));
        String[] input2A = {"abab", "ab", "abcd"};
        System.out.println(new HWQ5LongestCommonPrefix().longestCommonPrefix(input2A));
    }

    public String longestCommonPrefix(String[] A) {
        int length = 0;
        for (int i = 0; i < A.length; i++) {
            length = Math.max(length, A[i].length());
        }
//        System.out.println(length);
        Character characterToBeCompared;
        String maxCommonLength = "";
        for (int j = 0; j < length; j++) {
            characterToBeCompared = null;
            boolean isSameElements = true;
            for (int i = 0; i < A.length; i++) {
                if (j >= A[i].length()) {
                    isSameElements = false;
                    break;
                }
                char currentCharacter = A[i].charAt(j);
                if (characterToBeCompared == null) {
                    characterToBeCompared = currentCharacter;
                } else if (characterToBeCompared != currentCharacter) {
                    isSameElements = false;
                    break;
                }
            }
            if (isSameElements)
                maxCommonLength = maxCommonLength + characterToBeCompared;
            else break;
        }
        return maxCommonLength;
    }
}
