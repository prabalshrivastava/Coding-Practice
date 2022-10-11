package scaler.advancedDsa.hashing2;

public class HWQ1PointsOnSameLine {
    //    Problem Description
//    Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.
//    Find and return the maximum number of points that lie on the same line.
//            Problem Constraints
//1 <= (length of the array A = length of array B) <= 1000
//            -105 <= A[i], B[i] <= 105
//    Input Format
//    The first argument is an integer array A.
//    The second argument is an integer array B.
//    Output Format
//    Return the maximum number of points which lie on the same line.
//    Example Input
//    Input 1:
//    A = [-1, 0, 1, 2, 3, 3]
//    B = [1, 0, 1, 2, 3, 4]
//    Input 2:
//    A = [3, 1, 4, 5, 7, -9, -8, 6]
//    B = [4, -8, -3, -2, -1, 5, 7, -4]
//    Example Output
//    Output 1:
//            4
//    Output 2:
//            2
//    Example Explanation
//    Explanation 1:
//    The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
//    Explanation 2:
//    Any 2 points lie on a same line.
    public static void main(String[] args) {
        int[] input1A = {-1, 0, 1, 2, 3, 3};
        int[] input1B = {1, 0, 1, 2, 3, 4};
        System.out.println(new HWQ1PointsOnSameLine().solve(input1A, input1B));
        int[] input2A = {3, 1, 4, 5, 7, -9, -8, 6};
        int[] input2B = {4, -8, -3, -2, -1, 5, 7, -4};
        System.out.println(new HWQ1PointsOnSameLine().solve(input2A, input2B));
    }

    public int solve(int[] A, int[] B) {
        return 0;
    }
}
