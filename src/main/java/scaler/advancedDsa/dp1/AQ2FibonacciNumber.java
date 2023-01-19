package scaler.advancedDsa.dp1;

import java.util.Scanner;

public class AQ2FibonacciNumber {

  //  Problem Description
//  Given a positive integer A, write a program to find the Ath Fibonacci number.
//  In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
//      NOTE: 0th term is 0. 1th term is 1 and so on.
//      Problem Constraints
//0 <= A <= 44
//  Input Format
//  First and only argument is an integer A.
//  DocFinder.Output Format
//  Return an integer denoting the Ath Fibonacci number.
//  Example Input
//  Input 1:
//  A = 4
//  Input 2:
//  A = 6
//  Example Output
//  Output 1:
//      3
//  Output 2:
//      8
//  Example Explanation
//  Explanation 1:
//  Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
// 0th term is 0 So, 4th term of Fibonacci series is 3.
//  Explanation 2:
//      6th term of Fibonacci series is 8.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(new AQ2FibonacciNumber().fib(n));
    System.out.println(new AQ2FibonacciNumber().fib(n, new int[n + 1]));
    System.out.println(new AQ2FibonacciNumber().fib(0, new int[1]));
    System.out.println(new AQ2FibonacciNumber().fib(1, new int[1 + 1]));
    System.out.println(new AQ2FibonacciNumber().fib(2, new int[2 + 1]));
    System.out.println(new AQ2FibonacciNumber().fib(3, new int[3 + 1]));
    System.out.println(new AQ2FibonacciNumber().fib(4, new int[4 + 1]));
    System.out.println(new AQ2FibonacciNumber().fib(5, new int[5 + 1]));
  }

    int fib(int n, int[] fibArr) {
    if (n <= 1) {
      return n;
    }
    if (fibArr[n] > 0) {
      return fibArr[n];
    }

    int fib = fib(n - 1, fibArr) + fib(n - 2, fibArr);
    fibArr[n] = fib;
    return fib;
  }
  int fib(int n) {
    if (n <= 1) {
      return 1;
    }
    int prev = 0;
    int next = 1;
//    System.out.println(prev);
//    System.out.println(next);
    for (int i = 2; i <= n; i++) {
      int temp = next;
      next = next + prev;
      prev = temp;
//      System.out.println(next);
    }
    return next;
  }
}
