package scaler.module1.recursion2;


public class HWQ1KthSymbol {
//    Problem Description
//    On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
//    Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.).
//    Problem Constraints
//1 <= A <= 20
//            1 <= B <= 2A - 1
//    Input Format
//    First argument is an integer A.
//    Second argument is an integer B.
//    Output Format
//    Return an integer denoting the Bth indexed symbol in row A.
//            Example Input
//    Input 1:
//    A = 2
//    B = 1
//    Input 2:
//    A = 2
//    B = 2
//    Example Output
//    Output 1:
//            0
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    Row 1: 0
//    Row 2: 01
//    Explanation 2:
//    Row 1: 0
//    Row 2: 01

    public static void main(String[] args) {

    }

    public int solve(int A, int B) {
        int currentRow;
        sol(A, B, 1, "0");
        return A;
    }

    private String sol(int a, int b, int currentRow, String s) {
        if (s.length() < 1)
            return "";
        if ("0".equals(s)) {
            return "01";
        } else if ("1".equals(s)) {
            return "10";
        }
        String ans = sol(a, b, currentRow, s.substring(0, s.length() / 2));
        ans += sol(a, b, currentRow, s.substring(s.length() / 2));
        return ans;
    }
}
