package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

public class Game implements ILightsOut {
    private static final int SIZE = 5;
    private int moves;
    @Override
    public int getMoveCount() {
        return moves;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public boolean[][] getGrid() {
        return new boolean[5][5];
    }

    @Override
    public void makeMove(int x, int y) {
        boolean[][] gridArray = new boolean[SIZE][SIZE];
        gridArray[x][y] = !gridArray[x][y];

        moves++;

        if (x - 1 > -1){
            gridArray[x-1][y] = !gridArray[x-1][y];
        }
        if (y - 1 > -1){
            gridArray[x][y-1] = !gridArray[x][y-1];
        }
        if (x + 1 < 5){
            gridArray[x+1][y] = !gridArray[x+1][y];
        }
        if (y + 1 < 5){
            gridArray[x][y+1] = !gridArray[x][y+1];
        }


    }
}
