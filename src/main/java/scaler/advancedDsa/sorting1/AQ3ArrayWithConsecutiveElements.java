package scaler.advancedDsa.sorting1;

import java.util.Arrays;

public class AQ3ArrayWithConsecutiveElements {
    //    Problem Description
//    Given an array of positive integers A, check and return whether the array elements are consecutive or not.
//    NOTE: Try this with O(1) extra space.
//    Problem Constraints
//1 <= length of the array <= 100000
//            1 <= A[i] <= 10^9
//    Input Format
//    The only argument given is the integer array A.
//            Output Format
//    Return 1 if the array elements are consecutive else return 0.
//    Example Input
//    Input 1:
//    A = [3, 2, 1, 4, 5]
//    Input 2:
//    A = [1, 3, 2, 5]
//    Example Output
//    Output 1:
//            1
//    Output 2:
//            0
//    Example Explanation
//    Explanation 1:
//    As you can see all the elements are consecutive, so we return 1.
//    Explanation 2:
//    Element 4 is missing, so we return 0.
    public static void main(String[] args) {
        int[] input1A = {3, 2, 1, 4, 5};
        System.out.println(new AQ3ArrayWithConsecutiveElements().solve(input1A));
        int[] input2A = {1, 3, 2, 5};
        System.out.println(new AQ3ArrayWithConsecutiveElements().solve(input2A));
        int[] input3A = {285, 223, 327, 320, 107, 127, 266, 277, 324, 282, 322, 260, 257, 87, 288, 321, 269, 86, 69, 206, 66, 165, 160, 67, 316, 216, 161, 118, 330, 337, 274, 145, 256, 318, 250, 187, 273, 68, 105, 193, 314, 137, 77, 336, 287, 120, 334, 278, 281, 279, 289, 299, 291, 307, 190, 212, 286, 113, 227, 226, 301, 300, 174, 270, 123, 317, 275, 338, 202, 205, 70, 101, 344, 271, 102, 312, 157, 224, 201, 106, 88, 292, 305, 343, 246, 328, 138, 148, 315, 254, 108, 229, 346, 350, 255, 304, 247, 302, 208, 85, 158, 63, 225, 147, 172, 64, 78, 89, 258, 109, 323, 237, 80, 191, 110, 283, 83, 221, 296, 111, 72, 71, 155, 140, 95, 252, 126, 90, 91, 114, 228, 163, 303, 197, 162, 248, 75, 339, 116, 92, 209, 198, 139, 112, 276, 143, 306, 319, 180, 173, 325, 184, 335, 326, 156, 240, 293, 115, 261, 340, 290, 351, 58, 117, 341, 241, 329, 311, 119, 232, 121, 192, 135, 308, 213, 182, 313, 253, 146, 103, 214, 124, 331, 332, 230, 349, 194, 333, 259, 211, 284, 294, 342, 166, 309, 195, 73, 264, 164, 233, 98, 345, 74, 136, 239, 122, 231, 167, 175, 183, 93, 125, 84, 263, 200, 347, 132, 295, 128, 129, 177, 130, 280, 94, 234, 168, 297, 141, 104, 142, 207, 262, 131, 298, 144, 76, 154, 310, 57, 348, 59, 60, 265, 152, 61, 153, 62, 236, 65, 242, 235, 79, 176, 149, 133, 81, 82, 96, 169, 97, 210, 170, 99, 268, 151, 100, 251, 134, 150, 267, 159, 171, 272, 178, 196, 179, 203, 181, 185, 186, 188, 189, 199, 243, 204, 215, 217, 218, 238, 219, 220, 222, 244, 245, 249};
        System.out.println(new AQ3ArrayWithConsecutiveElements().solve(input3A));
    }

    public int solve(int[] A) {
        //bubbleSort(A);
        mergeSort(A, 0, A.length - 1);
//        System.out.println(Arrays.toString(A));
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] + 1 != A[i + 1]) {
                return 0;
            }
        }
        return 1;
    }

    private void mergeSort(int[] a, int l, int r) {
        if (l == r)
            return;
        int mid = (r + l) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(l, r, a, mid + 1);
    }

    private void merge(int l, int r, int[] arr, int y) {
//        System.out.printf("l=%s,r=%s,y=%s,arr=%s%n", l, r, y, Arrays.toString(arr));
        int i = l;
        int j = y;
        int index = 0;
        int[] ansArr = new int[r - l + 1];
        while (i <= y - 1 && j <= r) {
            if (arr[i] <= arr[j]) {
                ansArr[index++] = arr[i++];
            } else {
                ansArr[index++] = arr[j++];
            }
        }
        while (i <= y - 1) {
            ansArr[index++] = arr[i++];
        }
        while (j <= r) {
            ansArr[index++] = arr[j++];
        }
        i = l;
        for (int k = 0; k < ansArr.length; k++) {
            arr[i++] = ansArr[k];
        }
    }


    private void bubbleSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }
}
