package scaler.common;

public class CommonUtils {
    public static long getModdedSum(long sum) {
        if (sum < 0)
            sum = (long) ((sum + (Math.pow(10, 9) + 7)) % (Math.pow(10, 9) + 7));
        else
            sum = (long) (sum % (Math.pow(10, 9) + 7));
        return sum;
    }
    public static int getModdedIntSum(long sum) {
        if (sum < 0)
            sum = (long) ((sum + (Math.pow(10, 9) + 7)) % (Math.pow(10, 9) + 7));
        else
            sum = (long) (sum % (Math.pow(10, 9) + 7));
        return (int) sum;
    }


    public static long getModdedNumber(long A, long C) {
        if (A < 0) {
//            System.out.println(A);
            return (A + C) % C;
        } else
            return A % C;
    }

    public static int getModdedNumberInt(long A, long C) {
        if (A < 0) {
//            System.out.println(A);
            return (int) ((A + C) % C);
        } else
            return (int) (A % C);
    }
}