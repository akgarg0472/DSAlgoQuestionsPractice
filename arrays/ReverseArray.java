package com.akgarg.dsalgo.arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] array = new int[]{
                1,2,3,4,5,6,7,8,9,10,11
        };

        reverseArray(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    private static void reverseArray(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex < endIndex) {
            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
            startIndex += 1;
            endIndex -= 1;
        }
    }
}
