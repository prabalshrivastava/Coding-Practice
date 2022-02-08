package faang450.arrays;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {
    //https://practice.geeksforgeeks.org/problems/next-permutation5226/1
    //  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    //  If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
    //  The replacement must be in place and use only constant extra memory.
    //  Example 1:
    //  Input: nums = [1,2,3]
    //  Output: [1,3,2]
    //  Example 2:
    //  Input: nums = [3,2,1]
    //  Output: [1,2,3]
    //  Example 3:
    //  Input: nums = [1,1,5]
    //  Output: [1,5,1]
    //  Example 4:
    //  Input: nums = [1]
    //  Output: [1]
    //  Constraints:
    //  1 <= nums.length <= 100
    //  0 <= nums[i] <= 100
    //  In mathematics, the lexicographic or lexicographical order is a generalization of the alphabetical order of the dictionaries to sequences of ordered symbols or,
    //  more generally, of elements of a totally ordered set.

    //  Example 1:
    //  Input: N = 6
    //  arr = {1, 2, 3, 6, 5, 4}
    //  Output: {1, 2, 4, 3, 5, 6}
    //  Explaination: The next permutation of the
    //  given array is {1, 2, 4, 3, 5, 6}.
    //  Example 2:
    //  Input: N = 3
    //  arr = {3, 2, 1}
    //  Output: {1, 2, 3}
    //  Explaination: As arr[] is the last
    //  permutation. So, the next permutation
    //  is the lowest one.
    //  Your Task:
    //  You do not need to read input or print anything. Your task is to complete the function nextPermutation() which takes N and arr[ ] as input parameters and returns a list of numbers containing the next permutation.
    //  Expected Time Complexity: O(N)
    //  Expected Auxiliary Space: O(1)
    //  Constraints:
    //          1 ≤ N ≤ 10000
    public static void main(String[] args) {
        //1,2,3
        //1,3,2
        //2,1,3
        //2,3,1
        //3,1,2
        //3,2,1

        //a,b,5
        //1,1,5 //a,b,5
        //1,5,1 //a,5,b
        //1,1,5 //b,a,5
        //1,5,1 //b,5,a
        //5,1,1 //5,a,b
        //5,1,1 //5,b,a

        //1, 2, 3, 4, 5, 6
        //1, 2, 3, 4 ,6, 5

        //1, 2, 3, 4, 5, 6  //only for reference
        //1, 2, 3, 5, 4, 6
        //1, 2, 3, 5, 6, 4
        //1, 2, 3, 6, 4, 5
        //1, 2, 3, 6, 5, 4

        //1, 2, 3, 4, 5, 6  //only for reference


//        int[] arr = {1, 2, 3};    //1,2,3
//        int[] arr = {1, 3, 2};    //1,3,2
//        int[] arr = {2, 1, 3};    //2,1,3
//        int[] arr = {2, 3, 1};    //2,3,1
//        int[] arr = {3, 1, 2};    //3,1,2
//        int[] arr = {3, 2, 1};    //3,2,1
//        int[] arr = {1, 2, 3};

//        int[] arr = {1, 1, 5};
//        int[] arr = {1, 5, 1};
//        int[] arr = {5, 1, 1};
//        int[] arr = {1, 1, 5};


//        int[] arr = {1, 2, 3, 4};
//        int[] arr = {9, 8, 7, 6};
        int[] arr = {1, 2, 3, 5, 6, 4};
        //1, 2, 3, 4
        //1, 2, 4, 3
        //1, 3, 2, 4
        //1, 3, 4, 2


        //1, 2, 5, 3
        System.out.println(new NextPermutation().nextPermutation(arr.length, arr));
    }


    void swap(int i, int j, int arr[]) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    List<Integer> nextPermutation(int N, int arr[]) {
        // code here
        int ind = 0;
        int v[] = arr.clone();
        for (int i = N - 2; i >= 0; i--) {
            if (v[i] < v[i + 1]) {
                ind = i;
                break;
            }
        }
        for (int i = N - 1; i > ind; i--) {
            if (v[i] > v[ind]) {
                swap(i, ind, v);
                ind++;
                break;
            }
        }
        for (int i = 0; i < (N - ind) / 2; i++)
            swap(i + ind, N - i - 1, v);
        List<Integer> li = new ArrayList<>();
        for (int x : v) li.add(x);
        return li;
    }
}
