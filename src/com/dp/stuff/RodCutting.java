package com.dp.stuff;

/**
 * Given a length of rod and prices of each length. Find the best rod cuts for
 * getting max selling price.
 * 
 * @author ishan
 *
 */
public class RodCutting {

	public static void main(String[] args) {
		int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int lengthOfRod = 4;
		System.out.println(getMaxProfits(price, lengthOfRod));
		
		System.out.println("################################");
		
		System.out.println(getMaxProfitDynamic(price,lengthOfRod));

	}

	private static int getMaxProfitDynamic(int[] price, int n) {
		int val[] = new int[n+1]; 
        val[0] = 0; 
  
        // Build the table val[] in bottom up manner and return 
        // the last entry from the table 
        for (int i = 1; i<=n; i++) 
        { 
            int max_val = Integer.MIN_VALUE; 
            for (int j = 0; j < i; j++) 
                max_val = Math.max(max_val,  
                                   price[j] + val[i-j-1]); 
            val[i] = max_val; 
        } 
  
        return val[n];
		
		
	} 

	private static int getMaxProfits(int[] price, int n) {
		int max = Integer.MIN_VALUE;
		System.out.println("entering for "+n);
		if(n==0){
			return 0;
		}
		for (int i = 1; i <= n; i++) {
			System.out.println("addding price for " + i + " and " + n);
			int cost = price[i - 1] + getMaxProfits(price, n - i);
			if (cost > max) {
				max = cost;
			}
		}
		System.out.println("*******");
		return max;
	}

}
