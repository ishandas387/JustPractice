package com.string.stuff;

import java.util.Arrays;

/**
 * Given a string, the task is to remove duplicates from it. Expected time complexity O(n) 
 * where n is length of input string and extra space O(1) under the assumption that 
 * there are total 256 possible characters in a string.
 * @author ishan
 *
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		final int MAX = 256;
		int [] charInt = new int[MAX];
		Arrays.fill(charInt, 0);
		
		//String s ="new years eeeeve new";
		String s ="geeksforgeeks";
		char[] charArray = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<charArray.length;i++){
			if(charInt[charArray[i]] ==1){
				continue;
			}else{
				charInt[charArray[i]]++;
				sb.append(charArray[i]);
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
