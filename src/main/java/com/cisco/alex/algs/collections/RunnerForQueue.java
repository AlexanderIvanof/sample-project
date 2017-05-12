package com.cisco.alex.algs.collections;

import java.util.Arrays;
import java.util.List;

/**
 * @author oleivano
 */
public class RunnerForQueue {

    public static void main(String[] args) {
        Queue<String> queueOfStrings = new ResizeTwiceCapacityQueueOfStrings();

        List<String> testedStrings = Arrays.asList("1", "2", "3", "4", "-", "5", "6", "-", "-", "-", "7");
        for (String it : testedStrings) {
            if (it.equals("-")) {
                System.out.println(queueOfStrings.dequeue());
            } else {
                queueOfStrings.enqueue(it);
            }
        }
    }
}
