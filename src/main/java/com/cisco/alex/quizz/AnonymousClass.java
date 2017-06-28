package com.cisco.alex.quizz;

import sun.misc.Unsafe;

/**
 * @author oleivano
 */
public class AnonymousClass {

    public static void main(String[] args) throws Exception {
        Runnable anonymous = new Runnable() {
            int someNumber = 3;

            @Override
            public void run() {
                System.out.println("Try to get my field without this method. Number is: " + someNumber);
            }
        };

        Unsafe unsafe = Unsafe.getUnsafe();

        Class<?> clazz = Class.forName("AnonymousClass");

    }
}
