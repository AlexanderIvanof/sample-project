package com.cisco.alex.pattern;

import java.util.Objects;

/**
 * Initial {@code decorator} for worker.
 *
 * @author oleivano
 */
public abstract class WorkerDecorator implements Worker {

    protected Worker delegate;

    public WorkerDecorator(Worker delegate) {
        Objects.requireNonNull(delegate);
        this.delegate = delegate;
    }

}
