package com.ggle;
/**
 * You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.

    Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.

    A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
    A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
    We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.

    Return an array answer of size n where answer{i} is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.


 */
public class WhereTheBallFalls {
    private static int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
    public static void main(String[] args) {
        // if the cell has +1 then check the column +1 cell ( to right )
        // if the cell has -1 then check the column -1 cell ( to left )
        // if the destination cell has the same value as the previou cell then ball will roll
        // if not then then ball is stuck
        // or if the destination cell is out of bounds the ball is stuck as well
        // dfs

        int[] result = new int[grid[0].length];

        // recursive 
        // for each column, process value
        for(int i = 0; i<grid[0].length; i++) {
            result[i] = recursiveBallDrop(0, i, grid);
        }

        // iterative
        // for each column check the row 
        int[] iResult = new int[grid[0].length];
        for ( int c = 0; c< grid[0].length; c++ ) {
            int currentCol = c;
            for(int r =0; r<grid.length; r++) {
                int nextCol = c + grid[r][c];
                if(nextCol < 0 || nextCol > grid[0].length -1 ||
                    grid[r][c] != grid[r][nextCol]){
                        iResult[c] = -1;
                        break;
                    }
                    iResult[c] = nextCol;
                    currentCol = nextCol;
            }
        }

        // dynamic

    }
    private static int recursiveBallDrop(int row, int column, int[][] grid2) {
        if(row == grid2.length) {
            return column;
        }
        int nextCol = grid2[row][column] + column;
        if(nextCol < 0 || nextCol > grid2[0].length-1 || 
        grid2[row][column] != grid2[row][nextCol]) {
            return -1;
        }
        return recursiveBallDrop(row+1, nextCol, grid2);
    }
}
