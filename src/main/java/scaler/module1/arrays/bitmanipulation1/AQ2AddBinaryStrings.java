package scaler.module1.arrays.bitmanipulation1;

public class AQ2AddBinaryStrings {
//    Problem Description
//    Given two binary strings, return their sum (also a binary string).
//    Example:
//
//    a = "100"
//
//    b = "11"
//    Return a + b = "111".

    public static void main(String[] args) {
        String a = "100";
        String b = "11";
        System.out.println(new AQ2AddBinaryStrings().addBinary(a, b));
        String A = "1010110111001101101000";
        String B = "1000011011000000111100110";
        System.out.println(new AQ2AddBinaryStrings().addBinary(A, B));
        System.out.println(new AQ2AddBinaryStrings().addBinary("1", "1"));
    }

    public String addBinary(String A, String B) {
        int length;
        if (A.length() > B.length()) {
            length = A.length();
//            String format = "%0" + length + "d";
//            B = String.format(format, Long.parseLong(B));
            B = String.format("%" + length + "s", B).replace(' ', '0');
        } else {
            length = B.length();
//            String format = "%0" + length + "d";
//            A = String.format(format, Long.parseLong(A));
            A = String.format("%" + length + "s", A).replace(' ', '0');
        }
//        System.out.println(format);

//        System.out.println(A);
//        System.out.println(B);
        int carry = 0;
        String str = "";
        for (int i = A.length() - 1; i >= 0; i--) {
            int sum = Integer.parseInt(String.valueOf(A.charAt(i))) + Integer.parseInt(String.valueOf(B.charAt(i))) + carry;
//            System.out.println(sum);
            int prepend = sum % 2;
            carry = sum / 2;
            str = prepend + str;
        }
        if (carry == 1)
            str = 1 + str;
        return str;
    }
}
