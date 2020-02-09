package com.leetfree;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of 1-N and the elements being anything from 1-N .
 * Find the first duplicate occurance
 * 
 * [1,2,3,1,4,5,3,4] ->>>> 1 at index 3
 * 
 */
public class FindFirstDuplicate{
    public static void main(String[] args) {
        int [] a = {1,2,3,1,4,5,2,4};
        System.out.println(a.length);

        System.out.println(twoPointers(a));
      

        //using hashset O(n) time and O(n) space

        Set<Integer> set = new HashSet<>();

        for(int i =0; i<= a.length -1 ; i++){
            if(set.contains(a[i])) {
                System.out.println(a[i] +"  at$ " +i);
                break;
            } else {
                set.add(a[i]);
            }
        }

        //Now given the fact that the array has only elements from 1-N . N being the length of element
        // Without hashset can we do something.
        for(int i =0 ; i< a.length ; i++){
            int index = Math.abs(a[i])-1; // as index starts from 0
            if(a[index] < 0){
                System.out.println(a[i] +"  at !" +i);
                break;
            } else {
                a[index] = Math.negateExact(a[index]);
            }

        }
        
    }

    private static String twoPointers(int[] a) {
          //two pointers O(n^2)
          for(int i=0; i<= a.length-1 ; i++ ){
            for(int j= i+1 ; j<= a.length-1 ;j++){
                if(a[i] == a[j]){
                    return (a[j] +"  at-- " +j);
                }
            }
        }
        return "none";
    }
}