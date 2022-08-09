package scaler.module1.strings;

import java.util.HashSet;
import java.util.Set;

public class HWQ4StringOperations {
    //    Problem Description
//    Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:
//    Concatenate the string with itself.
//    Delete all the uppercase letters.
//    Replace each vowel with '#'.
//    You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.
//            NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.
//    Problem Constraints
//1<=N<=100000
//    Input Format
//    First argument is a string A of size N.
//            Output Format
//    Return the resultant string.
//    Example Input
//    A="AbcaZeoB"
//    Example Output
//"bc###bc###"
//    Example Explanation
//    First concatenate the string with itself so string A becomes "AbcaZeoBAbcaZeoB".
//    Delete all the uppercase letters so string A becomes "bcaeobcaeo".
//    Now replace vowel with '#'.
//    A becomes "bc###bc###".
    public String solve(String A) {
        A = A + A;
        Set<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) >= 'A' && A.charAt(i) <= 'Z') {
            } else if (vowels.contains(A.charAt(i))) {
                stringBuilder.append('#');
            } else {
                stringBuilder.append(A.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new HWQ4StringOperations().solve("AbcaZeoB"));//"bc###bc###"
    }
}
