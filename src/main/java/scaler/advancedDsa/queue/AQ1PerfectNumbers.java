package scaler.advancedDsa.queue;

import scaler.common.LinkedListUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AQ1PerfectNumbers {
    //    Problem Description
//    Given an integer A, you have to find the Ath Perfect Number.
//    A Perfect Number has the following properties:
//    It comprises only 1 and 2.
//    The number of digits in a Perfect number is even.
//    It is a palindrome number.
//    For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
//    Problem Constraints
//1 <= A <= 100000
//    Input Format
//    The only argument given is an integer A.
//    Output Format
//    Return a string that denotes the Ath Perfect Number.
//            Example Input
//    Input 1:
//    A = 2
//    Input 2:
//    A = 3
//    Example Output
//    Output 1:
//            22
//    Output 2:
//            1111
//    Example Explanation
//    Explanation 1:
//    First four perfect numbers are:
//            1. 11
//            2. 22
//            3. 1111
//            4. 1221
//    Explanation 2:
//    First four perfect numbers are:
//            1. 11
//            2. 22
//            3. 1111
//            4. 1221
    public static void main(String[] args) {
        System.out.println("1 : " + new AQ1PerfectNumbers().solve(1));//11
        System.out.println("2 : " + new AQ1PerfectNumbers().solve(2));//22
        System.out.println("3 : " + new AQ1PerfectNumbers().solve(3));//1111
        System.out.println("4 : " + new AQ1PerfectNumbers().solve(4));//1221
        System.out.println("5 : " + new AQ1PerfectNumbers().solve(5));//2112
        System.out.println("6 : " + new AQ1PerfectNumbers().solve(6));//2222
        System.out.println("7 : " + new AQ1PerfectNumbers().solve(7));//111111
        System.out.println("8 : " + new AQ1PerfectNumbers().solve(8));//112211
        System.out.println("9 : " + new AQ1PerfectNumbers().solve(9));//121121
        System.out.println("10 : " + new AQ1PerfectNumbers().solve(10));//122221
    }

    public String solve(int A) {
        if (A == 1)
            return "11";
        if (A == 2)
            return "22";

        Queue<Integer> perfectNoQueue = new LinkedList<>();
        perfectNoQueue.offer(1);
        perfectNoQueue.offer(2);
        int count = 2;
        while (true) {
            Integer current = perfectNoQueue.peek();

            int proccessing = (current * 10) + 1;
            perfectNoQueue.offer(proccessing);
            count++;
            if (count == A) {
                StringBuilder peeked = new StringBuilder(proccessing + "");
                return peeked.toString() + peeked.reverse();
            }

            proccessing = (current * 10) + 2;
            perfectNoQueue.offer(proccessing);
            count++;
            if (count == A) {
                StringBuilder peeked = new StringBuilder(proccessing + "");
                return peeked.toString() + peeked.reverse();
            }
            perfectNoQueue.poll();
        }
    }
}
