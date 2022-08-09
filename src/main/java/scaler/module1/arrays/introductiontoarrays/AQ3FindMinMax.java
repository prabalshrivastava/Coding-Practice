package scaler.module1.arrays.introductiontoarrays;

import java.util.Scanner;

public class AQ3FindMinMax {
  //  Problem Description
  //  Write a program to print maximum and minimum elements of the input array A of size N where you
  // have to take integer N and other N elements as input from the user.
  //      Problem Constraints
  // 1 <= N <= 1000
  //      1 <= A <= 1000
  //  Input Format
  //  A single line representing N followed by N integers of the array A
  //  Output Format
  //  A single line containing two space separated integers representing maximum and minimum
  // elements of the input array.
  //      Example Input
  //  Input 1:
  //      5 1 2 3 4 5
  //  Input 2:
  //      4 10 50 40 80
  //  Example Output
  //  Output 1:
  //      5 1
  //  Output 2:
  //      80 10

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int max = arr[0];
    int min = arr[0];
    for (int i = 0; i < n; i++) {
      if (arr[i] > max) max = arr[i];
      if (arr[i] < min) min = arr[i];
    }
    System.out.println(max + " " + min);
  }
}
