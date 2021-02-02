package com.akgarg.dsalgo.arrays;

import java.math.BigInteger;

public class FactorialOfLargeNumber {
    public static void main(String[] args) {
        System.out.println("Factorial of 1000 is : " + getFactorial(1000));
    }

    private static BigInteger getFactorial(int number) {
        BigInteger factorial = new BigInteger("1");

        while (number >= 1) {
            BigInteger temp = factorial.multiply(BigInteger.valueOf(number));
            factorial = temp;
            number -= 1;
        }

        return factorial;
    }
}
