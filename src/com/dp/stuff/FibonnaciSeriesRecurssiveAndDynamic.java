package com.dp.stuff;

public class FibonnaciSeriesRecurssiveAndDynamic {

	public static void main(String[] args) {
		System.out.println(fiboByRecurssion(9));
		
		System.out.println(fiboByDynamicProg(9));
		System.out.println(Integer.MAX_VALUE);

	}
 
	private static int fiboByDynamicProg(int i) {
		int[] dp = new int[i+2];
		dp[0]=0;
		dp[1]=1;
		
		for(int j=2;j<=i ;j++){
			dp[j]= dp[j-1]+dp[j-2];
			
		}
		return dp[i];
	}

	private static int fiboByRecurssion(int i) {
		if(i<=1){
			return i;
		}
		return fiboByRecurssion(i-1)+fiboByRecurssion(i-2);
	}

}
