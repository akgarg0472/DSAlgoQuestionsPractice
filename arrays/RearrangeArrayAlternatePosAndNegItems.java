package com.akgarg.dsalgo.arrays;

import java.util.ArrayList;

public class RearrangeArrayAlternatePosAndNegItems {
    public static void main(String[] args) {
//        int[] array = {2, 3, -4, -1};
//        int[] array = {1, 2, 3, -4, -1, 4};
        int[] array = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4};
        System.out.println("Arranged array is : " + getArrangedArray(array));
    }

    private static ArrayList<Integer> getArrangedArray(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0;
        int j = array.length - 1;

        while (i <= j) {
            if (array[i] < 0 && array[j] > 0) {
                swap(array, i, j);
                i += 1;
                j -= 1;
            } else if (array[i] > 0 && array[j] < 0) {
                i += 1;
                j -= 1;
            } else if (array[i] > 0) {
                i += 1;
            } else if (array[j] < 0) {
                j -= 1;
            }
        }

        for (int p : array) {
            System.out.print(p + " ");
        }
        System.out.println();

        // i holds the index of first negative number
        j = 0;  // used to traverse the array from start

        while (i < array.length) {
            swap(array, j, i);
            swap(array, j + 1, i);
            j += 2;
            swap(array, j, i);
            i += 1;
        }

        for (int in : array) {
            list.add(in);
        }

        return list;
    }

    private static void swap(int[] array, int i, int j) {
        if (i < array.length && j < array.length) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
