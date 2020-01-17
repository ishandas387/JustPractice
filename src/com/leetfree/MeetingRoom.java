package com.leetfree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
 */

/**
 * Adding the meeting starting to a priority queue as min heap.
 * This problem can be solved using the greedy method. We sort the intervals using the start time, then we try to merge the next one that has the smallest start time ts from the remaining intervals with the previous interval that has smallest end time te. 
If ts < te, that means the interval with start time ts can not be merged with the all the previous intervals since te is the minimum end time. So we start a new room. 
If ts >= te,  this means the interval with start time ts can be merged with the room with end time te. 
We can use a priority query to record the end time, so we can get the minimum end time in O(logN) time
 *  */ 

class MeetingRoom{
    
    public int minMeetingRooms(int[][] intervals) {

            //sort the intervals array based on start time
            Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
            PriorityQueue<Integer> endTimeMeeting = new PriorityQueue<>();
            for(int [] interval : intervals){
                if(endTimeMeeting.isEmpty()){
                    endTimeMeeting.offer(interval[1]);
                }
                else{
                        if(interval[0] >= endTimeMeeting.peek()){
                        endTimeMeeting.poll();
                        endTimeMeeting.offer(interval[1]);
                        }
                        else{
                            endTimeMeeting.offer(interval[1]);
                        }
                     }
            }
            return endTimeMeeting.size();
    }

    public static void main(String[] args) {
        MeetingRoom meeting = new MeetingRoom();
        int[][] intervals = new int[5][2];
        intervals[0][0]= 2;
        intervals[0][1]=15;
        intervals[1][0]=36;
        intervals[1][1]=45;
        intervals[2][0]=9;
        intervals[2][1]=29;
        intervals[3][0]=16;
        intervals[3][1]=23;
        intervals[4][0]=4;
        intervals[4][1]=9;
        System.out.println(meeting.minMeetingRooms(intervals));
    }
}