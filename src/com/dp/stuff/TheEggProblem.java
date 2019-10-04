package com.dp.stuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Find min tries to figure out egg break. with N eggs and K floors
 * @author ishan
 *
 */
public class TheEggProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("number of eggs");
		int eggs = Integer.parseInt(br.readLine());
		System.out.println("number of floors");
		int floors = Integer.parseInt(br.readLine());
	
		testEgg(eggs,floors);
	}

	private static void testEgg(int eggs, int floors) {
		
		//setting a matrix to save results of eggs and floors.
		int[][] matrix = new int[eggs+1][floors+1];
		
		int result=Integer.MAX_VALUE;
		
		//setting up the base case if floor =1 then 1 drop and floor 0 ->0 drops.
		for(int i=1;i<eggs;i++){
			matrix[i][1]=1;
			matrix[i][0]=0;
		}
		
		//base case for 1 egg where floors matter
		for(int j =0;j<floors;j++){
			matrix[1][j]=j;
		}
		
		//now for each egg after 1st egg and for each floor after first floor
		//try and loop for number of floor and result shall be ->
		//either the egg breaks or the egg doesnt
		//if egg breaks try for remaining egg from FLOOR-1 
		//if egg doesnt break try for same number of eggs but from remaining floors.
		//MAX of these two will give the result
		
		for(int i=2;i<=eggs;i++){
			for(int j=2;j<=floors;j++){  
				matrix[i][j]= Integer.MAX_VALUE;
				for(int x=1;x<=j;x++){
					result =1 + max(matrix[i-1][x-1],matrix[i][j-x]);
					if(result<matrix[i][j]){
						matrix[i][j]=result;
					}
				}
			}
		}
		
		//At the end of the loop the matrix with i,j will give the min try of egg break.
		System.out.println(matrix[eggs][floors]);
		
	}

	private static int max(int i, int j) {
		return i>j? i:j;
	}

}
