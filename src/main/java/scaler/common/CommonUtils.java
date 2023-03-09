package scaler.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonUtils {

  public static long getModdedSum(long sum) {
    if (sum < 0) {
      sum = (long) ((sum + (Math.pow(10, 9) + 7)) % (Math.pow(10, 9) + 7));
    } else {
      sum = (long) (sum % (Math.pow(10, 9) + 7));
    }
    return sum;
  }

  public static int getModdedIntSum(long sum) {
    if (sum < 0) {
      sum = (long) ((sum + (Math.pow(10, 9) + 7)) % (Math.pow(10, 9) + 7));
    } else {
      sum = (long) (sum % (Math.pow(10, 9) + 7));
    }
    return (int) sum;
  }


  public static long getModdedNumber(long A, long C) {
    if (A < 0) {
//            System.out.println(A);
      return (A + C) % C;
    } else {
      return A % C;
    }
  }

  public static int getModdedNumberInt(long A, long C) {
    if (A < 0) {
//            System.out.println(A);
      return (int) ((A + C) % C);
    } else {
      return (int) (A % C);
    }
  }

  public static void swap(int[] A, int idx, int i) {
    int temp = A[i];
    A[i] = A[idx];
    A[idx] = temp;
  }

  public static List<Integer> arrayToList(int[] numbers) {
    return Arrays.stream(numbers).boxed().collect(Collectors.toList());
  }

  public static List<Integer> arrayToList_Old(int[] numbers) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
      list.add(numbers[i]);
    }
    return list;
  }
}