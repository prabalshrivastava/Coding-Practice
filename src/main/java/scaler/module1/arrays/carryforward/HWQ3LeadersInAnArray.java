package scaler.module1.arrays.carryforward;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HWQ3LeadersInAnArray {
//    Problem Description
//
//    Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
//
//    An element is a leader if it is strictly greater than all the elements to its right side.
//
//    NOTE:The rightmost element is always a leader.
//
//
//
//            Problem Constraints
//
//1 <= N <= 105
//
//            1 <= A[i] <= 108
//
//
//
//    Input Format
//
//    First and only argument is an integer array A.
//
//
//
//            Output Format
//
//    Return an integer array denoting all the leader elements of the array.
//
//    NOTE: Ordering in the output doesn't matter.
//
//
//
//    Example Input
//
//    Input 1:
//
//    A = [16, 17, 4, 3, 5, 2]
//    Input 2:
//
//    A = [1, 2]
//
//
//    Example Output
//
//    Output 1:
//
//            [17, 2, 5]
//    Output 2:
//
//            [2]
//
//
//    Example Explanation
//
//    Explanation 1:
//
//    Element 17 is strictly greater than all the elements on the right side to it.
//            Element 2 is strictly greater than all the elements on the right side to it.
//            Element 5 is strictly greater than all the elements on the right side to it.
//    So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
//    Explanation 2:
//
//    Only 2 the rightmost element is the leader in the array.
public static void main(String[] args) {
    System.out.println(Arrays.toString(new HWQ3LeadersInAnArray().solve(new int[]{93, 57, 83, 41, 100, 10, 79, 27, 94, 22, 4, 96, 48, 18, 89, 37, 21, 5, 46, 81, 15, 30, 47, 23, 34, 65, 55, 9, 36, 20, 54, 17, 7, 56, 78, 84, 87, 97, 16, 69, 28, 11, 44, 49, 8, 25, 98, 75, 53, 62, 19, 24, 80, 68, 50, 91, 1, 86, 77, 14, 72, 66, 42, 63, 73, 45, 31, 61, 85, 64, 35, 32, 92, 71, 74, 3, 99, 52, 90, 43, 6, 40, 38, 2, 12, 59, 29, 82, 76, 60, 67, 13, 70, 58, 39, 33, 95, 88, 51, 26})));
}
    public int[] solve(int[] A) {
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int count=0;
        for(int i=A.length-1;i>=0;i--){
            if(A[i] > max){
                max = A[i];
                res.add(A[i]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
