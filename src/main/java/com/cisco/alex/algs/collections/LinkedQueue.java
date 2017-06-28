package com.cisco.alex.algs.collections;

/**
 * Implementation of {@code queue} data structure based on <u>Linked List</u>.
 *
 * @author oleivano
 */
public class LinkedQueue<T> implements Queue<T> {

    private Node first;
    private Node last;
    private int dataLength;

    @Override
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node(item, null);
        ++dataLength;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

    }

    @Override
    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        --dataLength;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return dataLength;
    }

    private class Node {
        T item;
        Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
