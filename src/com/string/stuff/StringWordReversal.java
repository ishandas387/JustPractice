package com.string.stuff;

import java.util.Stack;
import java.util.StringTokenizer;

/**
	 * Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
	
	Input:
	The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.
	
	Output:
	For each test case, in a new line, output a single line containing the reversed String.
	
	Constraints:
	1 <= T <= 100
	1 <= |S| <= 2000
	
	Example:
	Input:
	2
	i.like.this.program.very.much
	pqr.mno
	
	Output:
	much.very.program.this.like.i
	mno.pqr
 * @author ishan
 *
 */
public class StringWordReversal {

	public static void main(String[] args) {
		String s ="i.like.this.program.very.much";
		StringTokenizer st = new StringTokenizer(s, ".");
		Stack<String> stack = new Stack<>();
		while(st.hasMoreElements()){
			stack.push(st.nextToken());
			
		}
		StringBuilder sb = new StringBuilder();
		String string = sb.toString();
		while(!stack.isEmpty()){
			if(null != sb.toString() && "" != sb.toString() ){
				sb.append(".");
			}
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());

	}

}
