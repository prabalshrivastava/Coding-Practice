package scaler.module1.recursion1;

public class AQ1CheckPalindrome {
//    Problem Description
//    Write a recursive function that checks whether string A is a palindrome or Not.
//    Return 1 if the string A is a palindrome, else return 0.
//    Note: A palindrome is a string that's the same when read forward and backward.
//    Problem Constraints
//1 <= A <= 50000
//    String A consists only of lowercase letters.
//            Input Format
//    The first and only argument is a string A.
//            Output Format
//    Return 1 if the string A is a palindrome, else return 0.
//    Example Input
//    Input 1:
//    A = "naman"
//    Input 2:
//    A = "strings"
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//            "naman" is a palindomic string, so return 1.
//    Explanation 2:
//            "strings" is not a palindrome, so return 0.

    public int solve(String A) {
        return isPalEven(A, 0, A.length() - 1) ? 1 : 0;
    }

    private boolean isPalEven(String a, int i, int j) {
//        System.out.println("[" + i + j + "]");
        if (i >= j) {
            return true;
        }
        if (a.charAt(i) == a.charAt(j)) {
            return isPalEven(a, ++i, --j);
        }
        return false;
    }

    public static void main(String[] args) {
        String input1A = "naman";
        System.out.println(new AQ1CheckPalindrome().solve(input1A));
        String input2A = "strings";
        System.out.println(new AQ1CheckPalindrome().solve(input2A));
    }
}
