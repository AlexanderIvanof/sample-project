package com.cisco.alex.pattern;

/**
 * @author oleivano
 */
public class WorkerImpl implements Worker {

    Worker delegate;

    public WorkerImpl(Worker delegate) {
        this.delegate = delegate;
    }

    @Override
    public void doSomething() {
        delegate.doSomething();
    }

    @Override
    public int getInt() {
        return delegate.getInt();
    }
}
