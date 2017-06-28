package com.cisco.alex.algs.collections;

/**
 * Interface that represents {@code Stack} data structure(FIFO).
 *
 * @author oleivano
 */
public interface Stack<T> {

    /**
     *
     * Adds item to the stack.
     *
     * @param item item to add
     */
    void push(T item);

    /**
     * Remove and return last added item from stack.
     *
     * @return item that will be removed.
     */
    T pop();

    /**
     * Return last added item from stack with no deletion.
     *
     * @return last added item.
     */
    T peek();


    /**
     * If {@code Stack is empty}
     *
     * @return {@code true} if {@code stack} is empty, and {@code false} otherwise.
     */
    boolean isEmpty();


    int size();
}
