package scaler.module1.strings;

import java.util.*;

public class HWQ3ChangeCharacter {
//    Problem Description
//    You are given a string A of size N consisting of lowercase alphabets.
//    You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
//    Find the minimum number of distinct characters in the resulting string.
//            Problem Constraints
//1 <= N <= 100000
//            0 <= B < N
//    Input Format
//    The first argument is a string A.
//    The second argument is an integer B.
//            Output Format
//    Return an integer denoting the minimum number of distinct characters in the string.
//            Example Input
//    A = "abcabbccd"
//    B = 3
//    Example Output
//2
//    Example Explanation
//    We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
//    So the minimum number of distinct character will be 2.

    public int solve(String A, int B) {
    //wrong solution rethink from start
        if (B == 0)
            return A.length();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < A.length(); i++) {
            char key = A.charAt(i);
            if (map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }
        List<Integer> list = new ArrayList<>();
        map.forEach(
                (character, integer) -> {
                    list.add(integer);
                }
        );
        list.sort(Comparator.comparingInt(o -> o));

//        System.out.println(list);
        int minCount = 0;
        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i);
            int count = 1;
            for (int j = i + 1; j < list.size(); j++) {
                sum = sum + list.get(j);
                count++;
//                System.out.println("[" + i + "][" + j + "] list.get(j) : " + list.get(j) + "------- count : " + count + "--------- sum : " + sum);
                if (sum == B) {
                    break;
                }
            }
            if (sum == B) {
                minCount = Math.min(minCount, count);
            }
        }
        if (minCount == 0)
            return B;
        return minCount;
    }

    public static void main(String[] args) {
        String A = "abcabbccd";
        int B = 3;
        System.out.println(new HWQ3ChangeCharacter().solve(A, B));

        String A2 = "hq";
        int B2 = 0;
        System.out.println(new HWQ3ChangeCharacter().solve(A2, B2));

        String A3 = "umeaylnlfd";
        int B3 = 1;
        System.out.println(new HWQ3ChangeCharacter().solve(A3, B3));
    }
}
