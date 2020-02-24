package com.ms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triplets {
    //given an array and target. Get all list of triplets which satisfy sum as target.
    public static void main(String[] args) {
        int a[] ={-1,0,1,2,-1,-4};
        int sum =0;
        System.out.println(basic(a,sum));
    }

    private static Set<List<Integer>> basic(int[] a, int sum) {
        Set<List<Integer>> listOfList = new HashSet<>();
        for(int i=0; i<a.length;i++){
            for(int j=0;j<a.length;j++){
                for(int k=0; k<a.length; k++){
                    List<Integer> list = new ArrayList<>();
                    if(i != j && i!=k && j != k){
                        if(a[i]+a[j]+a[k] == sum){
                            list.add(a[i]);
                            list.add(a[j]);
                            list.add(a[k]);
                            listOfList.add(list);
                        }
                    }
                }
            }
        }
        return listOfList;
    }
}