package scaler.arrays.subarrays;

public class AQ3SubarrayWithLeastAverage {
    //    Problem Description
//    Given an array of size N, find the subarray of size K with the least average.
//
//
//
//            Problem Constraints
//1<=k<=N<=1e5
//            -1e5<=A[i]<=1e5
//
//
//    Input Format
//    First argument contains an array A of integers of size N.
//    Second argument contains integer k.
//
//
//            Output Format
//    Return the index of the first element of the subarray of size k that has least average.
//    Array indexing starts from 0.
//
//
//    Example Input
//    Input 1:
//    A=[3, 7, 90, 20, 10, 50, 40]
//    B=3
//    Input 2:
//
//    A=[3, 7, 5, 20, -10, 0, 12]
//    B=2
//
//
//    Example Output
//    Output 1:
//            3
//    Output 2:
//
//            4
//
//
//    Example Explanation
//    Explanation 1:
//    Subarray between indexes 3 and 5
//    The subarray {20, 10, 50} has the least average
//    among all subarrays of size 3.
//    Explanation 2:
//
//    Subarray between [4, 5] has minimum average
//
    public static void main(String[] args) {
//        int[] input1A = {3, 7, 90, 20, 10, 50, 40};
//        int input1B = 3;
//        System.out.println(new AQ3SubarrayWithLeastAverage().solve(input1A, input1B));
//        int[] input2A = {3, 7, 5, 20, -10, 0, 12};
//        int input2B = 2;
//        System.out.println(new AQ3SubarrayWithLeastAverage().solve(input2A, input2B));
//
//        int[] input3A = {18, 11, 16, 19, 11, 9, 8, 15, 3, 10, 9, 20, 1, 19};
//        int input3B = 1;
//        System.out.println(new AQ3SubarrayWithLeastAverage().solve(input3A, input3B));//        12

        int[] input4A = {20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11};
        int input4B = 9;
        System.out.println(new AQ3SubarrayWithLeastAverage().solve(input4A,input4B));//3
    }

    public int solve(int[] A, int B) {
        int avg;
        int minAvg = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < A.length - (B - 1); i++) {
            int sum = 0;
            for (int j = i; j < i + B; j++) {
                sum = sum + A[j];
            }
            avg = sum;
            System.out.println("sum : " +  sum + " ------ avg : " + avg);
//            minAvg = Math.min(avg, minAvg);
            if (avg < minAvg) {
                minAvg = avg;
                ans = i;
            }
        }
        return ans;
    }
}
