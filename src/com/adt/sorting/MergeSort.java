package com.adt.sorting;

import java.time.temporal.TemporalUnit;

public class MergeSort {
    /** Kind of best in class.
        Space complexity: O(n) as it needs extra array of same length as temp array
        Time Complexity: O(nlogn) divides the array into half each time
        works on divide and conqur

    */
    public static void main(String[] args) {
        int[] arr = {3,5,2,6,1,6,2,65,111};
        int start =0;
        int end = arr.length-1;
        int [] temp = new int[arr.length];
        merge(arr, temp, start, end);
        for(int i: arr){
            System.out.println(i);
        }
    }

    private static void merge(int[] arr, int[] temp, int start, int end) {
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        merge(arr, temp, start, mid);
        merge(arr, temp, mid+1, end);
        sortMerge(arr, temp, start, end);
    }

    private static void sortMerge(int[] arr, int[] temp, int start, int end) {
        int leftStart = start;
        int leftEnd = (start+end)/2;
        int rightStart = leftEnd+1;
        int rightEnd = end;
        int left = leftStart;
        int right = rightStart;
        int index = left;

        while (left <= leftEnd && right <= rightEnd){
            if(arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd-left+1);
        System.arraycopy(arr, right, temp, index, rightEnd-right+1);
        System.arraycopy(temp, start, arr, start, end-start+1);

    }

}
