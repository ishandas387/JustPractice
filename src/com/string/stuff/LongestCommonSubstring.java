package com.string.stuff;

/**
 * Given two strings X and Y. The task is to find the length of the longest common substring.
 * @author ishan
 *
 */
public class LongestCommonSubstring {

	public static void main(String[] args) {
		//O(n*m^2)
		//n being the longest string where we search
		//m being the string where we find the substring possibilities with 2 for loops
		String s1 = "abcdefghxyzzzzz"; 
		String s2 ="qwetryxyzzzzzxy";
		String largestCommonSubstring;
		//print(s2);
		if( s2.length()<s1.length()){
			largestCommonSubstring = findLargestCommonSub(s1,s2);
		}else{
			largestCommonSubstring = findLargestCommonSub(s2,s1);
		}
		System.out.println(largestCommonSubstring);
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
