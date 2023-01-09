package scaler.common;

import java.util.Arrays;

public class Heap {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Heap.buildMinHeap(new int[]{20, 18, 10, 12, 9, 9, 3, 5, 6, 8})));
        System.out.println(Arrays.toString(Heap.buildMaxHeap(new int[]{3, 5, 9, 6, 8, 20, 10, 12, 18, 9})));
        System.out.println(Arrays.toString(Heap.buildMinHeap(new int[]{21, 16, 12, 3, 13, 7, 9})));
        System.out.println(Arrays.toString(Heap.buildMaxHeap(new int[]{3, 13, 7, 16, 21, 12, 9})));
    }

    public static int[] buildMinHeap(int[] A) {
        for (int i = (A.length / 2) - 1; i >= 0; i--) {
            minHeapify(A, i);
        }
        return A;
    }

    public static int[] buildMaxHeap(int[] A) {
        for (int i = (A.length / 2) - 1; i >= 0; i--) {
            maxHeapify(A, i);
        }
        return A;
    }

    public static int getMinFromMinHeap(int[] A) {
        if (A != null)
            return A[0];
        else
            return Integer.MAX_VALUE;
    }

    public static int getMaxFromMaxHeap(int[] A) {
        if (A != null)
            return A[0];
        else
            return Integer.MIN_VALUE;
    }

    public static int[] extractMaxFromMaxHeap(int[] A) {
        int[] arr = new int[A.length - 1];
        int max = A[A.length - 1];
        A[0] = A[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            arr[i] = A[i];
        }
        buildMaxHeap(arr);
        return arr;
    }

    public static int[] extractMinFromMinHeap(int[] A) {
        int[] arr = new int[A.length - 1];
        int min = A[A.length - 1];
        A[0] = A[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            arr[i] = A[i];
        }
        buildMinHeap(arr);
        return arr;
    }

    public static int[] insertMinHeap(int[] A, int newElement) {
        int[] arr = new int[A.length + 1];
        int i = 0;
        for (; i < A.length; i++) {
            arr[i] = A[i];
        }
        arr[i] = newElement;
//        for (int j = (arr.length / 2) - 1; j >= 0; j--) {
//            minHeapify(arr, j);
//        }
        buildMinHeap(arr);
        return arr;
    }

    public static int[] insertMaxHeap(int[] A, int newElement) {
        int[] arr = new int[A.length + 1];
        int i = 0;
        for (; i < A.length; i++) {
            arr[i] = A[i];
        }
        arr[i] = newElement;
//        for (int j = (arr.length / 2) - 1; j >= 0; j--) {
//            maxHeapify(arr, j);
//        }
        buildMaxHeap(arr);
        return arr;
    }

    public static void minHeapify(int[] A, int i) {
        while (2 * i + 1 < A.length) {
            int rc;
            if (2 * i + 2 < A.length)
                rc = A[2 * i + 2];
            else
                rc = Integer.MAX_VALUE;
            int min = Math.min(A[i], Math.min(A[2 * i + 1], rc));
            if (min == A[i]) {
                break;
            } else if (min == A[2 * i + 1]) {
                int temp = A[i];
                A[i] = A[2 * i + 1];
                A[2 * i + 1] = temp;
                i = 2 * i + 1;
            } else if (min == A[2 * i + 2]) {
                int temp = A[i];
                A[i] = A[2 * i + 2];
                A[2 * i + 2] = temp;
                i = 2 * i + 2;
            }
        }
    }

    public static void maxHeapify(int[] A, int i) {
        while (2 * i + 1 < A.length) {
            int rc;
            if (2 * i + 2 < A.length)
                rc = A[2 * i + 2];
            else
                rc = Integer.MIN_VALUE;
            int max = Math.max(A[i], Math.max(A[2 * i + 1], rc));
            if (max == A[i]) {
                break;
            } else if (max == A[2 * i + 1]) {
                int temp = A[i];
                A[i] = A[2 * i + 1];
                A[2 * i + 1] = temp;
                i = 2 * i + 1;
            } else if (max == A[2 * i + 2]) {
                int temp = A[i];
                A[i] = A[2 * i + 2];
                A[2 * i + 2] = temp;
                i = 2 * i + 2;
            }
        }
    }
}
