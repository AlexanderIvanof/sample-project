package com.cisco.alex.pattern;

/**
 * Class to run any of implementation of pattern.
 *
 * @author oleivano
 */


public class PatternRunner {


    public static void main(String[] args) {
        LogToConsoleWorkerImpl wrk = new LogToConsoleWorkerImpl(new ConcreteWorkerImpl());
        wrk.doSomething();
        wrk.getInt();
        wrk.showActualState();
    }
}
