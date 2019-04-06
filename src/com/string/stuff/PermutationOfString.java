package com.string.stuff;

/**
	 * Given a string S. The task is to print all permutations of a given string.
	
	Input:
	The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.
	
	Output:
	For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.
	
	Constraints:
	1 ≤ T ≤ 10
	1 ≤ size of string ≤ 5
	 
	Example:
	Input:
	2
	ABC
	ABSG
	
	Output:
	ABC ACB BAC BCA CAB CBA 
	ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
	
	Explanation:
	Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .
 * @author ishan
 *
 */
public class PermutationOfString {

	public static void main(String[] args) {

		String str ="ABC";
		int i =0;
		System.out.println("sending the str with 0 as start and "+(str.length()-1)+" as length");
		permute(str,0,str.length()-1);
		

	}

	private static void permute(String str, int start, int length) {
		System.out.println("start: "+start+ "end:: "+length);
		if(start==length){
			System.out.println(str);
		}
		else{
			for(int i=start;i<=length;i++){
				System.out.println("swap: "+start+ "with:: "+i+ "for str:"+str);
				str = swap(str,start,i);
				
				permute(str,start+1,length);
				
				System.out.println("swap: "+start+ "with:: "+i+ "for str:"+str);
				str = swap(str, start, i);
			}
		}
		
		
	}

	private static String swap(String str, int start, int i) {
		char[] charArray = str.toCharArray();
			char temp;
			temp = charArray[start];
			charArray[start]= charArray[i];
			charArray[i]=temp;
			System.out.println("after swap:: "+String.valueOf(charArray));
			return  String.valueOf(charArray);
		}
		
	}



