package scaler.maths.modulararithmeticintroduction;

import java.awt.*;

public class HWQ3FindIfTwoRectanglesOverlap {
    //    Problem Description
//    Eight integers A, B, C, D, E, F, G, and H represent two rectangles in a 2D plane.
//    For the first rectangle, its bottom left corner is (A, B), and the top right corner is (C, D), and for the second rectangle, its bottom left corner is (E, F), and the top right corner is (G, H).
//    Find and return whether the two rectangles overlap or not.
//            Problem Constraints
//-10000 <= A < C <= 10000
//            -10000 <= B < D <= 10000
//            -10000 <= E < G <= 10000
//            -10000 <= F < H <= 10000
//    Input Format
//    The eight arguments are integers A, B, C, D, E, F, G, and H.
//            Output Format
//    Return 1 if the two rectangles overlap else, return 0.
//    Example Input
//    Input 1:
//    A = 0   B = 0
//    C = 4   D = 4
//    E = 2   F = 2
//    G = 6   H = 6
//    Input 2:
//    A = 0   B = 0
//    C = 4   D = 4
//    E = 2   F = 2
//    G = 3   H = 3
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    Rectangle with bottom left (2, 2) and top right (4, 4) is overlapping.
//    Explanation 2:
//    Overlapping rectangles can be found.
    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
//        int isEFInside = 0;
//        int isGHInside = 0;
//        if ((A <= E && E <= C) && (D <= F && F <= B)) {
//            isEFInside = 1;
//        }
//        if ((A <= G && G <= C) && (D <= H && H <= B)) {
//            isGHInside = 1;
//        }
//        return isEFInside ^ isGHInside;

        if (F >= D || H <= B)
            return 0;
        if (E >= C || G <= A)
            return 0;
//        else if (E > A && F > B && G < C && H < D)
//            return 0;
        else
            return 1;
    }

    public static void main(String[] args) {
        int input1A = 0;
        int input1B = 0;
        int input1C = 4;
        int input1D = 4;
        int input1E = 2;
        int input1F = 2;
        int input1G = 6;
        int input1H = 6;
        System.out.println(new HWQ3FindIfTwoRectanglesOverlap().solve(input1A, input1B, input1C, input1D, input1E, input1F, input1G, input1H));


        int input2A = 0;
        int input2B = 0;
        int input2C = 4;
        int input2D = 4;
        int input2E = 2;
        int input2F = 2;
        int input2G = 3;
        int input2H = 3;
        System.out.println(new HWQ3FindIfTwoRectanglesOverlap().solve(input2A, input2B, input2C, input2D, input2E, input2F, input2G, input2H));


        int input3A = 0;
        int input3B = 0;
        int input3C = 1;
        int input3D = 1;
        int input3E = 1;
        int input3F = 1;
        int input3G = 6;
        int input3H = 6;
        System.out.println(new HWQ3FindIfTwoRectanglesOverlap().solve(input3A, input3B, input3C, input3D, input3E, input3F, input3G, input3H));
    }
}
