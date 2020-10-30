package com.random;

public class MergeSort {


    
    public static void main(String[] args) {
        int[] arr = {3,5,2,6,1,6,2,65,111};
        int start = 0;
        int end = arr.length-1;
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, start, end);
        for(int i : arr){
            System.out.println(i);
        }
        
    }

    private static void mergeSort(int[] arr,int[] temp, int start, int end) {

        if(start >= end){
            return;
        }
        //break it into halves
        int middle = (start+end)/2;

        mergeSort(arr, temp, start, middle);
        mergeSort(arr, temp, middle+1, end);
        
        //sort and merge the halves
        sortAndMerge(arr, temp,start, end);

    }

    private static void sortAndMerge(int[] arr, int[] temp, int start, int end) {
        int leftEnd = (start+end)/2;;
        int rightStart = leftEnd+1;
        int leftStart = start;
        int size = end-start +1;
        int left  = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= end){
            if(arr[left] <= arr[right]){
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[ right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd-left+1);
        System.arraycopy(arr, right, temp, index, end-right+1);
        System.arraycopy(temp, leftStart, arr, start, size);
    }
}
