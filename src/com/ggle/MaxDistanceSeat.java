package com.ggle;

public class MaxDistanceSeat {
    public static void main(String[] args) {
        int[] arr = {1,0,0,0,1,0,1};
        int previous =-1;
        int future = 0;
        int ans = 0;

        int length = arr.length;
        for(int i=0; i<length; i++){
            if(arr[i] == 1){
                previous =i; 
            } else {
                 while(future < length && arr[future] ==0 || future<i){
                     future++;
                 }
                     int left = previous == -1? length : i-previous;
                     int right = future == length? length: future - i;
                     // min of left person or right person gives the closest person.

                     ans = Math.max(ans, Math.min(left, right));
            }
        }

        System.out.println(ans);

    }
}
