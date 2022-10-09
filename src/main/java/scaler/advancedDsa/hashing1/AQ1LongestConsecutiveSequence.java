package scaler.advancedDsa.hashing1;

import java.util.HashSet;
import java.util.Iterator;

public class AQ1LongestConsecutiveSequence {
    //    Problem Description
//    Given an unsorted integer array A of size N.
//    Find the length of the longest set of consecutive elements from array A.
//            Problem Constraints
//1 <= N <= 106
//            -106 <= A[i] <= 106
//    Input Format
//    First argument is an integer array A of size N.
//    Output Format
//    Return an integer denoting the length of the longest set of consecutive elements from the array A.
//            Example Input
//    Input 1:
//    A = [100, 4, 200, 1, 3, 2]
//    Input 2:
//    A = [2, 1]
//    Example Output
//    Output 1:
//            4
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//    The set of consecutive elements will be [1, 2, 3, 4].
//    Explanation 2:
//    The set of consecutive elements will be [1, 2].
    public static void main(String[] args) {
        int[] input1A = {100, 4, 200, 1, 3, 2};
        System.out.println(new AQ1LongestConsecutiveSequence().longestConsecutive(input1A));
        int[] input2A = {2, 1};
        System.out.println(new AQ1LongestConsecutiveSequence().longestConsecutive(input2A));
    }

    public int longestConsecutive(final int[] A) {
        HashSet<Integer> hashSet = new HashSet();
        for (int i = 0; i < A.length; i++) {
            hashSet.add(A[i]);
        }
        int ans = Integer.MIN_VALUE;
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Integer startingPoint = iterator.next();
            if (hashSet.contains(startingPoint - 1)) {

            } else {
                startingPoint++;
                int countOfseq = 1;
                while (hashSet.contains(startingPoint)) {
                    startingPoint++;
                    countOfseq++;
                }
                ans = Math.max(countOfseq, ans);
            }
        }
        return ans;
    }
}
