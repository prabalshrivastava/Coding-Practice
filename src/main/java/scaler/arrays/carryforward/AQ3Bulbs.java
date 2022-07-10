package scaler.arrays.carryforward;

public class AQ3Bulbs {
  //  Problem Description
  //  A wire connects N light bulbs.
  //  Each bulb has a switch associated with it; however, due to faulty wiring, a switch also
  // changes the state of all the bulbs to the right of the current bulb.
  //  Given an initial state of all bulbs, find the minimum number of switches you have to press to
  // turn on all the bulbs.
  //  You can press the same switch multiple times.
  //  Note: 0 represents the bulb is off and 1 represents the bulb is on.
  //      Problem Constraints
  // 1 <= N <= 5×105
  //      0 <= A[i] <= 1
  //  Input Format
  //  The first and the only argument contains an integer array A, of size N.
  //      Output Format
  //  Return an integer representing the minimum number of switches required.
  //  Example Input
  //  Input 1:
  //  A = [0, 1, 0, 1]
  //  Input 2:
  //  A = [1, 1, 1, 1]
  //  Example Output
  //  Output 1:
  //      4
  //  Output 2:
  //      0
  //  Example Explanation
  //  Explanation 1:
  //  press switch 0 : [1 0 1 0]
  //  press switch 1 : [1 1 0 1]
  //  press switch 2 : [1 1 1 0]
  //  press switch 3 : [1 1 1 1]
  //  Explanation 2:
  //  There is no need to turn any switches as all the bulbs are already on.
  public int bulbs(int[] A) {
    return sol2(A);//O(n)
    //    return sol1(A);//O(n^2)
  }

  private int sol2(int[] A) {
    int countOfSwitchesPressed = 0;
    for (int i = 0; i < A.length; i++) {
      if (countOfSwitchesPressed % 2 == 1) {
        if (A[i] == 1) {
          A[i] = 0;
        } else {
          A[i] = 1;
        }
      }
      if (A[i] == 0) {
        countOfSwitchesPressed++;
        A[i] = 1;
      }
    }
    return countOfSwitchesPressed;
  }

  private int sol1(int[] A) {
    int countOfSwitchesPressed = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) {
        countOfSwitchesPressed++;
        for (int j = i + 1; j < A.length; j++) {
          if (A[j] == 1) {
            A[j] = 0;
          } else {
            A[j] = 1;
          }
        }
        A[i] = 1;
      }
    }
    return countOfSwitchesPressed;
  }

  public static void main(String[] args) {
    int[] A = {0, 1, 0, 1};
    System.out.println(new AQ3Bulbs().bulbs(A));
    int[] B = {1, 1, 1, 1};
    System.out.println(new AQ3Bulbs().bulbs(B));
  }
}
