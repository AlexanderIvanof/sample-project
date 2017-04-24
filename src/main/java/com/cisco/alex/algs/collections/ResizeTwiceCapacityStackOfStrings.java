package com.cisco.alex.algs.collections;

import java.util.Arrays;

/**
 * @author oleivano
 */
public class ResizeTwiceCapacityStackOfStrings extends FixedCapacityStackOfStrings {

    private static final int ARRAY_INITIAL_CAPACITY = 1;

    public ResizeTwiceCapacityStackOfStrings() {
        super(ARRAY_INITIAL_CAPACITY);
    }

    @Override
    public void push(String item) {
        final int currentLength = dataHolder.length;
        if (headIndex == currentLength) {
            // repeated doubling
           dataHolder = Arrays.copyOf(dataHolder, currentLength * 2);
        }
        super.push(item);
    }

}
