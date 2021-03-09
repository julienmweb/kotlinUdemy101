package com.virtualpairprogrammers.learningkotlin.java;

import java.util.GregorianCalendar;

public class Exercise1 {

    public static void main(String[] Args) {
        JavaPersonEx1 john = new JavaPersonEx1(1L, "Mr", "John", "Blue", new GregorianCalendar(1977,9,3));
        JavaPersonEx1 jane = new JavaPersonEx1(2L, "Mrs", "Jane", "Green", null);
        System.out.println (john + "'s age is " + john.getAge());
        System.out.println (jane + "'s age is " + jane.getAge());
        System.out.println ("The age of someone born on 3rd May 1988 is " + JavaPersonEx1.getAge(new GregorianCalendar(1988,5,3)));
    }

}
