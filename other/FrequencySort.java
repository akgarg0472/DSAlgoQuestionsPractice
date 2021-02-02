package com.akgarg.dsalgo.other;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(2);
        array.add(1);
        array.add(3);
        array.add(2);
        array.add(1);
        array.add(2);
        System.out.print("Original array is: ");
        System.out.println(array);
        System.out.print("Array after sorting is: ");
        frequencySort(array);
        System.out.println(array);
    }

    private static void frequencySort(List<Integer> array) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer integer : array) {
            if (!map.containsKey(integer)) {
                map.put(integer, 1);
            } else {
                map.replace(integer, map.get(integer) + 1);
            }
        }

        Collections.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int frequencyOne = map.get(o1);
                int frequencyTwo = map.get(o2);

                if (frequencyOne != frequencyTwo) {
                    return frequencyTwo - frequencyOne;
                } else if (frequencyOne == frequencyTwo) {
                    return array.indexOf(o1) - array.indexOf(o2);
                }

                return o1 - o2;
            }
        });
    }
}
