package scaler.advancedDsa.bitmanipulations1;

public class AQ4AddBinaryStrings {
//    Problem Description
//    Given two binary strings, return their sum (also a binary string).
//    Example:
//    a = "100"
//    b = "11"
//    Return a + b = "111".

    public static void main(String[] args) {
        String a = "100";
        String b = "11";
        System.out.println(new AQ4AddBinaryStrings().addBinary(a, b));
    }

    public String addBinary(String A, String B) {
        int a = A.length() - 1;
        int b = B.length() - 1;
        int carry = 0;
        String ans = "";
        while (true) {
            int aI = 0;
            if (a >= 0)
                aI = Integer.parseInt("" + A.charAt(a));
            int bI = 0;
            if (b >= 0)
                bI = Integer.parseInt("" + B.charAt(b));
            if (a < 0 && b < 0 && carry == 0)
                break;
//            System.out.println(aI + " - " + bI);
            int sum = aI + bI + carry;
            carry = 0;
            if (sum >= 2) {
                carry = sum / 2;
                int mod = sum % 2;
                ans = mod + ans;
            } else {
                ans = sum + ans;
            }
//                System.out.println(ans);
            a--;
            b--;
        }
        return ans;
    }
}
