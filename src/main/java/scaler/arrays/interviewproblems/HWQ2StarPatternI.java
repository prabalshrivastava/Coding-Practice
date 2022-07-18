package scaler.arrays.interviewproblems;

import java.util.Arrays;
import java.util.Scanner;

public class HWQ2StarPatternI {
    //    Problem Description
//
//    Write a program to input an integer N from user and print hollow diamond star pattern series of N lines.
//
//    See example for clarifications over the pattern.
//
//
//
//    Problem Constraints
//
//1 <= N <= 1000
//
//
//
//    Input Format
//
//    First line is an integer N
//
//
//
//    Output Format
//
//    N lines conatining only char '*' as per the question.
//
//
//
//    Example Input
//
//    Input 1:
//
//            4
//    Input 2:
//
//            6
//
//
//    Example Output
//
//    Output 1:
//
//            ********
//            ***  ***
//            **    **
//            *      *
//            *      *
//            **    **
//            ***  ***
//            ********
//    Output 2:
//
//            ************
//            *****  *****
//            ****    ****
//            ***      ***
//            **        **
//            *          *
//            *          *
//            **        **
//            ***      ***
//            ****    ****
//            *****  *****
//            ************
//
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        for (int i = 0; i < input * 2; i++) {
            for (int j = 0; j < input * 2; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
