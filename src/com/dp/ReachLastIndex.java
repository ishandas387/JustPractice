package com.dp;

import java.lang.management.MemoryPoolMXBean;
import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0
 * to 1, then 3 steps to the last index.
 */
public class ReachLastIndex {
    public static void main(String[] args) {
        /**
         * a dynamic programming problem is a 4 step process:
         * 
         * Start with the recursive backtracking solution Optimize by using memoization
         * table (top-down3 dynamic programming) Remove the need for recursion
         * (bottom-up dynamic programming) Apply final tricks to reduce the time /
         * memory complexity
         */

        int[] nums = { 2, 3, 1, 1, 4 };
        int pos = 0;
        canJumpFromPos(pos, nums);

        // DP top down
        // top down with an array for memo
        int[] memo = new int[nums.length];
        // last index is always the good index.
        memo[memo.length - 1] = 1;
        Arrays.fill(memo, -1);

        // set all to unknown
        // 1 as good index from where last index can be reached
        // 0 as bad index
        canJumFromPosDp(pos, nums, memo);

        /**
         * Top-down to bottom-up conversion is done by eliminating recursion. In
         * practice, this achieves better performance as we no longer have the method
         * stack overhead and might even benefit from some caching. More importantly,
         * this step opens up possibilities for future optimization. The recursion is
         * usually eliminated by trying to reverse the order of the steps from the
         * top-down approach.
         */
        canJumpFromPosDpBotTop(pos, nums, memo);

        /**
         * Once we have our code in the bottom-up state, we can make one final,
         * important observation. From a given position, when we try to see if we can
         * jump to a GOOD position, we only ever use one - the first one (see the break
         * statement). In other words, the left-most one. If we keep track of this
         * left-most GOOD position as a separate variable, we can avoid searching for it
         * in the array. Not only that, but we can stop using the array altogether.
         * 
         * Iterating right-to-left, for each position we check if there is a potential
         * jump that reaches a GOOD index (currPosition + nums[currPosition] >=
         * leftmostGoodIndex). If we can reach a GOOD index, then our position is itself
         * GOOD.
         */
        canJumpFromPosGreedy(nums);
    }

    private static boolean canJumpFromPosGreedy(int[] nums) {
        int goodPos = nums.length-1;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i]+i >= goodPos){
                goodPos =i;
            }
        }
        return goodPos == 0;

        //cute
        //O(n) time complexity. single pass
        //O(1) space as no extra array is used.
    }

    private static boolean canJumpFromPosDpBotTop(int pos, int[] nums, int[] memo) {
        // no such base case
        // get this from back , the last but 1 index and move right to left.
        for (int i = nums.length - 2; i >= 0; i--) {
            int longestJump = Math.min(nums[i] + i, nums.length - 1);
            for (int j = i + 1; j <= longestJump; j++) {
                if (memo[j] == 1) {
                    memo[i] = 1;
                    break;
                }
            }
        }
        return memo[0] == 1;

        // O(n^2) as the complexity
        // no recurssion .
    }

    private static boolean canJumpFromPos(int pos, int[] nums) {
        // basic backtrack

        // base case
        if (pos == nums.length - 1) {
            return true;
        }

        int longestJump = Math.min(pos + nums[pos], nums.length - 1);
        for (int i = pos + 1; i < longestJump; i++) {
            if (canJumpFromPos(i, nums)) {
                return true;
            }
        }
        return false;

        /**
         * Time complexity : O(2^n) There are 2^n (upper bound) ways of jumping from the
         * first position to the last, where n is the length of array nums. For a
         * complete proof.
         * 
         * Space complexity : O(n). Recursion requires additional memory for the stack
         * frames.
         */

    }

    private static boolean canJumFromPosDp(int pos, int[] nums, int[] memo) {

        if (memo[pos] != -1) {
            return memo[pos] == 1 ? true : false;
        }

        int longestJump = Math.min(nums.length - 1, nums[pos] + pos);
        for (int i = pos + 1; i <= longestJump; i++) {
            if (canJumFromPosDp(i, nums, memo)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[pos] = 0;
        return false;

        /**
         * Time complexity : O(n^2). For every element in the array, e are looking at
         * the next nums[i] elements to its right aiming to find a GOOD index. nums[i]
         * can be at most n, where n is the length of array nums.
         * 
         * Space complexity : O(2n) = O(n)O(2n)=O(n). First n originates from recursion.
         * Second n comes from the usage of the memo table.
         */
    }

}