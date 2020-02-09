package com.string.stuff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Given a string S, find length of the longest substring with all distinct
 * characters. For example, for input "abca", the output is 3 as "abc" is the
 * longest substring with all distinct characters.
 * 
 * @author ishan
 *
 */
public class LongestDistinctSubstring {

	public static void main(String[] args) {


		// Lets do it with brute force. Get all substrings and find the highets length.

		// 3 nested forloops O(n^3)
		String s = "abcdab";
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {

			for (int j = i + 1; j <= n; j++) {

				if (allUnique(s, i, j)) {
					ans = Math.max(ans, j - i);
				}
			}
		}
		System.out.println(ans);

		// SLIDING WINDOW
		// for each addition of j items we dont need to check full substring everytime
		/**
		 * If a substring s_{ij}s ij ​ from index ii to j - 1j−1 is already checked to
		 * have no duplicate characters. We only need to check if s[j]s[j] is already in
		 * the substring s_{ij}s ij ​ .
		 */
		 System.out.println("sliding"+slidingWindow(s));
		 System.out.println("map "+doItByMap(s));
		 printLongestSubstring("");
		 printLongestSubstring2("");
	}

	//Time complexity O(2n) , space O(n)
	private static int slidingWindow(String s) {
		Set<Character> set = new HashSet<>();
		char[] ch = s.toCharArray();
		int i=0; int j =0;
		int ans = 0;
		while(i< ch.length-1 && j < ch.length-1){
			if(!set.contains(ch[j])){
				set.add(ch[j++]);
				ans = Math.max(ans, j-1);

			}else{
				set.add(ch[i++]);
			}
		}
		return ans;
	}

	private static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}

	//Use a map .
	// Store each char with index. 
	// if found in map. increment start pointer to that index.
	//Continue until end reaches the end

	private static int doItByMap(String s){
		s= "tmmzuxt";
		int n = s.length();
		Map<Character,Integer> map = new HashMap<>();
		int ans =0;
		for(int i =0, j=0 ; j<n;j++){
				if(map.containsKey(s.charAt(j))){
					//increment i 
					i = Math.max(map.get(s.charAt(j)),i);
					if( j == s.length()-1){
					ans = Math.max(ans, j-i+1);
					}
				} else {
					ans = Math.max(ans, j-i+1);
					map.put(s.charAt(j), j+1);
				}
		}
		return ans;
	}

	private static void printLongestSubstring(String s){
		s = "abcabcbb";
		String output ="";
		Map<Character,Integer> map = new HashMap<>();
		for(int start =0 ,  end =0; end < s.length(); end++){
			if(map.containsKey(s.charAt(end)) ){

				start = Math.max(map.get(s.charAt(end))+1, start);
				map.remove(s.charAt(end));
			} else {
				map.put(s.charAt(end), end);
			}
			if(output.length() < end -start +1){
				output = s.substring(start, end+1);
			}
		}
		System.out.println(output);

	}

	//this one works for every corner case
	private static void printLongestSubstring2(String s){
		s = "abcabcbb";
		String output ="";
		Set<Character> set = new HashSet<>();
		int i =0;
		int j=0;
		int ans =0;
		while(j < s.length()){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j));
				ans = Math.max(ans, j-i+1);
				j++;
			}else{
				set.remove(s.charAt(i));
				i++;
			}
		}
		System.out.println(ans);
	}
}
