package scaler.advancedDsa.recursion1;

import java.util.Scanner;

public class HWQ4PrintReverseString {
    //    Problem Description
//    Write a recursive function that, given a string S, prints the characters of S in reverse order.
//            Problem Constraints
//1 <= |s| <= 1000
//    Input Format
//    First line of input contains a string S.
//    Output Format
//    Print the character of the string S in reverse order.
//    Example Input
//    Input 1:
//    scaleracademy
//    Input 2:
//    cool
//    Example Output
//    Output 1:
//    ymedacarelacs
//    Output 2:
//    looc
//    Example Explanation
//    Explanation 1:
//    Print the reverse of the string in a single line.
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        System.out.println(input);
        System.out.println(reverse(input.toCharArray(), 0, input.length() - 1));
    }

    private static char[] reverse(char[] input, int i, int j) {

        return input;
    }
}
