package com.random.stuff;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MaxOccurance {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};

        int i = 0;
        int maxCount = Integer.MIN_VALUE;
        int maxPosition = 0;
        int counter = 0;
    
        while (i < arr.length) {
            if(i == 0) {
                counter++;
            }
            if(i != 0  && arr[i-1] != arr[i]) {
                    counter++;
                    if(counter > maxCount) {
                        maxCount = counter;
                        maxPosition = i;
                    }
            } else {
                counter = 1;

            }

            i++;
        }

        System.out.println(arr[maxPosition]);

    }

    private static void printMaxValUsingMap(int[] arr) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int i =0; i<arr.length; i++) {
            Integer count = counter.getOrDefault(arr[i], 0);
            count = count +1;
            counter.put(arr[i], count);
        }

        Set<Entry<Integer, Integer>> entrySet = counter.entrySet();
        
        
        int maxKey = 0;
        int maxVal = 0;
        for(Entry<Integer, Integer> e : entrySet ) {
            int v = e.getValue();
            if(v > maxVal){
                maxVal = v;
                maxKey = e.getKey();

            }
        }    
        
        System.out.println("max occurance in the array is of "+maxKey);
    }
}
