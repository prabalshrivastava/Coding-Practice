package scaler.advancedDsa.hashing1;

import java.util.*;

public class HWQ1SortArrayInGivenOrder {
//    Problem Description
//    Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
//    For the elements not present in B, append them at last in sorted order.
//    Return the array A after sorting from the above method.
//    NOTE: Elements of B are unique.
//            Problem Constraints
//1 <= length of the array A <= 100000
//            1 <= length of the array B <= 100000
//            -10^9 <= A[i] <= 10^9
//    Input Format
//    The first argument given is the integer array A.
//    The second argument given is the integer array B.
//            Output Format
//    Return the array A after sorting as described.
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    B = [5, 4, 2]
//    Input 2:
//    A = [5, 17, 100, 11]
//    B = [1, 100]
//    Example Output
//    Output 1:
//            [5, 4, 2, 1, 3]
//    Output 2:
//            [100, 5, 11, 17]
//    Example Explanation
//    Explanation 1:
//    Simply sort as described.
//    Explanation 2:
//    Simply sort as described.

    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 4, 5};
        int[] input1B = {5, 4, 2};
        System.out.println(Arrays.toString(new HWQ1SortArrayInGivenOrder().solve(input1A, input1B)));
        int[] input2A = {5, 17, 100, 11};
        int[] input2B = {1, 100};
        System.out.println(Arrays.toString(new HWQ1SortArrayInGivenOrder().solve(input2A, input2B)));

        int[] input3A = {12, 7};
        int[] input3B = {7, 1, 6, 17, 2, 19, 10};
        System.out.println(Arrays.toString(new HWQ1SortArrayInGivenOrder().solve(input3A, input3B)));
    }

    public int[] solve(int[] A, int[] B) {
        Arrays.sort(A);
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            hashmap.put(A[i], hashmap.getOrDefault(A[i], 0) + 1);
        }
        HashSet<Integer> hashSet = new HashSet();
        for (int i = 0; i < B.length; i++) {
            int count = hashmap.getOrDefault(B[i], 0);
            while (count > 0) {
                list.add(B[i]);
                count--;
            }
            hashSet.add(B[i]);
        }
//        System.out.println(" - " + list);
        for (int i = 0; i < A.length; i++) {
            if (!hashSet.contains(A[i])) {
                list.add(A[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
