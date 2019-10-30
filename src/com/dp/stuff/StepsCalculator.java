package com.dp.stuff;
/**
 * Given n number of steps how many ways a person can complete given 
 * the number of ways the person can move to top
 * N number of steps available
 * X{} number of steps person can take
 * 
 *
 */
public class StepsCalculator {

	public static void main(String[] args) {

		int numberOfSteps = 5;
		int [] x ={1,2,3};
		
		System.out.println(findTheNumberOfWays(numberOfSteps));
		System.out.println("with array of steps "+findTheNumberOfWays(numberOfSteps,x));
		
		System.out.println("dp without array of steps  "+findTheNumberOfWaysDp(numberOfSteps));
		 
		
		System.out.println("dp with array of steps "+findTheNumberOfWaysDp(numberOfSteps,x));
	}

	private static int findTheNumberOfWays(int numberOfSteps, int[] x) {
		//base case
		if(numberOfSteps==0 ){
			return 1;
		}else{
			int total =0;
			for(int i=0;i<=x.length-1;i++){
				if(numberOfSteps-x[i]>=0){
					total += findTheNumberOfWays(numberOfSteps-x[i], x);
				}
			}
			return total;
			
		}
	}

	private static int findTheNumberOfWaysDp(int numberOfSteps, int[] x) {
		int[] store =new int[numberOfSteps+1];
		store[0]=1;
		
		for(int i=1;i<=numberOfSteps;i++){
			int total=0;
			for(int j=0;j<=x.length-1;j++){
				if(i-x[j]>=0){
					total += store[i-x[j]];
				}
			}
			store[i]=total;
		}
		return store[numberOfSteps];
	}

	//dynamic programming way
	private static int findTheNumberOfWaysDp(int numberOfSteps) {
		if(numberOfSteps==0 )
			return 1;
		int[] store =new int[numberOfSteps+1];
		//bottoms up
		//base case
		store[0]=1;
		store[1]=1;
		for(int i=2;i<=numberOfSteps;i++){
			store[i]= store[i-1]+store[i-2];
		}
		return store[numberOfSteps];
		
	}
	//recursive
	private static int findTheNumberOfWays(int n) {
		//this is just considering 2 step and 1 step
		
		//base case is considered // if 0 steps then 1//if 1 step then also 1 
		if(n ==0 || n==1){
			return 1;
		}else{
			return findTheNumberOfWays(n-1)+findTheNumberOfWays(n-2);
		}
		
		
		
	}

}
