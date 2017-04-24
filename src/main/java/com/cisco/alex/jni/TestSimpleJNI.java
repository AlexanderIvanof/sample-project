package com.cisco.alex.jni;

/**
 * @author oleivano
 */
public class TestSimpleJNI {

    static {
        System.loadLibrary("hello");
    }

    private native void greetings();

    public static void main(String[] args) {
        new TestSimpleJNI().greetings();
    }
}
