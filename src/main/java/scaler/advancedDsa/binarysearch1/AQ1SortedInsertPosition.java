package scaler.advancedDsa.binarysearch1;

public class AQ1SortedInsertPosition {
    //    Problem Description
//    Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
//    If not, return the index where it would be if it were inserted in order.
//            NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.
//            Problem Constraints
//1 <= N <= 106
//    Input Format
//    The first argument is an integer array A of size N.
//    The second argument is an integer B.
//            Output Format
//    Return an integer denoting the index of target value.
//            Example Input
//    Input 1:
//    A = [1, 3, 5, 6]
//    B = 5
//    Input 2:
//    A = [1]
//    B = 1
//    Example Output
//    Output 1:
//            2
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    The target value is present at index 2.
//    Explanation 2:
//    The target value is present at index 0.
    public static void main(String[] args) {
        int[] input1A = {1, 3, 5, 6};
        int input1B = 5;
        System.out.println(new AQ1SortedInsertPosition().searchInsert(input1A, input1B));
        int[] input2A = {1};
        int input2B = 1;
        System.out.println(new AQ1SortedInsertPosition().searchInsert(input2A, input2B));
        int[] input3A = {1, 3, 5, 6};
        int input3B = 7;
        System.out.println(new AQ1SortedInsertPosition().searchInsert(input3A, input3B));

    }

    public int searchInsert(int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (B == A[mid]) {
                return mid;
            } else if (B > A[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (l < 0) return 0;
        else return l;
    }
}
