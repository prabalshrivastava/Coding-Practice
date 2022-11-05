package scaler.advancedDsa.stacks2;


public class HWQ2MaximumRectangle {
    //    Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
//    Find the largest rectangle containing only 1's and return its area.
//    Note: Rows are numbered from top to bottom and columns are numbered from left to right.
//            Input Format
//    The only argument given is the integer matrix A.
//            Output Format
//    Return the area of the largest rectangle containing only 1's.
//    Constraints
//1 <= N, M <= 1000
//            0 <= A[i] <= 1
//    For Example
//    Input 1:
//    A = [   [0, 0, 1]
//            [0, 1, 1]
//            [1, 1, 1]   ]
//    Output 1:
//            4
//    Input 2:
//    A = [   [0, 1, 0, 1]
//            [1, 0, 1, 0]    ]
//    Output 2:
//            1
    public static void main(String[] args) {
        int[][] input1A = {{0, 0, 1}, {0, 1, 1}, {1, 1, 1}};
        System.out.println(new HWQ2MaximumRectangle().solve(input1A));

        int[][] input2A = {{0, 1, 0, 1}, {1, 0, 1, 0}};
        System.out.println(new HWQ2MaximumRectangle().solve(input2A));

    }

    public int solve(int[][] A) {
        return 0;
    }
}
