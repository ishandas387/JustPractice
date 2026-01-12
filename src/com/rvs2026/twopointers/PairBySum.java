package com.rvs2026.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.HandlerBase;

public class PairBySum {

    /**
     * Given an array of integers nums and an
     *  integer target, return indices of the two 
     * numbers such that they add up to target.
     */
    
    // brute force O(n^2)
    public static List<List<Integer>> bruteForce(int[] arr, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i =0; i< arr.length-1; i++) {
            for(int j=i+1; j<arr.length-1 ; j++) {
                if(arr[i]+arr[j] == sum) {
                    results.add(Arrays.asList(i,j));
                }
            }
        }
        return results;
    }

    //sort and two pointer,  O(nlogn)
    public static List<List<Integer>> sortAndTwoPointers(int[] arr, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;

        while(left < right) {
            int local = arr[left]+arr[right];
            if( local == sum) {
                results.add(Arrays.asList(left, right));
            }

            if(local > sum) {
                right--;
            } else {
                left++;
            } 
        }
        return results;
    }

    // use a hashset, extra space but linear time, O(n)
    public static List<List<Integer>> useMap(int[] arr, int sum) {
        Map<Integer, Integer> mapOfValueAndLocation = new HashMap<>();
        List<List<Integer>> results = new ArrayList<>(); 
        
        for(int i=0 ; i<arr.length-1; i++) {
            int complement = sum - arr[i];
            if(mapOfValueAndLocation.containsKey(complement)) {
                results.add(Arrays.asList(mapOfValueAndLocation.get(complement), i));
            } 

            mapOfValueAndLocation.put(arr[i], i);
            
        }
        return results;
    }

    	public static void main(String[] args) {
		Long startTime = System.currentTimeMillis();
		int[] arr={1,2,2,4,6,7,4};
		int sum=8;
		System.out.println("*******");
		List<List<Integer>> pairBySum = bruteForce(arr,sum);
		System.out.println(pairBySum);
		System.out.println(System.currentTimeMillis() -startTime);
		System.out.println("*******");
		startTime=System.currentTimeMillis();
		System.out.println("*******");
		List<List<Integer>> pairBySum2 = sortAndTwoPointers(arr,sum);
		System.out.println(pairBySum2);
		System.out.println(System.currentTimeMillis() -startTime);
		System.out.println("*******");
		startTime=System.currentTimeMillis();
		System.out.println("*******");
		List<List<Integer>> pairBySum3 = useMap(arr,sum);
		System.out.println(pairBySum3);
		System.out.println(System.currentTimeMillis() -startTime);
		System.out.println("*******");
	}
}
