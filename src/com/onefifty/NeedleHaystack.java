package com.onefifty;

// given two strings find if needle is present in haystack. get the first occurance
public class NeedleHaystack {
    public static void main(String[] args) {
        String needle ="sad";
        String haystack = "butsad";
        System.out.println(firstOccurance(haystack, needle));

    }

    private static int firstOccurance(String haystack, String needle) {
        int nL = needle.length();
        int hL = haystack.length();

        if(nL > hL) {
            return -1;
        }
        int diff = nL;
        int i=0;
        while (i < hL) {
            int j = i+diff;
            String sub = haystack.substring(i, j);
            if(needle.equalsIgnoreCase(sub)) {
                return i;
            }
            i++;

        }
        return -1;
    }
}
