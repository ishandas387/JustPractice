package com.dp.stuff.rvs;

import java.util.HashMap;
import java.util.Map;

public class Fibo {
    
    public static void main(String[] args) {
        // get the fibonacci series. 
        System.out.println(fib(9));
        
        System.out.println(fibWithDp(9));
        
        System.out.println(fibWithDpBottomToTop(9));
    }
    
    //dp bottom top with just array
    private static int fibWithDpBottomToTop(int i) {
        int[] array = new int[i+1];
        array[0]=0;
        array[1]=1;
        for(int j =2 ; j<=i; j++ ){
            array[j] = array[j-1] + array[j-2];
        }
        return array[i];
    }

    public static int fib(int i) {
        if(i <= 1){
            return i;
        }
        return fib(i-1)+fib(i-2);
    }

    //dp with top to bottom

    public static int fibWithDp(int i){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        return fibTopToBottom(map,i);
    }

    private static int fibTopToBottom(Map<Integer, Integer> map, int i) {
        if(map.containsKey(i)){
            return map.get(i);
        }else{
            if(i <= 1){
                return i;
            }
            int nthValue = fibTopToBottom(map, i-1)+ fibTopToBottom(map, i-2);
            map.put(i, nthValue);
            return nthValue;
        }
    }

    
}