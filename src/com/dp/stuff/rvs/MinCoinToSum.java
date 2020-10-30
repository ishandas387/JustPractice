package com.dp.stuff.rvs;

import java.util.Arrays;

public class MinCoinToSum {
    public static void main(String[] args) {
        int[] coins = {1,5,10,2};
        int sum = 12;
        System.out.println(getMinCoinToSum(coins, sum));
    }

    private static int getMinCoinToSum(int[] coins, int sum) {
        int[] sumArr = new int[sum+1];

        Arrays.fill(sumArr, sum+1);
        sumArr[0]=0;
        for(int i=0; i<=sum; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j] <= i){
                    sumArr[i] = Math.min(sumArr[i], sumArr[i - coins[j]]+1);
                }
            }
        }
        if(sumArr[sum] == sum+1){
            return -1;
        } else {
            return sumArr[sum];
        }

    }
}
