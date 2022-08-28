package scaler.module1.hashing2;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class HWQ1IsDictionary {
    //    Problem Description
//    Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
//    Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
//    Problem Constraints
//1 <= N, length of each word <= 105
//    Sum of the length of all words <= 2 * 106
//    Input Format
//    The first argument is a string array A of size N.
//    The second argument is a string B of size 26, denoting the order.
//            Output Format
//    Return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.
//    Example Input
//    Input 1:
//    A = ["hello", "scaler", "interviewbit"]
//    B = "adhbcfegskjlponmirqtxwuvzy"
//    Input 2:
//    A = ["fine", "none", "no"]
//    B = "qwertyuiopasdfghjklzxcvbnm"
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    The order shown in string B is: h < s < i for the given words. So return 1.
//    Explanation 2:
//            "none" should be present after "no". Return 0.
    public int solve(String[] A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            map.put(B.charAt(i), i);
        }
        String[] C = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = A[i];
        }
        Arrays.sort(A, (o1, o2) -> {
            int max = Math.max(o1.length(), o2.length());
            for (int i = 0; i < max; i++) {
                if (i >= o1.length() || i >= o2.length()) {
                    return o1.length() - o2.length();
                }
                if (map.get(o1.charAt(i)) - map.get(o2.charAt(i)) == 0) {
                    continue;
                } else {
                    return map.get(o1.charAt(i)) - map.get(o2.charAt(i));
                }
            }
            return 0;
        });
        for (int i = 0; i < C.length; i++) {
            if (!C[i].equals(A[i])) {
                return 0;
            }
        }
        return 1;
    }

    public int solve2(String[] A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            map.put(B.charAt(i), i);
        }
        AtomicBoolean flag = new AtomicBoolean(true);
        AtomicInteger index = new AtomicInteger();
        Arrays.stream(A).sorted((o1, o2) -> {
            int max = Math.max(o1.length(), o2.length());
            for (int i = 0; i < max; i++) {
                if (i >= o1.length() || i >= o2.length()) {
                    return o1.length() - o2.length();
                }
                if (map.get(o1.charAt(i)) - map.get(o2.charAt(i)) == 0) {
                    continue;
                } else {
                    return map.get(o1.charAt(i)) - map.get(o2.charAt(i));
                }
            }
            return 0;
        }).forEach(s -> {
            String s1 = A[index.getAndIncrement()];
            if (!s.equals(s1)) {
                flag.set(false);
            }
        });
        return flag.get() ? 1 : 0;
    }

    public int solve1(String[] A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            map.put(B.charAt(i), i);
        }
        List<String> collect = Arrays.stream(A).sorted((o1, o2) -> {
            int max = Math.max(o1.length(), o2.length());
            for (int i = 0; i < max; i++) {
                if (i >= o1.length() || i >= o2.length()) {
                    return o1.length() - o2.length();
                }
                if (map.get(o1.charAt(i)) - map.get(o2.charAt(i)) == 0) {
                    continue;
                } else {
                    return map.get(o1.charAt(i)) - map.get(o2.charAt(i));
                }
            }
            return 0;
        }).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            if (!collect.get(i).equals(A[i])) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String[] input1A = {"hello", "scaler", "interviewbit"};
        String input1B = "adhbcfegskjlponmirqtxwuvzy";
        System.out.println(new HWQ1IsDictionary().solve(input1A, input1B));
        String[] input2A = {"fine", "none", "no"};
        String input2B = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(new HWQ1IsDictionary().solve(input2A, input2B));
    }
}
