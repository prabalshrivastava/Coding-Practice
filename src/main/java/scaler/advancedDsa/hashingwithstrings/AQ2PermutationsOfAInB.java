package scaler.advancedDsa.hashingwithstrings;

import java.util.HashMap;
import java.util.Map;

public class AQ2PermutationsOfAInB {
    //    Problem Description
//    You are given two strings, A and B, of size N and M, respectively.
//    You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
//    Problem Constraints
//1 <= N < M <= 105
//    Input Format
//    Given two arguments, A and B of type String.
//    Output Format
//    Return a single integer, i.e., number of permutations of A present in B as a substring.
//            Example Input
//    Input 1:
//    A = "abc"
//    B = "abcbacabc"
//    Input 2:
//    A = "aca"
//    B = "acaa"
//    Example Output
//    Output 1:
//            5
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//    Permutations of A that are present in B as substring are:
//            1. abc
//    2. cba
//    3. bac
//    4. cab
//    5. abc
//    So ans is 5.
//    Explanation 2:
//    Permutations of A that are present in B as substring are:
//            1. aca
//    2. caa
    public static void main(String[] args) {
        String input1A = "abc";
        String input1B = "abcbacabc";
        System.out.println(new AQ2PermutationsOfAInB().solve(input1A, input1B));
        String input2A = "aca";
        String input2B = "acaa";
        System.out.println(new AQ2PermutationsOfAInB().solve(input2A, input2B));
    }

    public int solve(String A, String B) {
        int count = 0;
        Map<Character, Integer> needFreqA = new HashMap();
        Map<Character, Integer> currFreqB = new HashMap();
        int need = A.length();
        for (int i = 0; i < A.length(); i++) {
            needFreqA.put(A.charAt(i), needFreqA.getOrDefault(A.charAt(i), 0) + 1);
//            currFreqB.put(B.charAt(i), currFreqB.getOrDefault(B.charAt(i), 0) + 1);
        }
//        System.out.println(needFreqA);
        for (int i = 0; i < A.length(); i++) {
            if (currFreqB.getOrDefault(B.charAt(i), 0) < needFreqA.getOrDefault(B.charAt(i), 0)) {
                need--;
            }
            currFreqB.put(B.charAt(i), currFreqB.getOrDefault(B.charAt(i), 0) + 1);
            if (need == 0) {
                count++;
            }
        }
//        System.out.println(currFreqB);
        int movingOut = 0;
        for (int i = A.length(); i < B.length(); i++) {
            if (B.charAt(i) != B.charAt(movingOut)) {
                if (currFreqB.getOrDefault(B.charAt(i), 0) < needFreqA.getOrDefault(B.charAt(i), 0)) {//checking if the need is already fulfilled
                    need--;//now since the new element has come in need reduces/fulfills
                }
                if (currFreqB.getOrDefault(B.charAt(movingOut), 0) <= needFreqA.getOrDefault(B.charAt(movingOut), 0)) {
                    need++;
                }
            }
            currFreqB.put(B.charAt(i), currFreqB.getOrDefault(B.charAt(i), 0) + 1);
            currFreqB.put(B.charAt(movingOut), currFreqB.getOrDefault(B.charAt(movingOut), 1) - 1);
            movingOut++;
            if (need == 0)
                count++;
        }
        return count;
    }
}