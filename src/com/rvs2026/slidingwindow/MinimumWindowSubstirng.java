package com.rvs2026.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given two strings:
 * 
 * s = "ADOBECODEBANC"
 * t = "ABC"
 * 
 * Find the smallest substring in s
 * that contains ALL characters of t.
 * 
 * Example
 * 
 * Input:
 * 
 * s = "ADOBECODEBANC"
 * t = "ABC"
 * 
 * Output:
 * 
 * "BANC"
 * 
 * 
 * Step 1 — Pattern Recognition
 * Keywords
 * smallest substring
 * contains all characters
 * contiguous
 * 
 * 
 * Important Observation
 * 
 * We need:
 * 
 * expand window until VALID
 * shrink window to minimize size
 * 
 * This is the classic:
 * 
 * expand → valid
 * shrink → optimize
 * 
 * pattern.
 * This screams:
 * 
 * Variable Size Sliding Window
 * 
 * Core Sliding Window Pattern
 * Expand Until Valid
 * right++
 * Shrink While Valid
 * while(valid)
 * 
 * This is THE most important variable-window pattern.
 * 
 * 
 * 
 * The algorithm naturally finds the minimum window because:
 * 
 * We only expand when we don't have enough characters
 * We always try to contract when we have a valid window
 * We keep track of the smallest valid window seen throughout the process
 * 
 * This approach ensures we examine each character at most twice (once when
 * expanding,
 * once when contracting), giving us an efficient O(m + n) solution where m and
 * n are the lengths of strings s and t.
 */
public class MinimumWindowSubstirng {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));

        // Additional test cases
        System.out.println(minWindow("a", "a")); // Output: "a"
        System.out.println(minWindow("a", "aa")); // Output: ""
        System.out.println(minWindow("ab", "A")); // Output: ""
        System.out.println(minWindow("aaflslflsldkalskaaa", "aaa")); // Output: "aaa"
        
    }

    // O(m + n) time complexity, where m and n are the lengths of s and t respectively.
    private static int minWindow(String source, String target) {

        if (target == null || target.length() == 0 || source == null || source.length() == 0) {
            return 0;
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : target.toCharArray()) {
            targetMap.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;

        int required = targetMap.size();
        int formed = 0;
        for (right =0; right < source.length(); right++) {
            char c = source.charAt(right);
            windowMap.merge(c, 1, Integer::sum);

            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point it ceases to be 'desirable'.
            while (left <= right && formed == required) {
                char leftChar = source.charAt(left);
                minLength = Math.min(minLength, right - left + 1);

                // decrease the count of the leftmost character and check if it is still valid
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (targetMap.containsKey(leftChar) 
                    && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
