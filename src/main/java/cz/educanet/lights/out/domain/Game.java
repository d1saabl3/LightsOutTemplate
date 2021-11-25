package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

import java.util.Random;

public class Game implements ILightsOut {
    private static final int SIZE = 5;
    private int moves;
    private int turnedOn;
    private boolean[][] grid = new boolean[SIZE][SIZE];


    @Override
    public int getMoveCount() {
        return moves;
    }

    @Override
    public boolean isGameOver() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!grid[i][j]) {
                    turnedOn++;
                }
            }
        }
        if (turnedOn == 25) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean[][] getGrid() {
        return grid;
    }

    @Override
    public void randomize() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Random random = new Random();
                grid[i][j] = random.nextBoolean();
            }
        }
    }

    @Override
    public void makeMove(int x, int y) {
        grid[x][y] = !grid[x][y];

        moves++;

        if (x - 1 > -1){
            grid[x-1][y] = !grid[x-1][y];
        }
        if (y - 1 > -1){
            grid[x][y-1] = !grid[x][y-1];
        }
        if (x + 1 < SIZE){
            grid[x+1][y] = !grid[x+1][y];
        }
        if (y + 1 < SIZE){
            grid[x][y+1] = !grid[x][y+1];
        }


    }
}
