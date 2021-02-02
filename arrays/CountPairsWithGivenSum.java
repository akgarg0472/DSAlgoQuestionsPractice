package com.akgarg.dsalgo.arrays;

import java.util.HashMap;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
//        int[] array = {1, 5, 7, 1};
//        int k = 6;
//
//        int[] array = {1, 1, 1, 1};
//        int k = 2;

        int[] array = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
        int k = 11;

        System.out.println("Number of pairs (Brute Force) : " + getNumberOfPairs(array, k));
        System.out.println("Number of pairs (Optimized) : " + getPairsCount(array, k));
    }

    // brute force method O(n^2)
    private static int getNumberOfPairs(int[] array, int k) {
        if (array.length == 1) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == k) {
                    count += 1;
                }
            }
        }

        return count;
    }

    // Optimized method O(n)
    private static int getPairsCount(int[] array, int k) {
        if (array.length == 1) {
            return 0;
        }

        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (!hashMap.containsKey(array[i])) {
                hashMap.put(array[i], 1);
            } else {
                int previousFrequency = hashMap.get(array[i]);
                hashMap.replace(array[i], previousFrequency + 1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (hashMap.get(k - array[i]) != null) {
                count += hashMap.get(k - array[i]);
            }

            if (k - array[i] == array[i]) {
                count -= 1;
            }
        }

        return count / 2;
    }
}
