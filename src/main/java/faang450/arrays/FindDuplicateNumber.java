package faang450.arrays;

import java.util.Arrays;

public class FindDuplicateNumber {
//    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//    There is only one repeated number in nums, return this repeated number.
//    You must solve the problem without modifying the array nums and uses only constant extra space.
//    Example 1:
//    Input: nums = [1,3,4,2,2]
//    Output: 2
//
//    Example 2:
//    Input: nums = [3,1,3,4,2]
//    Output: 3
//    Example 3:
//
//    Input: nums = [1,1]
//    Output: 1
//    Example 4:
//
//    Input: nums = [1,1,2]
//    Output: 1
//
//    Constraints:
//            1 <= n <= 105
//    nums.length == n + 1
//            1 <= nums[i] <= n
//    All the integers in nums appear only once except for precisely one integer which appears two or more times.
//
//    Follow up:
//
//    How can we prove that at least one duplicate number must exist in nums?
//    Can you solve the problem in linear runtime complexity?

    public static void main(String[] args) {
        int[] input1 = {1, 3, 4, 2, 2};
//        int[] input1 = {2, 3, 4, 1, 2};
//        int[] input1 = {3, 1, 3, 4, 2};
//        int[] input1 = {1, 1};
//        int[] input1 = {1, 1, 2};
//        int[] input1 = {3, 1, 3, 4, 2};
//        int[] input1 = {3, 1, 3, 4, 2};
        sol1(input1);
//        sol2(input1);
    }

    private static void sol1(int[] input1) {
        int[] output = new int[input1.length];
        int duplicate = 0;
        for (int i = 0; i < input1.length; i++) {
            //output[input1[i]] == input1[i]  -->  output[input1[0]] == input1[0]  -->  output[1] == 1
            //output[input1[i]] == input1[i]  -->  output[input1[1]] == input1[1]  -->  output[3] == 3
            //output[input1[i]] == input1[i]  -->  output[input1[2]] == input1[2]  -->  output[4] == 4
            //output[input1[i]] == input1[i]  -->  output[input1[3]] == input1[3]  -->  output[2] == 2
            //output[input1[i]] == input1[i]  -->  output[input1[4]] == input1[4]  -->  output[2] == 2
            //output[] = {0,1,2,3,4}
            if (output[input1[i]] == input1[i]) {
                duplicate = input1[i];
                break;
            }
            output[input1[i]] = input1[i];
        }
        System.out.println(Arrays.toString(output));
        System.out.println("duplicate : " + duplicate);
    }

    private static void sol2(int[] input1) {
        int n = input1.length - 1;
        int sum = (n * (n + 1)) / 2;
        System.out.println(sum);
        int total = 0;
        for (int i = 0; i < input1.length; i++) {
            total = total + input1[i];
        }
        System.out.println(total - sum);
    }
}
