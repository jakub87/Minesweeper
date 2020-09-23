package minesweeper;

import java.util.Random;

public abstract class BasicMineSweeper {
    protected char mineTab[][];
    protected char playerTab[][];
    protected Random random;

    protected int minesNumber;
    protected int tabSize;

    protected BasicMineSweeper(int minesNumber) {
        this.minesNumber = minesNumber;
        tabSize = 9;
        mineTab = new char[tabSize][tabSize];
        playerTab = new char[tabSize][tabSize];
        random = new Random();
        initializeFields(); // prepare fiels to play
        generateMines(); // generate random mines on board
        setBorderMines(); // set borders of mines
    }

    private void initializeFields() {
        for (int i = 0; i < tabSize ; i++) {
            for (int j = 0; j < tabSize ; j++) {
                mineTab[i][j] = '.';
                playerTab[i][j] = '.';
            }
        }
    }

    private void generateMines() {
        int row;
        int column;
        boolean occupiedField;
        for (int i = 0; i < minesNumber; i++) {
            occupiedField = true;
            do {
                row = random.nextInt(tabSize);
                column = random.nextInt(tabSize);
                if (mineTab[row][column] == '.') {
                    mineTab[row][column] = 'X';
                    occupiedField = false;
                }
            }while (occupiedField);
        }
    }

    private void setBorderMines() {
        for (int i = 0; i < mineTab.length; i++) {
            for (int j = 0; j < mineTab.length ; j++) {
                if (mineTab[i][j] == '.') {
                    int countMiner = setMines(i, j);
                    if (countMiner > 0) {
                        mineTab[i][j] = Character.forDigit(countMiner,10);
                    }
                }
            }
        }
    }

    private int setMines(int row, int column) {
        int counter=0;
        if (column - 1 >= 0 && mineTab[row][column-1] == 'X' ) {
            counter++;
        }
        if (row - 1 >= 0 && mineTab[row-1][column] == 'X') {
            counter++;
        }
        if (column + 1 < tabSize && mineTab[row][column+1] == 'X') {
            counter++;
        }
        if (row + 1 < tabSize && mineTab[row+1][column] == 'X') {
            counter++;
        }
        if (row - 1 >= 0 && column - 1 >= 0 && mineTab[row-1][column-1] == 'X') {
            counter++;
        }
        if (row - 1 >= 0 && column + 1 < tabSize && mineTab[row-1][column+1] == 'X') {
            counter++;
        }
        if (row + 1 < tabSize && column + 1 < tabSize && mineTab[row+1][column+1] == 'X' ) {
            counter++;
        }
        if (row + 1 < tabSize && column - 1 >= 0 && mineTab[row+1][column-1] == 'X') {
            counter++;
        }
        return counter;
    }
}
