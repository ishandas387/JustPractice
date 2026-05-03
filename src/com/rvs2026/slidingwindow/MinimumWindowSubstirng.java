package com.rvs2026.slidingwindow;

/**
 * 
 * Given two strings:

s = "ADOBECODEBANC"
t = "ABC"

Find the smallest substring in s
that contains ALL characters of t.

Example

Input:

s = "ADOBECODEBANC"
t = "ABC"

Output:

"BANC"


Step 1 — Pattern Recognition
Keywords
smallest substring
contains all characters
contiguous


Important Observation

We need:

expand window until VALID
shrink window to minimize size

This is the classic:

expand → valid
shrink → optimize

pattern.
This screams:

Variable Size Sliding Window
 * 
 * Core Sliding Window Pattern
Expand Until Valid
right++
Shrink While Valid
while(valid)

This is THE most important variable-window pattern.



The algorithm naturally finds the minimum window because:

We only expand when we don't have enough characters
We always try to contract when we have a valid window
We keep track of the smallest valid window seen throughout the process

This approach ensures we examine each character at most twice (once when expanding,
once when contracting), giving us an efficient O(m + n) solution where m and n are the lengths of strings s and t.
 */
public class MinimumWindowSubstirng {
    
}
