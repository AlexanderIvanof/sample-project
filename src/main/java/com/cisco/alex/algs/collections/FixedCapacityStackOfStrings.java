package com.cisco.alex.algs.collections;

import java.util.Arrays;

/**
 * @author oleivano
 */
public class FixedCapacityStackOfStrings implements Stack<String> {

    private static final int INITIAL_HEAD_INDEX = 0;

    protected String[] dataHolder;
    protected int headIndex = INITIAL_HEAD_INDEX;

    public FixedCapacityStackOfStrings(int initialCapacity) {
        dataHolder = new String[initialCapacity];
    }

    @Override
    public void push(String item) {
        dataHolder[headIndex++] = item;
    }

    @Override
    public String pop() {
        if (headIndex == INITIAL_HEAD_INDEX) {
            return null;
        }
        final String currentHead = dataHolder[--headIndex];
        dataHolder[headIndex] = null;
        return currentHead;
    }

    @Override
    public boolean isEmpty() {
        return headIndex == INITIAL_HEAD_INDEX;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

}
