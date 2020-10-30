package com.dp.stuff.rvs;

public class CountOfNextSmallestInt {

    class Item{
        int val;
        int index;

        public Item(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,1,5,12,3,1222,223,44,2,1};

        Item[] items = new Item[arr.length];
        CountOfNextSmallestInt cs = new CountOfNextSmallestInt();
        for(int i=0;i<arr.length;i++){
            items[i] = cs.new Item(arr[i],i);
        }

        Item[] sorted = new Item[arr.length];
        int[] count = new int[arr.length];
        
        breakMerge(items, sorted, count, 0, arr.length-1);

        for(int i:count){
            System.out.println(i);
        }

    }

    private static void breakMerge(Item[] items, Item[] sorted, int[] count, int start, int end) {
        if(start >= end){
            return;
        }

        int mid = (start+end)/2;

        breakMerge(items, sorted, count, start, mid);
        breakMerge(items, sorted, count, mid+1, end);

        sortAndMerge(items, sorted, count, start, end);
    }

    private static void sortAndMerge(Item[] items, Item[] sorted, int[] count, int start, int end) {
        int left = start;
        int leftEnd = (start+end)/2;
        int right = leftEnd+1;
        int rightEnd = end;
        int index = left;

        int counter =0;
        while(left <= leftEnd && right <= rightEnd){
            if(items[left].val <= items[right].val){
                count[items[left].index] += counter;
                sorted[index++] = items[left++];
            } else {
                counter++;
                sorted[index++] = items[right++];
            }
        }


        while(left <= leftEnd){
            count[items[left].index] += counter;
            sorted[index++] = items[left++];
        }

        while(right <= rightEnd){
            sorted[index++] = items[right++];
        }

        System.arraycopy(sorted, start, items, start, end-start+1);
    }
}
