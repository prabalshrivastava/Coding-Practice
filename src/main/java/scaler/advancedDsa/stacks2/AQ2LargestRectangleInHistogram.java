package scaler.advancedDsa.stacks2;

import java.util.Arrays;
import java.util.Stack;

public class AQ2LargestRectangleInHistogram {
    //    Problem Description
//    Given an array of integers A.
//    A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
//    Find the area of the largest rectangle formed by the histogram.
//            Problem Constraints
//1 <= |A| <= 100000
//            1 <= A[i] <= 1000000000
//    Input Format
//    The only argument given is the integer array A.
//            Output Format
//    Return the area of the largest rectangle in the histogram.
//    Example Input
//    Input 1:
//    A = [2, 1, 5, 6, 2, 3]
//    Input 2:
//    A = [2]
//    Example Output
//    Output 1:
//            10
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//    The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
//    Explanation 2:
//    Largest rectangle has area 2.
    public static void main(String[] args) {
        int[] input1A = {2, 1, 5, 6, 2, 3};
        System.out.println(new AQ2LargestRectangleInHistogram().largestRectangleArea(input1A));
        int[] input2A = {2};
        System.out.println(new AQ2LargestRectangleInHistogram().largestRectangleArea(input2A));
        int[] input3A = {2, 1, 4, 7, 5, 2, 1, 3, 4, 5, 6, 4, 3, 2, 3, 1, 5, 6, 4, 2};
        System.out.println(new AQ2LargestRectangleInHistogram().largestRectangleArea(input3A));
        //Indexes  Elements                     : { 0, 1,2,3,4,5, 6,7,8,9,10,11,12,13,14,15,16,17,18,19};
        //Original Elements                     : { 2, 1,4,7,5,2, 1,3,4,5, 6, 4, 3, 2, 3, 1, 5, 6, 4, 2};
        //Next Small Elements on left           : {-1,-1,1,4,4,1,-1,1,3,4, 5, 3, 1, 1, 2,-1, 1, 5, 1, 1};
        //Next Small Elements on left index     : {-1,-1,1,2,2,1,-1,1,7,8, 9, 7, 6, 6,13,-1,15,16,15,15};
        //Next Small Elements on right          : { 1, 1, 5, 3, 1,-1,  2, 3, 4, 4, 3, 2, 1, 1,-1,  4, 4, 2, -1};
    }

    public int largestRectangleArea(int[] A) {
        int[] nextSmallElementsOnLeftIndexes = extractNextSmallElementsOnLeftIndexes(A);
        int[] nextSmallElementsOnRightIndexes = extractNextSmallElementsOnRightIndexes(A);
//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(nextSmallElementsOnLeftIndexes));
//        System.out.println(Arrays.toString(nextSmallElementsOnRightIndexes));
        int ansArea = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int leftIndex = nextSmallElementsOnLeftIndexes[i];
            int rightIndex = nextSmallElementsOnRightIndexes[i];
            int left = leftIndex == -1 ? 0 : leftIndex;
            int right = rightIndex == -1 ? 0 : rightIndex;
//            int width = right - left + 1 - 2;
            int width = rightIndex - leftIndex + 1 - 2;
//            System.out.printf("rightIndex(%s)-leftIndex(%s)-1=width(%s)%n", rightIndex, leftIndex, width);
            width = width == -1 ? 0 : width;
            ansArea = Math.max(ansArea, A[i] * width);
//            System.out.printf("A[%s]->%s*%s=%s ansArea:%s | ", i, A[i], width, A[i] * width, ansArea);
        }
        return ansArea;
    }

    private int[] extractNextSmallElementsOnRightIndexes(int[] A) {
        int[] nextSmallElementsOnRightIndexes = new int[A.length];
        Stack<Integer> nextSmallElementsOnRightIndexesStack = new Stack<>();
        for (int i = A.length - 1; i >= 0; i--) {
            if (nextSmallElementsOnRightIndexesStack.isEmpty()) {
                nextSmallElementsOnRightIndexes[i] = A.length;
                nextSmallElementsOnRightIndexesStack.push(i);
            } else {
                if (A[nextSmallElementsOnRightIndexesStack.peek()] < A[i]) {
                    nextSmallElementsOnRightIndexesStack.push(i);
                }
                while (!nextSmallElementsOnRightIndexesStack.isEmpty() && A[nextSmallElementsOnRightIndexesStack.peek()] >= A[i]) {
                    nextSmallElementsOnRightIndexesStack.pop();
                }
                if (nextSmallElementsOnRightIndexesStack.isEmpty()) {
                    nextSmallElementsOnRightIndexes[i] = A.length;
                } else {
                    nextSmallElementsOnRightIndexes[i] = nextSmallElementsOnRightIndexesStack.peek();
                }
                nextSmallElementsOnRightIndexesStack.push(i);
            }
        }
        return nextSmallElementsOnRightIndexes;
    }

    private int[] extractNextSmallElementsOnLeftIndexes(int[] A) {
        int[] nextSmallElementsOnLeftIndexes = new int[A.length];
        Stack<Integer> nextSmallElementsOnLeftIndexesStack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (nextSmallElementsOnLeftIndexesStack.isEmpty()) {
                nextSmallElementsOnLeftIndexesStack.push(i);
                nextSmallElementsOnLeftIndexes[i] = -1;
            } else {
                Integer top = nextSmallElementsOnLeftIndexesStack.peek();
////                System.out.printf("i:%s - A[i]:%s - Stack:%s%n", i, A[i], nextSmallElementsOnLeftIndexesStack);
                if (A[i] > A[top]) {
                    nextSmallElementsOnLeftIndexes[i] = top;
                    nextSmallElementsOnLeftIndexesStack.push(i);
                } else {
                    while (!nextSmallElementsOnLeftIndexesStack.isEmpty() && A[i] <= A[top]) {
////                        System.out.printf("%s <= %s%n", A[i], A[top]);
                        nextSmallElementsOnLeftIndexesStack.pop();
                        if (nextSmallElementsOnLeftIndexesStack.isEmpty())
                            break;
                        top = nextSmallElementsOnLeftIndexesStack.peek();
                    }
////                    System.out.printf("Post Popping i:%s - A[i]:%s - Stack:%s - ansArr%s%n", i, A[i], nextSmallElementsOnLeftIndexesStack,Arrays.toString(nextSmallElementsOnLeftIndexes));
                    if (nextSmallElementsOnLeftIndexesStack.isEmpty()) {
                        nextSmallElementsOnLeftIndexes[i] = -1;
                    } else {
                        nextSmallElementsOnLeftIndexes[i] = top;
                    }
                    nextSmallElementsOnLeftIndexesStack.push(i);
                }
            }
        }
        return nextSmallElementsOnLeftIndexes;
    }
}
