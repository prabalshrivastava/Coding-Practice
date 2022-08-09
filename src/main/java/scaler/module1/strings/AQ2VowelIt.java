package scaler.module1.strings;

import java.util.HashSet;
import java.util.Set;

public class AQ2VowelIt {
    //    Raman is very fond of vowels. One day, he got a string as a gift for his birthday. He got very excited and wanted to obtain the longest subsequence of vowels from the original string. You are asked to help Raman.
//
//    Given a string A of lowercase English alphabets, find and return a string which is the longest subsequence of vowels in the string A.
//
//            Note:
//
//            1. Vowels are "a" , "e" ,"i" , "o" , "u".
//            2. A subsequence is a sequence that can be derived from another sequence by deleting some or no elements from the original sequence without changing the order of the remaining elements.
//            3. It is guaranteed that atleast one vowel will be present in the given string.
//
//    Input Format
//
//    The only argument given is string A.
//            Output Format
//
//    Return a string which is the longest subsequence of vowels in the string A.
//    Constraints
//
//1 <= length of the string <= 100000
//    For Example
//
//    Input 1:
//    abcdye
//    Output 1:
//    ae
//
//    Input 2:
//    abhishek
//    Output 2:
//    aie
//
//    Input 3:
//    interviewbit
//    Output 3:
//    ieiei
    public static void main(String[] args) {
        String input1 = "abcdye";
        System.out.println(new AQ2VowelIt().solve(input1));
        //Output 1:
        //ae

        String input2 = "abhishek";
        System.out.println(new AQ2VowelIt().solve(input2));
        //Output 2:
        //aie

        String input3 = "interviewbit";
        System.out.println(new AQ2VowelIt().solve(input3));
        //Output 3:
        //ieiei
    }

    public String solve(String A) {
        String s = "";
        Set<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < A.length(); i++) {
            if (vowels.contains(A.charAt(i))) {
                s = s + A.charAt(i);
            }
        }
        return s;
    }

}
