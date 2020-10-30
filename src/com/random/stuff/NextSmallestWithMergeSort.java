package com.random.stuff;

public class NextSmallestWithMergeSort {
    //leet 315

    class Item{
        int val;
        int index;

        public Item(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        
        int[] arr = {5,2,6,1};
        Item[] given = new Item[arr.length];
        NextSmallestWithMergeSort ns = new NextSmallestWithMergeSort();
        for(int i=0;i<arr.length;i++){
            given[i] = ns.new Item(arr[i], i);
        }

        Item[] sorted = new Item[arr.length];
        int[] count = new int[arr.length];

        breakMerge(given, sorted, count, 0, arr.length-1);

        for(int i : count){
            System.out.println(i);
        }
    }

    private static void breakMerge(Item[] given, Item[] sorted, int[] count, int start, int end) {
        
        if(start >= end){
            return;
        }

        int mid = (start+end)/2;
        breakMerge(given, sorted, count, start, mid);
        breakMerge(given, sorted, count, mid+1, end);

        sortAndMerge(given, sorted, count, start, end);
        
    }

    private static void sortAndMerge(Item[] given, Item[] sorted, int[] count, int start, int end) {
        
        int left = start;
        int leftEnd = (start+end)/2;

        int right = leftEnd+1;
        int rightEnd = end;
        int index = start;

        int counter = 0;
        while(left <= leftEnd  && right <= rightEnd){
            if(given[left].val <= given[right].val ){
                count[given[left].index] += counter;
                sorted[index++] = given[left++];
            } else {
                counter++;
                sorted[index++] = given[right++];
            }
        }

        while(left <= leftEnd){
            count[given[left].index] += counter;
            sorted[index++] = given[left++];
        }

        while(right < rightEnd){
            sorted[index++] = given[right++];
        }

        System.arraycopy(sorted, start, given, start, end-start+1);

    }
}
