package minesweeper;

import java.util.Scanner;

public class GameMineSweeper extends BasicMineSweeper {
    private Scanner scanner;

    public GameMineSweeper(int minesNumber) {
        super(minesNumber);
        scanner = new Scanner(System.in);
    }

    private void printBoard() {
        System.out.println(" |123456789|");
        System.out.println("-|---------|");
        for (int i = 0; i < playerTab.length ; i++) {
            System.out.print(i+1+"|");
            for (int j = 0; j < playerTab.length ; j++) {
                System.out.print(playerTab[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("-|---------|");
     }

    private void failureGame() {
        for (int i = 0; i < mineTab.length ; i++) {
            for(int j = 0; j < mineTab.length; j++) {
                if (mineTab[i][j] == 'X') {
                    playerTab[i][j] = 'X';
                }
            }
        }
        printBoard();
        System.out.println("You stepped on a mine and failed!");
    }

    private void revealFreeFields(int y, int x) {
        if (x >= 0 && x < tabSize && y >= 0 && y < tabSize) {
            if (mineTab[y][x] == '.') {
                mineTab[y][x] = '/';
                playerTab[y][x] = '/';
                revealFreeFields(y-1,x);
                revealFreeFields(y,x-1);
                revealFreeFields(y+1,x);
                revealFreeFields(y,x+1);
                revealFreeFields(y+1,x+1);
                revealFreeFields(y+1,x-1);
                revealFreeFields(y-1,x-1);
                revealFreeFields(y-1,x+1);
            } else if (Character.isDigit(mineTab[y][x])){
                playerTab[y][x] = mineTab[y][x];
            }
        }
    }

    private boolean continueGame() {
        int freeOverall=0, freeMineCorrect=0, mineOverall=0, mineCorrect=0;

               for (int i = 0; i <tabSize ; i++) {
            for (int j = 0; j <tabSize ; j++) {
                if (playerTab[i][j] == '.') {
                    freeOverall++;
                    if (mineTab[i][j] == 'X') {
                        freeMineCorrect++;
                    }
                } else if (playerTab[i][j] == '*') {
                    mineOverall++;
                    if (mineTab[i][j] == 'X') {
                        mineCorrect++;
                    }
                }
            }
        }
        return (freeMineCorrect != minesNumber || freeOverall != minesNumber || mineOverall != 0) &&
                (mineOverall != minesNumber || mineCorrect != minesNumber);
    }

    public void startGame() {
        boolean cotinueGame = true;
        int x,y;
        String finalResult ="";
        printBoard();
        do {
            System.out.println("Set/unset mines marks or claim a cell as free: ");
            String output = scanner.nextLine();
            x = Integer.parseInt(output.split(" ")[0])-1;
            y = Integer.parseInt(output.split(" ")[1])-1;
            if (output.contains("free")) { //assume that field is free
                if (mineTab[y][x] == '.') {
                    revealFreeFields(y,x);
                } else {
                    playerTab[y][x] = mineTab[y][x];
                    if (mineTab[y][x] == 'X') { //filed with mine selected
                        failureGame();
                        break;
                    }
                }
            } else if (output.contains("mine")){ //case with mark mine
                //set or unset mine on field
                playerTab[y][x] = playerTab[y][x] == '*' ? '.' : '*';
            }
            cotinueGame = continueGame();
            if (!cotinueGame) {
                finalResult = "Congratulations! You found all mines!";
            }
            printBoard();
        }while(cotinueGame);
        System.out.println(finalResult);
    }
}
