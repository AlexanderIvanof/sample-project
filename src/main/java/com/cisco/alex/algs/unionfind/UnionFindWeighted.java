package com.cisco.alex.algs.unionfind;

import java.util.Arrays;

/**
 * @author oleivano
 */
public class UnionFindWeighted extends UnionFindWithRoot {

    protected int[] rootSize;

    public UnionFindWeighted(int numberOfElements) {
        super(numberOfElements);
        rootSize = new int[numberOfElements];
        Arrays.fill(rootSize, 1);
    }

    @Override
    public void union(int leftElement, int rightElement) {
        final int rootLeft = getRoot(leftElement);
        final int rootRight = getRoot(rightElement);

        if (rootLeft == rootRight) {
            return;
        }

        if (rootSize[rootLeft] > rootSize[rootRight]) {
            dataHolder[rootRight] = rootLeft;
            rootSize[rootLeft] += rootSize[rootRight];
        } else {
            dataHolder[rootLeft] = rootRight;
            rootSize[rootRight] += rootSize[rootLeft];
        }
    }
}
