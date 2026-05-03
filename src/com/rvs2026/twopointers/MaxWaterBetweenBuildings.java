package com.rvs2026.twopointers;

public class MaxWaterBetweenBuildings {

    /**
     * Given an array where each element represents building height:
     * 
     * height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 
     * Return how much rain water can be trapped.
     * 
     * 
     * Water depends on:
     * 
     * 1. Highest wall on LEFT
     * 
     * and
     * 
     * 2. Highest wall on RIGHT
     */

    public static void main(String[] args) {
          int[] height = {4,2,0,3,2,5};

        trpBruteForce(height); // o(n2) time because inner loops

        // if the left max is left right is calculated every iteration, why dont we save
        // it, or memoritize it.

        memotize(height); // 3 linear paases O(n) but storage also space complexity O(n)

        // how to avoid extra space. Can we do it in O(n) time and O(1) space.

        twoPointers(height);
    }

    /**
     * At every index:

        water=min(leftMax,rightMax)−height[i]
        Suppose:

leftMax = 2
rightMax = 5

Water level becomes:

min(2,5)=2

Meaning:

left side is limiting factor
right side does NOT matter anymore

So if:

leftMax < rightMax

we can safely process the left side.

Similarly:

if rightMax smaller → process right side

This is the entire trick.
     * @param height
     */
    private static void twoPointers(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0; 

        int water = 0;

        while(left < right) {
            if(height[left] < height[right]) {
                if(leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } 
            else {
                 if(rightMax <= height[right]) {
                    rightMax = height[right];
                 } else {
                    water += rightMax - height[right];
                 }
                 right --;
            }
        }

        System.out.println(water);
    }

    private static void memotize(int[] height) {

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // build leftmax
        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // calculate the water now

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        System.out.println(water);
    }

    /**
     * 
     * Water depends on:
     * 
     * 1. Highest wall on LEFT
     * 
     * and
     * 
     * 2. Highest wall on RIGHT
     * 
     * @param height
     */
    private static void trpBruteForce(int[] height) {

        int water = 0;

        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            water = water + Math.min(leftMax, rightMax) - height[i];
        }

        System.out.println(water);
    }

}
