package scaler.module1.arrays.arrayandmaths;

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
    public int majorityElement1(final int[] A) {
        int majorityElement = A[0];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (majorityElement == A[i]) {
                count++;
            } else if (count > 0) {
                count--;
                if (count == 0) majorityElement = Integer.MAX_VALUE;
            } else {
                majorityElement = A[i];
                count++;
            }
        }
        return majorityElement;
    }

    public int majorityElement(final int[] A) {
        int majorityElement1 = Integer.MAX_VALUE;
        int count1 = 0;
        int majorityElement2 = Integer.MAX_VALUE;
        int count2 = 0;

        for (int i = 0; i < A.length; i++) {
            if (majorityElement1 == A[i]) {
                count1++;
            } else if (majorityElement2 == A[i]) {
                count2++;
            } else if (majorityElement1 == Integer.MAX_VALUE) {
                majorityElement1 = A[i];
                count1 = 1;
            } else if (majorityElement2 == Integer.MAX_VALUE) {
                majorityElement2 = A[i];
                count2 = 1;
            } else {
                if (count2 < count1) {
                    count2--;
                    if (count2 == 0) {
                        majorityElement2 = Integer.MAX_VALUE;
                    }
                } else {
                    count1--;
                    if (count1 == 0) {
                        majorityElement1 = Integer.MAX_VALUE;
                    }
                }
            }
        }

        int freq1 = 0;
        int freq2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (majorityElement1 == A[i])
                freq1++;
            if (majorityElement2 == A[i])
                freq2++;
        }

        if (freq1 > freq2) {
            if (freq1 > A.length / 3) {
                return majorityElement1;
            }
        } else {
            if (freq2 > A.length / 3) {
                return majorityElement2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2};
        System.out.println(new AQ1MajorityElement().majorityElement(arr));
        int[] arr1 = {3, 4, 3, 6, 1, 3, 2, 5, 3, 3, 3};
        System.out.println(new AQ1MajorityElement().majorityElement(arr1));
        int[] arr2 = {1, 1, 2};
        System.out.println(new AQ1MajorityElement().majorityElement(arr2));
        int[] arr3 = {2, 2, 1, 1, 1};
        System.out.println(new AQ1MajorityElement().majorityElement(arr3));
    }
}
