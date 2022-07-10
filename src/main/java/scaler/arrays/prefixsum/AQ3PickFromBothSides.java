package scaler.arrays.prefixsum;

public class AQ3PickFromBothSides {
  //  Problem Description
  //  You are given an integer array A of size N.
  //  You have to pick B elements in total. Some (possibly 0) elements from left end of array A and
  // some (possibly 0) from the right end of array A to get the maximum sum.
  //  Find and return this maximum possible sum.
  //      NOTE: Suppose B = 4, and array A contains 10 elements, then
  //  You can pick the first four elements or can pick the last four elements, or can pick 1 from
  // front and 3 from the back, etc. You need to return the maximum possible sum of elements you can
  // pick.
  //      Problem Constraints
  // 1 <= N <= 105
  //      1 <= B <= N
  // -103 <= A[i] <= 103
  //  Input Format
  //  First argument is an integer array A.
  //  Second argument is an integer B.
  //  Output Format
  //  Return an integer denoting the maximum possible sum of elements you picked.
  //  Example Input
  //  Input 1:
  //  A = [5, -2, 3 , 1, 2]
  //  B = 3
  //  Input 2:
  //  A = [1, 2]
  //  B = 1
  //  Example Output
  //  Output 1:
  //      8
  //  Output 2:
  //      2
  //  Example Explanation
  //  Explanation 1:
  //  Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
  //  Explanation 2:
  //  Pick element 2 from end as this is the maximum we can get
  public static void main(String[] args) {
    int[] A1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    int B1 = 5;
    //    System.out.println(new AQ3PickFromBothSides().solve(A1, B1));
    int[] A = {5, -2, 3, 1, 2};
    int B = 3;
    //    System.out.println(new AQ3PickFromBothSides().solve(A, B));
    int[] C = {1, 2};
    int D = 1;
    //    System.out.println(new AQ3PickFromBothSides().solve(C, D));
    int[] E = {
      -533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942,
      -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869,
      912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644,
      -338, -243, -963, -141, -277, 741, 529, -222, -684, 35
    };
    int F = 48;
    //    System.out.println(new AQ3PickFromBothSides().solve(E, F)); // 6253
    int[] G = {
      -584, -714, -895, -512, -718, -545, 734, -886, 701, 316, -329, 786, -737, -687, -645, 185,
      -947, -88, -192, 832, -55, -687, 756, -679, 558, 646, 982, -519, -856, 196, -778, 129, -839,
      535, -550, 173, -534, -956, 659, -708, -561, 253, -976, -846, 510, -255, -351, 186, -687,
      -526, -978, -832, -982, -213, 905, 958, 391, -798, 625, -523, -586, 314, 824, 334, 874, -628,
      -841, 833, -930, 487, -703, 518, -823, 773, -730, 763, -332, 192, 985, 102, -520, 213, 627,
      -198, -901, -473, -375, 543, 924, 23, 972, 61, -819, 3, 432, 505, 593, -275, 31, -508, -858,
      222, 286, 64, 900, 187, -640, -587, -26, -730, 170, -765, -167, 711, 760, -104, -333
    };
    int H = 32;
    System.out.println(new AQ3PickFromBothSides().solve(G, H)); // 727
  }

  public int solve(int[] A, int B) {
    System.out.println("A.length :" + A.length);
    System.out.println("B : " + B);
    int[] prefixSum = new int[A.length];
    int[] suffixSum = new int[A.length];
    prefixSum[0] = A[0];
    for (int i = 1; i < A.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + A[i];
    }
    suffixSum[suffixSum.length - 1] = A[A.length - 1];
    for (int i = A.length - 2; i >= 0; i--) {
      suffixSum[i] = suffixSum[i + 1] + A[i];
    }
    //    System.out.println(Arrays.toString(prefixSum));
    //    System.out.println(Arrays.toString(suffixSum));
    int max = Integer.MIN_VALUE;
    for (int i = -1; i < B; i++) {
      int sum;
      int suffixIndex = A.length - B + i + 1;
      if (suffixIndex == A.length) {
        System.out.printf("prefixSum[i] : -> prefixSum[%d] -> %d%n", i, prefixSum[i]);
        sum = prefixSum[i];
      } else if (i == -1) {
        sum = suffixSum[suffixIndex];
      } else {
        System.out.printf(
            "prefixSum[i] + suffixSum[suffixIndex] : -> prefixSum[%d] + suffixSum[%d] -> %d + %d => %d%n",
            i,
            suffixIndex,
            prefixSum[i],
            suffixSum[suffixIndex],
            prefixSum[i] + suffixSum[suffixIndex]);
        sum = prefixSum[i] + suffixSum[suffixIndex];
      }
      if (sum > max) max = sum;
    }
    return max;
  }
}
