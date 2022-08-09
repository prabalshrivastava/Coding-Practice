package scaler.module1.strings;

import java.util.ArrayList;
import java.util.List;

public class HWQ2CountOccurrences {
//    Problem Description
//    Find the number of occurrences of bob in string A consisting of lowercase English alphabets.
//            Problem Constraints
//    1 <= |A| <= 1000
//    Input Format
//    The first and only argument contains the string A, consisting of lowercase English alphabets.
//            Output Format
//    Return an integer containing the answer.
//    Example Input
//    Input 1:
//            "abobc"
//    Input 2:
//            "bobob"
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//    The only occurrence is at second position.
//            Explanation 2:
//    Bob occures at first and third position.

    public int solve(String A) {
        String s = "bob";
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == s.charAt(0)) {
                list.add(i);
            }
        }
//        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            Integer currentIndex = list.get(i);
            boolean isMatching = true;
            for (int j = 0; j < s.length(); j++) {
                if (j + currentIndex < A.length() && s.charAt(j) == A.charAt(j + currentIndex)) {

                } else {
                    isMatching = false;
                    break;
                }
            }
            if (isMatching) {
                ans++;
            }
        }
        return ans;
    }

    public int solve1(String A) {
        String s = "bob";
        int ans = 0;
        int firstNextPossibleStartingPoint = Integer.MAX_VALUE;
        for (int i = 0; i < A.length(); i++) {
            boolean isFirstProcessed = false;
            for (int j = 0; j < s.length(); j++) {
                if (A.charAt(i) == s.charAt(j)) {
                    if (j == s.length() - 1) {
                        ans++;
                    }
                    isFirstProcessed = true;
                } else {
                    break;
                }
                if (isFirstProcessed && firstNextPossibleStartingPoint == Integer.MAX_VALUE && s.charAt(0) == A.charAt(i)) {
                    firstNextPossibleStartingPoint = i;
                }
            }
            if (firstNextPossibleStartingPoint != Integer.MAX_VALUE) {
                i = firstNextPossibleStartingPoint;
                firstNextPossibleStartingPoint = Integer.MAX_VALUE;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        String input1 = "abobc";
        System.out.println(new HWQ2CountOccurrences().solve(input1));
        String input2 = "bobob";
        System.out.println(new HWQ2CountOccurrences().solve(input2));
    }
}
