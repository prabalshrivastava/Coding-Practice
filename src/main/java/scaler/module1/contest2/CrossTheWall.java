package scaler.module1.contest2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CrossTheWall {
    public static void main(String[] args) {
        System.out.println(new CrossTheWall().solve(2, 7, new int[]{3, 4, 2, 2, 3}));
        System.out.println(new CrossTheWall().solve(3, 5, new int[]{1, 2, 2, 5, 3, 2}));
        System.out.println(new CrossTheWall().solve(12, 8, new int[]{7, 1, 6, 1, 1, 5, 1, 1, 1, 1, 1, 3, 2, 1, 5, 2, 1, 8, 3, 3, 2, 1, 2, 4, 1, 3, 2, 3, 4, 3, 1, 7, 1, 3, 4, 1}));//3
        System.out.println(new CrossTheWall().solve(8, 11, new int[]{4, 2, 2, 3, 11, 11, 7, 1, 3, 8, 1, 2, 6, 5, 3, 7, 1, 8, 2, 1})); // 4
        System.out.println(new CrossTheWall().solve(13, 16, new int[]{10, 1, 2, 1, 2, 15, 1, 5, 1, 10, 4, 1, 8, 3, 10, 5, 1, 9, 3, 2, 1, 1, 3, 9, 4, 5, 1, 9, 1, 4, 6, 2, 1, 1, 2, 5, 4, 6, 1, 15, 1, 11, 1, 1, 2, 1, 14, 2})); // 6
    }

    public int solve(int A, int B, int[] C) {
        HashSet<Integer> hashSet = new HashSet<>();
        int sum = 0;
        int max = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            sum = sum + C[i];
            hashSet.add(C[i]);
            if (sum == B) {
                count++;
                sum = 0;
//                System.out.println(hashSet);
                for (Integer element : hashSet) {
                    map.put(element, map.getOrDefault(element, 0) + 1);
                    max = Math.max(max, map.getOrDefault(element, 0));
                }
                hashSet = new HashSet<>();
            }
        }
//        System.out.println(map);
//        System.out.println(max);
        return count - max;
    }
}
