package com.cisco.alex.algs.collections;

/**
 * Data structure that represent {@code Bag} data type.
 *
 * @author oleivano
 */
public interface Bag<T> extends Iterable<T> {

    /**
     * Adds element to bag.
     *
     * @param item item to add.
     */
    void add(T item);

    /**
     * Returns number of items inside the bag.
     *
     * @return number of items.
     */
    int size();
}
