package com.akgarg.dsalgo.arrays;

import java.util.Stack;

public class InversionCount {
    public static void main(String[] args) {
//        int[] array = {2, 4, 1, 3, 5};
//        int[] array = {2, 3, 4, 5, 6};
//        int[] array = {10, 10, 10};
        int[] array = {8, 4, 2, 1};
        System.out.println("\nInversion count is : " + getInversionCount(array));
    }

    private static int getInversionCount(int[] array) {
        int inversionCount = 0;
        boolean isSorted = false;

        // checking if array is already in ascending sorting order
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                isSorted = true;
            } else {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            return 0;
        }

        Stack<InversionPairs> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    inversionCount += 1;
                    stack.push(new InversionPairs(array[i], array[j]));
                }
            }
        }

        // printing all pairs if there is any
        for (InversionPairs ip : stack) {
            System.out.print(ip + ", ");
        }

        return inversionCount;
    }
}

class InversionPairs {
    private int firstValue;
    private int secondValue;

    InversionPairs(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Override
    public String toString() {
        return "(" + firstValue + ", " + secondValue + ")";
    }
}