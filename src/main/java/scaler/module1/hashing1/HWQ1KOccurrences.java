package scaler.module1.hashing1;

import java.util.HashMap;

public class HWQ1KOccurrences {
    //    Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].
//    He wants to select some trees to replace his broken branches.
//    But he wants uniformity in his selection of trees.
//    So he picks only those trees whose heights have frequency B.
//    He then sums up the heights that occur B times. (He adds the height only once to the sum and not B times).
//    But the sum he ended up getting was huge so he prints it modulo 10^9+7.
//    In case no such cluster exists, Groot becomes sad and prints -1.
//    Constraints:
//            1.   1<=N<=100000
//            2.   1<=B<=N
//3.   0<=H[i]<=10^9
//    Input: Integers N and B and an array C of size N
//    Output: Sum of all numbers in the array that occur exactly B times.
//    Example:
//    Input:
//    N=5 ,B=2 ,C=[1 2 2 3 3]
//    Output:
//            5
//    Explanation:
//    There are 3 distinct numbers in the array which are 1,2,3.
//    Out of these, only 2 and 3 occur twice. Therefore the answer is sum of 2 and 3 which is 5.
    public int getSum(int A, int B, int[] C) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            if (map.containsKey(C[i])) {
                map.put(C[i], map.get(C[i]) + 1);
            } else
                map.put(C[i], 1);
        }
//        System.out.println(map);
        int sum = 0;
        boolean isYes = false;
        for (Integer element : map.keySet()) {
//            System.out.println(element);
            if (map.get(element) == B) {
                isYes = true;
                sum = sum + element;
//                System.out.println("sum : " + sum);
                sum = (int) (sum % (Math.pow(10, 9) + 7));
            }
        }
        if (isYes)
            return sum;
        else
            return -1;
    }

    public static void main(String[] args) {
        int N = 5;
        int B = 2;
        int[] C = {1, 2, 2, 3, 3};
        System.out.println(new HWQ1KOccurrences().getSum(N, B, C));

        int A1 = 4;
        int B1 = 4;
        int[] C1 = {2, 2, 2, 2};
        System.out.println(new HWQ1KOccurrences().getSum(A1, B1, C1));

        int A2 = 5;
        int B2 = 5;
        int[] C2 = {1, 2, 3, 4, 5};
        ;
        System.out.println(new HWQ1KOccurrences().getSum(A2, B2, C2));//-1

        int A3 = 3;
        int B3 = 2;
        int[] C3 = {0, 0, 1};
        System.out.println(new HWQ1KOccurrences().getSum(A3, B3, C3));//0
    }
}
