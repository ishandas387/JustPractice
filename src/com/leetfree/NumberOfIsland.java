package com.leetfree;

import java.util.Arrays;
import java.util.List;

/**
 * Given a 2D grid of 1(land) and 0(water) count the number of island in the
 * grid The outside of the grid is water.
 * 
 */
public class NumberOfIsland {
        private static int[][] grid = { { 1, 0, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

    public static void main(String[] args) {
        System.out.println("island count " + getIslandCount(grid));
    }

    private static int getIslandCount(int[][] grid2) {

        // Linearly traverse the grid

        int islandCount = 0;
        if(grid.length == 0){
            return islandCount;
        }
        int row = grid.length;
        int column = grid[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == 1) {
                    islandCount++;
                    dfs(r, c);
                }
            }
        }
        return islandCount;
    }

    private static void dfs(int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        // depth first search surrounding
        // first the break point

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0;
        // mark as visited.
        // and dfs for neighbours

        dfs(r - 1, c);
        dfs(r + 1, c);
        dfs(r, c - 1);
        dfs(r, c + 1);
    }
}