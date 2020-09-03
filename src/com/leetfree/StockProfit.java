package com.leetfree;

/**
 * Given stock prices for days in array . get me the max profit. BUY and SELL
 */
public class StockProfit {
    public static void main(String[] args) {
        int[] stockPrice = {7,1,5,3,6,4};
        System.out.println(maxProfit(stockPrice));
    }

    private static int maxProfit(int[] stockPrice) {
        int maxProfitV = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i=0; i< stockPrice.length; i++){
            if(stockPrice[i]  < minValue){
                minValue = stockPrice[i];
            }
            else {
                if(maxProfitV < (stockPrice[i] - minValue)){
                    maxProfitV = stockPrice[i] - minValue;
                }
            }
        }
        return maxProfitV;
    }
}