package com.akgarg.dsalgo.other;

public class NthFibonacciTerm {
    public static void main(String[] args) {
        System.out.println("8th term of fibonacci series is : " + nFibonacciTerm(8));
        System.out.println("9th term of fibonacci series is : " + nFibonacciTerm(9));
        System.out.println("10th term of fibonacci series is : " + nFibonacciTerm(10));
    }

    private static int nFibonacciTerm(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        return nFibonacciTerm(n - 1) + nFibonacciTerm(n - 2);
    }
}
