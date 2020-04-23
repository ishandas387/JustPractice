package com.leetfree;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

    Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

    If S[i] == "I", then A[i] < A[i+1]
    If S[i] == "D", then A[i] > A[i+1]
 */

public class DiString {
    public static void main(String[] args) {
        
        print(getArray("IDDI"));
    }   

    public static int[] getArray(String input){
        int N = input.length();
        int low = 0;
        int high = N;
        int [] result = new int[N+1];
        for(int i =0 ; i<N; ++i){
            if(input.charAt(i) == 'I'){ 
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }
        result[input.length()] = low;
        return result;
    }

    public static void print(int[] a){
        for(int i =0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}