Two pointer

When to use ?

1. Used mostly on linear ds like array, linked list.
2. Predictable ds like sorted array

Types ?

1. Inward pointers
    P1 starting from left and P2 starting from right move inward until a criteria is met
2. Staged pointers
    P1 move forward, when a criteria is met move P2 forward. 
3. Unidirectional
    Move both P1 and P2 from left to right, usually P2 keeping track of something.

Example realworld ?

Garbage collector -> A scan pointer traverses through heap, A free pointer keeps track of next available space where the next live object will be reallocated.
As the scan pointer moves it skips the dead objects and moves the live objects to the free pointer specified space. Hence compacting the memory by grouping all live objects together.