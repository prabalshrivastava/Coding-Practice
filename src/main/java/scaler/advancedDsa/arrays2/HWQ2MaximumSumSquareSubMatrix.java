package scaler.advancedDsa.arrays2;

public class HWQ2MaximumSumSquareSubMatrix {
//    Problem Description
//    Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1, such that the sum of all the elements in the submatrix is maximum.
//            Problem Constraints
//1 <= N <= 103.
//            1 <= B <= N
//-102 <= A[i][j] <= 102.
//    Input Format
//    First arguement is an 2D integer matrix A.
//    Second argument is an integer B.
//    Output Format
//    Return a single integer denoting the maximum sum of submatrix of size B x B.
//            Example Input
//    Input 1:
//    A = [
//            [1, 1, 1, 1, 1]
//            [2, 2, 2, 2, 2]
//            [3, 8, 6, 7, 3]
//            [4, 4, 4, 4, 4]
//            [5, 5, 5, 5, 5]
//            ]
//    B = 3
//    Input 2:
//    A = [
//            [2, 2]
//            [2, 2]
//            ]
//    B = 2
//    Example Output
//    Output 1:
//            48
//    Output 2:
//            8
//    Example Explanation
//    Explanation 1:
//    Maximum sum 3 x 3 matrix is
//    8 6 7
//            4 4 4
//            5 5 5
//    Sum = 48
//    Explanation 2:
//    Maximum sum 2 x 2 matrix is
//  2 2
//          2 2
//    Sum = 8
public int solve(int[][] A, int B) {
    return B;
}
public static void main(String[] args) {
    int[][] input1A = {
            {1, 1, 1, 1, 1},
            {2, 2, 2, 2, 2},
            {3, 8, 6, 7, 3},
            {4, 4, 4, 4, 4},
            {5, 5, 5, 5, 5}
    };
    int input1B = 3;
    System.out.println(new HWQ2MaximumSumSquareSubMatrix().solve(input1A,input1B));
    int[][] input2A = {
            {2, 2},
            {2, 2}
    };
    int input2B = 2;
    System.out.println(new HWQ2MaximumSumSquareSubMatrix().solve(input2A,input2B));
}
}
