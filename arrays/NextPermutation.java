package com.akgarg.dsalgo.arrays;

public class NextPermutation {
    public static void main(String[] args) {
//        int[] array = {3, 2, 1};
//        int[] array = {1, 3, 2};
//        int[] array = {1, 1, 5};
        int[] array = {4, 5, 6, 3, 2, 1};
        getNextPermutation(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void getNextPermutation(int[] array) {
        // return if the array contains only one element or array is empty
        if (array.length <= 1) {
            return;
        }

        int k = array.length - 2; //variable used to check how much array is sorted in ascending order from last
        while (array[k] >= array[k + 1]) {
            k -= 1;
            // case when there is no more next permutation available for given input numbers
            if (k == -1) {
                reverseArray(array, 0, array.length - 1);
                return;
            }
        }

        // if whole array of integers is not in ascending order from end, then check up to where it is sorted and
        // then swap the number greater than that of number at kth index(index less than one of the index up to where array is sorted) and then stop current loop.
        for (int i = array.length - 1; i > k; i--) {
            if (array[i] > array[k]) {
                swap(array, k, i);
                break;
            }
        }
        // now if array is in ascending order from en, it means that we have traversed all possible permutation up to now,
        // so reversing the sorted array to again start checking for next possible permutation
        reverseArray(array, k + 1, array.length - 1);
    }

    // helper method to reverse array from an index to an index
    private static void reverseArray(int[] array, int i, int j) {
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i += 1;
            j -= 1;
        }
    }

    // helper method to swap two array elements
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
