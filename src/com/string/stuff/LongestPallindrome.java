package com.string.stuff;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S, find the longest palindromic substring in S. Substring of
 * string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A
 * string which reads the same backwards. More formally, S is palindrome if
 * reverse(S) = S. Incase of conflict, return the substring which occurs first (
 * with the least starting index ).
 * 
 * NOTE: Required Time Complexity O(n2).
 * 
 * Input: The first line of input consists number of the testcases. The
 * following T lines consist of a string each.
 * 
 * Output: In each separate line print the longest palindrome of the string
 * given in the respective test case.
 * 
 * Constraints: 1 ≤ T ≤ 100 1 ≤ Str Length ≤ 104
 * 
 * Example: Input: 1 aaaabbaa
 * 
 * Output: aabbaa
 * 
 * Explanation: Testcase 1: The longest palindrome string present in the given
 * string is "aabbaa".
 * 
 * @author ishan
 *
 */
//O(n^2)
public class LongestPallindrome {

	public static void main(String[] args) {
		String str = "racecar";

		System.out.println(returnLargestPal(str));

	}

	private static String returnLargestPal(String s) {
		// TODO Auto-generated method stub

		// Validations
		if (s.isEmpty()) {
			return "Please enter a String";
		}

		if (s.length() == 1) {
			return s;
		}
		// Validations end
		// Start with one char (starting) as a longest palindrome
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i = i + 1) {

			// get longest palindrome for odd length (center is i)
			String tmp = checkForEquality(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

			// get longest palindrome for even length (center is i, i+1)
			tmp = checkForEquality(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}

		return longest;
	}

	/**
	 * In this method equality is checked starting from the center moving one
	 * character left and one character right from the center. If both chars are
	 * equal then the next set of chars are checked.
	 * 
	 */
	public static String checkForEquality(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		System.out.println("***"+s.substring(begin + 1, end));
		return s.substring(begin + 1, end);
	}

}
