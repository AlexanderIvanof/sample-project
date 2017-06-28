package com.cisco.alex.algs.collections;

import java.util.Arrays;

/**
 * @author oleivano
 */
public class ResizeTwiceCapacityStack<T> extends FixedCapacityStack<T> {

    private static final int ARRAY_INITIAL_CAPACITY = 1;

    public ResizeTwiceCapacityStack() {
        super(ARRAY_INITIAL_CAPACITY);
    }

    @Override
    public void push(T item) {
        final int currentLength = dataHolder.length;
        if (headIndex == currentLength) {
            // repeated doubling
           dataHolder = Arrays.copyOf(dataHolder, currentLength * 2);
        }
        super.push(item);
    }

    @Override
    public T pop() {
        T currentValue = super.pop();
        if (headIndex > 0 && headIndex == dataHolder.length / 4) {
            dataHolder = Arrays.copyOf(dataHolder, dataHolder.length / 2);
        }
        return currentValue;
    }
}
