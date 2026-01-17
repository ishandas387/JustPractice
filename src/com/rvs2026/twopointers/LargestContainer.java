package com.rvs2026.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 *  You are given an array of numbers, each representing the height of a vertical line on a graph,
    A container can be ~rmed with any pair of these lines, along with the x-axis o'f the graph,
    Return the amount of water which the largest container can hold.
 */
public class LargestContainer {

    // O(n)
    public static int findPairWithMaxArea(int[] heights) {
       
         int left = 0;
         int right = heights.length-1;

         int maxA = Integer.MIN_VALUE;

         while(left < right) {
            int maxArea = Math.min(heights[left], heights[right]) * (right - left);
            maxA = Math.max(maxA, maxArea);
            if(heights[left] < heights[right]) {
                left++;
            } else if(heights[right] < heights[left]) {
                right--;
            } else {
                left++;
                right--;
            }
         }
         return maxA;

    }

    public static void main(String[] args) {
            int[] heights = {2, 7, 8, 3, 7, 6 };
            int result = findPairWithMaxArea(heights);
            System.out.println(result);
    }
}
