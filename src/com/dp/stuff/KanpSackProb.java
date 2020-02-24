package com.dp.stuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a bag which can carry max weight W. set of items with value and weight
 * of each. Find the max value items that can go into the bag.`
 *
 */
public class KanpSackProb {

	public static void main(String[] args) {
		int[] values ={20,5,10,40,15,25};
		int[] weights={1,2,3,8,7,4};
		int w=10;
		//include current item in bag and recur for other items with reduced
		//bag capacity.
		//exclude the current item and recur for the other items.
		
		int item = values.length-1;
		Long start = System.currentTimeMillis();
		System.out.println("Max profit value "+recursiveWayOfDoingThings(values,weights,item ,w));
		System.out.println("Time taken "+(System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		Map<String,Integer> lookUp = new HashMap<>();
		System.out.println("Max profit value with DP "+topToBottomDP(values,weights,item,w, lookUp));
		System.out.println("Time taken "+(System.currentTimeMillis() - start));
		
		
		start = System.currentTimeMillis();
		System.out.println("Max profit value with DP "+bottomUpDP(values,weights,item,w));
		System.out.println("Time taken "+(System.currentTimeMillis() - start));
	}

	private static int bottomUpDP(int[] values, int[] weights, int item, int w) {
		return 0;
	}

	private static int topToBottomDP(int[] values, int[] weights, int item, int w, Map<String, Integer> lookUp) {
		// base case
				if (w < 0) {
					return Integer.MIN_VALUE;
				}
				if (w == 0 || item < 0) {
					return 0;
				}
			String key = item +"|"+w;
			if(!lookUp.containsKey(key)){
				int include = values[item] +topToBottomDP(values, weights, item-1, w-weights[item],lookUp);
				//exclude the current item
				int exclude= topToBottomDP(values, weights, item-1,w,lookUp);
				
				lookUp.put(key, Integer.max(include, exclude));
			}
			return lookUp.get(key);
	}

	//recursive stuff is exponetial in time complexity.
	private static int recursiveWayOfDoingThings(int[] values, int[] weights, int item, int w) {
		System.out.println("item to check "+item+" bag with current weight "+w);
		// base case
		if (w < 0) {
			return Integer.MIN_VALUE;
		}
		if (w == 0 || item < 0) {
			return 0;
		}
		
		//include current item and check others
		System.out.println("adding item "+item+" to bag with w "+w);
		int include = values[item] +recursiveWayOfDoingThings(values, weights, item-1, w-weights[item]);
		//exclude the current item
		System.out.println("not adding item "+item+" to bag with w "+w);
		int exclude= recursiveWayOfDoingThings(values, weights, item-1,w);
		
		return Integer.max(include, exclude);
	}
	
	//Trying out DP with top->bottom approach with map
	

}
