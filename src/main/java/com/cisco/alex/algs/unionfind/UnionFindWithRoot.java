package com.cisco.alex.algs.unionfind;

/**
 * @author oleivano
 */
public class UnionFindWithRoot extends UnionFindEager {

    public UnionFindWithRoot(int numberOfElements) {
        super(numberOfElements);
    }

    @Override
    public boolean connected(int leftElement, int rightElement) {
        return getRoot(leftElement) == getRoot(rightElement);
    }

    @Override
    public void union(int leftElement, int rightElement) {
        final int rootLeft = getRoot(leftElement);
        final int rootRight = getRoot(rightElement);
        if (rootLeft != rootRight) {
            dataHolder[rootLeft] = rootRight;
        }
    }


    int getRoot(int elementNumber) {
        while(dataHolder[elementNumber] != elementNumber) {
            elementNumber = dataHolder[elementNumber];
        }
        return elementNumber;
    }
}
