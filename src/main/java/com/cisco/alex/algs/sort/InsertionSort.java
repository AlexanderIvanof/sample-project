package com.cisco.alex.algs.sort;

import java.util.Objects;

/**
 * @author oleivano
 */
public class InsertionSort implements Sortable {

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        Objects.nonNull(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (SortingUtils.less(arr[j], arr[j - 1])) {
                    SortingUtils.exch(arr, j, (j - 1));
                } else {
                    break;
                }
            }
        }
    }
}
