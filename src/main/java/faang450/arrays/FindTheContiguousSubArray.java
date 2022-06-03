package faang450.arrays;

import java.util.Arrays;

public class FindTheContiguousSubArray {
    //https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
/*
    Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
    Example 1:
    Input:
    N = 5
    Arr[] = {1,2,3,-2,5}
    Output: 9
    Explanation:
    Max subarray sum is 9
    of elements (1, 2, 3, -2, 5) which
    is a contiguous subarray.

    Example 2:
    Input:
    N = 4
    Arr[] = {-1,-2,-3,-4}
    Output:-1
    Explanation:
    Max subarray sum is -1
    of element (-1)

    Your Task:
    You don't need to read input or print anything. The task is to complete the function maxSubarraySum() which takes Arr[] and N as input parameters and returns the sum of subarray with maximum sum.
    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(1)
    Constraints:
    1 ≤ N ≤ 106
    -107 ≤ A[i] ≤ 107
*/

    public static void main(String[] args) {
        System.out.println(sol1());

        int arr[]= {-9,-5,-2,-11,5};
        long maxh = 0, maxf = arr[0];

        sol2(arr, maxh, maxf);
    }

    private static void sol2(int[] arr, long maxh, long maxf) {
        //Iterating over the array.
        for(int i = 0; i< arr.length; i++){

            //Updating max sum till current index.
            maxh += arr[i];
            //Storing max sum so far by choosing maximum between max
            //sum so far and max sum till current index.
            if(maxf < maxh)
                maxf = maxh;

            //If max sum till current index is negative, we do not need to add
            //it to result so we update it to zero.
            if(maxh <0)
                maxh =0;

        }
        System.out.println("maxf "+ maxf);
    }

    private static int sol1() {
        //1,2,3,-2,5
        //Taking 2 slots ---------> 2 = array.length
        //1,2 | 2,3 | 3,-2 | -2,5

        //Taking 3 slots
        //1,2,3 | 2,3,-2 | 3,-2,5

        //Taking 4 slots
        //1,2,3,-2 | 2,3,-2,5

        //Taking 5 slots
        //1,2,3,-2,5

//        int[] input1 = {1, 2, 3, -2, 5};
        int[] input1 = {-1,-2,-3,-4};
        int max = input1[0];

        for (int slot = 1; slot <= input1.length; slot++) {
            //slot 1
            //slot 2
            //slot 3
            //slot 4
            //slot 5
            for (int i = 0; i < input1.length; i++) {
                int currentSum = input1[0];
                int j = i;
                while (j < slot) {
                    //j < slot -> 0 < 1
                    //j < slot -> 1 < 1  -> false

                    //j < slot -> 0 < 2
                    //j < slot -> 1 < 2
                    //j < slot -> 2 < 2  -> false

                    //j < slot -> 0 < 3
                    //j < slot -> 1 < 3
                    //j < slot -> 2 < 3
                    //j < slot -> 3 < 3  -> false
                    currentSum = currentSum + input1[j];

                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[0] -> currentSum = 0 + 1  -> currentSum = 1

                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[0] -> currentSum = 0 + 1  -> currentSum = 1
                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[1] -> currentSum = 1 + 2  -> currentSum = 3

                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[0] -> currentSum = 0 + 1  -> currentSum = 1
                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[1] -> currentSum = 1 + 2  -> currentSum = 3
                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[2] -> currentSum = 3 + 3  -> currentSum = 6

                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[0] -> currentSum = 0 + 1  -> currentSum = 1
                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[1] -> currentSum = 1 + 2  -> currentSum = 3
                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[2] -> currentSum = 3 + 3  -> currentSum = 6
                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[3] -> currentSum = 6 + -2  -> currentSum = 4

                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[0] -> currentSum = 0 + 1  -> currentSum = 1
                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[1] -> currentSum = 1 + 2  -> currentSum = 3
                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[2] -> currentSum = 3 + 3  -> currentSum = 6
                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[3] -> currentSum = 6 + -2  -> currentSum = 4
                    //currentSum = currentSum + input1[j]; -> currentSum = currentSum + input1[3] -> currentSum = 4 + 5  -> currentSum = 9

                    j++;
                }
                if (currentSum > max) {
                    max = currentSum;
                }
            }
        }
        return max;
    }
}
