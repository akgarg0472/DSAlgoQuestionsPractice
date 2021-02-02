package com.akgarg.dsalgo.arrays;

import java.util.Collections;
import java.util.Stack;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] array = {6, -3, -10, 0, 2};
//        int[] array = {2, 3, 4, 5, -1, 0};

        System.out.println("Maximum product : " + getSubArray(array));
    }

    // brute force approach O(n^2)
    private static int getSubArray(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        int product = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }

            product = array[i];
            stack.push(product);

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] != 0) {
                    product *= array[j];
                    stack.push(product);
                } else {
                    stack.push(product);
                    product = 1;
                }
            }
        }

        return Collections.max(stack);
    }
}
