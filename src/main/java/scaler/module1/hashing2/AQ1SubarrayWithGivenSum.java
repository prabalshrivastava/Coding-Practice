package scaler.module1.hashing2;

import java.util.*;

public class AQ1SubarrayWithGivenSum {
//    Problem Description
//    Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
//    If the answer does not exist return an array with a single element "-1".
//    First sub-array means the sub-array for which starting index in minimum.
//            Problem Constraints
//1 <= length of the array <= 100000
//            1 <= A[i] <= 109
//            1 <= B <= 109
//    Input Format
//    The first argument given is the integer array A.
//    The second argument given is integer B.
//            Output Format
//    Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    B = 5
//    Input 2:
//    A = [5, 10, 20, 100, 105]
//    B = 110
//    Example Output
//    Output 1:
//            [2, 3]
//    Output 2:
//            -1
//    Example Explanation
//    Explanation 1:
//            [2, 3] sums up to 5.
//    Explanation 2:
//    No subarray sums up to required number.z

    public int[] solve(int[] A, int B) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            map.put(sum, i);
        }
        System.out.println(map);
        int count = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
            if (map.containsKey(entry.getKey() - B)) {
                System.out.printf("entry.getKey() - B : %s - %s = %s%n", entry.getKey(), B, entry.getKey() - B);
                int start = map.get(entry.getKey() - B) + 1;
//                System.out.printf("%s %s %n", start, count);
//                System.out.printf("%s %s %n", start, end);
                List<Integer> ans = new ArrayList<>();
                for (int j = start; j <= count; j++) {
                    ans.add(A[j]);
                }
                return ans.stream().mapToInt(Integer::intValue).toArray();
            }
            count++;
        }
        return new int[]{-1};
    }

    public int[] solvePfSumOn2(int[] A, int B) {
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            List<Integer> ans = new ArrayList<>();
            for (int j = i; j < A.length; j++) {
                ans.add(A[j]);
                sum = sum + A[j];
                if (sum == B) {
                    return ans.stream().mapToInt(Integer::intValue).toArray();
                }
            }
        }
        return new int[]{-1};
    }

    public int[] solveOn3(int[] A, int B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int sum = 0;
                int[] arr = new int[j - i + 1];
                int count = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + A[k];
                    arr[count++] = A[k];
                }
                if (sum == B)
                    return arr;
            }
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
//        int[] input1A = {1, 2, 3, 4, 5};
//        int input1B = 5;
//        System.out.println(Arrays.toString(new AQ1SubarrayWithGivenSum().solve(input1A, input1B)));
//
//        int[] input2A = {5, 10, 20, 100, 105};
//        int input2B = 110;
//        System.out.println(Arrays.toString(new AQ1SubarrayWithGivenSum().solve(input2A, input2B)));

        int[] input3A = {42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25, 50, 50, 41, 29, 34, 18, 16, 6, 49, 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41, 40, 3, 50, 27, 17, 14, 5, 31, 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22, 38, 35, 6, 35, 41, 34, 21, 30, 45, 48, 45, 37};
        int input3B = 100;
        System.out.println(Arrays.toString(new AQ1SubarrayWithGivenSum().solve(input3A, input3B)));
    }
}
