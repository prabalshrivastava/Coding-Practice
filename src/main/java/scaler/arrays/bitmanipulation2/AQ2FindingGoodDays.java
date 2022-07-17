package scaler.arrays.bitmanipulation2;

public class AQ2FindingGoodDays {
    //    Problem Description
//    Alex has a cat named Boomer. He decides to put his cat to the test for eternity.
//
//    He starts on day 1 with a stash of food unit, every next day, the stash doubles.
//
//    If Boomer is well behaved during a particular day, she receives food worth equal to the stash on that day.
//
//    Boomer receives a net worth of A units of food. What is the number of days he was well behaved?
//
//
//
//    Problem Constraints
//1 <= A <= 231-1
//
//
//
//    Input Format
//    First and only argument is an integer A.
//
//
//
//    Output Format
//    Return an integer denoting the number of days Boomer was well behaved.
//
//
//
//    Example Input
//    Input 1:
//
//    A = 5
//    Input 2:
//
//    A = 8
//
//
//    Example Output
//    Output 1:
//
//            2
//    Output 2:
//
//            1
//
//
//    Example Explanation
//    Explanation 1:
//
//    To eat a total of 5 units of food, Boomer behaved normally on Day 1 and on the Day 3.
//    Explanation 2:
//
//    To eat a total of 8 units of food, Boomer behaved normally only on day 4.
    public static void main(String[] args) {
        int input1A = 5;
        System.out.println(new AQ2FindingGoodDays().solve(input1A));
        int input2A = 8;
        System.out.println(new AQ2FindingGoodDays().solve(input2A));
    }

    public int solve(int A) {
        int count = 0;
        while (A > 0) {
            A = A & (A - 1);
            count++;
        }
        return count;
    }
}
