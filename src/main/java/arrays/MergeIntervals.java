package arrays;

import java.util.Arrays;

public class MergeIntervals {
//    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//    Example 1:
//    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//    Example 2:
//    Input: intervals = [[1,4],[4,5]]
//    Output: [[1,5]]
//    Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//    Constraints:
//    1 <= intervals.length <= 104//    intervals[i].length == 2
//    0 <= starti <= endi <= 104


    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] output = new int[input.length][2];

        int counter = 0;
        for (int i = 0; i < input.length - 1; i++) {
            int[] previous = input[i];
            int[] next = input[i + 1];
            if (previous[1] >= next[1]) {
                output[counter] = new int[]{previous[0], next[1]};
                counter++;
            }
        }
        System.out.println(Arrays.deepToString(output));
    }
}
