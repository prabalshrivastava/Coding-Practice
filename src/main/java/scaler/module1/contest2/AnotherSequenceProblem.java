package scaler.module1.contest2;

public class AnotherSequenceProblem {
    public static void main(String[] args) {
        System.out.println(new AnotherSequenceProblem().solve(3));  //7
        System.out.println(new AnotherSequenceProblem().solve(2));  //2
        System.out.println(new AnotherSequenceProblem().solve(7));  //104
        System.out.println(new AnotherSequenceProblem().solve(25)); //6328671
    }

    public int solve(int A) {
        if (A == 1 || A == 2)
            return A;
        if (A == 0)
            return 1;
        return solve(A - 1) + solve(A - 2) + solve(A - 3) + A;
    }
}
