package scaler.language.javadiscussion2;

import java.util.Arrays;

public class Q13 {

  public static void main(String[] args) {
    int[] numbers = {1, 3, 5, 6, 7, 8, 9, 10, 11};
    System.out.println(Arrays.binarySearch(numbers, 4));
  }
}

//Here's what's happening in the code:
//    An array of integers named numbers is initialized with some values.
//    The Arrays.binarySearch() method is called to search for the value 4 in the numbers array. This method searches the specified array of ints for the specified value using the binary search algorithm.
//    Since 4 is not present in the array, the method returns the index of the "theoretical" position where 4 should be inserted to maintain the sorted order of the array. According to the binary search algorithm, if the element is not present in the array, the method returns the value -insertion_point - 1, where insertion_point is the index at which the element should be inserted.
//    In this case, the 4 should be inserted at index 2 in order to maintain the sorted order of the array. So, the method returns -3, which is calculated as -(insertion_point) - 1 = -(2+1) = -3.
//    The System.out.println() method is used to print the result to the console, which is -3.