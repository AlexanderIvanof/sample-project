package com.cisco.alex;

import java.util.function.Supplier;


/**
 * Created by oleivano on 02/06/2017.
 */
public class AppRunner {

    private static String name = "Hello";

    public static void main(String[] args) {
        Supplier<String> lambdaSup = () -> name.toUpperCase();

        Supplier<String> methRefSup = name::toUpperCase;

        name = "Привет";

        System.out.println(lambdaSup.get());
        System.out.println(methRefSup.get());
    }
}
