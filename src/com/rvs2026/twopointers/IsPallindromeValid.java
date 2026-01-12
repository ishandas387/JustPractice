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
     *  where n is the length of the string s. 
     * In the worst case, the algorithm needs to traverse 
     * the entire string once using the two-pointer approach. 
     * Each character is visited at most once by either pointer i or j. 
     * Even though there are conditional checks for alphanumeric characters, 
     * the total number of iterations is still bounded by n since each iteration 
     * either advances i, decrements j, or both.
     * @param string
     * @return
     */
    private static boolean isPallindrome(String s) {

        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if(!Character.isLetterOrDigit(l)) {
                left++;
            }
            if(!Character.isLetterOrDigit(r)) {
                right--;
            }
            if(Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }

            left++;
            right--;
        }

        return true;

    }
}
