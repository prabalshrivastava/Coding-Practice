package scaler.advancedDsa.recursion;


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
        return sol(A , B - 1);
    }
    //0
    //01
    //0110
    //01101001
    //01101001 10010110
    //01101001 10010110 10010110 01101001

    private int sol(int n, int k) {
        if (n == 1 || k == 0)
            return 0;
        int ans = sol(n - 1, k / 2);
        if (ans == 0) { //01
            if (k % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {    //10
            if (k % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
