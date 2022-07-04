package scaler.arrays.introductiontoarrays;

import java.util.Scanner;

public class HWQ4SeparateOddEven {
  //  Problem Description
  //  You are given an integer T denoting the number of test cases. For each test case, you are
  // given an integer array A.
  //  You have to put the odd and even elements of array A in 2 separate arrays and print the new
  // arrays.
  //      NOTE: Array elements should have the same relative order as in A.
  //      Problem Constraints
  // 1 <= T <= 10
  //      1 <= |A| <= 105
  //      1 <= A[i] <= 109
  //  Input Format
  //  First line of the input contains a single integer T.
  //  For each test case:
  //  First line consists of a single integer |A| denoting the length of array.
  //  Second line consists of |A| space separated integers denoting the elements of array A.
  //      Output Format
  //  For each test case:
  //  First line should contain an array of space separated integers containing all the odd elements
  // of array A
  //  Second line should contain an array of space separated integers containing all the even
  // elements of array A
  //  Example Input
  //  Input 1:
  //      2
  //      5
  //      1 2 3 4 5
  //      3
  //      4 3 2
  //  Input 2:
  //      2
  //      3
  //      2 2 2
  //      2
  //      1 1
  //  Example Output
  //  Output 1:
  //      1 3 5
  //      2 4
  //      3
  //      4 2
  //  Output 2:
  //      2 2 2
  //      1 1
  //  Example Explanation
  //  Explanation 1:
  //  Test Case 1:
  //  Odd elements in the array(in the order they occur) are: 1, 3, 5.
  //  Even elements in the array(in the order they occur) are: 2, 4.
  //  Test Case 2
  //  Odd elements in the array(in the order they occur) are: 3.
  //  Even elements in the array(in the order they occur) are: 4, 2.
  //  Explanation 2:
  //  Test Case 1:
  //  There are no odd elements in the array.
  //  Even elements in the array(in the order they occur) are: 2, 2, 2.
  //  Test Case 2
  //  Odd elements in the array(in the order they occur) are: 1, 1.
  //  There are no even elements in the array.

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int noOfTestCases = scanner.nextInt();
    for (int i = 0; i < noOfTestCases; i++) {
      int arraySize = scanner.nextInt();
      int[] array = new int[arraySize];
      for (int j = 0; j < arraySize; j++) {
        array[j] = scanner.nextInt();
      }
      for (int j = 0; j < array.length; j++) {
        if (array[j] % 2 != 0) {
          System.out.print(array[j] + " ");
        }
      }
      System.out.println("");
      for (int j = 0; j < array.length; j++) {
        if (array[j] % 2 == 0) {
          System.out.print(array[j] + " ");
        }
      }
      System.out.println("");
    }
  }
}
// 10
// 7
// 509800927 348992125 733735508 654457679 499101452 855551825 443382987
// 8
// 905578050 972494652 245375028 878368500 105860782 944700823 490393895 948966983
// 9
// 798010236 29079384 720590272 493468480 808983313 722971196 470315704 720150938 679454398
// 2
// 860913338 587475971
// 8
// 517757309 70339184 520722130 366035448 185927255 578942245 538351388 348346547
// 10
// 452362886 75768689 247249986 472805849 415014921 242296902 57978761 364718082 268628454 774115327
// 7
// 225137014 98149921 536535463 21434335 358473307 153990006 582935602
// 3
// 897324350 664604339 44410966
// 1
// 968819918
// 9
// 467587686 584409350 192985738 440958471 883800429 304643155 432387944 370170046 791202706
