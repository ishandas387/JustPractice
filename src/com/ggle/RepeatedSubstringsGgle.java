package com.ggle;

import java.util.HashMap;
import java.util.Map;

//given a string and int get the repeated substring with that length
public class RepeatedSubstringsGgle {
    public static void main(String[] args) {
        Map<String, Integer> result = repeatedChecks("this is a testtest", 4);
        System.out.println(result);
    }

    private static Map<String, Integer> repeatedChecks(String input, int len) {
        //tumbling window
        int count =0;
        String sub ="";
        Map<String, Integer> result = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<input.length();i++){
            while(count < len){
                if(i < input.length()){
                    sub = sub+input.charAt(i++);
                }
                count++;
            }

            if(map.containsKey(sub)){
                result.put(sub, map.get(sub));
            } else {
                map.put(sub, i-len);
            }

            count = 0;
            sub ="";
        }

        return result;
    }

    @Test
    public void testSubString(){
        
    }
}
