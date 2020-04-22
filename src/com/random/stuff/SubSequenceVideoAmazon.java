package com.random.stuff;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.math.*;

public class SubSequenceVideoAmazon {

    public static void main(String[] args) {
            String a[] = new String[] { "a", "b", "c","a" }; 
  
            List<String> list = Arrays.asList(a); 

            System.out.println(getTheSubsequence(list));
    }

    private static List<Integer> getTheSubsequence(List<String> list){
            Map<String, Integer> map = new HashMap<>();
            for(int i =0; i<list.size();i++){
                map.put(list.get(i), i);
            }
            int left =0;
            int right =0;
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < list.size(); i++)
            {
                right = Math.max(right, map.get(list.get(i)));
                if (right == i)
                {
                    result.add(1 + right - left);
                    left = right + 1;
                }
            }
            return result;
        }
    
}