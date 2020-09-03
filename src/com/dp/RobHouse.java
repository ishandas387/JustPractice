package com.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and
 * then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 */
public class RobHouse {
    public static void main(String[] args) {
        int[] houses = { 1, 2, 3, 1 };

        // For each entry in arr we will just need to check max - That entry plus i-2
        // postion OR just i-1 position without +

        int currentMax =0;
        int prevMax =0;

        for(int i : houses){
            int temp = currentMax;
            currentMax = Math.max(currentMax , prevMax+i);
            prevMax = temp;
        }

        System.out.println(currentMax);

        // trying the same thing in dp way of arr bottom up kind of

        int [] arr = new int[houses.length];
        //base case
        arr[0] = houses[0];
        arr[1] = Math.max(arr[0], houses[1]);
        for(int i=2; i<houses.length;i++){
           // at house i we can rob or not rob it
           //as we cannot rob adjecent houses, if we rob house i we will add it with house i-2
           // if we decide not to, then value of i-1 stays 

           // we will just have to decide on what is the MAX 
           arr[i] = Math.max(arr[i-2] + houses[i], arr[i-1]);
        }
        System.out.println(arr[arr.length-1]);
    }
}