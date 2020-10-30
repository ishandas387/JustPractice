package com.dp;

import com.leetfree.DiString;

public class FrogJump {
    public static void main(String[] args) {
        // int[] arr = {1,3,2,4,8,10};
        // int[] arr = {2,6,8,5};
        int[] arr = { 1, 5, 5, 2, 6 };

        int maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int distance = 0;
            int j = i;
            while (j - 1 >= 0 && arr[j - 1] >= arr[j]) {
                j--;
            }
            int k = i;
            while (k + 1 < arr.length && arr[k + 1] >= arr[k]) {
                k++;
            }
            distance = (k - j) + 1;
            maxDist = Math.max(distance, maxDist);
        }
        System.out.println(maxDist);
        System.out.println("max distance achievable" + getMaxDistance(arr));
    }

    private static int getMaxDistance(int[] arr) {
        int pos = 0;
        return recurssiveCall(arr, 0, arr[0]);

    }

    private static int recurssiveCall(int[] arr, int pos, int value) {

        int max = Integer.MIN_VALUE;
        if (pos < 0 || pos == arr.length || arr[pos] < value) {
            return 0;
        } else {
            for(int i=pos;i<arr.length;i++){
                int dist = 0;
                dist = 1 + recurssiveCall(arr, i-1, arr[i]) + recurssiveCall(arr, i + 1, arr[i]);
                max = Math.max(max, dist);

            }

        }
        return max;
    }
}
