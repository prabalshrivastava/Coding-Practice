package scaler.advancedDsa.stacks2;

import javax.lang.model.util.Elements;
import java.util.Arrays;
import java.util.Stack;

public class AQ1NearestSmallerElement {
    //    Problem Description
//    Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
//            More formally,
//    G[i] for an element A[i] = an element A[j] such that
//    j is maximum possible AND
//    j < i AND
//    A[j] < A[i]
//    Elements for which no smaller element exist, consider the next smaller element as -1.
//    Problem Constraints
//1 <= |A| <= 100000
//            -109 <= A[i] <= 109
//    Input Format
//    The only argument given is integer array A.
//    Output Format
//    Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.
//    Example Input
//    Input 1:
//    A = [4, 5, 2, 10, 8]
//    Input 2:
//    A = [3, 2, 1]
//    Example Output
//    Output 1:
//            [-1, 4, -1, 2, 2]
//    Output 2:
//            [-1, -1, -1]
//    Example Explanation
//    Explanation 1:
//    index 1: No element less than 4 in left of 4, G[1] = -1
//    index 2: A[1] is only element less than A[2], G[2] = A[1]
//    index 3: No element less than 2 in left of 2, G[3] = -1
//    index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
//    index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
//    Explanation 2:
//    index 1: No element less than 3 in left of 3, G[1] = -1
//    index 2: No element less than 2 in left of 2, G[2] = -1
//    index 3: No element less than 1 in left of 1, G[3] = -1
    public static void main(String[] args) {
        int[] input1A = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(new AQ1NearestSmallerElement().prevSmaller(input1A)));//[-1, 4, -1, 2, 2]
        int[] input2A = {3, 2, 1};
        System.out.println(Arrays.toString(new AQ1NearestSmallerElement().prevSmaller(input2A)));//[-1, -1, -1]
        int[] input3A = {4, 5, 2, 10, 18, 2};
        System.out.println(Arrays.toString(new AQ1NearestSmallerElement().prevSmaller(input3A)));//[-1, 4, -1, 2, 10, -1]
        int[] input4A = {4, 6, 10, 11, 7, 6, 3, 5};
        System.out.println(Arrays.toString(new AQ1NearestSmallerElement().prevSmaller(input4A)));//[-1, 4, 6, 10, 6, 4, -1, 3]
    }

    public int[] prevSmaller(int[] A) {
        Stack<Integer> nearestElementStack = new Stack<>();
        int[] ansArr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (nearestElementStack.isEmpty()) {
                nearestElementStack.push(A[i]);
                ansArr[i] = -1;
            } else {
                Integer topOfStack = nearestElementStack.peek();
                if (topOfStack < A[i]) {
                    ansArr[i] = topOfStack;
                    nearestElementStack.push(A[i]);
                } else {
//                    System.out.println("topOfStack >= A[i] -> %s>=%s : %s",topOfStack,A[i],);
                    while (topOfStack >= A[i]) {
                        nearestElementStack.pop();
                        if (!nearestElementStack.isEmpty()) {
                            topOfStack = nearestElementStack.peek();
                        } else
                            break;
                    }
                    if (nearestElementStack.isEmpty())
                        ansArr[i] = -1;
                    else
                        ansArr[i] = topOfStack;
                    nearestElementStack.push(A[i]);
                }
            }
        }
        return ansArr;
    }
}
