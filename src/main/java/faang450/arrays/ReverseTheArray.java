package faang450.arrays;

import java.util.Arrays;

public class ReverseTheArray {
//    Input  : arr[] = {1, 2, 3}
//    Output : arr[] = {3, 2, 1}
//
//    Input :  arr[] = {4, 5, 1, 2}
//    Output : arr[] = {2, 1, 5, 4}

    public static void main(String[] args) {
        sol1();
        sol2();
        sol2Modified();
        sol3();
    }

    private static void sol1() {
        int[] arr = new int[]{1, 2, 3};
        //{3, 2, 1};
        int[] output = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            output[output.length - i - 1] = arr[i];
        }
        System.out.println(Arrays.toString(output));
    }

    private static void sol2() {
        int[] arr = new int[]{1, 2, 3};
        for (int i = 0; i < arr.length/2; i++) {
            int a = arr[i];
            int b = arr[arr.length - 1 - i];
            int c = a;
            arr[i] = b;
            arr[arr.length - 1 - i] = c;
        }
        System.out.println(Arrays.toString(arr));
    }

//    a = a + b;
//    b = a - b;  -> a + b - b;
//    a = a - b;

//    a = 1, b = 2;
//    a = 1 + 2;    a = 3
//    b = 3 - 2;  -> b = 1; a = 3;
//    a = 3 - 1;  -> b = 1; a = 2;


    private static void sol2Modified() {
        int[] arr = new int[]{1, 2, 3};
        for (int i = 0; i < arr.length/2; i++) {
            arr[i] = arr[i] + arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = arr[i] - arr[arr.length - 1 - i];
            arr[i] = arr[i] - arr[arr.length - 1 - i];
        }
        System.out.println(Arrays.toString(arr));
    }


    private static void sol3() {
        int[] arr = new int[]{1, 2, 3};
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str = str + arr[i];
            if (i != arr.length -1){
                str = str + ",";
            }
        }
        String[] split = new StringBuilder(str).reverse().toString().split(",");
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(Arrays.toString(arr));
    }
}
