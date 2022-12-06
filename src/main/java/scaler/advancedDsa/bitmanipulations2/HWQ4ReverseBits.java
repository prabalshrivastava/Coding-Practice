package scaler.advancedDsa.bitmanipulations2;

public class HWQ4ReverseBits {
//    Problem Description
//    Reverse the bits of an 32 bit unsigned integer A.
//    Problem Constraints
//0 <= A <= 232
//    Input Format
//    First and only argument of input contains an integer A.
//    Output Format
//    Return a single unsigned integer denoting the decimal value of reversed bits.
//    Example Input
//    Input 1:
//            0
//    Input 2:
//            3
//    Example Output
//    Output 1:
//            0
//    Output 2:
//            3221225472
//    Example Explanation
//    Explanation 1:
//            00000000000000000000000000000000
//            =>      00000000000000000000000000000000
//    Explanation 2:
//            00000000000000000000000000000011
//            =>      11000000000000000000000000000000

    public long reverse(long A) {
        long n = A;
        int count = 0;
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            long remainder = n % 2;
            s.insert(0,remainder);
            n = n / 2;
        }
//        System.out.println(s);
        s = new StringBuilder(String.format("%" + 32 + "s", s.toString()).replace(' ', '0'));
//        System.out.println(s);
        s.reverse();
//        System.out.println(s);
        long ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += (long) (Integer.parseInt(String.valueOf(s.charAt(i))) * Math.pow(2, count));
            count++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int input1 = 0;
        System.out.println(new HWQ4ReverseBits().reverse(input1));
        int input2 = 3;
        System.out.println(new HWQ4ReverseBits().reverse(input2));
    }
}
