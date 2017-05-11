package com.cisco.alex.pattern;

/**
 * One of implementation of {@link Worker} interface.
 *
 * @author oleivano
 */
public class LogToConsoleWorkerImpl extends WorkerDecorator {

    public LogToConsoleWorkerImpl(Worker delegate) {
        super(delegate);
    }

    @Override
    public void doSomething() {
        System.out.println("Before call");
        delegate.doSomething();
        System.out.println("After call");
    }

    @Override
    public int getInt() {
        System.out.println("Before call");
        int result = delegate.getInt();
        System.out.println("After call: i = " + result);
        return result;
    }

    public void showActualState() {
        System.out.println("Worker's type: " + delegate.getClass().getName());
        System.out.println("========================================");
    }
}
