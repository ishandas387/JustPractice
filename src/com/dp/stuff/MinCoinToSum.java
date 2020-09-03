package com.dp.stuff;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1:
 * 
 * Input: coins = [1, 2, 5], amount = 11 Output: 3 Explanation: 11 = 5 + 5 + 1
 */
public class MinCoinToSum {
  
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        
        //bottom up
        buttomUp(coins, amount);

      

    }

    //O(N X S) n number of coin and S amount
    private static void buttomUp(int[] coins, int amount) {
        int[] dp= new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] =0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[amount] != amount+1){

            System.out.println(dp[amount]);
        } else {
            System.out.println(-1);
        }
    }

}