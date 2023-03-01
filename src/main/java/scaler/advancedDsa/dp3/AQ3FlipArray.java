package scaler.advancedDsa.dp3;


public class AQ3FlipArray {

  //  Problem Description
//  Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).
//  Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.
//      Problem Constraints
//1 <= length of(A) <= 100
//  Sum of all the elements will not exceed 10,000.
//  Input Format
//  First and only argument is an integer array A.
//      Output Format
//  Return an integer denoting the minimum number of elements whose sign needs to be flipped.
//      Example Input
//  Input 1:
//  A = [15, 10, 6]
//  Input 2:
//  A = [14, 10, 4]
//  Example Output
//  DocFinder.Output 1:
//      1
//  Output 2:
//      1
//  Example Explanation
//  Explanation 1:
//  Here, we will flip the sign of 15 and the resultant sum will be 1.
//  Explanation 2:
//  Here, we will flip the sign of 14 and the resultant sum will be 0.
//  Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.
  public static void main(String[] args) {
    int[] input1A = {15, 10, 6};
    System.out.println(new AQ3FlipArray().solve(input1A));
    int[] input2A = {14, 10, 4};
    System.out.println(new AQ3FlipArray().solve(input2A));
    int[] input3A = {8, 4, 5, 7, 6, 2};
    System.out.println(new AQ3FlipArray().solve(input3A));//3
  }

  public int solve(int[] A) {
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum = sum + A[i];
    }
    for (int i = 1; i < sum; i++) {
      int ans = knapsack(A, A.length, i);
      if (ans < 10001) {
        return ans;
      }
    }
    return 0;
  }

  private int knapsack(int[] weights, int noOfItems, int capacity) {
    if (capacity == 0) {
      return 0;
    }
    if (noOfItems == 0) {
      return 10001;
    }
    int ans;
    if (capacity >= weights[noOfItems - 1]) {
      //choose
      ans = Math.min(
          1 + knapsack(weights, noOfItems - 1, capacity - weights[noOfItems - 1]),
          knapsack(weights, noOfItems - 1, capacity)
      );
    } else {
      //Not Choose
      ans = knapsack(weights, noOfItems - 1, capacity);
    }
    return ans;
  }

  public int solveWithPair(final int[] A) {
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum = sum + A[i];
    }
//    System.out.println(sum);
    int capacity;
    if (sum % 2 == 0) {
      capacity = sum / 2 - 1;
    } else {
      capacity = sum / 2;
    }
    int[] noOfFlipAndcapacity = new int[]{0, capacity};
    return knapsackWithPair(A, A.length, noOfFlipAndcapacity)[0];
  }

  private int[] knapsackWithPair(int[] weights, int noOfItems,
      int[] noOfFlipAndcapacity) {
    int capacity = noOfFlipAndcapacity[1];
    int noOfFlips = noOfFlipAndcapacity[0];
    if (capacity == 0) {
      return new int[]{noOfFlips, capacity};
    }
    if (noOfItems == 0) {
      return new int[]{noOfFlips, capacity};
    }
    int[] ans;
    if (capacity >= weights[noOfItems - 1]) {
      //choose
      int[] ans1 = knapsackWithPair(weights, noOfItems - 1,
          new int[]{noOfFlips + 1, capacity - weights[noOfItems - 1]});
      int[] ans2 = knapsackWithPair(weights, noOfItems - 1, noOfFlipAndcapacity);
      if (ans1[1] == ans2[1]) {
        if (ans1[0] < ans2[0]) {
          ans = ans1;
        } else {
          ans = ans2;
        }
      } else if (ans1[1] < ans2[1]) {
        ans = ans1;
      } else {
        ans = ans2;
      }
//      System.out.println(Arrays.toString(ans));
    } else {
      //not to choose
      ans = knapsackWithPair(weights, noOfItems - 1, noOfFlipAndcapacity);
    }
    return ans;
  }
}