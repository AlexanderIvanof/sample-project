package com.cisco.alex.algs.collections;

/**
 *  Implementation of {@code Stack} data structure based on <u>Linked List</u>.
 *
 * @author oleivano
 */
public class LinkedStack<T> implements Stack<T> {

    private class Node {
        T item;
        Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node first;

    @Override
    public void push(T item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
    }

    @Override
    public T pop() {
        if (first != null) {
            final Node head = first;
            first = head.next;
            return head.item;
        } else {
            return null;
        }
    }

    @Override
    public T peek() {
        return first == null ? null : first.item;
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
