package com.cisco.alex.algs.sort;

import java.util.Arrays;

/**
 * @author oleivano
 */
public class SortingRunner {


    public static void main(String[] args) {
        Sortable sortable = new SelectionSort();
        String[] arr = {"Evil", "Am", "I", "Am"};
        sortable.sort(arr);
        System.out.println(Arrays.toString(arr));

        sortable = new InsertionSort();
        String[] arr1 = {"Evil", "Am", "I", "Am"};
        sortable.sort(arr1);
        System.out.println("arr1 = " + Arrays.toString(arr1));
    }
}
