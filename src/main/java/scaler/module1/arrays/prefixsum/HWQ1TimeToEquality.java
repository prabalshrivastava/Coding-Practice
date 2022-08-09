package scaler.module1.arrays.prefixsum;

public class HWQ1TimeToEquality {
  public int solve(int[] A) {
    int max = A[0];
    for (int i = 0; i < A.length; i++) {
      if (A[i] > max) {
        max = A[i];
      }
    }
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      count = count + (max - A[i]);
    }
    return count;
  }

  public static void main(String[] args) {
    int[] B = new int[] {2, 4, 1, 3, 2};
    System.out.println(new HWQ1TimeToEquality().solve(B));
  }
}
