package scaler.advancedDsa.binarysearch2;

public class AQ3SpecialInteger {
    //    Problem Description
//    Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
//            Problem Constraints
//1 <= |A| <= 100000
//            1 <= A[i] <= 10^9
//            1 <= B <= 10^9
//    Input Format
//    The first argument given is the integer array A.
//    The second argument given is integer B.
//            Output Format
//    Return the maximum value of K (sub array length).
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    B = 10
//    Input 2:
//    A = [5, 17, 100, 11]
//    B = 130
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            3
//    Example Explanation
//    Explanation 1:
//    Constraints are satisfied for maximal value of 2.
//    Explanation 2:
//    Constraints are satisfied for maximal value of 3.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 4, 5};
        int input1B = 10;
        System.out.println(new AQ3SpecialInteger().solve(input1A, input1B));
        int[] input2A = {5, 17, 100, 11};
        int input2B = 130;
        System.out.println(new AQ3SpecialInteger().solve(input2A, input2B));
        int[] input3A = {26, 45, 18, 3, 7, 15, 32, 45, 43, 48, 49, 7, 15};
        int input3B = 226;
        System.out.println(new AQ3SpecialInteger().solve(input3A, input3B));
        int[] input4A = {1, 2, 3, 4, 5, 100};
        int input4B = 10;
        System.out.println(new AQ3SpecialInteger().solve(input4A, input4B));
        int[] input5A = {1, 1000000000};
        int input5B = 1000000000;
        System.out.println(new AQ3SpecialInteger().solve(input5A, input5B));
    }

    public int solve(int[] A, int B) {
        long l = 0;
        long r = A.length;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
//            System.out.println("Passing mid : " + mid);
            if (checkSum(A, mid, B)) {
//                System.out.println("returned true for " + mid);
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) ans;
    }

    private boolean checkSum(int[] a, long k, int B) {
        long sum = 0;
//        System.out.println("k " + k);
        for (int i = 0; i < k; i++) {
//            System.out.println("adding : " + a[i]);
            sum = sum + a[i];
        }
//        System.out.println("sum : " + sum);
        if (sum > B) {
            return false;
        }
        for (int i = 1; i <= a.length - k; i++) {
//            System.out.printf("(i - 1)[%s] | (k + i)[%s] | sum - a[i - 1] + a[k + i - 1] | %s - %s + %s => %s%n", i - 1, k + i, sum, a[i - 1], a[(int) (k + i - 1)], sum - a[i - 1] + a[(int) (k + i - 1)]);
            sum = sum - a[i - 1] + a[(int) (k + i - 1)];
//            System.out.println("sum : " + sum);
            if (sum > B)
                return false;
        }
        return true;
    }
}
