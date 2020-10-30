package com.leetfree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * In a given grid, each cell can have one of three values:
 * 
 * the value 0 representing an empty cell; the value 1 representing a fresh
 * orange; the value 2 representing a rotten orange.
 * 
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten
 * orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1 instead.
 */
public class RotOranges {

    class Pair {
        int row;
        int column;

        public Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args) {
        int[][] oranges = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        Queue<Pair> rottenStuff = new ArrayDeque<>();
        int timeElapsed = 0;
        int freshOranges = 0;
        int rowL = oranges.length;
        int columnL = oranges[0].length;
        RotOranges ro = new RotOranges();
        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < columnL; j++) {
                if (oranges[i][j] == 2) {
                    rottenStuff.offer(ro.new Pair(i, j));
                } else if (oranges[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, {0, - 1 } };
        rottenStuff.offer(ro.new Pair(-1, -1));

        // BFS
        while (!rottenStuff.isEmpty()) {
            Pair poll = rottenStuff.poll();
            int r = poll.row;
            int c = poll.column;

            if (r == -1) {
                timeElapsed++;
                if (!rottenStuff.isEmpty()) {
                    // every time you see -1 that means time has elapsed. each time
                    // something is added to the queue in the bounds of the grid
                    // time has elapsed and all of the neigbours are affected.
                    // so after each addition of neighbours add this -1 so that we
                    // can count the time elapsed.
                    rottenStuff.offer(ro.new Pair(-1, -1));
                }

            } else {
                // rotten
                for (int[] dir : directions) {
                    int neighbourRow = r + dir[0];
                    int neighbourCol = c + dir[1];
                    if (neighbourCol < columnL && neighbourRow < rowL && neighbourCol >= 0 && neighbourRow >= 0) {
                        if (oranges[neighbourRow][neighbourCol] == 1) {
                            freshOranges--;
                            oranges[neighbourRow][neighbourCol] = 2;
                            rottenStuff.offer(ro.new Pair(neighbourRow, neighbourCol));
                        }
                    }
                }

            }
        }

        System.out.println(freshOranges == 0 ? timeElapsed : -1);

    }
}
