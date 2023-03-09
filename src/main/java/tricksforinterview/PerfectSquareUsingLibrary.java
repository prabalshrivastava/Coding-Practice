package tricksforinterview;

public class PerfectSquareUsingLibrary {

  public static void main(String[] args) {
    for (int i = 0; i < 20; i++) {
      checkPerfectSquare(i);
    }
  }

  private static void checkPerfectSquare(int num) {
    double sqrt = Math.sqrt(num);

    if (sqrt == Math.floor(sqrt)) {
      System.out.println(num + " is a perfect square.");
    } else {
      System.out.println(num + " is not a perfect square.");
    }
  }
}