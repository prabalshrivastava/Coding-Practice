package scaler.module1.contest2;

import java.util.HashMap;
import java.util.Map;

public class LittlePonnyAndPalindromes {
    public static void main(String[] args) {
        String A = "aabb";
        System.out.println(new LittlePonnyAndPalindromes().solve(A));
        String B = "aecbb";
        System.out.println(new LittlePonnyAndPalindromes().solve(B));
    }

    public int solve(String A) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean isPossiblePal = true;
        if (A.length() % 2 == 0) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    isPossiblePal = false;
                }
            }
        } else {
            int isOdd = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    isOdd++;
                }
            }
            if (isOdd > 1) {
                isPossiblePal = false;
            }
        }

        return isPossiblePal ? 1 : 0;
    }
}
