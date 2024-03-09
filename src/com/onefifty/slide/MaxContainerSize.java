package com.onefifty.slide;

import java.util.Stack;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the
 * two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * <p>Find two lines that together with the x-axis form a container, such that the container
 * contains the most water.
 *
 * <p>Return the maximum amount of water a container can store.
 *
 * <p>Notice that you may not slant the container.
 *
 * <p>Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation: The above vertical lines are
 * represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 */
public class MaxContainerSize {

  public static void main(String[] args) {
    int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    // brute force is checking all the pairs. O(n2)
    System.out.println("max area  " + getMax(arr));
  }

  // an area is calculated by min height of between the two columns as L and distance between the two points as B, L*B
  private static int getMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    int left = 0;
    int right = arr.length-1;
    while (left <= right) {
      max = Math.max(max, (Math.min(arr[left], arr[right]) * (right-1)));
      if (arr[left] < arr[right]) {
          left++;
      } else {
        right--;
      }
    }
    return max;
  }
}
