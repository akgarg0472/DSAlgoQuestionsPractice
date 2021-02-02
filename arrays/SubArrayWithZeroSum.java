package com.akgarg.dsalgo.arrays;

import java.util.HashSet;
import java.util.Stack;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
//        int[] array = {4, 2, -3, 1, 6};
//        int[] array = {4, 2, 0, 1, 6};
        int[] array = {4, 2, -3, -1, 0, 4};
        System.out.println("Any subArray with sum zero (Brute force) : " + isSubArrayWithZeroSum(array));
        System.out.println("Any subArray with sum zero (HashSet optimized) : " + subArrayWithZeroSum(array));
    }

    // brute force method O(n^2)
    private static String isSubArrayWithZeroSum(int[] array) {
        if (array.length == 1 && array[0] == 0) {
            return "Yes";
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            stack.removeAllElements();

            int sum = array[i];
            stack.push(array[i]);

            if (sum == 0) {
                System.out.println(stack);
                return "Yes";
            }

            for (int j = i + 1; j < array.length; j++) {
                sum += array[j];
                stack.push(array[j]);
                if (sum == 0) {
                    System.out.println(stack);
                    return "Yes";
                }
            }
        }
        return "No";
    }

    // hashSet (optimized approach O(n) )
    private static String subArrayWithZeroSum(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (array[i] == 0 || sum == 0 || set.contains(sum)) {
                return "Yes";
            }

            set.add(sum);
        }
        return "No";
    }
}
