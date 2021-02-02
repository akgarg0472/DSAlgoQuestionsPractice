package com.akgarg.dsalgo.arrays;

import java.util.ArrayList;

public class CommonElementsInThreeSortedArrays {
    public static void main(String[] args) {
        int[] arrayOne = {1, 5, 10, 20, 40, 80};
        int[] arrayTwo = {6, 7, 20, 80, 100};
        int[] arrayThree = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.println("Common Elements are (Brute Force) : " + getCommonElements(arrayOne, arrayTwo, arrayThree));
        System.out.println("Common Elements are (Optimized) : " + getAllCommonElements(arrayOne, arrayTwo, arrayThree));
    }

    // brute force O(n^3)
    private static ArrayList<Integer> getCommonElements(int[] arrayOne, int[] arrayTwo, int[] arrayThree) {
        ArrayList<Integer> commonElements = new ArrayList<>();

        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                for (int k = 0; k < arrayThree.length; k++) {
                    if (arrayOne[i] == arrayTwo[j] && arrayTwo[j] == arrayThree[k]) {
                        commonElements.add(arrayThree[k]);
                    }
                }
            }
        }
        return commonElements;
    }

    // optimized approach O(n1+n2+n3), in this approach simply traversing all three arrays at once without using nested loops

    private static ArrayList<Integer> getAllCommonElements(int[] arrayOne, int[] arrayTwo, int[] arrayThree) {
        ArrayList<Integer> commonElements = new ArrayList<>();

        int i = 0;  // variable to traverse arrayOne index
        int j = 0;  // variable to traverse arrayTwo index
        int k = 0;  // variable to traverse arrayThree index

        while (i < arrayOne.length && j < arrayTwo.length && k < arrayThree.length) {
            if (arrayOne[i] == arrayTwo[j] && arrayTwo[j] == arrayThree[k]) {
                commonElements.add(arrayOne[i]);
                i += 1;
                j += 1;
                k += 1;
            } else if (arrayOne[i] < arrayTwo[j]) {
                i += 1;
            } else if (arrayTwo[j] < arrayThree[k]) {
                j += 1;
            } else {
                k += 1;
            }
        }
        return commonElements;
    }
}
