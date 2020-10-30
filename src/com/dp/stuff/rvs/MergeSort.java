package com.dp.stuff.rvs;

public class MergeSort {
    
    public static void main(String[] args) {
        int[] arr ={4,5,2,6,2,6,111,52,5332,12};

        int[] temp = new int[arr.length];

        breakMerge(arr, temp, 0, arr.length-1);

        for(int i: arr){
            System.out.println(i);
        }
    }

    private static void breakMerge(int[] arr, int[] temp, int start, int end) {

        if(start >= end){
            return;
        }

        int mid =(start+end)/2;
        breakMerge(arr, temp, start, mid);
        breakMerge(arr, temp, mid+1, end);

        sortAndMerge(arr, temp, start, end);
    }

    private static void sortAndMerge(int[] arr, int[] temp, int start, int end) {

        int left = start;
        int leftEnd = (start+end)/2;
        int right = leftEnd+1;
        int rightEnd = end;
        int index = start;

        while(left <= leftEnd && right <= rightEnd){
            if(arr[left] <= arr[right]){
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        while(left <= leftEnd){
            temp[index++] = arr[left++];
        }

        while(right <= rightEnd){
            temp[index++] = arr[right++];
        }

        System.arraycopy(temp, start, arr, start, end-start+1);
    }
}
