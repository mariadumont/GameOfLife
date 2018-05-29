/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOfLife;

/**
 *
* @author alu20482156n
 */
public class Universe {

    private boolean[][] matrix;
    private boolean[][] newMatrix;

    public Universe() {
        SingletonUniverse cs = SingletonUniverse.getInstance();
        matrix = new boolean[cs.getNumRows()][cs.getNumCols()];
        newMatrix = new boolean[cs.getNumRows()][cs.getNumCols()];
        for (int i = 0; i < cs.getNumRows(); i++) {
            for (int j = 0; j < cs.getNumCols(); j++) {
                matrix[i][j] = false;
                newMatrix[i][j] = false;
            }
        }
        
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
    }

    public void tick() {
        SingletonUniverse cs = SingletonUniverse.getInstance();
        int numNeighbours;
        for (int i = 0; i < cs.getNumRows(); i++) {
            for (int j = 0; j < cs.getNumCols(); j++) {
                newMatrix[i][j] = false;
                numNeighbours = numNeighbours(i, j);
                if (matrix[i][j] && (numNeighbours == 2 || numNeighbours == 3)) {
                    newMatrix[i][j] = true;
                } else {
                    if (!matrix[i][j] && numNeighbours == 3) {
                        newMatrix[i][j] = true;
                    }
                }
            }
        }
        boolean[][] temp = matrix;
        matrix = newMatrix;
        newMatrix = temp;
    }

    public int numNeighbours(int row, int col) {
        SingletonUniverse cs = SingletonUniverse.getInstance();
        int counter = 0;
        if (row - 1 >= 0) {
            if (col - 1 >= 0) {
                if (matrix[row - 1][col - 1]) {
                    counter++;
                }
            }
            if (matrix[row - 1][col]) {
                counter++;
            }
            if (col + 1 < cs.getNumCols()) {
                if (matrix[row - 1][col + 1]) {
                    counter++;
                }
            }
        }
        if (col - 1 >= 0) {
            if (matrix[row][col - 1]) {
                counter++;
            }
        }
        if (col + 1 < cs.getNumCols()) {
            if (matrix[row][col + 1]) {
                counter++;
            }
        }
        if (row + 1 < cs.getNumRows()) {
            if (col - 1 >= 0) {
                if (matrix[row + 1][col - 1]) {
                    counter++;
                }
            }
            if (matrix[row + 1][col]) {
                counter++;
            }
            if (col + 1 < cs.getNumCols()) {
                if (matrix[row + 1][col + 1]) {
                    counter++;
                }
            }
        }
        return counter;
    }

}
