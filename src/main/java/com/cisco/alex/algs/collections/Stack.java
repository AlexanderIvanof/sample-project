package com.cisco.alex.algs.collections;

/**
 * @author oleivano
 */
public interface Stack<T> {

    void push(T item);
    T pop();
    boolean isEmpty();
    int size();
}
