package scaler.advancedDsa.binarysearch1;


public class HWQ1MatrixSearch {
    //    Problem Description
//    Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
//    This matrix A has the following properties:
//    Integers in each row are sorted from left to right.
//    The first integer of each row is greater than or equal to the last integer of the previous row.
//            Return 1 if B is present in A, else return 0.
//    NOTE: Rows are numbered from top to bottom, and columns are from left to right.
//            Problem Constraints
//1 <= N, M <= 1000
//            1 <= A[i][j], B <= 106
//    Input Format
//    The first argument given is the integer matrix A.
//    The second argument given is the integer B.
//    Output Format
//    Return 1 if B is present in A else, return 0.
//    Example Input
//    Input 1:
//    A = [
//            [1,   3,  5,  7]
//            [10, 11, 16, 20]
//            [23, 30, 34, 50]
//            ]
//    B = 3
//    Input 2:
//    A = [
//            [5, 17, 100, 111]
//            [119, 120, 127, 131]
//            ]
//    B = 3
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//            3 is present in the matrix at A[0][1] position so return 1.
//    Explanation 2:
//            3 is not present in the matrix so return 0.
    public static void main(String[] args) {
        int[][] input1A = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int input1B = 3;
//        System.out.println(input1A.length);//3
//        System.out.println(input1A[0].length);//4
        System.out.println(new HWQ1MatrixSearch().searchMatrix(input1A, input1B));
        System.out.println("");
        int[][] input2A = {
                {5, 17, 100, 111},
                {119, 120, 127, 131}
        };
        int input2B = 3;
        System.out.println(new HWQ1MatrixSearch().searchMatrix(input2A, input2B));
        System.out.println("");
        int[][] input4A =
                {
                        {3},
                        {29},
                        {36},
                        {63},
                        {67},
                        {72},
                        {74},
                        {78},
                        {85},
                };
        int input4B = 41;
        System.out.println(new HWQ1MatrixSearch().searchMatrix(input4A, input4B));
        System.out.println("");
    }

    public int searchMatrix(int[][] A, int B) {
        int l = 0;
        int r = (A.length * A[0].length) - 1;
        while (l <= r) {
//            System.out.printf("l:%s - r:%s%n", l, r);
            int mid = (l + r) / 2;
//            System.out.println("A.length : " + A[0].length);
            int row = mid / A[0].length;//row doesn't change frequently
            int col = mid % A[0].length;//column is frequent
            int element = A[row][col];
//            System.out.printf("mid : %s - row : %s - col : %s - element : %s%n", mid, row, col, element);
            if (element == B) {
//                System.out.println("found at index : " + A[row][col] + " - " + row + " - " + col);
                return 1;
            } else if (B < element) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }
}
