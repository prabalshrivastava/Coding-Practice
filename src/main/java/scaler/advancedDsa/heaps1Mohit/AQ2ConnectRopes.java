package scaler.advancedDsa.heaps1Mohit;

import java.util.PriorityQueue;

public class AQ2ConnectRopes {
    //    Problem Description
//    You are given an array A of integers that represent the lengths of ropes.
//    You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
//    Find and return the minimum cost to connect these ropes into one rope.
//    Problem Constraints
//1 <= length of the array <= 100000
//            1 <= A[i] <= 1000
//    Input Format
//    The only argument given is the integer array A.
//            Output Format
//    Return an integer denoting the minimum cost to connect these ropes into one rope.
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    Input 2:
//    A = [5, 17, 100, 11]
//    Example Output
//    Output 1:
//            33
//    Output 2:
//            182
//    Example Explanation
//    Explanation 1:
//    Given array A = [1, 2, 3, 4, 5].
//    Connect the ropes in the following manner:
//            1 + 2 = 3
//            3 + 3 = 6
//            4 + 5 = 9
//            6 + 9 = 15
//    So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
//    Explanation 2:
//    Given array A = [5, 17, 100, 11].
//    Connect the ropes in the following manner:
//            5 + 11 = 16
//            16 + 17 = 33
//            33 + 100 = 133
//    So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 4, 5};
        System.out.println(new AQ2ConnectRopes().solve(input1A));
        int[] input2A = {5, 17, 100, 11};
        System.out.println(new AQ2ConnectRopes().solve(input2A));
    }

    public int solve(int[] A) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            heap.add(A[i]);
        }
        int totalRopeSize = 0;
//        System.out.println(heap);
        while (!heap.isEmpty()) {
            if (heap.size() > 1) {
                int newRope = heap.poll() + heap.poll();
                heap.add(newRope);
                totalRopeSize = totalRopeSize + newRope;
            } else
                break;
        }
        return totalRopeSize;
    }

//    public int solve(int[] A) {
////        int[] minHeap = new int[A.length];
////        int noOfLeaves = (A.length + 1) / 2;
//        int i = 0;
//        while (2 * i + 1 < A.length) {
//            int leftIndex = 2 * i + 1;
//            int rightIndex = 2 * i + 2;
//            int lc = A[leftIndex];
//            int rc;
//            if (2 * i + 2 <= A.length - 1) {
//                rc = A[rightIndex];
//            } else {
//                rc = Integer.MAX_VALUE;
//            }
//            int min = Math.min(Math.min(lc, rc), A[i]);
//            if (min == A[i]) {
//                break;
//            } else if (min == lc) {
//                //swap root with lc
//                int temp = A[i];
//                A[i] = A[2 * i + 1];
//                A[2 * i + 1] = temp;
//                i = 2 * i + 1;
//            } else if (min == rc) {
//                //swap root with rc
//                int temp = A[i];
//                A[i] = A[2 * i + 2];
//                A[2 * i + 2] = temp;
//                i = 2 * i + 2;
//            }
//
////            if (A[i] >= lc && lc <= rc) {
////                int temp = A[i];
////                A[i] = A[leftIndex];
////                A[leftIndex] = temp;
////                i = leftIndex;
////            } else if (A[i] >= rc && rc <= lc) {
////                int temp = A[i];
////                A[i] = A[rightIndex];
////                A[rightIndex] = temp;
////                i = rightIndex;
////            } else {
////                break;
////            }
//            i++;
//        }
//        System.out.println(Arrays.toString(A));
//        return i;
//    }
}
