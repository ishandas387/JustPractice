package com.ggle;

import java.util.Stack;

/**
 * Given two sequences pushed and popped with distinct values, return true if
 * and only if this could have been the result of a sequence of push and pop
 * operations on an initially empty stack.
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1] Output: true Explanation:
 * We might do the following sequence: push(1), push(2), push(3), push(4), pop()
 * -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 
 * 
 * Questions - both the arrays will always be the same length ?
 * the items in the array will be same or it can also be like a number which is not present in pushed arr.
 * 
 * 0 <= pushed.length == popped.length <= 1000
    0 <= pushed[i], popped[i] < 1000
    pushed is a permutation of popped.
    pushed and popped have distinct values.

    so always same values in both the arr. just a permutaion. 
 */
public class ValidateStackSequence {
    
    public static void main(String[] args) {
        int [] pushed ={1,2,3,4,5};
        int [] popped = {4,5,3,2,1};

        boolean isValidStackSeq = theBruteForceWay(pushed, popped);
        System.out.println(isValidStackSeq);
    }

    //O(n) mostly cause you are looping through two same size arrys , and O(n) for space using stack.
    private static boolean theBruteForceWay(int[] pushed, int[] popped) {

        
        Stack<Integer> stack = new Stack<>(); 
        int po =0 ;
        for(int i : pushed){
            stack.push(i);
            while(!stack.isEmpty() && po < popped.length && stack.peek() == popped[po]){
                stack.pop();
                po++;
            }
        }
        return stack.isEmpty();

    }

}