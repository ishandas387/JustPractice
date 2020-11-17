package com.random.stuff;

public class NextSmallestAgain {
    class Item{
        int value;
        int index;

        public Item(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        NextSmallestAgain ns = new NextSmallestAgain();
        int arr[] = {3,2,1,4,6,1,2};
        Item[] items = new Item[arr.length];
        Item[] temp = new Item[arr.length];
        int results[] = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            items[i] = ns.new Item(arr[i], i);
        }

        mergeSortMechanism(items, temp, results, 0, arr.length-1);
        
        for(int i : results){
            System.out.println(i);
        }
    }

    private static void mergeSortMechanism(Item[] items, Item[] temp, int[] results, int start, int end) {
        if(start >= end){
            return;
        }

        int mid = (start+end)/2;
        mergeSortMechanism(items, temp, results, start, mid);
        mergeSortMechanism(items, temp, results, mid+1, start);

        sortAndMerge(items, temp, results, start, end);
    }

    private static void sortAndMerge(Item[] items, Item[] temp, int[] results, int start, int end) {
        int left = start;
        int leftEnd = (start+end)/2;
        int right = leftEnd+1;
        int rightEnd = end;

        int index = start;
        int counter = 0;

        while(left <= leftEnd && right <= rightEnd){
            if(items[left].value <= items[right].value){
                results[items[left].index] += counter;
                temp[index++] = items[right++];
            } else {
                counter++;
                temp[index++] = items[left++];
            }
        }

        while(left <= leftEnd){
            results[items[left].index] +=counter;
            temp[index++] = items[left++];
        }

        while(right <= rightEnd){
            temp[index++] = items[right++];
        }

        System.arraycopy(temp, start, items, start, end-start+1);
    
    }

}
