package com.random;

// array of rod lengths will be givne
// array of price of each length will be given
// given a total length of rod
// cut it in the most profitable way 
// get me the max selling price. 
// optimization prob. 

// can be done through recurrsive 
// DP//
public class RodCutting {
    
    public static void main(String[] args) {

        int[] rodLengths = {1,2,3,4,5,8,9,10};
        int[] price =      {3,4,10,11,22,33,55,22};
        // 2+ 2 = 8
        // 1+3 = 13
        // 4 ~ 11
        //1+1+1+1 = 12


        int rod = 4;

        // for any given length it can be x and n-x; x<= rod
        int maxProfit = getMaxProfit(price, rod);

        int maxProfitDynamic = getMaxProfitDynamic(price, rod);

        System.out.println(maxProfit+"--"+maxProfitDynamic);
        
    }
    
    // exponetial recussive
    private static int getMaxProfit( int[] price, int rod) {
        int max = Integer.MIN_VALUE;
        if(rod == 0){
            return 0;
        }
        
        for(int i =1; i<rod;i++){
            
            int cost = Math.max(price[i-1], getMaxProfit(price, rod-i));
            if(cost>max){
                max= cost;
            }
        }
        
        return max;
    }
    
    //dynamic way storing the prevously calculted values. 
    private static int getMaxProfitDynamic(int[] price, int rod) {
        int[] val = new int[rod+1];
        val[0] =0;

        for(int i =1; i<= rod ; i++){
            int max = Integer.MIN_VALUE;
            for(int j=0 ; j<i;j++){
                max = Math.max(max, price[j] + val[i-j-1]);
            }
            val[i] = max;
        }
        return val[rod];
    }


}