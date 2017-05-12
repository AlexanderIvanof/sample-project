package com.cisco.alex;

import org.apache.tinkerpop.gremlin.process.traversal.step.util.Tree;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

interface CopySomethingPredicate<T> {

    boolean test(T obj);
}

/**
 * Created by oleivano on 02/06/2017.
 */
public class TestJava {

    private String name = "Hello";

    @Test
    public void testMethRefVsLambdaDiff() {
        Supplier<String> lambdaSup = () -> name.toUpperCase();

        Supplier<String> methRefSup = name::toUpperCase;

        name = "Привет";

        System.out.println(lambdaSup.get());
        System.out.println(methRefSup.get());
    }

    @Test
    public void testFunctionalInterface() {
        final List<String> collect1 = Stream.of("A", "B", "C", "C", "B", "A")
                .sequential()
                .filter(i -> new TreeSet<>().add(i))
                .collect(Collectors.toList());

        final List<String> collect2 = Stream.of("A", "B", "C", "C", "B", "A")
                .sequential()
                .filter(new TreeSet<>()::add)
                .collect(Collectors.toList());

        System.out.println(collect1.equals(collect2));

    }

    @Test
    public void testBrokeForeach() {
        final StringJoiner stringJoiner = new StringJoiner("<>");
    }


    @Test
    public void testSomeMethod() {
        assertTrue(1 == 1);
    }

    @Test
    public void testGraphIteration() {

        Tree<String> tree = new Tree<>("A", "B");
        final Tree<String> a = tree.get("A");
        a.put("C", new Tree<>());
        a.put("E", new Tree<>("D"));

        printAllTree(tree);
    }

    public static void printAllTree(Tree<String> tree) {
        final List<String> objectsAtDepth = tree.getObjectsAtDepth(1);
        for (String s : objectsAtDepth) {
            final Tree<String> subTree = tree.get(s);
            if (subTree.size() == 0) {
                System.out.println("Final ->" + s);
            } else {
                System.out.println("Key-> " + s);
                printAllTree(subTree);
            }
        }
    }
}
