package com.leetfree;

import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

/**
 * You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
Input: secret = "1807", guess = "7810"
Output: "1A3B" 

*/
public class BullsAndCows {
    public static void main(String[] args) {
        String result = countBandC("1807","7810");
        System.out.println("result :" +result );
        String result2 = countBandC("1123","0111");
        System.out.println("result2 :" +result2 );
        String result3 = countBandC("11","10");
        System.out.println("result3 :" +result3 );
        String r = simplerBAndC("1807","7810");
        System.out.println("simpler :" +r );
        String r2 = simplerBAndC("11","10");
        System.out.println("simpler :" +r2 );
    }

    private static String simplerBAndC(String secret, String guess) {
        int bull =0, cow =0;
        Map<Character, Integer> countMap = new HashMap<>();
        for(int i=0; i<secret.length(); i++){
            countMap.put(secret.charAt(i), countMap.getOrDefault(secret.charAt(i), 0)+1);
        }
        for(int j =0; j<guess.length(); j++){
            char charAtGuess = guess.charAt(j);
            if(countMap.containsKey(charAtGuess)) {
                if(charAtGuess == secret.charAt(j)) {
                    bull++;
                } else if (countMap.get(charAtGuess)-1 >= 0) {
                    cow++;
                }
                countMap.put(charAtGuess, countMap.get(charAtGuess) -1);
            }
        }
        return bull+"A"+cow+"B";
    }

    // doesnt work for 11 10
    private static String countBandC(String secret, String guess) {
        int bull =0 ;
        int cow =0;
        Map<Character, int[]> map = new HashMap<>();
        for(int i=0; i<secret.length(); i++){
            char charAt = secret.charAt(i);
            if (map.containsKey(charAt)) {
                map.put(charAt, new int[] {i, map.get(charAt)[1]+1});
            } else {
                map.put(charAt, new int[] {i, 1});
            }
        }

        for(int j=0; j<guess.length(); j++) {
            char charAt = guess.charAt(j);
            if (map.containsKey(charAt)) {
                int[] fromMap = map.get(charAt);
                if(fromMap[0] == j && fromMap[1] -1 >= 0) {
                    bull++;
                    map.put(charAt, new int[] {j, fromMap[1] -1});
                } else if (fromMap[0] != j && fromMap[1] -1 >= 0) {
                    cow++;
                    map.put(charAt, new int[] {j, fromMap[1] -1});
                }
            }
        }
        return bull+"A"+cow+"B";
    }
}
