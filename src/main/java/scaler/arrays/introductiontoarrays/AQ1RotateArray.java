package scaler.arrays.introductiontoarrays;

import java.util.Scanner;

public class AQ1RotateArray {
  //  Problem Description
  //  Given an integer array A of size N and an integer B, you have to print the same array after
  // rotating it B times towards the right.
  //  Problem Constraints
  // 1 <= N <= 106
  //      1 <= A[i] <=108
  //      1 <= B <= 109
  //  Input Format
  //  There are 2 lines in the input
  //  Line 1: The first number is the size N of the array A. Then N numbers follow which indicate
  // the elements in the array A.
  //  Line 2: A single integer B.
  //  Output Format
  //  Print array A after rotating it B times towards the right.
  //      Example Input
  //  Input 1 :
  //      4 1 2 3 4
  //      2
  //  Example Output
  //  Output 1 :
  //      3 4 1 2
  //  Example Explanation
  //  Example 1 :
  //  N = 4, A = [1, 2, 3, 4] and B = 2.
  //  Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
  //  Final array = [3, 4, 1, 2]
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int arraySize = scanner.nextInt();
    int[] arr = new int[arraySize];
    for (int j = 0; j < arraySize; j++) {
      arr[j] = scanner.nextInt();
    }
    scanner.nextLine();
    int rotateTimes = scanner.nextInt();
    rotateTimes = rotateTimes % arr.length;
    int index = 0;
    int[] holderArray = new int[rotateTimes];
    for (int j = arr.length - rotateTimes; j < arr.length; j++) {
      holderArray[index] = arr[j];
      index++;
    }

    //    System.out.println(Arrays.toString(arr));
    for (int j = arr.length - 1 - rotateTimes; j >= 0; j--) {
      arr[j + rotateTimes] = arr[j];
    }
    for (int i = 0; i < holderArray.length; i++) {
      arr[i] = holderArray[i];
    }
    //    System.out.println(Arrays.toString(arr));
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
