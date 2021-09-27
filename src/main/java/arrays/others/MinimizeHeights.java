package arrays.others;

import java.util.*;
import java.lang.*;
import java.io.*;

class MinimizeHeights {
    public static int getMinimizeHeights(int arr[], int n, int k) {


        //3,7,5,12
        //3,5,7,12

        //11,5,7,4
        //4,5,7,11
        //diff = 9, min = 4, max = 11


        //{7,12,3}
        //{3,7,12}

        //{11,15,20}

        //{11,7,4}  --> 7
        //{11,7 + 8,4}  --> {11,15,4} --> 11
        //{11,7 - 8,4}  --> {11,-1,4}

        if (n == 1)
            return 0;
        Arrays.sort(arr);
        int diff = arr[n - 1] - arr[0]; // 9 = 12 - 3; -> diff = 9
        int puranaMinimum = arr[0] + k;   // 15 = 3 + 8; -> puranaMinimum = 11
        int puranaMaximum = arr[n - 1] - k; //puranaMaximum = 12 - 8 = 4
        int temp = 0;
        if (puranaMinimum > puranaMaximum) {    //11 > 4
            temp = puranaMinimum;
            puranaMinimum = puranaMaximum;
            puranaMaximum = temp;
        }
        //puranaMinimum = 4
        //puranaMaximum = 11

        for (int i = 1; i < n - 1; i++) {
            int nayaMinimum = arr[i] - k;    //nayaMinimum = 7 - 8 = -1
            int nayaMaximum = arr[i] + k;           //nayaMaximum = 7 + 8 = 15

            if (nayaMinimum >= puranaMinimum || nayaMaximum <= puranaMaximum) //-1 >= 4 || 15 <= 11
                continue;
            if (puranaMaximum - nayaMinimum <= nayaMaximum - puranaMinimum) //11 - -1 <= 15 - 4 --> 12 <= 11 --> false
                puranaMinimum = nayaMinimum;
            else
                puranaMaximum = nayaMaximum; //puranaMaximum = 15
        }
        return Math.min(diff, puranaMaximum - puranaMinimum);
    }

    public static void main(String[] args) {
        int arr[] = {7, 12, 3};
        int n = arr.length;
        int k = 8;
        System.out.println(getMinimizeHeights(arr, n, k));
    }
}
