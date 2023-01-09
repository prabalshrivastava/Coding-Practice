package scaler.advancedDsa.heaps1;

import scaler.common.CommonUtils;
import scaler.common.Heap;

import java.util.Arrays;

public class AQ1MagicianAndChocolatesWIthHeapImpl {
    //    Problem Description
//    Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
//    In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
//    Find the maximum number of chocolates that the kid can eat in A units of time.
//    NOTE:
//    floor() function returns the largest integer less than or equal to a given number.
//    Return your answer modulo 109+7
//    Problem Constraints
//1 <= N <= 100000
//            0 <= B[i] <= INT_MAX
//0 <= A <= 105
//    Input Format
//    The first argument is an integer A.
//    The second argument is an integer array B of size N.
//            Output Format
//    Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.
//    Example Input
//    Input 1:
//    A = 3
//    B = [6, 5]
//    Input 2:
//    A = 5
//    b = [2, 4, 6, 8, 10]
//    Example Output
//    Output 1:
//            14
//    Output 2:
//            33
//    Example Explanation
//    Explanation 1:
//    At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates.
//            At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates.
//            At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate.
//            so, total number of chocolates eaten are 6 + 5 + 3 = 14
//    Explanation 2:
//    Maximum number of chocolates that can be eaten is 33.
    public static void main(String[] args) {
        int input1A = 3;
        int[] input1B = {6, 5};
//        System.out.println(new AQ1MagicianAndChocolates().nchoc(input1A, input1B));
        int input2A = 5;
        int[] input2B = {2, 4, 6, 8, 10};//max heap -> 10,8,6,2,4
        System.out.println(new AQ1MagicianAndChocolatesWIthHeapImpl().nchoc(input2A, input2B));
    }

    public int nchoc(int A, int[] B) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Collections.reverseOrder());
        Heap.buildMaxHeap(B);
        System.out.println(Arrays.toString(B));
        long ans = 0;
        for (int i = 0; i < A; i++) {
            int removedElement = Heap.getMaxFromMaxHeap(B);
            B = Heap.extractMaxFromMaxHeap(B);
            System.out.println("Post Removing : " + Arrays.toString(B));
            ans = CommonUtils.getModdedSum(ans + removedElement);
            B = Heap.insertMaxHeap(B, (removedElement / 2));
            System.out.println("Post Adding : " + Arrays.toString(B));
        }
        return (int) ans;
    }
}
