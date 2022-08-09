package scaler.module1.arrays.interviewproblems;

public class AQ1LengthOfLongestConsecutiveOnes {
    //    Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
//
//
//            Input Format
//
//    The only argument given is string A.
//            Output Format
//
//    Return the length of the longest consecutive 1’s that can be achieved.
//            Constraints
//
//1 <= length of string <= 1000000
//    A contains only characters 0 and 1.
//    For Example
//
//    Input 1:
//    A = "111000"
//    Output 1:
//            3
//
//    Input 2:
//    A = "111011101"
//    Output 2:
//            7
    public int solve(String A) {
        char[] chars = A.toCharArray();
        int countOf1s = 0;
        int countOf0s = 0;
        for (int i = 0; i < chars.length; i++) {
            int currentNo = Integer.parseInt(String.valueOf(chars[i]));
            if (currentNo == 1)
                countOf1s++;
            else
                countOf0s++;
        }
        if (countOf0s == 0)
            return countOf1s;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int currentNo = Integer.parseInt(String.valueOf(chars[i]));
            if (currentNo == 0) {
                int leftIndex = i - 1;
                int rightIndex = i + 1;
                int currentCountOf1s = 0;
                while (leftIndex >= 0 && Integer.parseInt(String.valueOf(chars[leftIndex])) == 1) {
                    currentCountOf1s++;
                    leftIndex--;
                }
                while (rightIndex < chars.length && Integer.parseInt(String.valueOf(chars[rightIndex])) == 1) {
                    currentCountOf1s++;
                    rightIndex++;
                }
                ans = Math.max(ans, currentCountOf1s);
            }
        }
        if (countOf1s > ans) {
            return ans + 1;
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        String input1A = "111000";
        System.out.println(new AQ1LengthOfLongestConsecutiveOnes().solve(input1A));
        //output1B = 3

        String input2A = "111011101";
        System.out.println(new AQ1LengthOfLongestConsecutiveOnes().solve(input2A));
        //output2B = 7
    }
}
