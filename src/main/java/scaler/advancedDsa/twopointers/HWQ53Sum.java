package scaler.advancedDsa.twopointers;

import java.util.Arrays;

public class HWQ53Sum {
    //    Problem Description
//    Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
//    Assume that there will only be one solution.
//    Problem Constraints
//-108 <= B <= 108
//            1 <= N <= 104
//            -108 <= A[i] <= 108
//    Input Format
//    First argument is an integer array A of size N.
//    Second argument is an integer B denoting the sum you need to get close to.
//            Output Format
//    Return a single integer denoting the sum of three integers which is closest to B.
//            Example Input
//    Input 1:
//    A = [-1, 2, 1, -4]
//    B = 1
//    Input 2:
//    A = [1, 2, 3]
//    B = 6
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            6
//    Example Explanation
//    Explanation 1:
//    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
//    Explanation 2:
//    Take all elements to get exactly 6.
    public static void main(String[] args) {
        int[] input1A = {-1, 2, 1, -4};
        int input1B = 1;
        System.out.println(new HWQ53Sum().threeSumClosest(input1A, input1B));
        int[] input2A = {1, 2, 3};
        int input2B = 6;
        System.out.println(new HWQ53Sum().threeSumClosest(input2A, input2B));
    }

    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        long ans = Integer.MAX_VALUE;
        long bestDistance = Integer.MAX_VALUE;
        for (int k = 0; k < A.length; k++) {
            int i = k + 1;
            int j = A.length - 1;
            while (i < j) {
                long sum = A[i] + A[j] + A[k];
                long distance = Math.abs(B - sum);
                if (A[i] + A[j] == B - A[k])
                    return B;
                else if (A[i] + A[j] < B - A[k]) {
                    if (distance < bestDistance) {
                        bestDistance = distance;
                        ans = sum;
                    }
                    i++;
                } else {
                    if (distance < bestDistance) {
                        bestDistance = distance;
                        ans = sum;
                    }
                    j--;
                }
            }
        }
        return (int) ans;
    }
}
