package scaler.strings;

public class AQ2SimpleReverse {
    //    Problem Description
//    Given a string A, you are asked to reverse the string and return the reversed string.
//            Problem Constraints
//1 <= |A| <= 105
//    String A consist only of lowercase characters.
//            Input Format
//    First and only argument is a string A.
//    Output Format
//    Return a string denoting the reversed string.
//            Example Input
//    Input 1:
//    A = "scaler"
//    Input 2:
//    A = "academy"
//    Example Output
//    Output 1:
//            "relacs"
//    Output 2:
//            "ymedaca"
//    Example Explanation
//    Explanation 1:
//    Reverse the given string.
    public static void main(String[] args) {
        String input1A = "scaler";
        System.out.println(new AQ2SimpleReverse().solve(input1A));
        String input2A = "academy";
        System.out.println(new AQ2SimpleReverse().solve(input2A));
    }

    public String solve(String A) {
        char[] array = A.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return new String(array);
    }
}
