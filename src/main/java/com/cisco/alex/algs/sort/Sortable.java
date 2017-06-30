package com.cisco.alex.algs.sort;

/**
 * @author oleivano
 */
public interface Sortable {

    <T extends Comparable<T>> void sort(T[] arr);
}
