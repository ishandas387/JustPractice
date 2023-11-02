package com.leetfree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D grid of 1(land) and 0(water) what is the farthest water.
 * grid The outside of the grid is out of bound.
 * 
 */
public class FarFromLand {
        private static int[][] grid = { { 1, 0, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };

    public static void main(String[] args) {
        System.out.println("far :: " + farFromCount(grid));
    }

    private static int farFromCount(int[][] grid2) {

        // Linearly traverse the grid
        int row = grid.length;
        int column = grid[0].length;

        int[] pointStorage = new int[row*column];
        Queue<int[]> q = new LinkedList<>();

        for(int i =0; i< row; i++){
            for(int j=0; j<column; j++){
                if(grid2[i][j] ==1) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        int level = -1;
        if(q.isEmpty() || q.size() == row*column) return -1;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()) {
            level++;
            int size = q.size();
            while(size-- >0){
                int[] pos = q.poll();
                for(int k=0; k<4;k++){
                    int r = pos[0] + directions[k][0];
                    int c = pos[1] + directions[k][1];
                    
                    if(r < 0 || c<0 || r >= row || c>= column || grid2[r][c] == 1) {
                        continue;
                    }
                    grid2[r][c] = 1;
                    q.offer(new int[]{r,c});
                }
            }
        }
        return level;
        

    }

}