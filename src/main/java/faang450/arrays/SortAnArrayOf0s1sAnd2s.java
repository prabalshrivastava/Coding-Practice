package faang450.arrays;

import java.util.Arrays;

public class SortAnArrayOf0s1sAnd2s {
    public static void main(String[] args) {
        int[] array = new int[3];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i;
//            //array[0] = 0;
//            //array[1] = 1;
//            //array[2] = 2;
//        }


        int[] input = {0, 2, 1, 2, 0};
        System.out.println(Arrays.toString(input));

        int[] output = new int[input.length];   //{0, 0, 1, 2, 2};

        for (int i = 0; i < input.length; i++) {
            array[input[i]] = array[input[i]] + 1;
            //array[input[0]] = array[input[0]] + 1; -> array[0] = array[0] + 1; -> array[0] = 0 + 1;  -> array[0] = 1;
            //array[input[1]] = array[input[1]] + 1; -> array[2] = array[2] + 1; -> array[2] = 0 + 1;  -> array[2] = 1;
            //array[input[2]] = array[input[2]] + 1; -> array[1] = array[1] + 1; -> array[1] = 0 + 1;  -> array[1] = 1;
            //array[input[3]] = array[input[3]] + 1; -> array[2] = array[2] + 1; -> array[2] = 1 + 1;  -> array[2] = 2;
            //array[input[4]] = array[input[4]] + 1; -> array[0] = array[0] + 1; -> array[0] = 1 + 1;  -> array[0] = 2;
        }

        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                output[j] = i;
            }
        }
        System.out.println(Arrays.toString(output));
    }
}
