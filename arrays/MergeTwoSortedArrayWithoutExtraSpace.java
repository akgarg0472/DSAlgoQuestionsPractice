package com.akgarg.dsalgo.arrays;

public class MergeTwoSortedArrayWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arrayOne = {1, 5, 9, 10, 15, 20};
        int[] arrayTwo = {2, 3, 8, 13};

        mergeArrays(arrayOne, arrayTwo);
    }

    private static void mergeArrays(int[] arrayOne, int[] arrayTwo) {
        int i = 0;
        int j = 0;

        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j]) {
                System.out.print(arrayOne[i] + " ");
                i += 1;
            } else if (arrayTwo[j] < arrayOne[i]) {
                System.out.print(arrayTwo[j] + " ");
                j += 1;
            } else {
                System.out.print(arrayOne[i] + " ");
                i += 1;
                j += 1;
            }
        }

        while (i < arrayOne.length) {
            System.out.print(arrayOne[i] + " ");
            i += 1;
        }

        while (j < arrayTwo.length) {
            System.out.print(arrayTwo[j] + " ");
            j += 1;
        }
    }
}
