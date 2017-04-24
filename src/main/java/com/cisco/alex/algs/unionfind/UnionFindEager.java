package com.cisco.alex.algs.unionfind;

/**
 * @author oleivano
 */
public class UnionFindEager implements UnionFind {

    protected int[] dataHolder;

    public UnionFindEager(int numberOfElements) {
        dataHolder = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; ++i) {
            dataHolder[i] = i;
        }
    }


    @Override
    public boolean connected(int leftElement, int rightElement) {
        return dataHolder[leftElement] == dataHolder[rightElement];
    }

    @Override
    public void union(int leftElement, int rightElement) {
        if (!connected(leftElement, rightElement)) {
            final int rightIndex = dataHolder[rightElement];
            final int leftIndex = dataHolder[leftElement];
            for (int i = 0; i < dataHolder.length; i++) {
                if (dataHolder[i] == leftIndex) {
                    dataHolder[i] = rightIndex;
                }
            }
        }
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFindWeighted(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6,1);
        uf.union(7,3);
        System.out.println(uf.connected(0, 4));
    }
}
