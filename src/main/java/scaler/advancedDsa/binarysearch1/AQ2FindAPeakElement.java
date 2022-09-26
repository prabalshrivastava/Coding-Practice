package scaler.advancedDsa.binarysearch1;

public class AQ2FindAPeakElement {
    //    Problem Description
//    Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.
//    For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
//            NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.
//    Problem Constraints
//1 <= |A| <= 100000
//            1 <= A[i] <= 109
//    Input Format
//    The only argument given is the integer array A.
//            Output Format
//    Return the peak element.
//    Example Input
//    Input 1:
//    A = [1, 2, 3, 4, 5]
//    Input 2:
//    A = [5, 17, 100, 11]
//    Example Output
//    Output 1:
//            5
//    Output 2:
//            100
//    Example Explanation
//    Explanation 1:
//            5 is the peak.
//            Explanation 2:
//            100 is the peak.
    public static void main(String[] args) {
        int[] input1A = {1, 2, 3, 4, 5};
        System.out.println(new AQ2FindAPeakElement().solve(input1A));
        int[] input2A = {5, 17, 100, 11};
        System.out.println(new AQ2FindAPeakElement().solve(input2A));
        int[] input3A = {1, 1000000000, 1000000000};
        System.out.println(new AQ2FindAPeakElement().solve(input3A));
        int[] input4A = {95, 200, 5, 17, 10, 11, 101};//17
        System.out.println(new AQ2FindAPeakElement().solve(input4A));
    }

    public int solve(int[] A) {
        int l = 0;
        int r = A.length - 1;
        int mid;
        int ans = Integer.MIN_VALUE;
        if (A.length == 1)
            return A[0];
        if (A[0] > A[1]) return A[0];
        if (A[A.length - 1] > A[A.length - 2])
            return A[A.length - 1];
        while (l <= r) {
            mid = (l + r) / 2;
            if (A[mid - 1] <= A[mid] && A[mid] >= A[mid + 1]) {
                //ans = Math.max(ans, A[mid]);
                return A[mid];
            } else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
