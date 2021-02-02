package com.akgarg.dsalgo.arrays;

import java.util.HashSet;

public class ArraySubsetOfArray {
    public static void main(String[] args) {
        int[] arrayOne = {11, 1, 13, 21, 3, 7};
        int[] arrayTwo = {11, 3, 7, 1};
//        int[] arrayOne = {10, 5, 2, 23, 19};
//        int[] arrayTwo = {19, 5, 3};
        System.out.println("is arrayTwo subArray of arrayOne (Brute Force) : " + isSubset(arrayOne, arrayTwo));
        System.out.println("is arrayTwo subArray of arrayOne (Hashing) : " + isArraySubset(arrayOne, arrayTwo));
    }

    // Time complexity O(m*n) and space complexity O(n)
    private static boolean isSubset(int[] arrayOne, int[] arrayTwo) {
        int[] temp = new int[arrayTwo.length];

        for (int i = 0; i < arrayTwo.length; i++) {
            for (int j = 0; j < arrayOne.length; j++) {
                if (arrayTwo[i] == arrayOne[j]) {
                    temp[i] = 1;
                }
            }
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                return false;
            }
        }

        return true;
    }

    // time complexity O(m+n) if we have good hash function implemented and space complexity O(n)
    private static boolean isArraySubset(int[] arrayOne, int[] arrayTwo) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arrayOne.length; i++) {
            if (!set.contains(arrayOne[i])) {
                set.add(arrayOne[i]);
            }
        }

        for (int i = 0; i < arrayTwo.length; i++) {
            if (!set.contains(arrayTwo[i])) {
                return false;
            }
        }

        return true;
    }
}