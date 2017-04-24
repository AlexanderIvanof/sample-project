package com.cisco.alex.algs.unionfind;

/**
 * @author oleivano
 */
public interface UnionFind {

    boolean connected(int leftElement, int rightElement);

    void union(int leftElement, int rightElement);
}
