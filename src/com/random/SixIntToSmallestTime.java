package com.random;
import java.util.*;

public class SixIntToSmallestTime{
    public static void main(String[] args) {
        System.out.println(solution(1,1,2,4,2,2));
    }

    private static String solution(int A, int B, int C, int D, int E, int F) {
        int temp = 0; Double testNum = 0.0;
        int[] numsArray = new int[]{A,B,C,D,E,F};
        // Sort the Array
        Arrays.sort(numsArray);
        for (int i = 0; i < 6; i++){
            if (numsArray[i] > 5)
                temp++;
            testNum = testNum + numsArray[i]*Math.pow(10.0,5.0-i);
        }
        // Test of high digit count
        if (temp > 3){
            return null;
        }
        // Number is Too Big to be a time
        if ( testNum > 235959){
            return null;
        }
        // Number can be a time, just needs sorting
        if (numsArray[4] > 5){
            temp = numsArray[4];
            numsArray[4] = numsArray[2];
            numsArray[2] = temp;
        }
        if (numsArray[2] > 5){
            temp = numsArray[2];
            numsArray[2] = numsArray[3];
            numsArray[3] = temp;
        }
        if (numsArray[2] > 5){
            temp = numsArray[1];
            numsArray[1] = numsArray[2];
            numsArray[2] = temp;
        }
        if (numsArray[2] > numsArray[4]){
            temp = numsArray[4];
            numsArray[4] = numsArray[2];
            numsArray[2] = temp;
        }
        return ("" + numsArray[0] + numsArray[1] + ":" + numsArray[2] + numsArray[3] + ":" + numsArray[4] + numsArray[5]);
    }
}