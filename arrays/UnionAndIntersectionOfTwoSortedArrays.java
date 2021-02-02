package com.akgarg.dsalgo.arrays;

import java.util.ArrayList;

public class UnionAndIntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arrayOne = new int[]{
                1, 3, 4, 5, 7
        };
        int[] arrayTwo = new int[]{
                2, 3, 5, 6
        };

        System.out.println("Union of two Arrays is : " + findUnion(arrayOne, arrayTwo));
        System.out.println("InterSection of two Arrays is : " + findIntersection(arrayOne, arrayTwo));
    }

    private static ArrayList<Integer> findUnion(int[] arrayOne, int[] arrayTwo) {
        ArrayList<Integer> elements = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j]) {
                if (!elements.contains(arrayOne[i])) {
                    elements.add(arrayOne[i]);
                }
                i += 1;

            } else if (arrayOne[i] > arrayTwo[j]) {
                if (!elements.contains(arrayTwo[j])) {
                    elements.add(arrayTwo[j]);
                }
                j += 1;

            } else {
                if (!elements.contains(arrayOne[i])) {
                    elements.add(arrayOne[i]);
                }
                i += 1;
                j += 1;
            }
        }

        while (i < arrayOne.length) {
            if (!elements.contains(arrayOne[i])) {
                elements.add(arrayOne[i]);
            }
            i += 1;
        }

        while (j < arrayTwo.length) {
            if (!elements.contains(arrayTwo[j])) {
                elements.add(arrayTwo[j]);
            }
            j += 1;
        }

        return elements;
    }

    private static ArrayList<Integer> findIntersection(int[] arrayOne, int[] arrayTwo) {
        ArrayList<Integer> elements = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j]) {
                i += 1;
            } else if (arrayTwo[j] < arrayOne[i]) {
                j += 1;
            } else {
                elements.add(arrayOne[i]);
                i += 1;
                j += 1;
            }
        }

        return elements;
    }
}
