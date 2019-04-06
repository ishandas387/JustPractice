package com.string.stuff;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.ValidationEvent;

public class RomanToIntConversion {
//convert roman to int 
	// i = 1
	// ix= 9
	/**
	 * SYMBOL       VALUE
		I             1
		IV            4
		V             5
		IX            9
		X             10
		XL            40
		L             50
		XC            90
		C             100
		CD            400
		D             500
		CM            900 
		M             1000   
	 * @param args
	 * 
	 * I placed before V or X indicates one less, so four is IV (one less than 5) and 9 is IX (one less than 10).
		X placed before L or C indicates ten less, so forty is XL (10 less than 50) and 90 is XC (ten less than a hundred).
		C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than five hundred) and nine hundred is CM (a hundred less than a thousand).
	 */
	public static void main(String[] args) {
		
		
		String roman ="IX";
		int result = 0 ;
		for(int i=0; i<roman.length();i++){
			int s1 =  getIntValue(roman.charAt(i));
			
			if(i+1<roman.length()){
				int s2 = getIntValue(roman.charAt(i+1));
				if(s1<s2){
					result = result+ s2-s1;
					i++;
				}else{
					result = result+s1+s2;
					i++;
					
				}
			}else{
				result= result+s1;
				i++;
			}
		}
		System.out.println(result);
		/*char ch = 0;
		getIntValue(ch);*/
		
					
		
	}

	private static int getIntValue(char ch) {
		switch(ch){
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;	
		case 'M':
			return 1000;
			
		}
		return ch;
		
	}

}
