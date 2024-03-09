package com.random.stuff;

public class CountIsland {
    private static int[][] grid = 
    { { 1, 0, 1, 1, 0 },
      { 1, 0, 0, 0, 0 },
      { 1, 1, 0, 0, 0 },
      { 0, 0, 0, 0, 0 } };

    public static void main(String[] args) {
        System.out.println("island count " + getIslandCount());
    }

    private static int getIslandCount() {
        int numberOfIslands = 0;
        int row = grid.length;
        int column =grid[0].length;
        if(row == 0 && column ==0){
            return numberOfIslands;
        }

        for(int r=0; r<row; r++){
            for(int c=0; c<column; c++){
                if(grid[r][c] ==1){
                    numberOfIslands++;
                    dfs(r,c, row, column);
                }
            }
        }
        return numberOfIslands;
    }

    private static void dfs(int r, int c, int row, int column) {

        if(r<0 || c<0 || r>=row || c >=column || grid[r][c] ==0){
            return;
        }
        grid[r][c] =0;

        dfs(r-1, c, row, column);
        dfs(r+1, c, row, column);
        dfs(r, c-1, row, column);
        dfs(r, c+1, row, column);
        
    }
}
