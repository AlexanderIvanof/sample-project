package com.cisco.alex.algs.collections;

import java.util.Optional;

/**
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

    private Optional<Node> first = Optional.<Node>empty();

    @Override
    public void push(String item) {
        Node oldFirst = first.orElse(null);
        Node newFirst = new Node(item, oldFirst);
        first = Optional.of(newFirst);
    }

    @Override
    public String pop() {
        if (first.isPresent()) {
            final Node head = first.get();
            first = Optional.of(head.next);
            return head.item;
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return !first.isPresent();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Method not implemented yet!");
    }
}
