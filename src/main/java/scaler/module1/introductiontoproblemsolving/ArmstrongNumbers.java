package scaler.module1.introductiontoproblemsolving;

import java.util.Scanner;

public class ArmstrongNumbers {
  //  Problem Description
  //  You are given an integer N you need to print all the Armstrong Numbers between 1 to N.
  //  If sum of cubes of each digit of the number is equal to the number itself, then the number is
  // called an Armstrong number.
  //  For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 ).
  //  Problem Constraints
  // 1 <= N <= 500
  //  Input Format
  //  First and only line of input contains an integer N.
  //  Output Format
  //  Output all the Armstrong numbers in range [1,N] each in a new line.
  //      Example Input
  //  Input 1:
  //      5
  //  Input 2:
  //      200
  //  Example Output
  //  Output 1:
  //      1
  //  Output 2:
  //      1
  //      153
  //  Example Explanation
  //  Explanation 1:
  //      1 is an armstrong number.
  //  Explanation 2:
  //      1 and 153 are armstrong number under 200.

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (n < 1 || n > 500) return;
    int curr = n;

    for (int i = 1; i <= n; i++) {
      curr = i;
      long sum = 0;
      while (curr != 0) {
        // 153%10=3
        // 153/10=15

        // 15%10=5
        // 15/10=1

        // 1%10=1
        // 1/10=0

        int remainder = curr % 10;
        sum = sum + remainder * remainder * remainder;
        curr = curr / 10;
      }
      if (i == sum) {
        System.out.println(i);
      }
    }
  }
}
