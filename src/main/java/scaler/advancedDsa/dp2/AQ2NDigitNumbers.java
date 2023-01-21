package scaler.advancedDsa.dp2;

import com.google.gson.annotations.Since;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder;
import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Output;

public class AQ2NDigitNumbers {

  //  Problem Description
//  Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
//  Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
//  Since the answer can be large, output answer modulo 1000000007
//  Problem Constraints
//1 <= A <= 1000
//      1 <= B <= 10000
//  Input Format
//  First argument is the integer A
//  Second argument is the integer B
//  Output Format
//  Return a single integer, the answer to the problem
//  Example Input
//  Input 1:
//  A = 2
//  B = 4
//  Input 2:
//  A = 1
//  B = 3
//  Example Output
//  DocFinder.Output 1:
//      4
//  Output 2:
//      1
//  Example Explanation
//  Explanation 1:
//  Valid numbers are {22, 31, 13, 40}
//  Hence output 4.
//  Explanation 2:
//  Only valid number is 3
  public static void main(String[] args) {
    int input1A = 2;
    int input1B = 4;
    System.out.println(new AQ2NDigitNumbers().solve(input1A,input1B));
    int input2A = 1;
    int input2B = 3;
    System.out.println(new AQ2NDigitNumbers().solve(input2A,input2B));
  }
  public int solve(int A, int B) {
    return A;
  }
}