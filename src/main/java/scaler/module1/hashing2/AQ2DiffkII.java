package scaler.module1.hashing2;

import java.util.HashMap;
import java.util.Map;

public class AQ2DiffkII {
    //    Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
//            Example :
//    Input :
//    A : [1 5 3]
//    k : 2
//    Output :
//            1
//    as 3 - 1 = 2
//    Return 0 / 1 for this problem.
    public static void main(String[] args) {
        int[] A = {1, 5, 3};    //3-1=2 so 1
        int k = 2;
        System.out.println(new AQ2DiffkII().diffPossible(A, k));
        int[] A1 = {0}; //0 is only element so 0
        int B1 = 0;
        System.out.println(new AQ2DiffkII().diffPossible(A1, B1));
        int[] A2 = {1, 5, 4, 1, 2}; // 1-1=0 hence ans 1
        int B2 = 0;
        System.out.println(new AQ2DiffkII().diffPossible(A2, B2));
        int[] A3 = {66, 37, 46, 56, 49, 65, 62, 21, 7, 70, 13, 71, 93, 26, 18, 84, 96, 65, 92, 69, 97, 47, 6, 18, 17, 47, 28, 71, 70, 24, 46, 58, 71, 21, 30, 44, 78, 31, 45, 65, 16, 3, 22, 54, 51, 68, 19, 86, 44, 99, 53, 24, 40, 92, 38, 81, 4, 96, 1, 13, 45, 76, 77, 8, 88, 50, 89, 38, 60, 61, 49, 25, 10, 80, 49, 63, 95, 74, 29, 27, 52, 27, 40, 66, 38, 22, 85, 22, 91, 98, 19, 20, 78, 77, 48, 63, 27};    //
        int B3 = 31;
        System.out.println(new AQ2DiffkII().diffPossible(A3, B3));
        int[] A4 = {34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29};    //
        int B4 = 97;
        System.out.println(new AQ2DiffkII().diffPossible(A4, B4));
    }

    public int diffPossible(final int[] A, int B) {
        if (A.length < 2) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
//        System.out.println(map);
        for (int i = 0; i < A.length; i++) {
            int searchElement = B + A[i];
//            System.out.println("searchElement : " + searchElement);
            if (map.containsKey(searchElement)) {
                if (A[i] == searchElement) if (map.get(A[i]) > 1) return 1;
                else continue;
                return 1;
            }
        }
        return 0;
    }
}
