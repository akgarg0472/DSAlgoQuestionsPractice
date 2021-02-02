package com.akgarg.dsalgo.arrays;

public class CyclicallyRotateArrayByOne {
    public static void main(String[] args) {
        int[] array = new int[]{
                9, 8, 7, 6, 4, 2, 1, 3
        };

        cyclicallyRotateArray(array);

        for (int i : array) {
            System.out.print(i + " ");
        }

        // expected output : 9, 1, 2, 3, 4, 5, 6, 7, 8
    }

    private static void cyclicallyRotateArray(int[] array) {
        int lastValue = array[array.length - 1];

        for (int i = array.length - 1; i >= 1; i--) {
            array[i] = array[i - 1];
        }

        array[0] = lastValue;
    }
}