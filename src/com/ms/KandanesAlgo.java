package com.ms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class KandanesAlgo {

	/**
	 * Kandane's algo to find the max sum sub array
	 * @param args
	 */
	public static void main(String[] args) {
		 int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		 kandaneAlgo(a);
		 //find the missing number
		 // given an array find the missing element
		 // array of size N-1 and elements from 1 to N
		 int [] arr ={1,2,3,4,5,6,7,8,9,10,12};
		 findTheMissing(arr);
		 
		 //most occurring number in an array
		 int [] arr1 ={1,2,4,2};
		 maxOccur(arr1);
		 
		 		 
	}

	private static void maxOccur(int[] arr1) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i =0;i<arr1.length;i++){
			if(map.containsKey(arr1[i])){
				map.put(arr1[i], map.get(arr1[i])+1);
			}else{
				map.put(arr1[i],1);
			}
		}
		int max=0;
		int key=0;
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for(Entry<Integer, Integer> entry :entrySet){
			if(entry.getValue()>max){
				max =entry.getValue();
				key = entry.getKey();
			}
		}
		if(max ==1){
			System.out.println("-1");
		}else{
			System.out.println(key);
		}
	}

	private static void findTheMissing(int[] arr) {
		
		//sum from 1 to N = n(n+1)/2
		int sum = (arr.length+1)*(arr.length+2)/2;
		int total=0;
		for(int i =0;i<arr.length;i++){
			total += arr[i];
		} 
		System.out.println(sum-total);
		
	}

	private static void kandaneAlgo(int[] a) {
		int maxSum=0;
		 int maxSoFar=0;
		 for(int i=0;i<a.length;i++){
			 maxSum = maxSum + a[i];
			 if(maxSum > maxSoFar){
				 maxSoFar = maxSum;
				 
			 }
			 if(maxSum <0){
				 maxSum=0;
			 }
		 }
		 System.out.println(maxSoFar);
	}

}
