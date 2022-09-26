package scaler.advancedDsa.binarysearch1;

import java.util.ArrayList;
import java.util.List;

public class HWQ2MedianOfArray {
//    Problem Description
//    There are two sorted arrays A and B of sizes N and M respectively.
//    Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
//    NOTE:
//    The overall run time complexity should be O(log(m+n)).
//    IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
//    Problem Constraints
//1 <= N + M <= 2*106
//    Input Format
//    The first argument is an integer array A of size N.
//    The second argument is an integer array B of size M.
//            Output Format
//    Return a decimal value denoting the median of two sorted arrays.
//            Example Input
//    Input 1:
//    A = [1, 4, 5]
//    B = [2, 3]
//    Input 2:
//    A = [1, 2, 3]
//    B = [4]
//    Example Output
//    Output 1:
//            3.0
//    Output 2:
//            2.5
//    Example Explanation
//    Explanation 1:
//    The median of both the sorted arrays will be 3.0.
//    Explanation 2:
//    The median of both the sorted arrays will be (2+3)/2 = 2.5.

    public static void main(String[] args) {
        List<Integer> input1AList = new ArrayList<>();
        input1AList.add(1);
        input1AList.add(4);
        input1AList.add(5);

        List<Integer> input1BList = new ArrayList<>();
        input1BList.add(2);
        input1BList.add(3);
        System.out.println(new HWQ2MedianOfArray().findMedianSortedArrays(input1AList, input1BList));

        List<Integer> input2AList = new ArrayList<>();
        input2AList.add(1);
        input2AList.add(2);
        input2AList.add(3);

        List<Integer> input2BList = new ArrayList<>();
        input2BList.add(4);
        System.out.println(new HWQ2MedianOfArray().findMedianSortedArrays(input2AList, input2BList));
    }

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        return 0;
    }
}
