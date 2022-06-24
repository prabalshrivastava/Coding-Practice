package scaler.introductiontoproblemsolving;

import java.util.Scanner;

public class SummationGame {
  //  Problem Description
  //  Write a program to find sum all Natural numbers from 1 to N where you have to take N as input
  // from user
  //  Problem Constraints
  // 1 <= N <= 1000
  //  Input Format
  //  A single line representing N
  //  Output Format
  //  A single integer showing sum of all Natural numbers from 1 to N
  //  Example Input
  //  Input 1:
  //      5
  //  Input 2:
  //      10
  //  Example Output
  //  Output 1:
  //      15
  //  Output 2:
  //      55

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n < 0 || n > 1000) return;
    long sum = (n * (n + 1)) / 2;
    System.out.println(sum);
  }
}
