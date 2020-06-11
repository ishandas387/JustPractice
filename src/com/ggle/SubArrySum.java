package com.ggle;

/**
 * Given an array of integers and an integer k,
 *  you need to find the total number of continuous subarrays whose sum equals to k.
 */
public class SubArrySum {
    public static void main(String[] args) {
        int [] nums = {1,1,1};
        int k = 2;
        int count =0;

        //brute force // rough
        for(int i =0; i<nums.length; i++){
            int sum = nums[i];
            for(int j=i; j<nums.length;j++){
                if(i == j && nums[i] == k){
                    count++;
                    continue;
                } else {
                    if(i != j){

                        sum += nums[j];
                        if(sum == k){
                            count++;
        
                        } else if(sum > k){
                            break;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        // or just get all possible sub arrays and within loop 2 use another loop to get the sum 
        //On^3
        int count2=0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++)
                    sum += nums[i];
                if (sum == k)
                count2++;
            }
        }

        //On^2
        int count3 = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count3++;
            }
        }
         //gettinng the cumulative sum and checking 

        int count4 = 0;
        int[] csum = new int[nums.length+1];
        for (int start = 0; start < nums.length; start++) {
            csum[start] += nums[start];
            if(start ==0){
                if(csum[start] == k){
                    count4++;
                }
            } else {
                if(csum[start] == k){
                    count4++;
                } else {
                    int seen = csum[start] - k ;
                    for(int i =0 ; i<csum.length;i++){
                        if(seen == csum[i]){
                            count4++;
                        }
                    }
                }
            }
        }

        System.out.println(count  +"---"+count2+"-----"+count3+"----"+count4);

      
    }
}