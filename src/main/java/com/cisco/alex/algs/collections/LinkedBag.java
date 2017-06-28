package com.cisco.alex.algs.collections;

import java.util.Iterator;

/**
 * @author oleivano
 */
public class LinkedBag<T> implements Bag<T> {

    private ListNode first;
    private ListNode last;

    private int dataLength;

    @Override
    public void add(T item) {
        ListNode oldLast = last;
        last = new ListNode(item, null);
        if (first == null) {
            first = last;
        } else {
            oldLast.next = last;
        }
        dataLength++;
    }

    @Override
    public int size() {
        return dataLength;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListNode {
        ListNode next;
        T item;

        ListNode(T item, ListNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private class ListIterator implements Iterator<T> {

        ListNode current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T currentValue = current.item;
            current = current.next;
            return currentValue;
        }
    }
}
