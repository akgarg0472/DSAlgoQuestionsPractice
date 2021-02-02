package com.akgarg.dsalgo.arrays;

import java.util.Arrays;

public class DuplicateInArrayOfNPlusOneIntegers {
    public static void main(String[] args) {
        int[] array = {1, 2, 1};

        System.out.println("Duplicate Element is : " + getDuplicateElement(array) + " (Using Brute Force method)");
        System.out.println("Duplicate Element is : " + getDuplicateElementEfficient(array) + " (Using Sorted array method)");
    }

    // Brute Force Method in O(n^2)
    private static int getDuplicateElement(int[] array) {
        int index;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return array[i];
                }
            }
        }
        return -1;
    }

    // Using Sorted data to find duplicate element in O(n log n)
    private static int getDuplicateElementEfficient(int[] array) {
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[i + 1]) {
                return array[i];
            }
        }
        return -1;
    }
}
