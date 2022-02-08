package faang450.arrays.anjali;

public class JumpArray {
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 2, 6, 7};
        int count = 0;

        for (int i = 0; i < arr.length; i += arr[i]) {
            if (i != 0) {
                System.out.println("i  :" + arr[i]);
                count++;
            }
        }
        System.out.println("count  :" + count);
    }
}
