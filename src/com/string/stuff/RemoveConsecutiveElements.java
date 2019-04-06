package com.string.stuff;

import java.util.Stack;

public class RemoveConsecutiveElements {

	public static void main(String[] args) {

		String str = "abccdsnvvvvvvXXXXXXXXXXXXXXXXXXXXvlkjld";

		System.out.println(removeConsecutive(str));
		System.out.println(removeConsecutiveWithStack(str));
		
		
	}

	private static String removeConsecutiveWithStack(String str) {
		Stack<Character> st = new Stack<>();
		for(Character c : str.toCharArray() ){
			if(!st.isEmpty()){
				if(st.peek().charValue() == c){     
					st.pop();continue;
				}
			}
			st.push(c);
		}
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()){
			sb.append(st.pop());
		}
		return sb.toString();
	}

	private static String removeConsecutive(String str) {

		StringBuilder s = new StringBuilder();
		char[] charArray = str.toCharArray();
		for(int i =0;i<charArray.length;i++){
			if(i==0){
				if(charArray[i]!= charArray[i+1]){
					s.append(charArray[i]);
				}
			}else{
				if(i!= charArray.length-1){
					if(charArray[i] == charArray[i+1] || charArray[i-1]== charArray[i]){
						
					}else{
						s.append(charArray[i]);
					}
				}else{
					if(charArray[i-1]!= charArray[i]){
						s.append(charArray[i]);
					}
				}
			}
		}
		return s.toString();
	}

}
