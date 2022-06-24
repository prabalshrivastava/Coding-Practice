package scaler.introductiontoproblemsolving;

import java.util.Scanner;

public class IsItPrime {
  //  Problem Description
  //  Given an integer A, you have to tell whether it is a prime number or not.
  //  A prime number is a natural number greater than 1 which is divisible only by 1 and itself.
  //  Problem Constraints
  // 1 <= A <= 106
  //  Input Format
  //  First and only line of the input contains a single integer A.
  //  Output Format
  //  Print YES if A is a prime, else print NO.
  //  Example Input
  //  Input 1:
  //      3
  //  Input 2:
  //      4

  //  Example Output
  //  Output 1:
  //  YES
  //  Output 2:
  //  NO
  //  Example Explanation
  //  Explanation 1:
  //      3 is a prime number as it is only divisible by 1 and 3.
  //  Explanation 2:
  //      4 is not a prime number as it is divisible by 2.
  //
  // https://www.scaler.com/academy/mentee-dashboard/class/30034/assignment/problems/11291?navref=cl_tt_nv

  public static void main(String[] args) {
    // YOUR CODE GOES HERE
    // Please take input and print output to standard input/output (stdin/stdout)
    // DO NOT USE ARGUMENTS FOR INPUTS
    // E.g. 'Scanner' for input & 'System.out' for output
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();
    if (n < 1 || n > 1000000l) {
      return;
    }
    int count = 0;
    for (int i = 1; i * i <= n; i++) {
      if (n % i == 0) {
        count++;
        if (i != n / i) {
          count++;
        }
      }
    }
    if (count == 2) System.out.println("YES");
    else System.out.println("NO");
  }
}
