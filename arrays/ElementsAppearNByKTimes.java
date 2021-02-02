package com.akgarg.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

public class ElementsAppearNByKTimes {
    public static void main(String[] args) {
        int[] array = {3, 1, 2, 2, 1, 2, 3, 3};
        int k = 4;
        System.out.println("Elements appearing more than n/k times are : " + getElements(array, k));
    }

    // complexity is O(n) because traversing array one time and one time traversing HashMap
    private static String getElements(int[] array, int k) {
        if (k < 2) {
            return "";
        }

        String result = "";

        HashMap<Integer, Integer> map = new HashMap<>();

        int requiredFrequency = (array.length / k) + 1;

        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int prevValue = map.get(array[i]);
                map.put(array[i], prevValue + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= requiredFrequency) {
                result += entry.getKey() + " ";
            }
        }
        return result;
    }
}
