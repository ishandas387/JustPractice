package com.string.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PhonePad {
    /**
     * given a digits get all possible combination of word.
     * Imagine a phone dial paid which has the digits. 1 has none. 2 has 'abc'
     */

     static Map<String, String> map = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");

        }
    };

    static List<String> output = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(getList("234"));
    }

    public static List<String> getList(String digits) {

        getTheCombinations("", digits);
        return output;
    }

    private static void getTheCombinations(String combination, String digits) {

        if (digits.length() == 0) {
            output.add(combination);
        } else {
            // break the digit, get the first one
            String digit = digits.substring(0, 1);
            String letters = map.get(digit);

            for(int i =0; i< letters.length(); i++){
                String letter = letters.substring(i,i+1);
                getTheCombinations(combination + letter, digits.substring(1));
            }
        }
     }
}