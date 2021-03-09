package com.virtualpairprogrammers.learningkotlin.kotlin.kotlinJavaInterop;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Customer phil = new Customer(0, "Phil");
        phil.getName(); // there s a get method to retrieve value from kotlin object even if this method does not exists in kotlin object

        CustomerDatabase db = new CustomerDatabase();
        try {
            db.addCustomer(phil);
        } catch (IllegalAccessException e) {
            System.out.println("caught Exception");
        }

        List<Customer> customers = db.getCustomers();
        //customers.add(phil); //we can access the method add in java even if it s an immutable list in kotlin but when running the code e will have a UnsupportedOperationException

        for (Customer c : db.getCustomers()) {
            System.out.println(c);
        }

        ///// call static method
        CustomerDatabase.Companion.helloWorld(); // by default you can call static method like that
        CustomerDatabase.helloWorld(); // possible because we had annotation @JvmStatic in kotlin class
    }

}
