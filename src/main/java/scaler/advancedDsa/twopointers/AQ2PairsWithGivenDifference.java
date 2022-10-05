package scaler.advancedDsa.twopointers;

import java.util.Arrays;

public class AQ2PairsWithGivenDifference {
    //    Problem Description
//    Given an one-dimensional integer array A of size N and an integer B.
//    Count all distinct pairs with difference equal to B.
//    Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
//    Problem Constraints
//1 <= N <= 104
//            0 <= A[i], B <= 105
//    Input Format
//    First argument is an one-dimensional integer array A of size N.
//    Second argument is an integer B.
//    Output Format
//    Return an integer denoting the count of all distinct pairs with difference equal to B.
//            Example Input
//    Input 1:
//    A = [1, 5, 3, 4, 2]
//    B = 3
//    Input 2:
//    A = [8, 12, 16, 4, 0, 20]
//    B = 4
//    Input 3:
//    A = [1, 1, 1, 2, 2]
//    B = 0
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            5
//    Output 3:
//            2
//    Example Explanation
//    Explanation 1:
//    There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
//    Explanation 2:
//    There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
//    Explanation 3:
//    There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
    public static void main(String[] args) {
//        int[] input1A = {1, 5, 3, 4, 2};
//        int input1B = 3;
//        System.out.println(new AQ2PairsWithGivenDifference().solve(input1A, input1B));
//        int[] input2A = {8, 12, 16, 4, 0, 20};
//        int input2B = 4;
//        System.out.println(new AQ2PairsWithGivenDifference().solve(input2A, input2B));
//        int[] input3A = {1, 1, 1, 2, 2};
//        int input3B = 0;
//        System.out.println(new AQ2PairsWithGivenDifference().solve(input3A, input3B));
        int[] input4A = {8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3};//7
        int input4B = 3;
//        System.out.println(new AQ2PairsWithGivenDifference().solve(input4A, input4B));
        int[] input5A = {5, 2, 2, 4, 9, 8, 5, 3, 8, 8, 10, 4, 2, 10, 9, 7, 6, 1, 3, 9, 7, 1, 3, 5};
        int input5B = 3;
        System.out.println(new AQ2PairsWithGivenDifference().solve(input5A, input5B));
    }

    public int solve(int[] A, int B) {
        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));
        int i = 0;
        int j = 1;
        long count = 0;
        int previousI = Integer.MAX_VALUE;
        int previousJ = Integer.MAX_VALUE;
        while (j < A.length) {
            int diff = A[j] - A[i];
            if (diff == B) {
//                System.out.printf("Found = [%s][%s]=>%s-%s=%s%n", j, i, A[j], A[i], A[j] - A[i]);
                count++;
                count = getModdedNumber(count, (long) (Math.pow(10, 9) + 7));
                previousI = A[i];
                previousJ = A[j];
//                while (i == previousI) {
//                    System.out.printf("Skip [%s][%s]=>%s-%s=%s%n", j, i, A[j], A[i], A[j] - A[i]);
//                    i++;
//                }
                while (j < A.length && A[j] == previousJ) {
//                    System.out.printf("Skip [%s][%s]=>%s-%s=%s%n", j, i, A[j], A[i], A[j] - A[i]);
                    j++;
                }
//                j++;
            } else if (diff < B) {
//                System.out.printf("[%s][%s]=>%s-%s=%s%n", j, i, A[j], A[i], A[j] - A[i]);
                //increase A[j] - A[i] by increasing j or decreasing i
                //decreasing j is not possible since we are going back to already processed data
                j++;
            } else {
//                System.out.printf("[%s][%s]=>%s-%s=%s%n", j, i, A[j], A[i], A[j] - A[i]);
                //decrease A[j] - A[i] by decreasing j or increasing i
                i++;
                if (i == j)
                    j++;
            }

        }
        return (int) getModdedNumber(count, (long) (Math.pow(10, 9) + 7));
    }

    long getModdedNumber(long A, long C) {
        if (A < 0) {
//            System.out.println(A);
            return (A + C) % C;
        } else
            return A % C;
    }

}
