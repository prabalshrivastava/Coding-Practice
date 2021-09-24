package arrays;

import java.util.Arrays;

public class CyclicallyRotateAnArrayByOne {
    /*
    https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
    Given an array, rotate the array by one position in clock-wise direction.

    Example 1:
    Input:
    N = 5
    A[] = {1, 2, 3, 4, 5}
    Output: 5 1 2 3 4

    Example 2:
    Input:
    N = 8
    A[] = {9, 8, 7, 6, 4, 2, 1, 3}
    Output:3 9 8 7 6 4 2 1
    */

    public static void main(String[] args) {
        int rotationDegree = 3;
        int[] input1 = {1, 2, 3, 4, 5};
        int[] input2 = new int[rotationDegree];

        int input2Counter = 0;
        for (int i = input1.length - rotationDegree; i < input1.length; i++) {
            input2[input2Counter] = input1[i];
            input2Counter++;
        }
        System.out.println(Arrays.toString(input2));
        System.out.println();

        //{1, 2, 3, 4, 5}


        int counter = rotationDegree;//3
        while (counter > 0) {
            //{1, 2, 3, 4, 5}
            for (int i = input1.length - 1; i > 0; i--) {
                input1[i] = input1[i - 1];
            }
            System.out.println(Arrays.toString(input1));
            //{1, 2, 3, 4, 4}
            //{1, 2, 3, 3, 4}
            //{1, 2, 2, 3, 4}
            //{1, 1, 2, 3, 4}

//            input1[]
            counter--;
            //3
            //2
            //1
        }
        System.out.println("\n\n");
        counter = rotationDegree - 1;
        int count = 0;
        while (counter > -1) {
            input1[count] = input2[counter];
            //input1[0] = input2[2];
            //input1[1] = input2[1];
            //input1[2] = input2[0];
            counter--;
            count++;
        }
        System.out.println("\n");
        System.out.println(Arrays.toString(input1));
    }
}
