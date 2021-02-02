package com.akgarg.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
//        int[] array = {1, 9, 3, 10, 4, 20, 2};
        int[] array = {2, 6, 1, 9, 4, 5, 3};
        System.out.println("Longest consecutive subsequence length : " + getLongestConsecutiveSubsequenceLength(array));
        System.out.println("Longest consecutive subsequence length (Efficient) : " + getConsecutiveSubsequenceLength(array));
    }

    // average efficiency because sorting of array takes O(n log n) and O(n) space complexity (ArrayList)
    private static int getLongestConsecutiveSubsequenceLength(int[] array) {
        if (array.length <= 1) {
            return array.length;
        }

        int length = 0;
        int currentLength = 0;
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                list.add(array[i]);
            } else {
                if (array[i] != list.get(i - 1)) {
                    list.add(array[i]);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) + 1) {
                currentLength += 1;
            } else {
                currentLength = 1;
            }
            length = Math.max(length, currentLength);
        }
        return length;
    }


    private static int getConsecutiveSubsequenceLength(int[] array) {
        if (array.length == 1) {
            return 1;
        }

        HashSet<Integer> set = new HashSet<>();
        int length = 0;

        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i] - 1)) {
                int j = array[i];

                while (set.contains(j)) {
                    j += 1;
                }

                if (length < j - array[i]) {
                    length = j - array[i];
                }
            }
        }

        return length;
    }
}
