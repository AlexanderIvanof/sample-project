package com.cisco.alex.algs.collections;

/**
 * Interface that represents {@code queue} data structure(LIFO).
 *
 * @author oleivano
 */
public interface Queue<T> {

    /**
     * Insert a new item onto queue.
     *
     * @param item item to add
     */
    void enqueue(T item);

    /**
     * Remove and return the last recently added.
     *
     * @return last recently added item
     */
    T dequeue();


    boolean isEmpty();

    int size();
}
