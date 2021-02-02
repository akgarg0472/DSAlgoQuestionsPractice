package com.akgarg.dsalgo.arrays;

import java.util.Arrays;

public class KthMaxAndMinArrayElement {

//    Given an array arr[] and a number K where K is smaller than size of array.
//    The task is to find the Kth smallest element in the given array.
//    It is given that all array elements are distinct.

    public static void main(String[] args) {
        int[] array = new int[]{
                7, 4, 6, 3, 9, 1
        };

        int k = 2;

        KthElement element = new KthElement(array, k);

        System.out.println("Kth maximum element : " + element.getKthMaxElement());
        System.out.println("Kth minimum element : " + element.getKthMinElement());
    }
}

class KthElement {
    private int[] array;
    private int k;

    KthElement(int[] array, int k) {
        this.array = array;
        this.k = k;
        Arrays.sort(array);
    }

    int getKthMaxElement() {
        return this.array[array.length - k];
    }

    int getKthMinElement() {
        return this.array[k - 1];
    }
}
