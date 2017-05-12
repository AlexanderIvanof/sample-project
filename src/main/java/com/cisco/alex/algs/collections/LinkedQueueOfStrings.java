package com.cisco.alex.algs.collections;

/**
 * Implementation of {@code queue} data structure based on <u>Linked List</u>.
 *
 * @author oleivano
 */
public class LinkedQueueOfStrings implements Queue<String> {

    private Node first;
    private Node last;

    @Override
    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node(item, null);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

    }

    @Override
    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return 0;
    }

    private class Node {
        String item;
        Node next;

        Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
