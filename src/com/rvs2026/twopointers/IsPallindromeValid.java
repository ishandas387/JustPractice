package com.rvs2026.twopointers;

/**
 * given a string validate it if its a pallindrome
 */
public class IsPallindromeValid {

    public static void main(String[] args) {
        System.out.println(isPallindrome("abba"));
        System.out.println(isPallindrome("racecar"));
        System.out.println(isPallindrome("racecar2"));
    }

    /**
     * The time complexity is O(n),
     * where n is the length of the string s.
     * In the worst case, the algorithm needs to traverse
     * the entire string once using the two-pointer approach.
     * Each character is visited at most once by either pointer i or j.
     * Even though there are conditional checks for alphanumeric characters,
     * the total number of iterations is still bounded by n since each iteration
     * either advances i, decrements j, or both.
     * 
     * @param string
     * @return
     */
    private static boolean isPallindrome(String s) {
        if (s == null)
            return false;
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!Character.isLetterOrDigit(l)) {
                left++;
            }
            if (!Character.isLetterOrDigit(r)) {
                right--;
            }
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }

            left++;
            right--;
        }

        return true;

    }

    // without using inbuilt function
    public static boolean isPalindromeWithoutInbuiltFunction(String s) {
        if (s == null)
            return false;

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Skip non-alphanumeric from left
            while (left < right && !isAlphanumeric(chars[left])) {
                left++;
            }

            // Skip non-alphanumeric from right
            while (left < right && !isAlphanumeric(chars[right])) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (toLowerCase(chars[left]) != toLowerCase(chars[right])) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }

    private static char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32); // Convert to lowercase
        }
        return c;
    }
}
