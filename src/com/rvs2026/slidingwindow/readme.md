1. What Is Sliding Window?

Instead of:

checking every subarray separately

we maintain:

a moving “window”

and optimize calculations incrementally.

Brute Force Thinking

Suppose:

nums = [1,2,3,4]
k = 2

Find maximum sum subarray of size 2.

Brute force:

[1,2]
[2,3]
[3,4]

Compute every sum again.

Sliding Window Thinking

Instead of recalculating:

[1,2] = 3

Next window:

[2,3]

Don’t recompute from scratch.

Just:

remove 1
add 3

New sum:

3 - 1 + 3 = 5

This is the core sliding window optimization.

Main Sliding Window Types

Type	                    Example
Fixed Size Window	        max sum of size k
Variable Size Window	    longest substring without repeating chars
Dynamic Constraint Window	minimum window substring


How To Identify Sliding Window Problems

Look for keywords like:

1. Contiguous
subarray
substring
continuous segment

2. Window Size
size k
at most k
minimum length
longest substring

3. Optimization Over Range
maximum
minimum
longest
shortest
count


pattern recognition
window expansion
window shrink logic
state maintenance