package scaler.module1.strings;

public class AQ6IsAlpha {
//    Problem Description
//    You are given a function isalpha() consisting of a character array A.
//    Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.
//    Problem Constraints
//1 <= |A| <= 105
//    Input Format
//    Only argument is a character array A.
//            Output Format
//    Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.
//    Example Input
//    Input 1:
//    A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y']
//    Input 2:
//    A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    All the characters are alphabets.
//            Explanation 2:
//    All the characters are NOT alphabets i.e ('#', '2', '0', '2', '0').

    public int solve(char[] A) {
        int ans = 1;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] < 'a' || A[i] > 'z') && (A[i] < 'A' || A[i] > 'Z')) {
                ans = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] input1A = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};
        System.out.println(new AQ6IsAlpha().solve(input1A));
        char[] input2A = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
        System.out.println(new AQ6IsAlpha().solve(input2A));
        char[] input3A = { 'L', 'b', '6', 'Y', 'X', '6', 's', 'm', 'p', 'D', '3', 'h', '`', '8', '0', 'i' };
        System.out.println(new AQ6IsAlpha().solve(input3A));
    }
}
