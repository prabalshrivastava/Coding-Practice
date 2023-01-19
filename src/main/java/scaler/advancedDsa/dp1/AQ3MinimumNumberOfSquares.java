package scaler.advancedDsa.dp1;

public class AQ3MinimumNumberOfSquares {

  //  Problem Description
//  Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
//  Problem Constraints
//1 <= A <= 105
//  Input Format
//  First and only argument is an integer A.
//  Output Format
//  Return an integer denoting the minimum count.
//      Example Input
//  Input 1:
//  A = 6
//  Input 2:
//  A = 5
//  Example Output
//  DocFinder.Output 1:
//      3
//  Output 2:
//      2
//  Example Explanation
//  Explanation 1:
//  Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
//  Minimum count of numbers, sum of whose squares is 6 is 3.
//  Explanation 2:
//  We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
  public static void main(String[] args) {
    System.out.println(new AQ3MinimumNumberOfSquares().countMinSquares(6));//3    2^2+1^2+1^2
    System.out.println(new AQ3MinimumNumberOfSquares().countMinSquares(5));//2    2^2+1^2
    System.out.println(new AQ3MinimumNumberOfSquares().countMinSquares(10));//2   3^2+1^2
    System.out.println(new AQ3MinimumNumberOfSquares().countMinSquares(13));//2   3^2+2^2
  }

  public int countMinSquares(int A) {

    return A;
  }
}
