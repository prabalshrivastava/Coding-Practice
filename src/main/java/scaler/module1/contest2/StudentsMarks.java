package scaler.module1.contest2;

import java.util.Arrays;

public class StudentsMarks {
    public static void main(String[] args) {
        String[] input1 = {"adarsh80", "harsh95", "shivam95"};
        System.out.println(Arrays.toString(new StudentsMarks().solve(input1)));
    }

    public String[] solve(String[] A) {
        Arrays.sort(A, (o1, o2) -> {

            String s1 = o1.replaceAll("[a-zA-Z]", "");
            String s2 = o2.replaceAll("[a-zA-Z]", "");
            int num1 = 0;
            int num2 = 0;
            if (!"".equals(s1)) {
                num1 = Integer.parseInt(s1);
            }
            if (!"".equals(s1)) {
                num2 = Integer.parseInt(s2);
            }
            return num2 - num1;
        });
//        System.out.println(Arrays.toString(A));
        return A;
    }
}
