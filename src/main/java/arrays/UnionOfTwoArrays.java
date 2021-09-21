package arrays;

import java.util.Arrays;

public class UnionOfTwoArrays {
    //          1 2 3 4 5
    //          1 2 3 8 9
    //union  -> 1 2 3 4 5 8 9


    public static void main(String[] args) {
        int[] input1 = {11, 2, 3, 4, 5};
        int[] input2 = {1, 2, 3, 8, 9};
        sol1(input1, input2);
//        sol2(input1, input2);
    }

    private static void sol1(int[] input1, int[] input2) {
        int[] output = new int[input1.length + input2.length];

        int counter = 0;
        for (int i = 0; i < input1.length; i++) {
            output[i] = input1[i];
            counter++;
        }

        for (int i = 0; i < input2.length; i++) {
            int currentElement = input2[i];
            boolean flag = true;
            for (int j = 0; j < output.length; j++) {
                if (currentElement == output[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                output[counter] = currentElement;
                counter++;
            }
        }
        System.out.println(Arrays.toString(output));
        System.out.println(counter);
    }

    private static void sol2(int[] input1, int[] input2) {
        int counter = 0;
        String outputString = "";
        for (int i = 0; i < input1.length; i++) {
            outputString = outputString + "," + input1[i];
            counter++;
        }

//        System.out.println(Arrays.toString(outputString.split(",")));
        for (int i = 0; i < input2.length; i++) {
            if (!outputString.contains("," + String.valueOf(input2[i] + ","))) {
                outputString = outputString + "," + input2[i];
                counter++;
            }
        }
        System.out.println(Arrays.toString(outputString.split(",")));
        System.out.println(counter);
    }


}
