package com.leetfree;

public class CopyZeroes {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7};
        int[] arr2 ={1,0,2,3,0,4,5,0};

        printDuplicateZeroes(arr2);
        for(int i: arr2){
            System.out.println(i);
        }

    }

    private static void printDuplicateZeroes(int[] arr) {
        int length_ = arr.length -1;
        int possibleDups = 0;
        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included  
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        int last = length_ - possibleDups;
        for(int i = last ; i>=0;i--){
            if(arr[i] == 0){
                arr[i+possibleDups] =0;
                possibleDups--;
                arr[i+possibleDups] = 0;

            } else {
                arr[i+possibleDups] =arr[i];
                
            }
        }
    }
}