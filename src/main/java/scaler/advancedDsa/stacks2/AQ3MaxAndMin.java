package scaler.advancedDsa.stacks2;

import java.util.Arrays;
import java.util.Stack;

public class AQ3MaxAndMin {
    //    Problem Description
//    Given an array of integers A.
//    value of a array = max(array) - min(array).
//            Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
//    Problem Constraints
//1 <= |A| <= 100000
//            1 <= A[i] <= 1000000
//    Input Format
//    The first and only argument given is the integer array A.
//            Output Format
//    Return the sum of values of all possible subarrays of A modulo 109+7.
//    Example Input
//    Input 1:
//    A = [1]
//    Input 2:
//    A = [4, 7, 3, 8]
//    Example Output
//    Output 1:
//            0
//    Output 2:
//            26
//    Example Explanation
//    Explanation 1:
//    Only 1 subarray exists. Its value is 0.
//    Explanation 2:
//    value ( [4] ) = 4 - 4 = 0
//    value ( [7] ) = 7 - 7 = 0
//    value ( [3] ) = 3 - 3 = 0
//    value ( [8] ) = 8 - 8 = 0
//    value ( [4, 7] ) = 7 - 4 = 3
//    value ( [7, 3] ) = 7 - 3 = 4
//    value ( [3, 8] ) = 8 - 3 = 5
//    value ( [4, 7, 3] ) = 7 - 3 = 4
//    value ( [7, 3, 8] ) = 8 - 3 = 5
//    value ( [4, 7, 3, 8] ) = 8 - 3 = 5
//    sum of values % 10^9+7 = 26
    public static void main(String[] args) {
        int[] input1A = {1};
        System.out.println(new AQ3MaxAndMin().solve(input1A));
        int[] input2A = {4, 7, 3, 8};
        System.out.println(new AQ3MaxAndMin().solve(input2A));
        int[] input3A = {9, 7, 3, 5, 4, 2, 6, 1, 8};
        System.out.println(new AQ3MaxAndMin().solve(input3A));

    }

    public int solve(int[] A) {
        int[] ansLeft = new int[A.length];
        int[] leftGreaterArr = getLeftGreaterArr(A);
        int[] rightGreaterArr = getRightGreaterArr(A);
        System.out.println(Arrays.toString(leftGreaterArr));
        return 0;
    }

    private int[] getRightGreaterArr(int[] A) {
        Stack<Integer> rightGreaterStack = new Stack<>();
        int[] rightGreaterArr = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (rightGreaterStack.isEmpty()) {
                rightGreaterArr[i] = -1;
                rightGreaterStack.push(i);
            } else {
                if (A[i] <= A[rightGreaterStack.peek()]) {
                    rightGreaterArr[i] = rightGreaterStack.peek();
                    rightGreaterStack.push(i);
                } else {

                }
            }
        }
        return new int[0];
    }

    private int[] getLeftGreaterArr(int[] A) {
        Stack<Integer> leftGreaterStack = new Stack<>();
        int[] leftGreaterArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (leftGreaterStack.isEmpty()) {
                leftGreaterStack.push(i);
                leftGreaterArr[i] = -1;
            } else {
                if (A[i] >= A[leftGreaterStack.peek()]) {
                    while (!leftGreaterStack.isEmpty() && A[i] >= A[leftGreaterStack.peek()]) {
                        leftGreaterStack.pop();
                    }
                    if (leftGreaterStack.isEmpty())
                        leftGreaterArr[i] = -1;
                    else
                        leftGreaterArr[i] = leftGreaterStack.peek();
                    leftGreaterStack.push(i);
                } else {
                    leftGreaterArr[i] = leftGreaterStack.peek();
                    leftGreaterStack.push(i);
                }
            }
        }
        return leftGreaterArr;
    }
}
