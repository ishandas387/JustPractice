package com.random.stuff;

import java.util.Arrays;

/**
 * Given an array which is sorted and can have numbers - and +
 * return the squared array also sorted
 */
public class SortedSquaredArray {
    public static void main(String[] args) {
        int arr[] ={-3,-2,1,4,5};

        //brute force
        // sq the array and sort it
        //O(N) + sorting O(NlogN)

        int result [] = bruteForce(arr);

        //use two pointers left and right compare them and square them.
        //which ever larger square it and save it FROM end of the arry 
        //O(N)
        int result_best[] = singlePass(arr);
    }

    private static int[] singlePass(int[] arr) {
       int left =0;
       int right = arr.length;
       int outputarr[] = new int[arr.length];
       for(int i= arr.length; i>=0; i--){
           if(Math.abs(arr[left]) > Math.abs(arr[right])){
               outputarr[i] = arr[left] * arr[left];
                left++;
           } else{
            outputarr[i] = arr[right] * arr[right];
            right--;

           }
       } 
       return outputarr;
    }

    private static int[] bruteForce(int[] arr) {
        int outputarr[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            outputarr[i] = arr[i]*arr[i];

        }
        Arrays.sort(outputarr);
        return outputarr;
    }
}