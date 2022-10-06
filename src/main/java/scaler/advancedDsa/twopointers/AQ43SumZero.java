package scaler.advancedDsa.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AQ43SumZero {
    //    Problem Description
//    Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
//    Find all unique triplets in the array which gives the sum of zero.
//            Note:
//    Elements in a triplet (a, b, c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.
//    Problem Constraints
//0 <= N <= 7000
//            -108 <= A[i] <= 108
//    Input Format
//    Single argument representing a 1-D array A.
//            Output Format
//    Output a 2-D vector where each row represent a unique triplet.
//            Example Input
//    A = [-1,0,1,2,-1,4]
//    Example Output
//[ [-1,0,1],
//        [-1,-1,2] ]
//    Example Explanation
//    Out of all the possible triplets having total sum zero,only the above two triplets are unique.
    public static void main(String[] args) {
        int[] input1A = {-1, 0, 1, 2, -1, 4};
        System.out.println(Arrays.deepToString(new AQ43SumZero().threeSum(input1A)));
        int[] input2A = {1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 };
        System.out.println(Arrays.deepToString(new AQ43SumZero().threeSum(input2A)));
    }

    public int[][] threeSum(int[] A) {
        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));
        List<int[]> list = new ArrayList<>();
        int count = 0;
        for (int k = 0; k < A.length; k++) {
            int a = -A[k];
            int i = k + 1;
            int j = A.length - 1;
            while (i < j) {
                int b = A[i];
                int c = A[j];
                if (b + c == a) {
                    boolean isPresent = false;
                    for (int l = 0; l < list.size(); l++) {
//                        System.out.println(l);
                        if (list.get(l)[0] == -a &&
                                list.get(l)[1] == b &&
                                list.get(l)[2] == c) {
                            isPresent = true;
                        }
                    }
                    if (!isPresent) {
//                        ans[count++] = new int[]{-a, b, c};
                        list.add(new int[]{-a, b, c});
                    }

                    i++;
                    j--;
                } else if (b + c < a) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
