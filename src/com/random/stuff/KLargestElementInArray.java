package com.random.stuff;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class KLargestElementInArray {

    public static void main(String[] args) {

        // find Kth largest element in array;

        int[] arr = { 12, 33, 45, 12, 11, 55 };
        // clearly 45 55 are the largest if k = 2
        findKthLargestWithSorting(arr, 2);
        System.out.println("--------");
        findKthLargestWithHeap(arr, 2);

        //avg case O(n) is based on quick sort mechanism of selecting a pivot and arranging the array;
        // however if the pivot is selcted to be the largest or the smallest element in the arr
        // then the worst case run time is O(n^2)

        //just a new unsorted arr
        int[] arr2 = { 12, 33, 45, 12, 11, 55 };
        System.out.println("--------");
        findKthLargestWithQuickSelect(arr2, 2);

    }

    private static void findKthLargestWithQuickSelect(int[] arr2, int k) {

        int length = arr2.length;
        int left = 0;
        int right = length-1;
        Random rand = new Random(0);
        while(left <= right){
            //chose a random pivot 
            int pivot = rand.nextInt(right - left+1)+left;
            int indexAfterPartition = partitionP(arr2, left, right, pivot);

            if(indexAfterPartition == length - k){
                // that means it is exactly at the position where it should be
                // in an array 1,2,3,4,5 -> 2nd largest is 4 @ index (length - k) i.e (5-2) index 3 --> arr[3]==4

                System.out.println(arr2[indexAfterPartition]);
                System.exit(1);

            } else if ( indexAfterPartition > length-k){
                // then the pivot is at the right side and we will move the right pointer back
                right = indexAfterPartition-1;
            } else {
                // it is more ahead
                left = indexAfterPartition+1;
            }

        }

        System.out.println("not found");

    }

    private static int partitionP(int[] arr2, int left, int right, int pivot) {
        int pivotValue = arr2[pivot];
        //keep aside the pivot
        swap(arr2, pivot, right);
        //this is the tailindex of lesser item, just starts with left , but 
        // when the item in iteration is less than pivot value we swap the item with this index
        // and move this index forward
        int index = left;

        for(int i=left; i<right ; i++){
            if(arr2[i] <pivot){
                swap(arr2, i, index);
                index++;
            }
        }

        // once partion is done, we swap the pivot back to the the index as that is where it belongs when sorted
        swap(arr2, right, index);
        return index;
    }

    private static void swap(int[] arr2, int pivot, int right) {
        int temp = arr2[pivot];
        arr2[pivot] = arr2[right];
        arr2[right] = temp;
    }

    private static void findKthLargestWithHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a.compareTo(b));
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }


        }

        for(int i: minHeap){
            System.out.println(i);
        }


        //similar O(N logN)
    }

    private static void findKthLargestWithSorting(int[] arr, int k) {
        // sorting so O(N logN)

        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
            k--;
            if (k == 0) {
                break;
            }
        }
    }
}
