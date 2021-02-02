package com.akgarg.dsalgo.arrays;

import java.util.Arrays;

public class MaximumDifferenceBetweenHeights {
    public static void main(String[] args) {
//        int[] array = {2, 6, 3, 4, 7, 2, 10, 3, 2, 1};
        int[] array = {1, 5, 15, 10};
        int k = 3;
        System.out.println("Minimum Difference is : " + getMaximumDifference(array, k));
    }

    private static int getMaximumDifference(int[] array, int k) {
        int answer;
        int small;
        int big;
        int n = array.length;

        Arrays.sort(array);

        answer = array[n - 1] - array[0];
        big = array[n - 1] - k;
        small = array[0] + k;

        if (small > big) {
            int temp = small;
            small = big;
            big = small;
        }

        for (int i = 1; i < n - 1; i++) {
            int subtract = array[i] - k;
            int addition = array[i] + k;

            if (subtract >= small || addition <= big) {
                continue;
            }

            if (big - subtract <= addition - small) {
                small = subtract;
            } else {
                big = addition;
            }
        }

        return Math.min(answer, big - small);
    }
}
