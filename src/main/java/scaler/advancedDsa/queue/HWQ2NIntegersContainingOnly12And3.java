package scaler.advancedDsa.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HWQ2NIntegersContainingOnly12And3 {
//    Problem Description
//    Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
//    NOTE: All the A integers will fit in 32-bit integers.
//    Problem Constraints
//1 <= A <= 29500
//    Input Format
//    The only argument given is integer A.
//            Output Format
//    Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
//    Example Input
//    Input 1:
//    A = 3
//    Input 2:
//    A = 7
//    Example Output
//    Output 1:
//            [1, 2, 3]
//    Output 2:
//            [1, 2, 3, 11, 12, 13, 21]
//    Example Explanation
//    Explanation 1:
//    Output denotes the first 3 integers that contains only digits 1, 2 and 3.
//    Explanation 2:
//    Output denotes the first 3 integers that contains only digits 1, 2 and 3.

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new HWQ2NIntegersContainingOnly12And3().solve(1)));
        System.out.println(Arrays.toString(new HWQ2NIntegersContainingOnly12And3().solve(2)));
        System.out.println(Arrays.toString(new HWQ2NIntegersContainingOnly12And3().solve(3)));
        System.out.println(Arrays.toString(new HWQ2NIntegersContainingOnly12And3().solve(4)));
        System.out.println(Arrays.toString(new HWQ2NIntegersContainingOnly12And3().solve(5)));
        System.out.println(Arrays.toString(new HWQ2NIntegersContainingOnly12And3().solve(6)));
        System.out.println(Arrays.toString(new HWQ2NIntegersContainingOnly12And3().solve(7)));
        System.out.println(Arrays.toString(new HWQ2NIntegersContainingOnly12And3().solve(8)));
        System.out.println(Arrays.toString(new HWQ2NIntegersContainingOnly12And3().solve(9)));
        System.out.println(Arrays.toString(new HWQ2NIntegersContainingOnly12And3().solve(10)));

    }

    public int[] solve(int A) {
        Queue<Integer> queue = new LinkedList<>();

//        int[] ans = null;
//        if (A <= 3) {
//            ans = new int[A];
//            for (int i = 0; i < A; i++) {
//                ans[i] = i + 1;
//            }
//            return ans;
//        }
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        List<Integer> list = new LinkedList<>();
        while (queue.size() < A) {
            assert queue.peek() != null;
            Integer current = queue.peek();
            queue.offer((current * 10) + 1);
            if (queue.size() >= A)
                break;
            queue.offer((current * 10) + 2);
            if (queue.size() >= A)
                break;
            queue.offer((current * 10) + 3);
            list.add(queue.poll());
//            System.out.println("Q : " + queue);
            if (list.size() >= A) {
                break;
            }
        }
//        System.out.println("1Q : " + queue + " A : " + A + "  List : " + list);
        while (list.size() < A) {
            list.add(queue.poll());
        }
//        System.out.println("2Q : " + queue + " A : " + A + "  List : " + list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
