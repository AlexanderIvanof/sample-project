package com.cisco.alex.algs.sort;

/**
 * Utility class that helps to compare things.
 *
 * @author oleivano
 */
public final class SortingUtils {

    private SortingUtils() { }

    public static <T extends Comparable<T>> boolean less(T left, T right) {
        return left.compareTo(right) < 0;
    }

    public static <T extends Comparable<T>> void exch(T[] array, int leftIndex, int rightIndex) {
        T temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
