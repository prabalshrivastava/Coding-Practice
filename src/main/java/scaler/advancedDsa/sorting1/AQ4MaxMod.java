package scaler.advancedDsa.sorting1;

public class AQ4MaxMod {
//    Problem Description
//    Given an array A of size N, Groot wants you to pick 2 indices i and j such that
//1 <= i, j <= N
//    A[i] % A[j] is maximum among all possible pairs of (i, j).
//    Help Groot in finding the maximum value of A[i] % A[j] for some i, j.
//    Problem Constraints
//1 <= N <= 100000
//            0 <= A[i] <= 100000
//    Input Format
//    First and only argument in an integer array A.
//            Output Format
//    Return an integer denoting the maximum value of A[i] % A[j] for any valid i, j.
//            Example Input
//    Input 1:
//    A = [1, 2, 44, 3]
//    Input 2:
//    A = [2, 6, 4]
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            4
//    Example Explanation
//    Explanation 1:
//    For i = 3, j = 2  A[i] % A[j] = 3 % 44 = 3.
//    No pair exists which has more value than 3.
//    Explanation 2:
//    For i = 2, j = 1  A[i] % A[j] = 4 % 6 = 4.

    public int solve(int[] A) {
        int secondMax = 0;
        int firstMax = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[firstMax]) {
                firstMax = i;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (i != firstMax && A[i] != A[firstMax] && A[i] > A[secondMax]) {
                secondMax = i;
            }
        }
        System.out.printf("A[firstMax] - A[%s] : %s%n", firstMax, A[firstMax]);
        System.out.printf("A[secondMax] - A[%s] : %s%n", secondMax, A[secondMax]);
        return A[secondMax] % A[firstMax];
    }

    public static void main(String[] args) {
        int[] input1A = {1, 2, 44, 3};
        System.out.println(new AQ4MaxMod().solve(input1A));
        int[] input2A = {2, 6, 4};
        System.out.println(new AQ4MaxMod().solve(input2A));
        int[] input3A = {927, 707, 374, 394, 279, 799, 878, 937, 431, 112};//927
        System.out.println(new AQ4MaxMod().solve(input3A));
        int[] input4A = {366, 9, 715, 523, 49, 345, 764, 313, 584, 112};
        System.out.println(new AQ4MaxMod().solve(input4A));
        int[] input5A = {1, 2, 3, 3};
        System.out.println(new AQ4MaxMod().solve(input5A));
    }
}
