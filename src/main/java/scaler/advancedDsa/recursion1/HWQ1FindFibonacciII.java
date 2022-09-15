package scaler.advancedDsa.recursion1;

public class HWQ1FindFibonacciII {
    //    Problem Description
//    The Fibonacci numbers are the numbers in the following integer sequence.
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
//    In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
//    Fn = Fn-1 + Fn-2
//    Given a number A, find and return the Ath Fibonacci Number.
//    Given that F0 = 0 and F1 = 1.
//    Problem Constraints
//0 <= A <= 20
//    Input Format
//    First and only argument is an integer A.
//    Output Format
//    Return an integer denoting the Ath term of the sequence.
//    Example Input
//    Input 1:
//    A = 2
//    Input 2:
//    A = 9
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            34
//    Example Explanation
//    Explanation 1:
//    f(2) = f(1) + f(0) = 1
//    Explanation 2:
//    f(9) = f(8) + f(7) = 21 + 13  = 34
    public static void main(String[] args) {
        int input1A = 2;
        System.out.println(new HWQ1FindFibonacciII().findAthFibonacci(input1A));
        int input2A = 9;
        System.out.println(new HWQ1FindFibonacciII().findAthFibonacci(input2A));
        System.out.println(new HWQ1FindFibonacciII().findAthFibonacci(0));//0
    }

    public int findAthFibonacci(int A) {
        if (A == 1 || A == 0)
            return A;
        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }
}
