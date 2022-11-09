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
        int[] leftSmallerArr = getLeftSmallerArr(A);
        int[] rightSmallerArr = getRightSmallerArr(A);
//        System.out.println(Arrays.toString(leftGreaterArr));
//        System.out.println(Arrays.toString(rightGreaterArr));
//        System.out.println(Arrays.toString(leftSmallerArr));
//        System.out.println(Arrays.toString(rightSmallerArr));

        long ans = 0;
        for (int i = 0; i < A.length; i++) {
            long max = getModdedAns(A[i] * getModdedAns(i - leftGreaterArr[i]) * getModdedAns(rightGreaterArr[i] - i));
            long min = getModdedAns(A[i] * getModdedAns(i - leftSmallerArr[i]) * getModdedAns(rightSmallerArr[i] - i));
            ans = getModdedAns(ans + max - min);
        }
        return (int) getModdedAns(ans);
    }

    private long getModdedAns(long sum) {
        if (sum < 0)
            sum = (long) ((sum + (Math.pow(10, 9) + 7)) % (Math.pow(10, 9) + 7));
        else
            sum = (long) (sum % (Math.pow(10, 9) + 7));
        return sum;
    }


    private int[] getRightSmallerArr(int[] A) {
        Stack<Integer> rightSmallerStack = new Stack<>();
        int[] rightSmallerArr = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (rightSmallerStack.isEmpty()) {
                rightSmallerArr[i] = A.length;
                rightSmallerStack.push(i);
            } else {
                if (A[i] <= A[rightSmallerStack.peek()]) {
                    while (!rightSmallerStack.isEmpty() && A[i] <= A[rightSmallerStack.peek()]) {
                        rightSmallerStack.pop();
                    }
                    if (rightSmallerStack.isEmpty()) {
                        rightSmallerArr[i] = A.length;
                    } else {
                        rightSmallerArr[i] = rightSmallerStack.peek();
                    }
                } else {
                    rightSmallerArr[i] = rightSmallerStack.peek();
                }
                rightSmallerStack.push(i);
            }
        }
        return rightSmallerArr;
    }

    private int[] getLeftSmallerArr(int[] A) {
        Stack<Integer> leftSmallerStack = new Stack<>();
        int[] leftSmallerArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (leftSmallerStack.isEmpty()) {
                leftSmallerArr[i] = -1;
                leftSmallerStack.push(i);
            } else {
                if (A[i] <= A[leftSmallerStack.peek()]) {
                    while (!leftSmallerStack.isEmpty() && A[i] <= A[leftSmallerStack.peek()]) {
                        leftSmallerStack.pop();
                    }
                    if (leftSmallerStack.isEmpty()) {
                        leftSmallerArr[i] = -1;
                    } else {
                        leftSmallerArr[i] = leftSmallerStack.peek();
                    }
                } else {
                    leftSmallerArr[i] = leftSmallerStack.peek();
                }
                leftSmallerStack.push(i);
            }
        }
        return leftSmallerArr;
    }

    private int[] getRightGreaterArr(int[] A) {
        Stack<Integer> rightGreaterStack = new Stack<>();
        int[] rightGreaterArr = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            if (rightGreaterStack.isEmpty()) {
                rightGreaterArr[i] = A.length;
                rightGreaterStack.push(i);
            } else {
                if (A[i] <= A[rightGreaterStack.peek()]) {
                    rightGreaterArr[i] = rightGreaterStack.peek();
                    rightGreaterStack.push(i);
                } else {
                    while (!rightGreaterStack.isEmpty() && A[i] > A[rightGreaterStack.peek()]) {
                        rightGreaterStack.pop();
                    }
                    if (rightGreaterStack.isEmpty()) {
                        rightGreaterArr[i] = A.length;
                    } else {
                        rightGreaterArr[i] = rightGreaterStack.peek();
                    }
                    rightGreaterStack.push(i);
                }
            }
        }
        return rightGreaterArr;
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
