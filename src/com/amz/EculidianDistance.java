package com.amz;

import java.util.PriorityQueue;

public class EculidianDistance {

    public static void main(String[] args) {
        int[][] input = {{-5,4},{-6,-5},{4,6}};
        int k=2;
        calculateTheNearestK(input, k);
    }

    private static void calculateTheNearestK(int[][] input, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->(b[1]*b[1]+b[0]*b[0])-(a[1]*a[1]+a[0]*a[0]));
        for(int[] point : input){
            maxHeap.add(point);
            if(maxHeap.size()>k){
                maxHeap.remove();
            }
        }
        int[][] result = new int[k][2];
        while(k-- >0){
            result[k] = maxHeap.remove();
        }
        System.out.println(result);
    }
    
}