package com.cisco.alex.algs.sort;

/**
 * @author oleivano
 */
public class SelectionSort implements Sortable {

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (SortingUtils.less(arr[j], arr[min])) {
                    min = j;
                }
            }
            SortingUtils.exch(arr, i, min);
        }
    }
}
