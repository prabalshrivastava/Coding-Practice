package scaler.module1.sorting;


import java.util.Arrays;
import java.util.stream.Collectors;

public class HWQ1LargestNumber {
    //    Problem Description
//    Given an array A of non-negative integers, arrange them such that they form the largest number.
//    Note: The result may be very large, so you need to return a string instead of an integer.
//    Problem Constraints
//1 <= len(A) <= 100000
//            0 <= A[i] <= 2*109
//    Input Format
//    The first argument is an array of integers.
//    Output Format
//    Return a string representing the largest number.
//            Example Input
//    Input 1:
//    A = [3, 30, 34, 5, 9]
//    Input 2:
//    A = [2, 3, 9, 0]
//    Example Output
//    Output 1:
//            "9534330"
//    Output 2:
//            "9320"
//    Example Explanation
//    Explanation 1:
//    Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
//            Explanation 2:
//    Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
    public String largestNumber(final int[] A) {

        StringBuilder s = new StringBuilder();
        Arrays.stream(A).boxed().sorted((o1, o2) -> {
//            String o1S = o1.toString();
//            String o2S = o2.toString();
//            String o1L;
//            String o2L;
////            if (o1S.length() == o2S.length()) {
////                return o2.compareTo(o1);
////            }
//            if (o1S.length() > 1) o1L = o1S.substring(1);
//            else o1L = o1S;
//            if (o2S.length() > 1) o2L = o2S.substring(1);
//            else
//                o2L = o2S;
//            return Integer.parseInt(o2L) - Integer.parseInt(o1L);
            long sec = Long.parseLong(o2 + String.valueOf(o1));
            long f = Long.parseLong(o1 + String.valueOf(o2));
//            System.out.println("f : " + f + " - s : " + sec);
            if (f > sec) {
                return -1;
            } else {
                return 1;
            }
        }).forEach(s::append);
        String s1 = s.toString();
        if (s1.length() <= 19) {
            s1 = String.valueOf(Long.parseLong(s1));
        }
        return s1;

    }

    public String largestNumber1(final int[] A) {
        return Arrays.stream(A).boxed().sorted((o1, o2) -> {
            String o1S = o1.toString();
            String o2S = o2.toString();
            String o1L;
            String o2L;
            if (o1S.length() > 1) o1L = o1S.substring(1);
            else o1L = o1S;
            if (o2S.length() > 1) o2L = o2S.substring(1);
            else
                o2L = o2S;
            return Integer.parseInt(o2L) - Integer.parseInt(o1L);
        }).map(Object::toString).collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        int[] input1A = {3, 30, 34, 5, 9};
        System.out.println(new HWQ1LargestNumber().largestNumber(input1A));
        int[] input2A = {2, 3, 9, 0};
        System.out.println(new HWQ1LargestNumber().largestNumber(input2A));
        int[] input3A = {0, 0, 0, 0, 0};
        System.out.println(new HWQ1LargestNumber().largestNumber(input3A));
        int[] input4A = {472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412};    //9648527226766636354854724412368319
        System.out.println(new HWQ1LargestNumber().largestNumber(input4A));
        System.out.println();
    }

}
