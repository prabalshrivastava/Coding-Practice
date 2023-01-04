package scaler.advancedDsa.arrays3;

public class AQ2FirstMissingInteger {
//    Problem Description
//    Given an unsorted integer array, A of size N. Find the first missing positive integer.
//    Note: Your algorithm should run in O(n) time and use constant space.
//    Problem Constraints
//1 <= N <= 1000000
//            -109 <= A[i] <= 109
//    Input Format
//    First argument is an integer array A.
//            Output Format
//    Return an integer denoting the first missing positive integer.
//            Example Input
//    Input 1:
//            [1, 2, 0]
//    Input 2:
//            [3, 4, -1, 1]
//    Input 3:
//            [-8, -7, -6]
//    Example Output
//    Output 1:
//            3
//    Output 2:
//            2
//    Output 3:
//            1
//    Example Explanation
//    Explanation 1:
//    A = [1, 2, 0]
//    First positive integer missing from the array is 3.

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 0};
        System.out.println(new AQ2FirstMissingInteger().firstMissingPositive(input1));
        int[] input2 = new int[]{3, 4, -1, 1};
        System.out.println(new AQ2FirstMissingInteger().firstMissingPositive(input2));
        int[] input3 = new int[]{-8, -7, -6};
        System.out.println(new AQ2FirstMissingInteger().firstMissingPositive(input3));
    }

    public int firstMissingPositive(int[] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
//            if (A[i] > 0)
//                min = Math.min(A[i], min);
//            max = Math.max(A[i], max);
            
        }
        return max;
    }
}
