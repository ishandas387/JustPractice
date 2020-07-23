package com.ms;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,2,5,-11,6};

        //brute force will be all possible sum 
        // O(N^2)

        //GREEDY approach
        /**
         * iterate over the array and update at each step the standard set for such problems:

            current element

            current local maximum sum (at this given point)

            global maximum sum seen so far.
            O(N)
         */

         greedyStuff(arr);
         // O(N)
         /**
          * Constant space one. Move along the array and modify the array itself.
          * Linear space one. First move in the direction left->right, then in the direction right->left.
          */
         kadanesAlgo(arr);


    }

    private static void kadanesAlgo(int[] arr) {
        //constant space 
        // modify the same arr
        int max = arr[0];
        for(int i=1; i<arr.length;i++){
            if(arr[i-1] >0){
                arr[i] +=arr[i-1];
            }
            max = Math.max(arr[i], max);
        }
        System.out.println(max);
    }

    private static void greedyStuff(int[] arr) {

        int currsum = arr[0];
        int max = arr[0];
        for(int i=1; i<arr.length;i++){
            currsum = Math.max(arr[i], currsum+arr[i]);
            max = Math.max(currsum, max);
        }
        System.out.println(max);
    }
}