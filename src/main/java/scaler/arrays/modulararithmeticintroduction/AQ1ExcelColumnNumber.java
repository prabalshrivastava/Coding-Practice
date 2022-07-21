package scaler.arrays.modulararithmeticintroduction;

public class AQ1ExcelColumnNumber {
//        Problem Description
//        Given a column title as appears in an Excel sheet, return its corresponding column number.
//                Problem Constraints
//        1 <= length of the column title <= 5
//        Input Format
//        The only argument is a string that represents the column title in the excel sheet.
//                Output Format
//        Return a single integer that represents the corresponding column number.
//        Example Input
//        Input 1:
//        AB
//        Input 2:
//        ABCD
//        Example Output
//        Output 1:
//        28
//        Output 2:
//        19010
//        Example Explanation
//        Explanation 1:
//        A -> 1
//        B -> 2
//        C -> 3
// ...
//        Z -> 26
//        AA -> 27
//        AB -> 28

    public static void main(String[] args) {
        String input1 = "AB";
        System.out.println(new AQ1ExcelColumnNumber().titleToNumber(input1));
        String input2 = "ABCD";
        System.out.println(new AQ1ExcelColumnNumber().titleToNumber(input2));
    }

    public int titleToNumber(String A) {
        char[] chars = A.toCharArray();
        int sum = 0;
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int index = chars[i] - 64;
            System.out.println(chars[i] + " -> " + index);
            sum = (int) (sum + index * Math.pow(26, count));
            count++;
        }
        return sum;
    }

}
