package com.cisco.alex.algs.collections;

/**
 * Runner class for {@link Bag} implementations.
 *
 * @author oleivano
 */
public class RunnerForBag {

    public static void main(String[] args) {
        Bag<String> bagOfStrings = new LinkedBag<>();
        bagOfStrings.add("hello");
        bagOfStrings.add("from");
        bagOfStrings.add("the");
        bagOfStrings.add("bag");

        for (String i : bagOfStrings) {
            System.out.println(i);
        }

//        bagOfStrings.forEach(System.out::println);

        System.out.println(bagOfStrings.size());
    }
}
