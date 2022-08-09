package scaler.module1.introductiontoproblemsolving;

import java.util.Scanner;

public class IsItPerfectNumber {
  //  Problem Description
  //  You are given N positive integers.
  //  For each given integer A, you have to tell whether it is a perfect number or not.
  //  Perfect number is a positive integer which is equal to the sum of its proper positive
  // divisors.
  //      Problem Constraints
  // 1 <= N <= 10
  //      1 <= A <= 106
  //  Input Format
  //  First line of the input contains a single integer N.
  //  Each of the next N lines contains a single integer A.
  //      Output Format
  //  In a seperate line, print YES if a given integer is perfect, else print NO.
  //  Example Input
  //  Input 1:
  //      2
  //      4
  //      6
  //  Input 2:
  //      1
  //      3
  //  Example Output
  //  Output 1:
  //  NO
  //      YES
  //  Output 2:
  //  NO
  //  Example Explanation
  //  Explanation 1:
  //  For A = 4, the answer is "NO" as sum of its proper divisors = 1 + 2 = 3, is not equal to 4.
  //  For A = 6, the answer is "YES" as sum of its proper divisors = 1 + 2 + 3 = 6, is equal to 6.
  //  Explanation 2:
  //  For A = 3, the answer is "NO" as sum of its proper divisors = 1, is not equal to 3.
  // 10    10
  // 81    138613      NO
  // 84    359664      NO
  // 94    672448      NO
  // 50    446486      NO
  // 39    496         YES
  // 6    606234      NO
  // 39    738982      NO
  // 83    8128        YES
  // 8    484512      NO
  // 73    513847      NO

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int noOfInputs = sc.nextInt();
    if (noOfInputs < 1 || noOfInputs > 10) {
      return;
    }

    int[] inputs = new int[noOfInputs];
    for (int i = 0; i < noOfInputs; i++) {
      //   Scanner sc1 = new Scanner(System.in);
      int currentInput = sc.nextInt();
      if (currentInput >= 1 && currentInput <= 1000000) inputs[i] = currentInput;
      else i--;
    }
    //    // System.out.println(Arrays.toString(inputs));

    for (int i = 0; i < inputs.length; i++) {
      long n = inputs[i];
      // start finding the divisors.
      int sum = 0;
      for (int j = 1; j * j <= n; j++) {
        if (n % j == 0) {
          //          System.out.println(j);
          sum += j;
          if (j != n / j && n / j != n) {
            //            System.out.println(n / j);
            sum += (n / j);
          }
        }
      }
      //      System.out.println("sum = " + sum);
      if (sum == n) System.out.println("YES");
      else System.out.println("NO");
    }
  }
}
