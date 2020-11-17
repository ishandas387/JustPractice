package com.random.stuff;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateInConstantTime {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        List<Integer> results = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int value = Math.abs(nums[i]);
            if(nums[value-1] < 0){
                results.add(value);
            } else {
                nums[value-1] = - nums[value-1];
            }
        }
        
        for(int i : results){
            System.out.println(i);
        }
    }
}
