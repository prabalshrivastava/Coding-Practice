package scaler.advancedDsa.binarysearch2;


public class AQ1SquareRootOfInteger {
    //    Problem Description
//    Given an integer A.
//    Compute and return the square root of A.
//    If A is not a perfect square, return floor(sqrt(A)).
//    DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.
//            NOTE: Do not use the sqrt function from the standard library. Users are expected to solve this in O(log(A)) time.
//            Problem Constraints
//0 <= A <= 1010
//    Input Format
//    The first and only argument given is the integer A.
//    Output Format
//    Return floor(sqrt(A))
//    Example Input
//    Input 1:
//            11
//    Input 2:
//            9
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            3
//    Example Explanation
//    Explanation:
//    When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
//    When A = 9 which is a perfect square of 3, so we return 3.
    public static void main(String[] args) {
//        int input1 = 11;
//        System.out.println(new AQ1SquareRootOfInteger().sqrt(input1));
//        int input2 = 9;
//        System.out.println(new AQ1SquareRootOfInteger().sqrt(input2));
        System.out.println(new AQ1SquareRootOfInteger().sqrt(2147483647));//46340
    }

    public int sqrt(int A) {
        System.out.println(A);
        if (A <= 0)
            return 0;
        long l = 1;
        long r = A;
        long ans = 1;
        while (l <= r) {
            long mid = (l + r) / 2;
            long square = (long) mid * mid;
//            System.out.printf("l:%s | r:%s | mid:%s | square:%s%n", l, r, mid, square);
            if (square <= (long) A) {
                ans = mid;
                l = mid + 1;
            } else if (square > (long) A) {
                r = mid - 1;
            }
        }
        return (int) ans;
    }
}
