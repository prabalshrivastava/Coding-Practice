package scaler.language.javadiscussion2;

import java.util.Arrays;

public class Q14 {

  public static void main(String[] args) {
    int[] numbers = {1, 5, 4, 6, 7, 8, 9, 10, 11};
    System.out.println(Arrays.binarySearch(numbers, 4));
  }
}

//  If the output of Arrays.binarySearch(numbers, 4) is -2, it means that the value 4 is not present in the array numbers, and if it were to be inserted into the array, it should be inserted at index 1.
//    This may seem counterintuitive, but it is the expected behavior of the binarySearch method when the specified value is not present in the array. The method returns a negative number to indicate that the value is not present, and the absolute value of the returned number minus one indicates the index at which the value should be inserted.
//    In this case, the absolute value of -2 is 2, and if 4 were to be inserted into the array, it should be inserted at index 1 (i.e., between 1 and 5).