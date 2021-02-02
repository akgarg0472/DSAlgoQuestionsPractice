package com.akgarg.dsalgo.arrays;

public class TappingRainWater {
    private static int leftMaximum = 0;
    private static int rightMaximum = 0;

    public static void main(String[] args) {
//        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] array = {3, 0, 0, 2, 0, 4};
//        int[] array = {7, 4, 0, 9};
//        int[] array = {6, 9, 9};
//        int[] array = {4, 2, 0, 3, 2, 5};
//        int[] array = {3, 0, 2, 0, 4};
        int[] array = {0, 2, 1, 3, 0, 1, 2, 1, 2, 1};
        System.out.println("Total Trapped water is (Brute Force) : " + getTotalTrappedWater(array));
        System.out.println("Total Trapped water is : " + trappedWater(array));
    }

    // brute force
    private static int getTotalTrappedWater(int[] array) {
        int trappedWater = 0;

        for (int i = 0; i < array.length; i++) {
            leftMaximum = getLeftMaximum(array, i);
            rightMaximum = getRightMaximum(array, i);

            int temp = Math.min(leftMaximum, rightMaximum) - array[i];
            if (temp > 0) {
                trappedWater += temp;
            }
        }
        return trappedWater;
    }

    private static int getLeftMaximum(int[] array, int index) {
        int minIndexHeight = array[0];

        for (int i = 0; i < index; i++) {
            if (minIndexHeight < array[i]) {
                minIndexHeight = array[i];
            }
        }
        return minIndexHeight;
    }

    private static int getRightMaximum(int[] array, int index) {
        int maxIndexHeight = array[index];

        for (int i = index; i < array.length; i++) {
            if (maxIndexHeight < array[i]) {
                maxIndexHeight = array[i];
            }
        }
        return maxIndexHeight;
    }

    private static int trappedWater(int[] array) {
        int trap = 0;

        int leftIndex = 0;
        int rightIndex = array.length - 1;

        leftMaximum = array[leftIndex];
        rightMaximum = array[rightIndex];

        while (leftIndex < rightIndex) {
            if (array[leftIndex] <= array[rightIndex]) {
                leftIndex += 1;
                leftMaximum = Math.max(leftMaximum, array[leftIndex]);
                trap += (leftMaximum - array[leftIndex]);
            } else {
                rightIndex -= 1;
                rightMaximum = Math.max(rightMaximum, array[rightIndex]);
                trap += (rightMaximum - array[rightIndex]);
            }
        }
        return trap;
    }
}
