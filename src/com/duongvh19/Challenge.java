package com.duongvh19;

import java.util.function.Function;
import java.util.function.Supplier;

public class Challenge {

    public static void main(String[] args) {

        //Challenge 1
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.print(part + "\t");
                }
            }
        };

        Runnable r = () -> {
            String myString = "Let's split this up an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.print(part + "\t");
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(r);
        t2.start();

        //Challenge 2

        Function<String, String> lambdaFunction = s1 -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s1.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s1.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(lambdaFunction.apply("12345678"));

        //Challenge 4,5

        String result = secondChar(lambdaFunction, "1234567890");
        System.out.println(result);

        //Challenge 6
        Supplier<String> iLoveJava = () -> "I love Java!";
        System.out.println(iLoveJava.get());

    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static String secondChar(Function<String, String> func, String source) {
        return func.apply(source);
    }
}
