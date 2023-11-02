package com.onefifty.slide;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSubArry {
    
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int sum = 7;
        int n = minArr(arr, sum);
        System.out.println("min arr size "+ n);
        
    }

    /**
     * 
     * Two pointers right and left start from point zero.
     * With right expanding, create a window sum based on right function.
     * While the windowsum is greater than or equal to the desired sum, 
     * Remove left one by one from the sum and move left pointer forward.
     * Keep a note of min size.
     * return the min size.
     * 
     * Time complexity : O(n)
     * Space : O(1)
     */
    private static int minArr(int[] arr, int sum) {
       if(arr == null || arr.length == 0) {
        return 0;
       }

       int minSize = Integer.MAX_VALUE;
       int windowSum = 0;
       int left =0;
       for(int right =0; right < arr.length; right++) {
        windowSum += arr[right];
        while(windowSum >= sum) {
            minSize = Math.min(minSize, right - left +1);
            windowSum -= arr[left];
            left++; 
        }
       }

       if(minSize != Integer.MAX_VALUE) {
        return minSize;
       }

       return 0;
    }
}
