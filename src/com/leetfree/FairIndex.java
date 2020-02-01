package com.leetfree;
/**
 * Given an array get the fair index. Fair index is the index where the array can be
 * divided in to two equal parts with same sum.
 */
public class FairIndex{
    public static void main(String[] args) {
        //single array
        int [] arrA = {1,4,2,-2,5};
        int [] arrB ={7,-2,-2,2,5};
        int fairIndex = getFairIndex(arrB);
        System.out.println(fairIndex);
        
    }

    private static int getFairIndex(int[] arrA) {
        int sumTotalFromLeft = 0;
        for(int i =0 ; i<arrA.length;i++){
            sumTotalFromLeft += arrA[i];
        }
        int sumFromRight = 0;
        for(int j=arrA.length-1; j>=0; j--){
            sumFromRight += arrA[j];
            sumTotalFromLeft -= arrA[j];

            if(sumFromRight == sumTotalFromLeft){
                return j-1;
            }
        }
        return 0;
    }
}