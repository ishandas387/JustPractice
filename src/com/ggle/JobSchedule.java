package com.ggle;

import java.util.PriorityQueue;

public class JobSchedule {

    class Job{
        int start;
        int end;

        public Job(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Job [start=" + start + ", end=" + end + "]";
        }
        
    }
    public static void main(String[] args) {
        
        
        
        System.out.println(canSchedule(8, 2));
        System.out.println(canSchedule(18, 7));
        System.out.println(canSchedule(15, 27));
        System.out.println(canSchedule(26, 1));
        System.out.println(canSchedule(40, 2));
    }
    
    private static boolean canSchedule(int start, int duration) {
        JobSchedule js = new JobSchedule();
        PriorityQueue<Job> minHeap = new PriorityQueue<>((j1,j2) -> j1.start - j2.start);
        minHeap.offer(js.new Job(10, 10+7));
        minHeap.offer(js.new Job(25, 25+15));

        if(duration == 0){
            return false;
        }

        int prevEnd = 0;
        while(!minHeap.isEmpty()){
            Job poll = minHeap.poll();
            
            if(start >= poll.end && minHeap.isEmpty()){
                return true;
            }
            if(poll.start >= start+duration && (prevEnd == 0 || prevEnd <= start)){
                return true;
            } else {
                prevEnd = poll.end;
            }
        }
        return false;
    }
}
