package com.virtualpairprogrammers.application;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
// Functional Programming
public class JavaExamples {

    public static Function<String, String> toSentenceCase = x -> x.substring(0,1).toUpperCase() + x.substring(1);

    public static String applySomeFuctionToAString(String inputString, Function<String, String> myFunction) {
        return myFunction.apply(inputString);
    }

    public static void main(String args[]) {
        String result = applySomeFuctionToAString("hello", x -> x.toUpperCase());
        System.out.println(result);
        String result2 = applySomeFuctionToAString("hello", toSentenceCase);
        System.out.println(result2);


        List<String> colors = new ArrayList<String>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("black");

        List<String> upperCaseColors = new ArrayList<String>();
        for (String color: colors) {
            upperCaseColors.add(color.toUpperCase());
        }
        for (String color : upperCaseColors) {
            System.out.println(color);
        }
    }
}
