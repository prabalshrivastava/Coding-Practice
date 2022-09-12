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
        int input1A = 2;
        int input1B = 1;
        System.out.println(new HWQ1KthSymbol().solve(input1A, input1B)); //0
        int input2A = 2;
        int input2B = 2;
        System.out.println(new HWQ1KthSymbol().solve(input2A, input2B)); //1
        System.out.println(new HWQ1KthSymbol().solve(20, 42));  //1
        System.out.println(new HWQ1KthSymbol().solve(8, 60));  //1
    }


    public int solve(int A, int B) {
//        return Integer.parseInt(sol(A, B, "0"));
        return sol(A, B) ? 1 : 0;
    }
    //0
    //01
    //0110
    //01101001

    private boolean sol(int a, int b) {
        if (a == 1 || b == 1) {
            return false;
        }
        int length = (int) Math.pow(2, a - 1);
        int mid = length / 2;
        if (b <= mid) {
            return sol(a - 1, b);
        } else {
            return !sol(a - 1, b - mid);
        }
    }
//    private String sol1(int a, int b, String current) {
//        if (a == 1)
//            return String.valueOf(0);
//        char[] chars = current.toCharArray();
//        String ans = "";
//        for (int i = 0; i < chars.length; i++) {
//            if ('0' == chars[i]) {
//                ans = ans + "01";
//            } else if ('1' == chars[i]) {
//                ans += "10";
//            }
//        }
////        System.out.printf("ans : %current -------- ans.length()[%current] == Math.pow(2, a[%current] - 1)[%current] -> %current%n", ans, ans.length(), a, Math.pow(2, a - 1), (ans.length() == Math.pow(2, a - 1)));
//        if (ans.length() == Math.pow(2, a - 1)) {
//            return String.valueOf(ans.charAt(b - 1));
//        }
////        sol(a, b, currentRow, current.substring(0, current.length() / 2));
////        ans += sol(a, b, currentRow, current.substring(current.length() / 2));
//        return sol(a, b, ans);
//    }
}
