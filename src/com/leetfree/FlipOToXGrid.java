package com.leetfree;
/**
 * Given a grid of X O. flip all O to X if it is surrounded by X. O in the boundaries are not considered.
 */
public class FlipOToXGrid{
    private static char[][] grid = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X'} };

    public static void main(String[] args) {

        //Kind of brute force with DFS
        printTheGrid(grid);
        flip();
        System.out.println("---------");
        printTheGrid(grid);
        ///////////////////////



    }

    private static void flip() {
        int r = grid.length;
        int c = grid[0].length;

  
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                
                    if(grid[i][j] == 'O'){
                        flipOToX(grid,i,j);
                }
            }
        }
        
    }

    private static void flipOToX(char[][] grid, int i, int j) {
        int r = grid.length;
        int c = grid[0].length;
        if(i == 0 || i >= r-1 || j==0 || j>=c-1  || grid[i][j] == 'X'){
            return ;
        }

        grid[i][j] = 'X';
        flipOToX(grid, i-1, j);
        flipOToX(grid, i+1, j);
        flipOToX(grid, i, j-1);
        flipOToX(grid, i, j+1);
    }




    private static void printTheGrid(char[][] grid2) {
        for(int i=0; i<grid2.length; ++i){
            for(int j=0; j<grid2.length; ++j){
                System.out.print(grid2[i][j]);
            }
            System.out.println("");
        }
    }
}