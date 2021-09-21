package arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5, 3, 2}; //-> {1, 2, 3, 4, 5}
        int[] input2 = {1, 2, 3, 2};          //-> {1, 2, 3}


//        85 25 1 32 54 6
//        85 2


//        sol1(input1, input2);
        sol2(input1, input2);
    }

    private static void sol1(int[] input1, int[] input2) {
        int outputSize = 0;
        if (input1.length < input2.length) {
            outputSize = input1.length;
        } else {
            outputSize = input2.length;
        }
        int[] output = new int[outputSize];

        for (int i = 0; i < input1.length; i++) {
            for (int j = 0; j < input2.length; j++) {
                if (input1[i] == input2[j]) {
                    output[i] = input2[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(output));
    }

    private static void sol2(int[] input1, int[] input2) {
        int outputSize = 0;
        if (input1.length < input2.length) {
            outputSize = input1.length;
        } else {
            outputSize = input2.length;
        }
        int[] output = new int[outputSize];

        String input1String = "";
        for (int i = 0; i < input1.length; i++) {
            input1String = input1String + "," + input1[i];
        }
        System.out.println(input1String);
        for (int i = 0; i < input2.length; i++) {
            if (input1String.contains("," + input2[i])) {
                output[i] = input2[i];
            }
        }
        System.out.println(Arrays.toString(output));
    }
}
