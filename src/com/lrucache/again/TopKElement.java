package com.lrucache.again;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TopKElement {
    public static void main(String[] args) {
        int[] arr = { 10, 21, 2, 44, 1, 256, 11 };
        int k = 2;

        // sort and get naive way, O(n logn)

        naiveApproach(arr, k);

        System.out.println("*********");
        // same O(n logn)
        // using a min heap
        withMinHeap(arr, k);

        // O(n) approach will be try quick select approach
        // something to see like quicksort.
        // rather than sorting the full arr we just need to find the pivot at which
        // we can break the arr.

        System.out.println("*********");
        withQuickSelect(arr, k);
    }

    private static void withQuickSelect(int[] arr, int k) {
        int N = arr.length;
        // where do we find the kth largest element after the arr is sorted?
        // at N-K position
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int pivot = (left + right) / 2;
            int index = partition(arr, left, right, pivot);

            if (index == N - k) {
                System.out.println(arr[N - k]);
                return;
            } else if (index < N - k) {
                left = index+1;
            } else{
                right = index-1;
            }
        }
        System.out.println("end");

    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        
        int pivotVal = arr[pivot];
        swap(arr, right, pivot);
        
        int index = left;
        for(int i=left; i<right; i++){
            if(arr[i] < pivotVal){
                swap(arr, i, index);
                index++;
            }
        }

        swap(arr, pivot, right);
        return index;
        

    }

    private static void swap(int[] arr, int right, int pivot) {
        int temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
    }

    private static void withMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        for (int i : minHeap) {
            System.out.println(i);
        }
    }

    private static void naiveApproach(int[] arr, int k) {

        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 1; i <= k; i++) {
            System.out.println(arr[n - i]);
        }
    }

}
