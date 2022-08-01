package scaler.arrays.arrayandmaths;

import java.util.Arrays;

public class AQ5FindNthMagicNumber {
//    Problem Description
//    Given an integer A, find and return the Ath magic number.
//    A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
//    First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
//    Problem Constraints
//1 <= A <= 5000
//    Input Format
//    The only argument given is integer A.
//            Output Format
//    Return the Ath magic number.
//            Example Input
//    Example Input 1:
//    A = 3
//    Example Input 2:
//    A = 10
//    Example Output
//    Example Output 1:
//            30
//    Example Output 2:
//            650
//    Example Explanation
//    Explanation 1:
//    Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
//            3rd element in this is 30
//    Explanation 2:
//    In the sequence shown in explanation 1, 10th element will be 650.

    public static void main(String[] args) {
//        System.out.println(new AQ5FindNthMagicNumber().solve(3));
//        System.out.println(new AQ5FindNthMagicNumber().solve(10));
        System.out.println(new AQ5FindNthMagicNumber().solve(15));
    }

    public int solve(int A) {
        int[] arr = new int[A + 1];
        arr[0] = 0;
        arr[1] = 5;
        int pow = 2;
        int index = 2;
        for (int i = 2; i < arr.length; i++) {
            int j = 0;
            while (j < index) {
//            for (int j = 0; j <= i; j++) {
                if (index >= arr.length)
                    break;
                if (Math.pow(5, pow) != arr[j]) {
//                    System.out.printf("arr[%s] = 5^%s + arr[%s] => %s%n", index, pow, j, ((int) (Math.pow(5, pow) + arr[j])));
                    if (arr[j] < (int) Math.pow(5, pow))
                        arr[index++] = (int) Math.pow(5, pow) + arr[j];
                    else
                        break;
                }
                j++;
            }
            pow++;
        }
//        System.out.println(Arrays.toString(arr));
        return arr[A];
    }
}
