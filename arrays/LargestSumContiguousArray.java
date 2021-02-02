package com.akgarg.dsalgo.arrays;

public class LargestSumContiguousArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, -2, 5};
//        int[] array = {1, -3, 2, 1, -1};
//        int[] array = {-1, -2, -3, -4};
//        int[] array = {-2, 3, 2, -1};
        System.out.println("Maximum sum is " + getMaximumSum(array));
    }

    // Kadane's Algorithm
    private static int getMaximumSum(int[] array) {
        int max_current = array[0];
        int max_global = array[0];

        for (int i = 1; i < array.length; i++) {
            max_current = Math.max(array[i], array[i] + max_current);

            if (max_current > max_global) {
                max_global = max_current;
            }
        }

        return max_global;
    }
}
