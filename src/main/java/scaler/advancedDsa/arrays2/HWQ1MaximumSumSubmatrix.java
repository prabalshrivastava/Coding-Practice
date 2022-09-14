package scaler.advancedDsa.arrays2;

public class HWQ1MaximumSumSubmatrix {
    //    Problem Description
//    Given a N * M 2D matrix A. Find the maximum sum sub-matrix from the matrix A. Return the Sum.
//            Problem Constraints
//1 <= N, M <= 300
//            -104 <= A[i][j] <= 104
//    Input Format
//    The first argument is a 2D Integer array A.
//            Output Format
//    Return the sum of the maximum sum sub-matrix from matrix A.
//    Example Input
//    Input 1:-
//            -6 -6
//            -29 -8
//    A =  3 -8
//            -15  2
//            25 25
//            20 -5
//    Input 2:-
//    A = -17 -2
//            20 10
//    Example Output
//    Output 1:-
//            65
//    Output 2:-
//            30
//    Example Explanation
//    Explanation 1:-
//    The submatrix
//25 25
//        20 -5
//    has the highest submatrix sum 65.
//    Explanation 2:-
//    The submatrix
//20 10
//    has the highest sub matrix sum 30.
    public int solve(int[][] A) {
        return 0;
    }

    public static void main(String[] args) {
        int[][] input1A = {
                {-6, -6},
                {-29, -8},
                {3, -8},
                {-15, 2},
                {25, 25},
                {20, -5}
        };
        System.out.println(new HWQ1MaximumSumSubmatrix().solve(input1A));
        int[][] input2A = {
                {-17, -2},
                {20, 10}
        };
        System.out.println(new HWQ1MaximumSumSubmatrix().solve(input2A));
    }
}
