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
public class SingletonUniverse {

    private static SingletonUniverse instance;

    private int numCols;
    private int numRows;
    private int deltaTime;

    public SingletonUniverse() {
        numCols = 50;
        numRows = 50;
        deltaTime = 500;
    }

    public static SingletonUniverse getInstance() {
        if (instance == null) {
            instance = new SingletonUniverse();
        }
        return instance;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }

}
