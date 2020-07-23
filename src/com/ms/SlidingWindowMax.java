package com.ms;

/**
 * Given an array nums, there is a sliding window of size k which
 *  is moving from the very left of the array to the very right.
 *  You can only see the k numbers in the window. Each time the sliding 
 * window moves right by one position. Return the max sliding window.
 */
public class SlidingWindowMax {
    public static void main(String[] args) {
        // There are N - k + 1 sliding windows and there are k elements in each window
        //  O(Nk).
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        bruteWay(nums,k);

        //Using a heap
        //O(NlogK)
        
    }

    private static int[]  bruteWay(int[] nums, int k) {
        //if k is size 0 return 
        if(nums.length * k ==0){
            return new int[0];
        }
        int outputArrLength = (nums.length - k)+1;
        int[] out = new int[outputArrLength];
        for(int i=0;i<outputArrLength;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                max = Math.max(max, nums[j]);
            }
            out[i] = max;
        }

       return out;
    }
}