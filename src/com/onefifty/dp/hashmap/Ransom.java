package com.onefifty.dp.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 */
public class Ransom {
    public static void main(String[] args){
        String message ="aa";
        String magazine ="aab";
        System.out.println(extracted(message, magazine));
    }

    private static boolean extracted(String message, String magazine) {
        Map<Character, Integer> counter = new HashMap<>();

        for(int i=0; i<magazine.length(); i++){
            counter.put(magazine.charAt(i),
                    counter.getOrDefault(magazine.charAt(i), 0)+1);
        }

        for(int j=0; j<message.length(); j++) {
            Character m = message.charAt(j);
            if(!counter.containsKey(m)) {
                return false;
            } else {
                if(counter.get(m) == 0 ){
                    return false;
                } else {
                    counter.put(m, counter.get(m)-1);
                }
            }
        }
        return true;
    }
}
