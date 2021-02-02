package com.akgarg.dsalgo.arrays;

public class MinimumNumberOfJumps {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
//        int[] array = {1, 4, 3, 2, 6, 7};
//        int[] array = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
        System.out.println("Minimum jumps required is : " + minimumJumps(array));
    }

    private static int minimumJumps(int[] array) {
        int n = array.length;

        if (n <= 1) {
            return 0;
        }

        int jumps = 1;  // how many jumps made
        int maxReachable = array[0];    // holds the value of index (how many maximum steps can be taken from index i)
        int stepsPossible = array[0];   // holds the remaining number of indices that can be covered from current maxReachable source index

        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                return jumps;
            }
            maxReachable = Math.max(maxReachable, i + array[i]);
            stepsPossible -= 1;

            if (stepsPossible == 0) {
                jumps += 1;

                if (i >= maxReachable) {
                    return -1;
                }

                stepsPossible = maxReachable - i;
            }
        }

        return jumps;
    }
}
