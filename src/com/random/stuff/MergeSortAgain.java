package com.random.stuff;

public class MergeSortAgain {
    public static void main(String[] args) {
        int[] arr = {3,2,1,55,1223,21,3};
        int[] results = new int[arr.length];
        breakTheArr(arr, results, 0, arr.length-1 );

        for(int i : arr){
            System.out.println(i);
        }
        
    }

private static void breakTheArr(int[] arr, int[] results, int start, int end) {

        if(start >= end){
            return;
        }

        int mid = (start+end)/2;
        breakTheArr(arr, results, start, mid);
        breakTheArr(arr, results, mid+1, end);
        sortAndMerge(arr, results, start, end);

    }

    private static void sortAndMerge(int[] arr, int[] results, int start, int end) {
        
        int left = start;
        int leftEnd = (start+end)/2;
        int right = leftEnd+1;
        int rightEnd = end;
        int index = start;

        while(left<= leftEnd && right <= rightEnd){
            if(arr[left] < arr[right]){
                results[index++] = arr[left++];
            } else {
                results[index++] = arr[right++];
            }
        }

        while(left<= leftEnd){
            results[index++] = arr[left++];
        }

        while(right <= rightEnd){
            results[index++] = arr[right++];
        }

        System.arraycopy(results, start, arr, start, end-start+1);
      
    }
}
