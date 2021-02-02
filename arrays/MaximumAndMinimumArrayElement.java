package com.akgarg.dsalgo.arrays;

public class MaximumAndMinimumArrayElement {
    public static void main(String[] args) {
        int[] array = new int[]{
                1000, 11, 445, 1, 330, 3000
        };

        System.out.println("Largest Element is : " + getMaximumArrayElement(array));
        System.out.println("Smallest Element is : " + getMinimumArrayElement(array));
    }

    private static int getMaximumArrayElement(int[] array) {
        int largestElement = array[0];

        if (array.length == 1) {
            return largestElement;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] > largestElement) {
                largestElement = array[i];
            }
        }

        return largestElement;
    }

    private static int getMinimumArrayElement(int[] array) {
        int smallestElement = array[0];

        if (array.length == 1) {
            return smallestElement;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallestElement) {
                smallestElement = array[i];
            }
        }

        return smallestElement;
    }
}
