package scaler.arrays.interviewproblems;

public class AQ2ChristmasTrees {
    //    Problem Description
//    You are given an array A consisting of heights of Christmas trees and an array B of the same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q, and r), such that Ap < Aq < Ar, where p < q < r.
//            The cost of these trees is Bp + Bq + Br.
//
//            You are to choose 3 trees such that their total cost is minimum. Return that cost.
//
//            If it is not possible to choose 3 such trees return -1.
//
//
//
//            Problem Constraints
//            1 <= A[i], B[i] <= 109
//                                                                                                                                                                                                                                                      3 <= size(A) = size(B) <= 3000
//
//
//
//    Input Format
//    First argument is an integer array A.
//    Second argument is an integer array B.
//
//
//
//            Output Format
//    Return an integer denoting the minimum cost of choosing 3 trees whose heights are strictly in increasing order, if not possible, -1.
//
//
//
//    Example Input
//    Input 1:
//
//    A = [1, 3, 5]
//    B = [1, 2, 3]
//    Input 2:
//
//    A = [1, 6, 4, 2, 6, 9]
//    B = [2, 5, 7, 3, 2, 7]
//
//
//    Example Output
//    Output 1:
//
//            6
//    Output 2:
//
//            7
//
//
//    Example Explanation
//    Explanation 1:
//
//    We can choose the trees with indices 1, 2 and 3, and the cost is 1 + 2 + 3 = 6.
    public static void main(String[] args) {
        int[] input1A = {1, 3, 5};
        int[] input1B = {1, 2, 3};
        System.out.println(new AQ2ChristmasTrees().solve(input1A, input1B));
        int[] input2A = {1, 6, 4, 2, 6, 9};
        int[] input2B = {2, 5, 7, 3, 2, 7};
        System.out.println(new AQ2ChristmasTrees().solve(input2A, input2B));
        int[] input3A = {5, 9, 10, 4, 7, 8};
        int[] input3B = {5, 6, 4, 7, 2, 5};
        System.out.println(new AQ2ChristmasTrees().solve(input3A, input3B));
    }

    public int solve(int[] A, int[] B) {
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < A.length - 1; i++) {
            int middle = A[i];
//            System.out.printf("Checking for A[%s]=%s with cost %s%n", i, A[i], B[i]);
            int sum = B[i];
            int j = i - 1;
            int min = Integer.MAX_VALUE;
//            System.out.println("1 sum : " + sum);
            while (j >= 0) {
                if (A[j] < middle)
                    min = Math.min(B[j], min);
//                System.out.printf("Min Selected from left side : B[%s]=%s%n", j, B[j]);
                j--;
            }
            if (min != Integer.MAX_VALUE) {
                sum = sum + min;
            } else continue;
//            System.out.println("2 sum : " + sum);
            j = i + 1;
            min = Integer.MAX_VALUE;
            while (j < A.length) {
                if (A[j] > middle)
                    min = Math.min(B[j], min);
//                System.out.printf("Min Selected from right side : B[%s]=%s%n", j, B[j]);
                j++;
            }
            if (min != Integer.MAX_VALUE) {
                sum = sum + min;
            } else continue;
//            System.out.println("3 sum : " + sum + "\n");
            ans = Math.min(sum, ans);
        }
        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
}
