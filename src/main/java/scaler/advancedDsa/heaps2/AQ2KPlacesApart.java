package scaler.advancedDsa.heaps2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AQ2KPlacesApart {
//    Problem Description
//    N people having different priorities are standing in a queue.
//    The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
//    Your task is to sort the queue in the increasing order of priorities.
//            NOTE:
//    No two persons can have the same priority.
//    Use the property of the queue to sort the queue with complexity O(NlogB).
//    Problem Constraints
//1 <= N <= 100000
//            0 <= B <= N
//    Input Format
//    The first argument is an integer array A representing the priorities and initial order of N persons.
//    The second argument is an integer B.
//            Output Format
//    Return an integer array representing the sorted queue.
//    Example Input
//    Input 1:
//    A = [1, 40, 2, 3]
//    B = 2
//    Input 2:
//    A = [2, 1, 17, 10, 21, 95]
//    B = 1
//    Example Output
//    Output 1:
//            [1, 2, 3, 40]
//    Output 2:
//            [1, 2, 10, 17, 21, 95]
//    Example Explanation
//    Explanation 1:
//    Given array A = [1, 40, 2, 3]
//    After sorting, A = [1, 2, 3, 40].
//    We can see that difference between initial position of elements amd the final position <= 2.
//    Explanation 2:
//    After sorting, the array becomes [1, 2, 10, 17, 21, 95].

    public static void main(String[] args) {


        int[] input1A = {1, 40, 2, 3};
        int input1B = 2;
        System.out.println(Arrays.toString(new AQ2KPlacesApart().solve(input1A, input1B)));


        int[] input2A = {2, 1, 17, 10, 21, 95};
        int input2B = 1;
        System.out.println(Arrays.toString(new AQ2KPlacesApart().solve(input2A, input2B)));
    }

    public int[] solve(int[] A, int B)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] ans = new int[A.length];
        for (int i = 0; i < B; i++) {
            minHeap.add(A[i]);
        }
        int count = 0;
        for (int i = B; i < A.length; i++) {
            minHeap.add(A[i]);
            ans[count++] = minHeap.poll();
        }
        while (!minHeap.isEmpty()) {
            ans[count++] = minHeap.poll();
        }
        return ans;
    }

}
