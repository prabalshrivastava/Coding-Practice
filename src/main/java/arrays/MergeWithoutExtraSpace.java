package arrays;

import java.sql.Time;
import java.util.Arrays;

public class MergeWithoutExtraSpace {
//        Merge Without Extra Space
//        Hard Accuracy: 36.41% Submissions: 86722 Points: 8
//        Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. Merge the two arrays into one sorted array in non-decreasing order without using any extra space.
//
//        Example 1:
//        Input:
//        N = 4, M = 5
//        arr1[] = {1, 3, 5, 7}
//        arr2[] = {0, 2, 6, 8, 9}
//        Output: 0 1 2 3 5 6 7 8 9
//        Explanation: Since you can't use any
//        extra space, modify the given arrays
//        to form
//        arr1[] = {0, 1, 2, 3}
//        arr2[] = {5, 6, 7, 8, 9}
//
//        Example 2:
//        Input:
//        N = 2, M = 3
//        arr1[] = {10, 12}
//        arr2[] = {5, 18, 20}
//        Output: 5 10 12 18 20
//        Explanation: Since you can't use any
//        extra space, modify the given arrays
//        to form
//        arr1[] = {5, 10}
//        arr2[] = {12, 18, 20}
//
//
//        Your Task:
//        You don't need to read input or print anything. Complete the function merge() which takes the two arrays arr1[], arr2[] and their sizes n and m, as input parameters. The function does not return anything. Use the given arrays to sort and merge arr1[] and arr2[] in-place.
//        Note: The generated output will print all the elements of arr1[] followed by all the elements of arr2[].
//        Expected Time Complexity: O((n+m)*log(n+m))
//        Expected Auxiliary Space: O(1)
//
//        Constraints:
//        1 <= N, M <= 5*104
//        0 <= arr1i, arr2i <= 106

    public static void main(String[] args) {


        //{0, 2, 6, 8, 9,1, 3, 5, 7}

//        int size = Math.max(arr1.length, arr2.length);
//        int i = 0, j = 0;
//        int temporary = arr1[0];
//        for (; i < arr1.length; ) {
//            if (j < arr2.length && arr1[i] > arr2[j]) {
//                int temp = arr1[i];
//                arr1[i] = arr2[j];
//                arr2[j] = temp;
//                i++;
//            } else if (arr1[i] < arr2[j]) {
//                j++;
//            }
//        }

//{1, 3, 5, 7};
//{0, 2, 6, 8, 9};

//{0, 3, 5, 7};
//{1, 2, 6, 8, 9};

//{0, 1, 5, 7};
//{3, 2, 6, 8, 9};

//{0, 1, 2, 7};
//{5, 3, 6, 8, 9};

//{0, 1, 2, 3};
//{7, 5, 6, 8, 9};
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {0, 2, 6, 8, 9};

        for (int i = 0; i < arr1.length; i++) {
            int min = 0;
            int minNumber;
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] < arr2[min]) {
                    min = j;
                }
            }
            minNumber = arr2[min];
            if (arr1[i] > minNumber) {
                int temp = arr1[i];
                arr1[i] = arr2[min];
                arr2[min] = temp;
            }
        }

        //sort the remaining arrays
        for (int i = 0; i < arr2.length; i++) {
            for (int j = i + 1; j < arr2.length - 1; j++) {
                int temp = arr1[i];
                arr1[i] = arr1[j];
                arr1[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
