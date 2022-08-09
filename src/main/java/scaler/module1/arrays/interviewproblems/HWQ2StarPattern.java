package scaler.module1.arrays.interviewproblems;

import java.util.Scanner;

public class HWQ2StarPattern {
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

//   solve this pattern -> https://www.interviewbit.com/snippet/89e8ea0a35e8afff191b/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input * 2; j++) {
                if (j >= input - i && j < input + i) {
                    System.out.print(" ");
//                    System.out.print(j);
                } else
                    System.out.print("*");
            }
            System.out.println("");
        }

        for (int i = input - 1; i >= 0; i--) {
            for (int j = 0; j < input * 2; j++) {
                if (j >= input - i && j < input + i) {
                    System.out.print(" ");
//                    System.out.print(j);
                } else
                    System.out.print("*");
            }
            System.out.println("");
//        }
        }
    }
}
