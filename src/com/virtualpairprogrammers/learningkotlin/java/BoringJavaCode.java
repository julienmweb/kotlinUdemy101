package com.virtualpairprogrammers.learningkotlin.java;

import java.math.BigDecimal;
import java.util.Random;

public class BoringJavaCode {
    public static void main(String args[]) {
        String name = "Matt";

        // Casting in java
        Object result;
        Integer randomNumber = new Random().nextInt(3);
        if (randomNumber == 1) {
            result = new BigDecimal(30);
        } else {
            result = "Hello";
        }
        System.out.println("Result is currently " + result);

        if (result instanceof BigDecimal) {
            result = ((BigDecimal)result).add(new BigDecimal(47));
        } else {
            String tempResult = (String) result;
            result = tempResult.toUpperCase();
        }

        System.out.println("Result is currently " + result);

        ///////////////: Exception
        try {
            Thread.sleep(1000); // if there s no try catch or throw exception in method signature Unhandled exception: java.lang.InterruptedException
            System.out.println(divide(6,3));
        } catch (InterruptedException e) {

        }
    }

    public static Double divide(int a, int b) throws InterruptedException {
        Thread.sleep(1000);
        return (double) a / b;
    }
}
