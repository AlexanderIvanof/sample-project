package com.cisco.alex.algs.collections;

/**
 * Resize doubling implementation of {@code Queue} data structure based on array.
 *
 * @author oleivano
 */
public class ResizeTwiceCapacityQueueOfStrings implements Queue<String> {

    private static final int ARRAY_INITIAL_CAPACITY = 1;
    private static final int INITIAL_HEAD_INDEX = 0;

    protected String[] dataHolder;
    protected int headIndex = INITIAL_HEAD_INDEX;
    protected int tailIndex = INITIAL_HEAD_INDEX;
    private int dataLength;


    public ResizeTwiceCapacityQueueOfStrings() {
        dataHolder = new String [ARRAY_INITIAL_CAPACITY];
    }

    @Override
    public void enqueue(String item) {
        if (tailIndex == dataHolder.length - 1) {
            String[] resizedDouble = new String[dataHolder.length * 2];
            System.arraycopy(dataHolder, headIndex, resizedDouble, INITIAL_HEAD_INDEX, dataLength);
            dataHolder = resizedDouble;
            headIndex = INITIAL_HEAD_INDEX;
            tailIndex = dataLength;
        }

        if (dataHolder[tailIndex] != null) {
            tailIndex++;
        }
        dataHolder[tailIndex] = item;
        dataLength++;
    }

    // TODO: first call of dequeue method on empty array
    @Override
    public String dequeue() {
        final String valueToTakeOff = dataHolder[headIndex];
        dataHolder[headIndex++] = null;
        dataLength--;
        if (dataLength == dataHolder.length / 4) {
            String[] resizedDouble = new String[dataHolder.length / 2];
            System.arraycopy(dataHolder, headIndex, resizedDouble, INITIAL_HEAD_INDEX, dataLength);
            dataHolder = resizedDouble;
            headIndex = INITIAL_HEAD_INDEX;
            tailIndex = dataLength - 1;
        }
        return valueToTakeOff;
    }

    @Override
    public boolean isEmpty() {
        return dataLength == 0;
    }

    @Override
    public int size() {
        return dataLength;
    }

}
