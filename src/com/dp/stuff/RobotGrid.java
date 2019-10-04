package com.dp.stuff;
/**
 * Given a grid and a robot placed on starting (0,0)
 * determine the number of ways the robot could reach (i,j)
 * considering it can only move down and right.
 *
 */
public class RobotGrid {

	public static void main(String[] args) {

		int[][] grid = new int[8][8];
		
		int r=4;
		int c=4;
		
		System.out.println("number of ways: "+ numWays(grid,r,c));
	}

	private static int numWays(int[][] grid, int r, int c) {
		for(int i=0;i<8;i++){
			grid[i][0]=1;
		}
		for(int j=0;j<8;j++){
			grid[0][j]=1;
		}
		
		for(int i=1;i<8;i++){
			for(int j=1;j<8;j++){
				grid[i][j]= grid[i][j-1]+grid[i-1][j];
			}
		}
		return grid[r][c];
		//the robot can only move down or right.
		
		//to reach any given point we have to determine how many ways to reach the previous left
		//and previous top point
		
		//base case
		//to reach any point in the first row [0][j] it's 1 way
		//to reach any point in the first column [i][0] it's 1 way 
		
		//utilizing the grid for storing values
	}

}
