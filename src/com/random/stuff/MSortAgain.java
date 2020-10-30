package com.random.stuff;

public class MSortAgain {
    
    public static void main(String[] args) {
        int[] arrToSort =  {5,4,3,2,1};

        int[] temp = new int[arrToSort.length];
        
        breakForMerge(arrToSort, 0, arrToSort.length-1, temp);
        
        for(int i : arrToSort){
            System.out.println(i);
        }

    }

    private static void breakForMerge(int[] arrToSort, int start, int end, int[] temp) {

        if(start >= end){
            return;
        }

        int mid = (start+end)/2;

        breakForMerge(arrToSort, start, mid, temp);
        breakForMerge(arrToSort, mid+1, end, temp);

        // sort and merge

        sortAndMerge(arrToSort, start, end, temp);

    }

    private static void sortAndMerge(int[] arrToSort, int start, int end, int[] temp) {

        int left = start;
        int mid = (start+end)/2;
        int leftEnd = mid;
        int right = mid+1;
        int rightEnd = end;
        int index = start;

        while(left <= leftEnd && right <= rightEnd){
            if(arrToSort[left] <= arrToSort[right]){
                temp[index++] = arrToSort[left++];
            } else {
                temp[index++] = arrToSort[right++];
            }
        }

        while(left <= leftEnd){
            temp[index++] = arrToSort[left++];
        } 

        while(right <= rightEnd){
            temp[index++] = arrToSort[right++];
        }

        System.arraycopy(temp, start, arrToSort, start, end-start+1);
    }
}
