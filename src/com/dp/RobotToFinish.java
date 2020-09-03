package com.dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 */
public class RobotToFinish {
    public static void main(String[] args) {
        //linear recurssive basic
        //to reach any point it can either come from top or left
        int m=5;
        int n=5;
        uniquePaths(m,n);

        //dp way of doing would be have a 2D array memotize
        uniquePathsdp(m,n);
    }

    private static int uniquePathsdp(int m, int n) {
        //O(N X M)
        int[][] memo = new int[m][n];

        //initialize , any way to reach the first row is 1 from left side.
        // any number of paths to reach 1st column is 1 from up

        for(int i=0;i<n;i++){
            memo[0][i] =1;
        }
        for(int i=0;i<m;i++){
            memo[m][0] =1;

        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j] = memo[i-1][j] + memo[i][j-1];
            }
        }
        return memo[m][n];
    }

    private static int uniquePaths(int m, int n) {
        if(m==1 || n ==1){
            return 1;
        }
        return uniquePaths(m, n-1)+uniquePaths(m-1, n);
    }
}