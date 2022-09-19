package scaler.advancedDsa.recursion1;

public class HWQ5AnotherSequenceProblem {
    //    Problem Description
//    Given a sequence f(A) = f(A-1) + f(A-2) + f(A-3) + A . Calculate the Ath term of the sequence.
//            Given f(0)=1; f(1)=1; f(2)=2;
//    Problem Constraints
//0<=n<=20
//    Input Format
//    First and only argument is an integer A.
//    Output Format
//    Return an integer denoting the Ath term of the sequence.
//    Example Input
//    Input 1:
//            3
//    Input 2:
//            2
//    Example Output
//    Output 1:
//            7
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//    f(3) = 2+1+1+3 = 7
//    Explanation 2:
//    f(2) = 2 as given.
    public static void main(String[] args) {
        System.out.println(new HWQ5AnotherSequenceProblem().solve(0));//1
        System.out.println(new HWQ5AnotherSequenceProblem().solve(1));//1
        System.out.println(new HWQ5AnotherSequenceProblem().solve(2));//2
        System.out.println(new HWQ5AnotherSequenceProblem().solve(3));//7
        System.out.println(new HWQ5AnotherSequenceProblem().solve(4));//14
        System.out.println(new HWQ5AnotherSequenceProblem().solve(5));//28
        System.out.println(new HWQ5AnotherSequenceProblem().solve(6));
        System.out.println(new HWQ5AnotherSequenceProblem().solve(7));
    }

    public int solve(int A) {
        if (A == 0 || A == 1)
            return 1;
        if (A == 2)
            return 2;
        return solve(A - 1) + solve(A - 2) + solve(A - 3) + A;
    }
}
