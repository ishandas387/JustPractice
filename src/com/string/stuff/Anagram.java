package com.string.stuff;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		String s1 = "ddoga";

		String s2 = "godda";

		if (s1.length() != s2.length()) {
			System.out.println("not");
			System.exit(1);
		}
		System.out.println(checkWithSorting(s1, s2));
		System.out.println(checkWithCounting(s1, s2));

	}

	private static boolean checkWithCounting(String s1, String s2) {
		
		//o(n)
		int[] intA1= new int[256];
		int [] intA2 = new int[256];
		Arrays.fill(intA1, 0);
		Arrays.fill(intA2, 0);
		
		char[] charArray = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		
		for(int i=0; i<charArray.length && i<charArray2.length;i++){
			intA1[charArray[i]]++;
			intA2[charArray2[i]]++;
		}
		
		for(int i=0;i<256;i++){
			if(intA1[i]!=intA2[i]){
				return false;
			}
		}
		return true;
	}

	private static boolean checkWithSorting(String s1, String s2) {
		// o(nlogn)

		char[] charArray = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		Arrays.sort(charArray);
		Arrays.sort(charArray2);

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != charArray2[i]) {
				return false;
			}
		}
		return true;
	}
}
