package com.random.stuff;

class CoreSorting{
    public static void main(String[] args) {

        int [] arrToSort = {1,9,5,3,11,46,2,5,8};
        //bubble sort
        bubbleSort(arrToSort);
        //insertion sort
        insertionSort(arrToSort);
        //selection sort
        selectionSort(arrToSort);
        // merge sort
        //tim sort
        //quick sort

        printTheArr(arrToSort);
    }

    private static void selectionSort(int[] arrToSort) {
        /**
         * Step 1 − Set MIN to location 0
            Step 2 − Search the minimum element in the list
            Step 3 − Swap with value at location MIN
            Step 4 − Increment MIN to point to next element
            Step 5 − Repeat until list is sorted
         */
        //O(n^2)

         for(int i =0; i<arrToSort.length; i++){
            int min = i;
            for(int j = i+1 ; j<arrToSort.length; j++){
                if(arrToSort[min] < arrToSort[j]){
                    min =j;
                }
            }
            if(min != i){
                swap(min, i, arrToSort);
            }
         }
         printTheArr(arrToSort);
    }

    private static void insertionSort(int[] arrToSort) {
        //its like sorting playing cards
        //Takes twice the place since uses anew array or list to insert
        int[] newArr = new int[arrToSort.length];
        for(int i=0;i<arrToSort.length;i++){
            if(newArr[i] > arrToSort[i]){
                newArr[i] = arrToSort[i];
            }
        }
        printTheArr(newArr);
    }

    private static void bubbleSort(int[] arrToSort) {
        //bubbling up in each iteration
        // reapeatedly swap the items when they are in wrong order
        // a list that is sorted in reverse order will be the worst case here. O(n^2)

        //optimisation -> check if swap has happened in the inner loop. If not stop the sorting.

        for(int i =0; i< arrToSort.length;i++){
            for(int j=i+1;j<arrToSort.length;j++){
                if(arrToSort[i] > arrToSort[j]){
                    swap(i,j, arrToSort);
                }
            }
        }
        printTheArr(arrToSort);
    }

    private static void swap(int i, int j, int[] arrToSort) {

        int temp ;
        temp = arrToSort[i];
        arrToSort[i] = arrToSort[j];
        arrToSort[j] = temp;
    }

    private static void printTheArr(int[] arrToSort) {
        for(int i = 0; i<arrToSort.length;i++ ){
            System.out.println(arrToSort[i]);
        }

        System.out.println("-----");
    }
}