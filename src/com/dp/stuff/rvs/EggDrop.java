package com.dp.stuff.rvs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EggDrop {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of eggs");
        int eggs = Integer.parseInt(bf.readLine());
        System.out.println("Enter number of floors");
        int floors = Integer.parseInt(bf.readLine());
        System.out.println("min number of attemps to get where the egg breaks "+ eggBreak(eggs,floors));
    }

    private static String eggBreak(int eggs, int floors) {
        //create a 2D matrix to store bottom up approach DP
        int[][] matrix = new int[eggs+1][floors+1];

        //set the base case
        //if floor 1 then no matter the number of eggs the min will be 1 and 
        //if floor ->0 then 0 drops
        for(int i = 1; i<=eggs; i++){
            matrix[i][1] =1;
            matrix[i][0] =0;

        }

        //if 1 egg then base case is dependant on number of floors
        for(int j =0 ;j<floors; j++){
            matrix[1][j]=j;
        }

        //now for each stuff
        for(int i =2 ; i<=eggs; i++){
            for(int j = 2; j<=floors; j++){
                matrix[i][j] = Integer.MAX_VALUE;
                for(int x=1; x<=j ;x++){
                    int result = 1+ max(matrix[i-1][x-1], matrix[i][j-x]);
                    if(result < matrix[i][j]){
                        matrix[i][j] = result;
                    }
                }
            }
        }


        printTheMatrix(matrix,eggs, floors);
        return matrix[eggs][floors]+"";
    }

    private static int max(int i, int j) {
        return i>j? i:j;
    }

    private static void printTheMatrix(int[][] matrix, int eggs, int floors) {
        for(int i=0;i<=eggs;i++){
            for(int j=0; j<=floors;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }
}