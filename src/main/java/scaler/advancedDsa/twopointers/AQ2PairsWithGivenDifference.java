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
        int[] input1A = {1, 5, 3, 4, 2};
        int input1B = 3;
        System.out.println(new AQ2PairsWithGivenDifference().solve(input1A, input1B));
        int[] input2A = {8, 12, 16, 4, 0, 20};
        int input2B = 4;
        System.out.println(new AQ2PairsWithGivenDifference().solve(input2A, input2B));
        int[] input3A = {1, 1, 1, 2, 2};
        int input3B = 0;
        System.out.println(new AQ2PairsWithGivenDifference().solve(input3A, input3B));
    }

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int i = 0;
        int j = 1;
        long count = 0;
        while (j < A.length) {
            int diff = A[j] - A[i];
            if (diff == B) {
                count++;
                count = getModdedNumber(count, (long) (Math.pow(10, 9) + 7));
                i++;
                j++;
            } else if (diff < B) {
                //increase A[j] - A[i] by increasing j or decreasing i
                //decreasing j is not possible since we are going back to already processed data
                j++;
            } else {
                //decrease A[j] - A[i] by decreasing j or increasing i
                i++;
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
