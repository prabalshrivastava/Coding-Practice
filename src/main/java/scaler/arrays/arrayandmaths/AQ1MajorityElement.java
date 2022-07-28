package scaler.arrays.arrayandmaths;

public class AQ1MajorityElement {
    //    Problem Description
//    Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
//    You may assume that the array is non-empty and the majority element always exists in the array.
//    Problem Constraints
//1 <= N <= 5*105
//            1 <= num[i] <= 109
//    Input Format
//    Only argument is an integer array.
//    Output Format
//    Return an integer.
//            Example Input
//[2, 1, 2]
//    Example Output
//2
//    Example Explanation
//2 occurs 2 times which is greater than 3/2.
    public int majorityElement(final int[] A) {
        int majorityElement = A[0];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (majorityElement == A[i]) {
                count++;
            } else if (count > 0) {
                count--;
                if (count == 0)
                    majorityElement = Integer.MAX_VALUE;
            } else {
                majorityElement = A[i];
                count++;
            }
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2};
        System.out.println(new AQ1MajorityElement().majorityElement(arr));
        int[] arr1 = {3, 4, 3, 6, 1, 3, 2, 5, 3, 3, 3};
        System.out.println(new AQ1MajorityElement().majorityElement(arr1));
        int[] arr2 = {1, 1, 2};
        System.out.println(new AQ1MajorityElement().majorityElement(arr2));
    }
}
