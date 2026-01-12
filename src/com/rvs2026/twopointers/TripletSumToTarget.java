package com.rvs2026.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TripletSumToTarget {

    /**
     * Given an array of integers, return all triplets (a, b, c] such that a + b + c = 0. The
        solution must not contain duplicate triplets (e.g., [ 1, 2, 3] and [ 2, 3, 1] are £onsidered
        duplicate triplets), If no sud! triptets are found, return an empty array.
     */
    

        // brute force O(n^3) // 3 for loops ignore.

        //take a number from the array and treat it as a negative sum of the pair search algo.
        //O(n^2)
        public static List<List<Integer>> triplets(int[] arr) {

            List<List<Integer>> results = new ArrayList<>();
            Arrays.sort(arr); // O(nlogn)

            for(int i=0; i<=arr.length-1; i++) {
                final int effectiveI = i;
                            // Optimization: triplets consisting of only positive numbers will never sum
            // to 0.
            if (arr[i] > 0) {
                break;
            }
                if(i >0 && arr[i] == arr[i-1]) {
                    continue;
                    //avoids duplicates
                }

                List<List<Integer>> pairs = findPairsTwoSum(arr, i+1, -arr[i]);
                if(!pairs.isEmpty()) {
   
                    pairs.forEach(p -> {
                        List<Integer> trip = new ArrayList<>();
                        trip.add(arr[effectiveI]);
                        trip.addAll(p);
                        results.add(trip);
                    });

                }
            }

        
            return results;

        }

    public static List<List<Integer>> findPairsTwoSum(int[] nums, int start, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[left]);
                pair.add(nums[right]);
                pairs.add(pair);
                left += 1;
                // To avoid duplicate '[b, c]' pairs, skip 'b' if it’s the same as the
                // previous number.
                while (left < right && nums[left] == nums[left - 1]) {
                    left += 1;
                }
            } else if (sum < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        System.out.println(triplets(arr));
    }
}
