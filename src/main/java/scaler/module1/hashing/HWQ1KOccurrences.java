package scaler.module1.hashing;

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
        for (Integer element : map.keySet()) {
//            System.out.println(element);
            if (map.get(element) == B) {
                sum = sum + element;
//                System.out.println("sum : " + sum);
                sum = (int) (sum % (Math.pow(10, 9) + 7));
            }
        }
        return sum;
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
    }
}
