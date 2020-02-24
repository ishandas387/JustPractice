package com.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetPairBySum {
	// O(n^2)
	public static List<List<Integer>> getPairBySum(int[] arr, int sum) {
		List<List<Integer>> listOfPairs = new ArrayList<>();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				if ((arr[i] + arr[j]) == sum) {
					List<Integer> list = new ArrayList<>();
					list.add(arr[i]);
					list.add(arr[j]);
					listOfPairs.add(list);
				}
			}
		}
		return listOfPairs;
	}

	// O(nlogn)
	public static List<List<Integer>> getPairBySumWithSort(int[] arr, int sum) {
		List<List<Integer>> listOfPairs = new ArrayList<>();
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int s = arr[start] + arr[end];
			if (s == sum) {
				List<Integer> list = new ArrayList<>();
				list.add(arr[start]);
				list.add(arr[end]);
				listOfPairs.add(list);
			}

			if (s < sum) {
				start++;
			} else {
				end--;
			}
		}
		return listOfPairs;
	}
	//O(n)
	public static List<List<Integer>> getPairBySumWithSet(int [] arr, int sum){
		List<List<Integer>> listOfPairs = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<=arr.length-1;i++){
			int temp = sum- arr[i];
			if(set.contains(temp)){
				List<Integer> list = new ArrayList<>();
				list.add(arr[i]);
				list.add(temp);
				listOfPairs.add(list);
			}
			set.add(arr[i]);
		}
		return listOfPairs;
	}

	//using a map
	public static List<List<Integer>> getPairBySumWithMap(int [] arr, int sum){
		//return the index
		Map<Integer,Integer> map = new HashMap<>();
		List<List<Integer>> listOfPairs = new ArrayList<>();
		for(int i=0;i<=arr.length-1;i++){
			int temp = sum- arr[i];
			if(map.containsKey(temp)){
				List<Integer> list = new ArrayList<>();
				list.add(map.get(temp));
				list.add(i);
				listOfPairs.add(list);
			}
			map.put(arr[i], i);
		}
		return listOfPairs;
	}
	public static void main(String[] args) {
		Long startTime=System.currentTimeMillis();
		
		int[] arr={1,2,2,4,6,7,4};
		int sum=8;
		System.out.println("*******");
		List<List<Integer>> pairBySum = getPairBySum(arr,sum);
		System.out.println(pairBySum);
		System.out.println(System.currentTimeMillis() -startTime);
		System.out.println("*******");
		startTime=System.currentTimeMillis();
		System.out.println("*******");
		List<List<Integer>> pairBySum2 = getPairBySumWithSort(arr,sum);
		System.out.println(pairBySum2);
		System.out.println(System.currentTimeMillis() -startTime);
		System.out.println("*******");
		startTime=System.currentTimeMillis();
		System.out.println("*******");
		List<List<Integer>> pairBySum3 = getPairBySumWithSet(arr,sum);
		System.out.println(pairBySum3);
		System.out.println(System.currentTimeMillis() -startTime);
		System.out.println("*******");
	}

}
