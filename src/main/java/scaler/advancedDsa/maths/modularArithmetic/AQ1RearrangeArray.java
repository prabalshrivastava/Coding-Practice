package scaler.advancedDsa.maths.modularArithmetic;

import java.util.ArrayList;
import java.util.Arrays;

public class AQ1RearrangeArray {
//    Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
//    Example:
//    Input : [1, 0]
//    Return : [0, 1]
//    Lets say N = size of the array. Then, following holds true :
//    All elements in the array are in the range [0, N-1]
//    N * N does not overflow for a signed integer

    public void arrange(ArrayList<Integer> a) {
//        System.out.println(a);
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) * a.size());
        }
//        System.out.println(a);
        for (int i = 0; i < a.size(); i++) {
            int originalValue = a.get(i) / a.size();
//            System.out.printf("originalValue : %s ", originalValue);
            Integer newValue = a.get(originalValue) / a.size();
//            System.out.printf("newValue : %s ", newValue);
            int newValueToBePut = originalValue * a.size() + newValue;
//            System.out.printf("newValueToBePut : %s%n", newValueToBePut);
            a.set(i, newValueToBePut);
        }
//        System.out.println(a);
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) % a.size());
        }
//        System.out.println(a);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(3, 2, 4, 1, 0));
        new AQ1RearrangeArray().arrange(list1);

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 7, 0, 9, 3, 6, 8, 5, 4));
        new AQ1RearrangeArray().arrange(list2);
//        The expected return value:
//        2 7 8 1 4 0 6 5 3 9
//        Your function returned the following:
//        2 7 8 2 4 0 6 5 6 8
    }
}
