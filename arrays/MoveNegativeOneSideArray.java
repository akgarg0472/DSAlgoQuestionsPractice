package com.akgarg.dsalgo.arrays;

public class MoveNegativeOneSideArray {
    public static void main(String[] args) {
        int[] array = new int[]{
                -1, 2, -3, 4, 5, 6, -7, 8, 9
        };

        moveElements(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void moveElements(int[] array) {
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
                index += 1;
            }
        }
    }
}
