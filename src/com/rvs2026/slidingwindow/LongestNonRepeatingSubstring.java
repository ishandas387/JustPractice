package com.rvs2026.slidingwindow;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string:
 * 
 * s = "abcabcbb"
 * 
 * Find the length of the:
 * 
 * longest substring
 * without repeating characters
 * Example
 * 
 * Input:
 * 
 * "abcabcbb"
 * 
 * Output:
 * 
 * 3
 * 
 * Because:
 * 
 * "abc"
 * 
 * is the longest substring without duplicates.
 */
public class LongestNonRepeatingSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestNonRepeatingSubstring(s));
        // Additional test cases
        System.out.println(longestNonRepeatingSubstring("bbbbb")); // Output: 1
        System.out.println(longestNonRepeatingSubstring("pwwkew")); // Output: 3
        System.out.println(longestNonRepeatingSubstring("")); // Output: 0
        System.out.println(longestNonRepeatingSubstring("au")); // Output: 2   
    }

	private static int longestNonRepeatingSubstring(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> seen = new HashSet<>();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while(left < right && seen.contains(c)) {
                seen.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            
            seen.add(c);
           
        }

        return maxLength;
	}

}
