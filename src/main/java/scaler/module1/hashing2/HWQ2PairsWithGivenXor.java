package scaler.module1.hashing2;

import java.util.HashMap;
import java.util.Map;

public class HWQ2PairsWithGivenXor {
    //    Problem Description
//    Given an integer array A containing N distinct integers.
//    Find the number of unique pairs of integers in the array whose XOR is equal to B.
//            NOTE:
//    Pair (a, b) and (b, a) is considered to be the same and should be counted once.
//            Problem Constraints
//1 <= N <= 105
//            1 <= A[i], B <= 107
//    Input Format
//    The first argument is an integer array A.
//    The second argument is an integer B.
//            Output Format
//    Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.
//    Example Input
//    Input 1:
//    A = [5, 4, 10, 15, 7, 6]
//    B = 5
//    Input 2:
//    A = [3, 6, 8, 10, 15, 50]
//    B = 5
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//            (10 ^ 15) = 5
//    Explanation 2:
//            (3 ^ 6) = 5 and (10 ^ 15) = 5

    //x^y = B
    //x^y^B = B^B = 1
    //x^y^B = 1
    //x^y^B^x = 1^x
    //y^B = x


    //x^y = B
    //B^y = x
    //or
    //B^x = y


    public int solve(int[] A, int B) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int requiredElementInArray = A[i] ^ B;
            if (map.containsKey(requiredElementInArray)) {
                count++;
            } else {
                map.put(A[i], requiredElementInArray);
            }
        }
        return count;
    }

    public int solve1(int[] A, int B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if ((A[i] ^ A[j]) == B) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input1A = {5, 4, 10, 15, 7, 6};
        int input1B = 5;
        System.out.println(new HWQ2PairsWithGivenXor().solve(input1A, input1B));
        int[] input2A = {3, 6, 8, 10, 15, 50};
        int input2B = 5;
        System.out.println(new HWQ2PairsWithGivenXor().solve(input2A, input2B));
    }
}
