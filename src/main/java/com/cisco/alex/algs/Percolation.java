package com.cisco.alex.algs;

/**
 * @author oleivano
 */
public class Percolation {

    private final PercolationGrid grid;

    public Percolation(int gridSize) {
        grid = new PercolationGrid(gridSize);
    }

    public void open(int row, int col) {
        grid.openSite(row, col);
    }

    public boolean isOpen(int row, int col) {
        return grid.isSiteOpen(row, col);
    }

    public boolean isFull(int row, int col) {
        return grid.isFull(row, col);
    }

    public int numberOfOpenSites() {
        return grid.getNumberOfSites();
    }

    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {
        Percolation per = new Percolation(15);
        System.out.println("End");
    }
}
