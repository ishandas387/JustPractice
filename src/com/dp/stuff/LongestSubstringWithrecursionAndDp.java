package com.dp.stuff;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithrecursionAndDp {

	public static void main(String[] args) {
		//O(n*m^2)
		//n being the longest string where we search
		//m being the string where we find the substring possibilities with 2 for loops
		String s1 = "ABCDAB"; 
		String s2 ="QWERTDABTEST";
		String largestCommonSubstring;
		//print(s2);
		if( s2.length()<s1.length()){
			largestCommonSubstring = findLargestCommonSub(s1,s2);
		}else{
			largestCommonSubstring = findLargestCommonSub(s2,s1);
		}
		System.out.println(largestCommonSubstring);
		
		
		//recursion
		
		System.out.println(findTheSubRecurssion(s1,s2,s1.length(),s2.length()));
		
		//dynamic top to bottom
		
		Map<String,Integer> lookup = new HashMap<>();
		System.out.println(findByDynamic(s1,s2,s1.length(),s2.length(), lookup).intValue());
		
	}

	//dynamic top to bottom using map
	private static Integer findByDynamic(String s1, String s2, int m, int n, Map<String, Integer> lookup) {
		if(m==0 || n==0){
			return 0;
		}
		String key = m+"-"+n;
		if(!lookup.containsKey(key)){
			
			if(s1.charAt(m-1)==s2.charAt(n-1)){
				lookup.put(key, findByDynamic(s1, s2, m-1, n-1, lookup)+1);
			}
			else{
				lookup.put(key, Integer.max(findByDynamic(s1, s2, m, n-1, lookup).intValue(),findByDynamic(s1, s2, m-1, n, lookup).intValue()));
			}
		}
		return lookup.get(key);
	}

	//recursion
	private static int findTheSubRecurssion(String s1, String s2, int m, int n) {
		
		if(m==0 || n==0){
			return 0;
		}
		if(s1.charAt(m-1)==s2.charAt(n-1)){
			return findTheSubRecurssion(s1,s2,m-1,n-1)+1;
		}
		return Integer.max(findTheSubRecurssion(s1, s2, m, n-1),findTheSubRecurssion(s1,s2,m-1,n));
	}

	private static String findLargestCommonSub(String large, String small) {
		String sub = null;
		String maxSub = null;
		int max=0;
		int length=0;
		
		for(int i=0;i<small.length();i++){
			for(int j=i+1;j<=small.length();j++) {
				String substring = small.substring(i, j);
				if(large.contains(substring)){
					if(substring.length()>=max){
						max= substring.length();
						maxSub=substring;
					}
				}
			}
		}
		return maxSub;
	}

}
