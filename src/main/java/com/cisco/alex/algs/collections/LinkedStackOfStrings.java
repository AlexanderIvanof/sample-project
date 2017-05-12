package com.cisco.alex.algs.collections;

/**
 *  Implementation of {@code Stack} data structure based on <u>Linked List</u>.
 *
 * @author oleivano
 */
public class LinkedStackOfStrings implements Stack<String> {

    private class Node {
        String item;
        Node next;

        Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node first;

    @Override
    public void push(String item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
    }

    @Override
    public String pop() {
        if (first != null) {
            final Node head = first;
            first = head.next;
            return head.item;
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Method not implemented yet!");
    }
}
