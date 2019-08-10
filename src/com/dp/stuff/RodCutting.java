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
		
		//System.out.println(getMaxProfitDynamic(price,lengthOfRod));

	}

	/*private static int getMaxProfitDynamic(int[] price, int lengthOfRod) {
		int[] data = new int[lengthOfRod+1];
		
		
	}*/

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
