package com.cisco.alex.algs.collections;

/**
 * Resize doubling implementation of {@code Queue} data structure based on array.
 *
 * @author oleivano
 */
@SuppressWarnings("unchecked")
public class ResizeTwiceCapacityQueue<T> implements Queue<T> {

    private static final int ARRAY_INITIAL_CAPACITY = 1;
    private static final int INITIAL_INDEX = 0;

    protected T[] dataHolder;
    protected int headIndex = INITIAL_INDEX;
    protected int tailIndex = INITIAL_INDEX;
    private int dataLength;

    public ResizeTwiceCapacityQueue() {
        dataHolder = (T[]) new Object[ARRAY_INITIAL_CAPACITY];
    }

    @Override
    public void enqueue(T item) {
        if (tailIndex == dataHolder.length - 1) {
            T[] resizedDouble = (T[]) new Object[dataHolder.length * 2];
            System.arraycopy(dataHolder, headIndex, resizedDouble, INITIAL_INDEX, dataLength);
            dataHolder = resizedDouble;
            headIndex = INITIAL_INDEX;
            tailIndex = dataLength;
        }

        if (dataHolder[tailIndex] != null) {
            tailIndex++;
        }
        dataHolder[tailIndex] = item;
        dataLength++;
    }

    @Override
    public T dequeue() {
        if (dataLength == 0) {
            return null;
        }
        final T valueToTakeOff = dataHolder[headIndex];
        dataHolder[headIndex++] = null;
        dataLength--;
        if (dataLength == dataHolder.length / 4) {
            T[] resizedDouble = (T[]) new Object[dataHolder.length / 2];
            System.arraycopy(dataHolder, headIndex, resizedDouble, INITIAL_INDEX, dataLength);
            dataHolder = resizedDouble;
            headIndex = INITIAL_INDEX;
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
