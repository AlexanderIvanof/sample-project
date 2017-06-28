package com.cisco.alex.algs.collections;

import java.util.Arrays;

/**
 * @author oleivano
 */
public class FixedCapacityStack<T> implements Stack<T> {

    protected static final int INITIAL_HEAD_INDEX = 0;

    protected T[] dataHolder;
    protected int headIndex = INITIAL_HEAD_INDEX;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int initialCapacity) {
        dataHolder = (T[]) new Object[initialCapacity];
    }

    @Override
    public void push(T item) {
        dataHolder[headIndex++] = item;
    }

    @Override
    public T pop() {
        if (headIndex == INITIAL_HEAD_INDEX) {
            return null;
        }
        final T currentHead = dataHolder[--headIndex];
        dataHolder[headIndex] = null; // for GC needs
        return currentHead;
    }

    @Override
    public T peek() {
        int currentHead = headIndex - 1;
        if (currentHead < INITIAL_HEAD_INDEX) {
            return null;
        }
        return dataHolder[currentHead];
    }

    @Override
    public boolean isEmpty() {
        return headIndex == INITIAL_HEAD_INDEX;
    }

    @Override
    public int size() {
        return headIndex;
    }

}
