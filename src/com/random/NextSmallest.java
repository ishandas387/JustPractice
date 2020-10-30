package com.random;

public class NextSmallest {

    class Item{
        int val;
        int index;

        public Item(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        int start = 0;
        int end = arr.length-1;
        int[] count = new int[arr.length];

        Item[] items = new Item[arr.length];
        Item[] temp = new Item[arr.length];
        NextSmallest nsm = new NextSmallest();
        for(int i =0; i<arr.length;i++){
            items[i] = nsm.new Item(arr[i],i);
        }

        mergeSort(items, count, temp, start, end);
        for(Item i : temp){
            System.out.println(i.val);
        }

        System.out.println("********************");
        for(int i : count){
            System.out.println(i);
        }
        
    }

    private static void mergeSort(Item[] arr,int[] count, Item[] temp, int start, int end) {

        if(start >= end){
            return;
        }
        //break it into halves
        int middle = (start+end)/2;

        mergeSort(arr, count, temp, start, middle);
        mergeSort(arr, count, temp,  middle+1, end);
        
        //sort and merge the halves
        sortAndMerge(arr, count, temp, start, end);

    }

    private static void sortAndMerge(Item[] arr, int[] count, Item[] temp, int start, int end) {
        int leftEnd = (start+end)/2;;
        int rightStart = leftEnd+1;
        int leftStart = start;
        int size = end-start +1;
        int left  = leftStart;
        int right = rightStart;
        int index = leftStart;
      
        int counter=0;
        while(left <= leftEnd && right <= end){
            if(arr[left].val <= arr[right].val){
                temp[index] = arr[left];
                left++;
                count[arr[left].index] += counter;
            } else {
                counter++;
                temp[index] = arr[ right];
                right++;
            }
            index++;
        }

        while(left < leftEnd){
            count[arr[left].index] += counter;
            //temp--> copy from arr
            left++;
        }

        while(right < end){
           
        }

        //System.arraycopy(arr, left, temp, index, leftEnd-left+1);
        //System.arraycopy(arr, right, temp, index, end-right+1);
        System.arraycopy(temp, leftStart, arr, start, size);
    }
}
