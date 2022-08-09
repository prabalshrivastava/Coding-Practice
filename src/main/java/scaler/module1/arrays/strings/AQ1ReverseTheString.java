package scaler.module1.arrays.strings;

public class AQ1ReverseTheString {
    //    Problem Description
//    You are given a string A of size N.
//    Return the string A after reversing the string word by word.
//            NOTE:
//    A sequence of non-space characters constitutes a word.
//    Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
//    If there are multiple spaces between words, reduce them to a single space in the reversed string.
//    Problem Constraints
//1 <= N <= 3 * 105
//    Input Format
//    The only argument given is string A.
//            Output Format
//    Return the string A after reversing the string word by word.
//            Example Input
//    Input 1:
//    A = "the sky is blue"
//    Input 2:
//    A = "this is ib"
//    Example Output
//    Output 1:
//            "blue is sky the"
//    Output 2:
//            "ib is this"
//    Example Explanation
//    Explanation 1:
//    We reverse the string word by word so the string becomes "the sky is blue".
//    Explanation 2:
//    We reverse the string word by word so the string becomes "this is ib".
    public String solve(String A) {
        char[] toCharArray = A.toCharArray();
        reverse(toCharArray, 0, A.length() - 1);
//        System.out.println(Arrays.toString(toCharArray));
        int r = 0;
        int l = 0;
        while (r < toCharArray.length) {
            while (r < toCharArray.length && toCharArray[r] != ' ') {
                r++;
            }
//            System.out.println(r);
            reverse(toCharArray, l, r - 1);
            r++;
//            System.out.println(toCharArray);
            l = r;
        }
        return new String(toCharArray).trim();
    }

    private char[] reverse(char[] chars, int l, int r) {
//        System.out.println("l : " + l);
//        System.out.println("r : " + r);
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return chars;
    }

    public static void main(String[] args) {
        //System.out.println(new AQ1ReverseTheString().solve("prabal"));
        String input1A = "the sky is blue";
        System.out.println(new AQ1ReverseTheString().solve(input1A));
        String input2A = "this is ib";
        System.out.println(new AQ1ReverseTheString().solve(input2A));
        String input3A = "crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv ";
        System.out.println(new AQ1ReverseTheString().solve(input3A));
    }
}
