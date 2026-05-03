package com.rvs2026.slidingwindow;

/**
 * Given array:

[2,1,5,1,3,2]

Find maximum sum of subarray size:

k = 3


 */
public class MaxSumSubarray {
    // O(n) and space O(1)
    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        slidingwindow(arr, k);
    }

    private static void slidingwindow(int[] arr, int k) {

        if(arr.length < k ) {
            System.out.println("-1");
        }
        int windowSum =0;
        int maxSum = 0;
        for(int i=0 ; i<k ; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // sliding the window

        for( int i =k ; i <arr.length; i++  ) {
            windowSum += arr[i] - arr[i-k];
            maxSum = Math.max(windowSum, maxSum);
        }

        System.out.println(maxSum);
    }
}
