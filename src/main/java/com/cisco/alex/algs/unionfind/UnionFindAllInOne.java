package com.cisco.alex.algs.unionfind;

/**
 * @author oleivano
 */
public class UnionFindAllInOne implements UnionFind {

    private static final int INDEX_ADDRESS = 0;
    private static final int SIZE_ADDRESS = 1;
    private static final int NUMBER_OF_ROWS = 2;

    private int[][] dataHolderArray;

    public UnionFindAllInOne(int elementNumber) {
        dataHolderArray = new int[elementNumber][NUMBER_OF_ROWS];
        for (int i = 0; i < dataHolderArray.length; i++) {
            dataHolderArray[i][INDEX_ADDRESS] = i;
            dataHolderArray[i][SIZE_ADDRESS] = 1;
        }
    }

    @Override
    public boolean connected(int leftElement, int rightElement) {
        return getRoot(leftElement) == getRoot(rightElement);
    }

    @Override
    public void union(int leftElement, int rightElement) {
        final int rootLeft = getRoot(leftElement);
        final int rootRight = getRoot(rightElement);

        if (rootLeft == rootRight) {
            return;
        }

        if (dataHolderArray[rootLeft][SIZE_ADDRESS] > dataHolderArray[rootRight][SIZE_ADDRESS]) {
            dataHolderArray[rootRight][INDEX_ADDRESS] = rootLeft;
            dataHolderArray[rootLeft][SIZE_ADDRESS] += dataHolderArray[rootRight][SIZE_ADDRESS];
        } else  {
            dataHolderArray[rootLeft][INDEX_ADDRESS] = rootRight;
            dataHolderArray[rootRight][SIZE_ADDRESS] += dataHolderArray[rootLeft][SIZE_ADDRESS];
        }
    }

    private int getRoot(int elementId) {
        while (dataHolderArray[elementId][INDEX_ADDRESS] != elementId) {
            elementId = dataHolderArray[elementId][INDEX_ADDRESS];
        }
        return elementId;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFindAllInOne(10);
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
