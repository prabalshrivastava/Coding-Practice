package scaler.module1.hashing2;

public class HWQ3ValidSudoku {
//    Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
//    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//    The input corresponding to the above configuration :
//            ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
//    A partially filled sudoku which is valid.
//            Note:
//    A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
//    Return 0 / 1 ( 0 for false, 1 for true ) for this problem

    public static void main(String[] args) {
        String[] A = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        System.out.println(new HWQ3ValidSudoku().isValidSudoku(A));
    }

    public int isValidSudoku(final String[] A) {
        return 0;
    }
}
