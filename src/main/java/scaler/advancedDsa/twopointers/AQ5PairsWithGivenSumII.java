package scaler.advancedDsa.twopointers;

import com.google.gson.annotations.Since;

import java.util.Arrays;

public class AQ5PairsWithGivenSumII {
    //    Problem Description
//    Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
//    Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
//    Problem Constraints
//1 <= |A| <= 100000
//            1 <= A[i] <= 10^9
//            1 <= B <= 10^9
//    Input Format
//    The first argument given is the integer array A.
//    The second argument given is integer B.
//            Output Format
//    Return the number of pairs for which sum is equal to B modulo (10^9+7).
//    Example Input
//    Input 1:
//    A = [1, 1, 1]
//    B = 2
//    Input 2:
//    A = [1, 1]
//    B = 2
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            1
//    Example Explanation
//    Explanation 1:
//    Any two pairs sum up to 2.
//    Explanation 2:
//    only pair (1, 2) sums up to 2.
    public static void main(String[] args) {
        int[] input1A = {1, 1, 1};
        int input1B = 2;
        System.out.println(new AQ5PairsWithGivenSumII().solve(input1A, input1B));

        int[] input2A = {1, 1};
        int input2B = 2;
        System.out.println(new AQ5PairsWithGivenSumII().solve(input2A, input2B));
    }

    public int solve(int[] A, int B) {
        int i = 0;
        int j = A.length - 1;
        long count = 0;
        while (i < j) {
            if (A[i] + A[j] == B) {
//                System.out.printf("found [%s][%s]=>%s+%s=%s%n", j, i, A[j], A[i], A[j] + A[i]);
//                count++;
//                count = getModdedNumber(count);
//                j++;
                //case A[i]!=A[j]
                long countOfIDupe = 0;
                long countOfJDupe = 0;
                int ai = A[i];
                int aj = A[j];
                if (ai == aj) {
                    long n = j - i + 1;
//                    System.out.println("n=" + n);
                    n = n - 1;
//                    System.out.println("n=" + n);
                    long sum = (n * (n + 1)) / 2;
                    count = count + sum;
                    count = getModdedNumber(count);
                    return (int) count;
                } else {
                    while (i < A.length && A[i] == ai) {
                        i++;
                        countOfIDupe++;
                    }
                    while (j >= 0 && A[j] == aj) {
                        j--;
                        countOfJDupe++;
                    }
                    count = count + countOfIDupe * countOfJDupe;
                    count = getModdedNumber(count);
                }
                //case A[i]==A[j]
            } else if (A[i] + A[j] < B) {
//                System.out.printf("Skip [%s][%s]=>%s+%s=%s%n", j, i, A[j], A[i], A[j] + A[i]);
                i++;
            } else {
//                System.out.printf("Skip [%s][%s]=>%s+%s=%s%n", j, i, A[j], A[i], A[j] + A[i]);
                j--;
            }
        }
        count = getModdedNumber(count);
        return (int) count;
    }

    long getModdedNumber(long A) {
        long C = (long) (Math.pow(10, 9) + 7);
        if (A < 0) {
//            System.out.println(A);
            return (A + C) % C;
        } else
            return A % C;
    }

}
