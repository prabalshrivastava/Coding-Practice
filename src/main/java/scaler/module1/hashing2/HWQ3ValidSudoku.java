package scaler.module1.hashing2;

import java.util.HashMap;
import java.util.Map;

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
        String[] B = {"..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.."};
        System.out.println(new HWQ3ValidSudoku().isValidSudoku(B));
        String[] C = {"....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"};
        System.out.println(new HWQ3ValidSudoku().isValidSudoku(C));

    }

    public int isValidSudoku(final String[] A) {
        for (int i = 0; i < 9; i++) {
            Map<Character, Integer> rowWiseMap = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                char key = A[i].charAt(j);
                if (key != '.' && rowWiseMap.containsKey(key)) {
                    return 0;
                }
                rowWiseMap.put(key, 1);
            }
//            System.out.println(rowWiseMap);
        }
        for (int j = 0; j < 9; j++) {
            Map<Character, Integer> colWiseMap = new HashMap<>();
            for (int i = 0; i < 9; i++) {
                char key = A[i].charAt(j);
                if (key != '.' && colWiseMap.containsKey(key)) {
                    return 0;
                }
                colWiseMap.put(key, 1);
            }
//            System.out.println(colWiseMap);
        }
        for (int ai = 0; ai < 3; ai++) {
            for (int aj = 0; aj < 3; aj++) {
                Map<Character, Integer> boxWiseMap = new HashMap<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char key = A[i + 3* ai].charAt(j + 3* aj);
                        if (key != '.' && boxWiseMap.containsKey(key)) {
                            return 0;
                        }
                        boxWiseMap.put(key, 1);
                    }
                }
//                System.out.println(boxWiseMap);
            }
        }
        return 1;
    }
}
