package com.akgarg.dsalgo.arrays;

public class SortArray012 {
    public static void main(String[] args) {
        int[] array = new int[]{
                0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1
        };

        sortArray(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void sortArray(int[] array) {
        int size = array.length;
        int zeroIndex = 0;
        int oneIndex = 0;
        int twoIndex = size - 1;

        while (oneIndex <= twoIndex) {
            if (array[oneIndex] == 0) {
                swap(array, zeroIndex, oneIndex);
                zeroIndex += 1;
                oneIndex += 1;
            } else if (array[oneIndex] == 1) {
                oneIndex += 1;
            } else if (array[oneIndex] == 2) {
                swap(array, oneIndex, twoIndex);
                twoIndex -= 1;
            }
        }
    }

    private static void swap(int[] array, int indexFirst, int indexSecond) {
        int temp = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = temp;
    }
}
