package com.cisco.alex.algs;

/**
 * @author oleivano
 */
public class PercolationGrid {

    private final Site[][] grid;
    private final int numberOfSites;
    private final int lastRow;
    private int numberOfOpenSites;

    public PercolationGrid(int gridSize) {
        grid = new Site[gridSize][gridSize];
        numberOfSites = gridSize * gridSize;
        lastRow = gridSize - 1;
        initGrid(gridSize);
    }

    private void initGrid(int gridSize) {
        int elements = numberOfSites;
        for (int i = gridSize - 1; i >= 0; i--) {
            for (int j = gridSize - 1; j >= 0; j--) {
                int currentElement = elements--;
                grid[i][j] = new Site(currentElement);
            }
        }
    }

    public void openSite(int row, int column) {
        grid[row - 1][column - 1].isOpen = true;
        numberOfOpenSites++;
    }

    public boolean isSiteOpen(int row, int column) {
       return  grid[row - 1][column - 1].isOpen;
    }

    public void fillInSite(int row, int column) {
        grid[row][column].isFull = true;
    }

    public boolean isFull(int row, int column) {
        return grid[row][column].isFull;
    }

    public int getNumberOfSites() {
        return numberOfSites;
    }

    public int getNumberOfOpenSites() {
        return numberOfOpenSites;
    }

    public int getLastRow() {
        return lastRow;
    }

    private class Site {
        int elementNumber;
        int rootId;
        boolean isOpen;
        boolean isFull;

        Site(int elementNumber) {
            this.elementNumber = elementNumber;
            this.rootId = elementNumber;
        }
    }
}
