/**
 * Given a time represented in the format "HH:MM", 
 * form the next closest time by reusing the current digits.
 *  There is no limit on how many times a digit can be reused.
    You may assume the given input string is always valid. 
    For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 */
package com.leetfree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class NextClosestTime {
    public String retrunTheNextClosesTime(String time){

        String[] timeSplit = time.split(":");
        int minute = Integer.parseInt(timeSplit[1]);
        int hour = Integer.parseInt(timeSplit[0]);

        System.out.println("hours"+hour+":"+minute+"min");

        //try and capture all the integer from the time into a ds so that we can create 
        //combination of digits later.

        List<Integer> listOfInt = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        for(int i =0 ; i< time.length();i++){
            if(time.charAt(i) >='0' && time.charAt(i) <= '9'){
                charList.add(time.charAt(i));
            }
        }

        //get all non repeated combinations
        // to store all non repeated combinations with set and in order
        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int i=0; i< charList.size() ;i++){
            for(int j=0 ; j<charList.size(); j++){
                treeSet.add(Integer.parseInt(charList.get(i)+""+charList.get(j)));
            }
        }
        listOfInt.clear();
        listOfInt.addAll(treeSet);
        //get me the combination which is near to hour and min
        int posHour = search(listOfInt, hour);
        int posMin = search(listOfInt,minute);

        if(posHour < listOfInt.size()-1 && listOfInt.get(posHour+1) < 24){
            //next closest hence +1
             posHour = listOfInt.get(posHour+1);
        }else{
            posHour = listOfInt.get(0);
        }

        if(posMin < listOfInt.size()-1 && listOfInt.get(posMin+1) < 60){
            posMin = listOfInt.get(posMin+1);
       }else{
           posMin = listOfInt.get(0);
       }
       
        return posHour+":"+posMin;

    }
    
    private int search(List<Integer> list, int t) {
        int i =0;
        int j = list.size()-1;
        while(i<j){
            //get the pointer to half
            int p = i+ (j-i)/2;
            if(list.get(p) < t){
                i = p +1;
            }else{
                j = p;
            }
        }
        System.out.println("returning "+j);
        return j;
    }

    public static void main(String[] args) {
        System.out.println("test");
        NextClosestTime time = new NextClosestTime();
        System.out.println(time.retrunTheNextClosesTime("11:24"));
    }
}