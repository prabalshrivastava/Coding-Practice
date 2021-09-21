package arrays;

import java.util.Arrays;

public class MoveNegativeNumbersBeginningPositiveEndConstantExtraSpace {
    //https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/

//    Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
//    Output: -12 -13 -5 -7 -3 -6 11 6 5



    //{6, -1, 8, -2, -3, 12, 6, -1};

    //{6, -1, 8, -2, -3, 12, 6, -1};
    //{6, -1, 8, -2, -3, 12, 6, -1};






    public static void main(String[] args) {

//        System.out.println("Solution 2");
//        int[] input = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
//        System.out.println(Arrays.toString(input));
//        int[] output1 = new int[input.length];
//        for (int i = 0; i < input.length; i++) {
//            if (input[current] < 0) {
//                output1[current] = input[i];
//                current++;
//            } else {
//                output1[j] = input[i];
//                j--;
//            }
//        }

        sol1();
    }

    private static void sol1() {
        System.out.println("Solution 1");
        int[] input = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println(Arrays.toString(input));

        int[] output1 = new int[input.length];
        int currentIndex = 0;
        for (int i=0; i < input.length; i++) {
            if (input[i] < 0) {
                output1[currentIndex] = input[i];
                currentIndex++;
            }
        }

        System.out.println("Intermdeitat : " + Arrays.toString(output1));

        for (int j = 0; j < input.length; j++) {
            if (input[j] > 0) {
                output1[currentIndex] = input[j];
                currentIndex++;
            }
        }
        System.out.println(Arrays.toString(output1));
    }
}
