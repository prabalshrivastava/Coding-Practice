package Tesco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shifts {

  public static void main(String[] args) {
//    {8,10},{10,12},{14,19}
//    {8,12},{14,19}
//    int[][] input = {{8, 10}, {10, 12}, {14, 19}};
//    int[][] input = {{8, 10}, {14, 19}, {10, 12}};
//    int[][] input = {{4,5},{10,2},{50,6},{16,7},{3,4}};
    int[][] input = {{4, 5}, {1, 2}, {2, 3}, {5, 6}, {3, 4}};

    List<int[]> mergedShifts = new ArrayList<>();

    Arrays.sort(input, (firstObj, secondObj) -> {
      int start1 = firstObj[0];
      int end1 = firstObj[1];

      int start2 = secondObj[0];
      int end2 = secondObj[1];

      return end1 - end2;
    });

    System.out.println(Arrays.deepToString(input));
    int pickedStart = input[0][0];
    for (int i = 1; i < input.length; i++) {
      int currentStart = input[i][0];
      int currentEnd = input[i][1];

      int previousStart = input[i - 1][0];
      int previousEnd = input[i - 1][1];
      if (previousEnd == currentStart) {
        continue;
      } else {
        int[] newShift = {pickedStart, currentEnd};
          mergedShifts.add(newShift);
          mergedShifts.add(input[i]);
          pickedStart = currentStart;
//        if (pickedStart != Integer.MIN_VALUE) {
//        } else {
//          mergedShifts.add(input[i]);
//        }
//        pickedStart = Integer.MIN_VALUE;
      }
    }

//    for (int i = 1; i < input.length; i++) {
//      int currentStart = input[i][0];
//      int currentEnd = input[i][1];
//
//      int previousStart = input[i - 1][0];
//      int previousEnd = input[i - 1][1];
//      int existingStart = Integer.MIN_VALUE;
//      int existingEnd = Integer.MIN_VALUE;
//      int lastIndex = mergedShifts.size() - 1;
//      if (!mergedShifts.isEmpty()) {
//        existingStart = mergedShifts.get(lastIndex)[0];
//        existingEnd = mergedShifts.get(lastIndex)[1];
//      }
//
////      System.out.print(currentEnd + "-");
//      if (previousEnd == currentStart) {
//        //{8, 10}, {10, 12}
//        //{previousStart, previousEnd}, {currentStart, currentEnd}
//        //{previousStart, currentEnd}
//        //{{8, 10}, {14, 19}, {10, 12}};
//        int[] newShift = {previousStart, currentEnd};
//        mergedShifts.add(newShift);
//      } else if (existingEnd != Integer.MIN_VALUE && existingEnd == currentStart) {
//        //merge existing with current
//        //remove already existing
//        //insert the new one
//        int[] newShift = {existingStart, currentEnd};
//        mergedShifts.remove(lastIndex);
//        mergedShifts.add(newShift);
//      } else {
//        mergedShifts.add(input[i]);
//      }
//    }
    for (int[] shift : mergedShifts) {
      System.out.println(Arrays.toString(shift));
    }
  }
}
