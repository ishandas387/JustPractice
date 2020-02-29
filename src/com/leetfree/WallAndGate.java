package com.leetfree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a 2D matrix. -1 -> IS A WALL 0 -> IS A GATE INF -> represented as
 * infinity
 * 
 * Replace INF to the distance of the nearest gate. If no gate is accessible
 * keep it as INF.
 */
public class WallAndGate {

    private static final int INF = Integer.MAX_VALUE;
    private static int[][] grid = { { INF, -1, 0, INF }, { INF, INF, INF, -1 }, { INF, -1, INF, -1 },
            { 0, -1, INF, INF } };

    public static void main(String[] args) {
        int rows = grid.length;
        int col = grid[0].length;
        printTheGrid(grid);
        for(int r =0; r<rows; ++r){
            for(int c =0; c<col; ++c){
                if(grid[r][c] == 0){
                    dfs(r, c, 0);
                }
            }
        }
        System.out.println("------------");

        printTheGrid(grid);
      
    }

    
    private static void printTheGrid(int[][] grid2) {
        for(int i=0; i<grid2.length; ++i){
            for(int j=0; j<grid2.length; ++j){
                System.out.print(grid2[i][j]+" ");
            }
            System.out.println("");
        }
    }

    //DFS solution.
    //Start from  gate and iterate 
    private static void dfs( int r, int c, int dist) {
        int rows = grid.length;
        int col = grid[0].length;

        if(r >= rows || c >= col || r<0 ||c<0 || grid[r][c] == -1 ){
            return;
        }

        if(grid[r][c] >= dist){
            grid[r][c] = dist;
            dfs(r-1,c,dist+1);
            dfs(r,c-1,dist+1);
            dfs(r,c+1,dist+1);
            dfs(r+1,c,dist+1);
        }
    }


    //BFS solution O(mn) traversed atleast once
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] { 1,  0},
        new int[] {-1,  0},
        new int[] { 0,  1},
        new int[] { 0, -1}

        
        
);

}