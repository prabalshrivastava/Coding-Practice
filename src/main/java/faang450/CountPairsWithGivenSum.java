package faang450;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;

public class CountPairsWithGivenSum {
    /**
     * Count pairs with given sum
     * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
     * <p>
     * Example 1:
     * Input:
     * N = 4, K = 6
     * arr[] = {1, 5, 7, 1}
     * Output: 2
     * Explanation:
     * arr[0] + arr[1] = 1 + 5 = 6
     * and arr[1] + arr[3] = 5 + 1 = 6.
     * <p>
     * <p>
     * Example 2:
     * Input:
     * N = 4, K = 2
     * arr[] = {1, 1, 1, 1}
     * Output: 6
     * Explanation:
     * Each 1 will produce sum 2 with any 1.
     * <p>
     * Your Task:
     * You don't need to read input or print anything. Your task is to complete the function getPairsCount() which takes arr[],
     * n and k as input parameters and returns the number of pairs that have sum K.
     * <p>
     * <p>
     * Expected Time Complexity: O(N)
     * Expected Auxiliary Space: O(N)
     * <p>
     * Constraints:
     * 1 <= N <= 105
     * 1 <= K <= 108
     * 1 <= Arr[i] <= 106
     */

    public static void main(String[] args) {
//        int[] inputArr = {1, 5, 7, 1};
//        int n = 4, expectedSum = 6;

//        int[] inputArr = {1, 1, 1, 1};
//        int n = 4, expectedSum = 2;

        int[] inputArr = {1, 2, 3, 4, 5, 6, 7};
        int n = 4, expectedSum = 8;
        sol1(inputArr, expectedSum);

//        sol2(inputArr, expectedSum);
    }

    private static void sol2(int[] inputArr, int expectedSum) {
        List<AbstractMap.SimpleEntry<String, String>> list = new LinkedList<AbstractMap.SimpleEntry<String, String>>();
        for (int i = 0; i < inputArr.length - 1; i++) {
            int sum = inputArr[i] + inputArr[i + 1];
            if (sum == expectedSum) {
                AbstractMap.SimpleEntry<String, String> entry = new AbstractMap.SimpleEntry<>("inputArr[" + i + "](" + inputArr[i] + ")", "inputArr[" + (i + 1) + "](" + inputArr[i + 1] + ")");
                list.add(entry);
            }

            int j = inputArr.length - 1 - i;
            sum = inputArr[j] + inputArr[j - 1];
            if (sum == expectedSum) {
                AbstractMap.SimpleEntry<String, String> entry = new AbstractMap.SimpleEntry<>("inputArr[" + j + "](" + inputArr[j] + ")", "inputArr[" + (j - 1) + "](" + inputArr[j - 1] + ")");
                list.add(entry);
            }
        }
        System.out.println(list);
        System.out.println(list.size());
    }

    private static void sol1(int[] inputArr, int expectedSum) {
        List<AbstractMap.SimpleEntry<Integer, Integer>> list = new LinkedList<AbstractMap.SimpleEntry<Integer, Integer>>();
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                int sum = inputArr[i] + inputArr[j];
                if (sum == expectedSum) {
                    AbstractMap.SimpleEntry<Integer, Integer> entry = new AbstractMap.SimpleEntry<>(inputArr[i], inputArr[j]);
                    list.add(entry);
                }
            }
        }
        System.out.println(list);
        System.out.println(list.size());
    }
}
