package com.cisco.alex.pattern;

/**
 * @author oleivano
 */
public class ConcreteWorkerImpl implements Worker {

    public ConcreteWorkerImpl() { }

    @Override
    public void doSomething() {
        System.out.println("I'm doing");
    }

    @Override
    public int getInt() {
        return 12;
    }
}
