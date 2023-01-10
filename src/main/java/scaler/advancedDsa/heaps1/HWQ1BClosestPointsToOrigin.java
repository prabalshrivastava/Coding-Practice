package scaler.advancedDsa.heaps1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HWQ1BClosestPointsToOrigin {
    //    Problem Description
//    We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
//    Here, the distance between two points on a plane is the Euclidean distance.
//    You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
//    NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
//    Problem Constraints
//1 <= B <= length of the list A <= 105
//            -105 <= A[i][0] <= 105
//            -105 <= A[i][1] <= 105
//    Input Format
//    The argument given is list A and an integer B.
//    Output Format
//    Return the B closest points to the origin (0, 0) in any order.
//    Example Input
//    Input 1:
//    A = [
//            [1, 3],
//            [-2, 2]
//            ]
//    B = 1
//    Input 2:
//    A = [
//            [1, -1],
//            [2, -1]
//            ]
//    B = 1
//    Example Output
//    Output 1:
//            [ [-2, 2] ]
//    Output 2:
//            [ [1, -1] ]
//    Example Explanation
//    Explanation 1:
//    The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
//    So one closest point will be [-2,2].
//    Explanation 2:
//    The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
//    So one closest point will be [1,-1].
    public static void main(String[] args) {
        int[][] input1A = {
                {1, 3},
                {-2, 2}
        };
        int input1B = 1;
        System.out.println(Arrays.deepToString(new HWQ1BClosestPointsToOrigin().solve(input1A, input1B)));
        int[][] input2A = {
                {1, -1},
                {2, -1}
        };
        int input2B = 1;
        System.out.println(Arrays.deepToString(new HWQ1BClosestPointsToOrigin().solve(input2A, input2B)));
    }

    public int[][] solve(int[][] A, int B) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> {
            int a = o1[0] * o1[0] + o1[1] * o1[1];
            int b = o2[0] * o2[0] + o2[1] * o2[1];
            return a - b;
        });
        for (int i = 0; i < A.length; i++) {
            minHeap.add(A[i]);
        }
        int[][] ans = new int[B][];
        int count = 0;
        while (count < B && !minHeap.isEmpty()) {
            ans[count++] = minHeap.poll();
        }
        return ans;
    }
}
