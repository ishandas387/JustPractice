package com.rvs2026.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * You are given an array of integers nums and an integer k. There is a sliding
 * window of size k that starts at the left edge of the array. The window slides
 * one position to the right until it reaches the right edge of the array.
 * 
 * Return a list that contains the maximum element in the window at each step.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,1,0,4,2,6], k = 3
 * 
 * Output: [2,2,4,4,6]
 * 
 * Explanation:
 * Window position Max
 * --------------- -----
 * [1 2 1] 0 4 2 6 2
 * 1 [2 1 0] 4 2 6 2
 * 1 2 [1 0 4] 2 6 4
 * 1 2 1 [0 4 2] 6 4
 * 1 2 1 0 [4 2 6] 6
 * Constraints:
 * 
 * 1 <= nums.length <= 100,000
 * -10,000 <= nums[i] <= 10,000
 * 1 <= k <= nums.length
 * 
 * Step 1 — Pattern Recognition
 * 
 * Keywords:
 * 
 * window size k
 * maximum of each window
 * contiguous
 * 
 * This is:
 * 
 * Fixed Sliding Window
 * 
 * BUT:
 * 
 * requires fast max lookup.
 * 
 * 
 * Step 2 — Brute Force
 * 
 * For every window:
 * 
 * scan k elements
 * find max
 * Complexity
 * 
 * Windows:
 * 
 * O(n)
 * 
 * Each max search:
 * 
 * O(k)
 * 
 * Total:
 * 
 * O(nk)
 * 
 * Recognition Trick
 * 
 * If problem says:
 * 
 * maximum/minimum in every window
 * 
 * Think:
 * 
 * Monotonic Deque
 * 
 * Immediately.
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 0, 4, 2, 6};
        int k = 3;

        // change the below sysout to a method call to maxSlidingWindow and print the result
        int[] result = maxSlidingWindow(nums, k);

        System.out.println(java.util.Arrays.toString(result));

        // Additional test cases
        System.out.println(java.util.Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); // Output: [3, 3, 5, 5, 6, 7]
        System.out.println(java.util.Arrays.toString(maxSlidingWindow(new int[]{9, 11}, 2))); // Output: [11]
        System.out.println(java.util.Arrays.toString(maxSlidingWindow(new int[]{4, -2}, 2))); // Output: [4]
        System.out.println(java.util.Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1))); // Output: [1, -1]   
    }

    // brute force approach O(nk) time complexity, where n is the length of 
    // nums and k is the size of the window.
    // but monotonic deque approach can solve this in O(n) time complexity.
	private static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        //monotonic deque approach
        Deque<Integer> deque = new LinkedList<>();
        int pointer = 0;
        int index = 0;
        for(pointer =0; pointer < n ; pointer++) {
            // we add the index of the elements in the deque based on actual 
            // value of the element in the nums array.

            //4 parts to it.

            // 1. remove the elements from the back of the deque which are smaller than the current element
            // because they cannot be the maximum if there is a bigger element after them.
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[pointer]) {
                deque.pollLast();
            }
            // 2. add the current element index to the back of the deque
            deque.offerLast(pointer);
            // 3. remove the elements from the front of the 
            // deque which are out of the current window
            if(!deque.isEmpty() && deque.peekFirst() <= pointer - k) {
                deque.pollFirst();
            }
            // 4. if the window has hit size k, add the maximum element 
            // (which is at the front of the deque) to the result array
            if(pointer >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
        
		return result;
	}
}
