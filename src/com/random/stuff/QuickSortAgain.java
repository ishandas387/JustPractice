package com.random.stuff;

public class QuickSortAgain {
    public static void main(String[] args) {
        int[] arr = {233,132,5,21,2,11,46};

        quickSort(arr, 0, arr.length-1);
        for(int i : arr){
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr, int start, int end) {

        if(start >= end){
            return;
        }

        int pivot = (start+end)/2;
        int index = partition(arr, start, end, pivot);
        quickSort(arr, start, index-1);
        quickSort(arr, index, end);
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        while(left <= right){
            while(arr[left] < arr[pivot]){
                left++;
            }
            while(arr[right] > arr[pivot]){
                right--;
            }

            if(left <= right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    
}
