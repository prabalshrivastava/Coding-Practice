package scaler.arrays.arrays2dmatrices;

public class AQ4MatrixMultiplication {
    //  Problem Description
    //  You are given two integer matrices A(having M X N size) and B(having N X P). You have to
    // multiply matrix A with B and return the resultant matrix. (i.e. return the matrix AB).
    //  image
    //  Problem Constraints
    // 1 <= M, N, P <= 100
    //      -100 <= A[i][j], B[i][j] <= 100
    //  Input Format
    //  First argument is a 2D integer matrix A.
    //  Second argument is a 2D integer matrix B.
    //      Output Format
    //  Return a 2D integer matrix denoting AB.
    //  Example Input
    //  Input 1:
    //  A = [[1, 2],            B = [[5, 6],
    //      [3, 4]]                 [7, 8]]
    //  Input 2:
    //  A = [[1, 1]]            B = [[2],
    //      [3]]
    //  Example Output
    //  Output 1:
    //      [[19, 22],
    //      [43, 50]]
    //  Output 2:
    //      [[5]]
    //  Example Explanation
    //  Explanation 1:
    //  image
    //  Explanation 2:
    //      [[1, 1]].[[2, 3]] = [[1 * 2 + 1 * 3]] = [[5]]
    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};

        A = new int[][]{{1, 1}};
        B = new int[][]{{2}, {3}};
    }

    public int[][] solve(int[][] A, int[][] B) {
        int[][] result = new int[B.length][B.length];
        int[][] transpose = transpose(A);

//        for (int j = 0; j < transpose.length; j++) {
//            int sum = 0;
//            for (int i = 0; i < transpose[i].length; i++) {
//                transpose[i][j] * B[i][j]
//            }
//        }


        for (int i = 0; i < A.length; i++) {
            //0th row of A with 0th column of B
            //1st row of A with 1st column of B
            for (int j = 0; j < B[0].length; j++) {
                //00 01
                //10 11
                int currentRow = 0;
                for (int k = 0; k < A[i].length; k++) {
                    currentRow += A[i][k] * B[k][j];
                }

            }
            //varying col in A is varying row in B
        }
        return null;
    }

    public int[][] transpose(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }
}
