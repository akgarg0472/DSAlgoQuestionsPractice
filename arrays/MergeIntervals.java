package com.akgarg.dsalgo.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {
    public static void main(String[] args) {
//        Interval[] array = new Interval[]{
//                new Interval(1, 3),
//                new Interval(2, 6),
//                new Interval(8, 10),
//                new Interval(15, 18)
//        };
//        Interval[] array = new Interval[]{
//                new Interval(6, 8),
//                new Interval(1, 9),
//                new Interval(2, 4),
//                new Interval(4, 7)
//        };
//        Interval[] array = new Interval[]{
//                new Interval(1, 3),
//                new Interval(2, 4),
//                new Interval(5, 7),
//                new Interval(6, 8)
//        };
        Interval[] array = new Interval[]{
                new Interval(1, 5),
                new Interval(2, 3),
                new Interval(4, 6),
                new Interval(7, 8),
                new Interval(8, 10),
                new Interval(12, 15)
        };
//        Interval[] array = new Interval[]{
//                new Interval(5, 7),
//                new Interval(6, 8)
//        };

        mergeIntervals(array);
    }

    private static void mergeIntervals(Interval[] array) {
        // if there is no element in the array
        if (array.length == 0) {
            return;
        }

        // stack to store the merged set(s)
        Stack<Interval> stack = new Stack<>();

        // sorting intervals according to their start value using custom comparator
        Arrays.sort(array, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getStart() - o2.getStart();
            }
        });

        // pushing first interval to the stack for calculations
        stack.push(array[0]);

        for (int i = 1; i < array.length; i++) {
            Interval top = stack.peek();

            // if two intervals are not merging, then add second one to the stack
            if (top.getEnd() < array[i].getStart()) {
                stack.push(array[i]);
            }
            // if two intervals can be merged then merging according to the logic
            else if (top.getEnd() >= array[i].getStart()) {
                stack.pop();
                top.setEnd(array[i].getEnd());
                stack.push(top);
            }
        }

        // printing sets after merging intervals
        for (Interval i : stack) {
            System.out.println(i.getStart() + ", " + i.getEnd());
        }
    }
}

class Interval {
    private int start;
    private int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    int getStart() {
        return start;
    }

    int getEnd() {
        return end;
    }

    void setEnd(int end) {
        this.end = end;
    }
}
