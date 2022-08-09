package scaler.module1.arrays.carryforward;

public class HWQ2EvenSubarrays {

    //  Problem Description
    //  You are given an integer array A.
    //  Decide whether it is possible to divide the array into one or more subarrays of even length
    // such that the first and last element of all subarrays will be even.
    //  Return "YES" if it is possible; otherwise, return "NO" (without quotes).
    //  Problem Constraints
    // 1 <= |A|, A[i] <= 106
    //  Input Format
    //  The first and the only input argument is an integer array, A.
    //      Output Format
    //  Return a string "YES" or "NO" denoting the answer.
    //      Example Input
    //  Input 1:
    //  A = [2, 4, 8, 6]
    //  Input 2:
    //  A = [2, 4, 8, 7, 6]
    //  Example Output
    //  Output 1:
    //      "YES"
    //  Output 2:
    //      "NO"
    //  Example Explanation
    //  Explanation 1:
    //  We can divide A into [2, 4] and [8, 6].
    //  Explanation 2:
    //  There is no way to divide the array into even length subarrays.
    public String solve(int[] A) {
        if (A.length %2==0 && A[0]%2==0 && A[A.length-1]%2==0){
            return "YES";
        }else
            return "NO";
//        String ans ="YES";
//      for (int i = 0; i < A.length; i++) {
//          if (A[i]%2 == 0) {
//              int j = i + 1;
//              int len = 1;
//              while (j < A.length && A[j] % 2 != 0) {
//                  j++;
//                  len++;
//              }
//              i = j;
//              if (j>=A.length){
//                  return "NO";
//              }
//              if (len%2==0){
//                  ans = "YES";
//              }else
//                  return "NO";
//          }else {
//              return "NO";
//          }
//      }
//      return "YES";
    }

    public static void main(String[] args) {
      int[] input1A = {2, 4, 8, 6};
      System.out.println(new HWQ2EvenSubarrays().solve(input1A));
      int[] input2A = {2, 4, 8, 7, 6};
      System.out.println(new HWQ2EvenSubarrays().solve(input2A));
        int[] input3A = { 978, 847, 95, 729, 778, 586, 188, 782, 813, 870, 871, 940, 312, 693, 580, 101, 760, 837, 564, 633, 680, 155, 241, 374, 682, 290, 850, 601, 433, 922, 773, 959, 530, 290, 990, 50, 516, 409, 868, 131, 664, 851, 721, 880, 20, 450, 745, 387, 787, 823, 392, 242, 674, 347, 65, 135, 819, 324, 651, 678, 139, 940 };
      System.out.println(new HWQ2EvenSubarrays().solve(input3A));

    }
}
