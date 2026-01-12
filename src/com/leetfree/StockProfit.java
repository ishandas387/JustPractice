package com.leetfree;

/**
 * Given stock prices for days in array . get me the max profit. BUY and SELL
 */
public class StockProfit {
    public static void main(String[] args) {
        int[] stockPrice = {7,1,5,3,6,4};
        System.out.println(maxProfit(stockPrice));

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i =0 ; i<stockPrice.length ; i++) {

            if(stockPrice[i] <= min) {
                min = stockPrice[i];
            }
            if(stockPrice[i] >= max) {
                max = stockPrice[i];
            }
        }

        System.out.println(max-min);
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

    private static int maxTeam(int[] a, int[] b) {
        int l = a.length;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0; i<a.length; i++) {

            if(a[i] +b[i] > max) {
                max = a[i]+b[i];
                index = i;
            }
        }
        // team index on array. may be index +1 for team name
        return index;
    }
}