package com.cisco.alex.alg.unionfind

import com.cisco.alex.algs.unionfind.UnionFind

/**
 *
 * @author oleivano
 * @since
 */
class UnionFindWeightedGr implements UnionFind {

    def dataHolder
    def sizeHolder

    UnionFindWeightedGr(int elementSize) {
        dataHolder = []
        sizeHolder = []
        (0..<elementSize).each {
            dataHolder << it
            sizeHolder << 1
        }
    }

    @Override
    boolean connected(int leftElement, int rightElement) {
        return getRoot(leftElement) == getRoot(rightElement)
    }

    @Override
    void union(int leftElement, int rightElement) {
        def rootLeft = getRoot(leftElement)
        def rootRight = getRoot(rightElement)

        if (rootLeft == rootRight) {
            return
        }

        if (sizeHolder[rootLeft] > sizeHolder[rootRight]) {
            dataHolder[rootRight] = rootLeft
            sizeHolder[rootLeft] += sizeHolder[rootRight]
        } else {
            dataHolder[rootLeft] = rootRight
            sizeHolder[rootRight] += sizeHolder[rootLeft]
        }
    }

    private int getRoot(int elementIndex) {
        while(dataHolder[elementIndex] != elementIndex) {
            elementIndex = dataHolder[elementIndex]
        }
        elementIndex
    }

    static main(args) {
        UnionFind uf = new UnionFindWeightedGr(10)
        uf.union(4, 3)
        uf.union(3, 8)
        uf.union(6, 5)
        uf.union(9, 4)
        uf.union(2, 1)
        uf.union(5, 0)
        uf.union(7, 2)
        uf.union(6,1)
        uf.union(7,3)
        println("Hello ${uf.connected(0,9)}")

    }
}
