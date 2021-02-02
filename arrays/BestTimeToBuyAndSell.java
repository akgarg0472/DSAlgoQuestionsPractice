package com.akgarg.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class BestTimeToBuyAndSell {
    public static void main(String[] args) {
        int[] array = new int[]{
                7, 1, 5, 3, 6, 4
        };
//        int[] array = new int[]{
//                7, 6, 4, 3, 1
//        };

        System.out.println("Maximum Profit is : " + getMaximumProfit(array));
    }

    private static int getMaximumProfit(int[] array) {
        if (array.length == 1) {
            return 0;
        }

        ArrayList<Integer> record = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int profit = array[j] - array[i];
                if (profit > 0) {
                    record.add(profit);
                }
            }
        }

        try {
            return Collections.max(record);
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
}