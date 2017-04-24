package com.cisco.alex.algs.collections;

import java.util.Arrays;
import java.util.List;

/**
 * @author oleivano
 */
public class RunnerForStack {

    public static void main(String[] args) {
        Stack<String> stringStack = new ResizeTwiceCapacityStackOfStrings();
        stringStack.pop();
        List<String> testedStrings = Arrays.asList("to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is");
        for (String it : testedStrings) {
            if (it.equals("-")) {
                System.out.println(stringStack.pop());
            } else {
                stringStack.push(it);
            }
        }
    }
}
