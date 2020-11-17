package com.random.stuff;

import java.util.Map;
import java.util.TreeMap;

public class Calendar1 {
    static TreeMap<Integer,Integer> booked = new TreeMap<>();
    public static void main(String[] args) {

       System.out.println(booking(10,20));
       System.out.println(booking(15,25));
       System.out.println(booking(20,30));
        
    }

    private static boolean booking(int start, int end) {
        
        Integer prev = booked.get(start);
        Integer next = booked.get(end);

        if((prev == null || booked.get(prev) <= start) && (next == null || next >= end)){
            booked.put(start,end);
            return true;
        } 
        return false;
    }
}
