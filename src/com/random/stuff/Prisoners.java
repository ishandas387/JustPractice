package com.random.stuff;

public class Prisoners {

	public static void main(String[] args) {
		int numberOfPrisners=7;
		int numberOfChocolates=19;
		int startPointer=2;
		System.out.println(prisonerNumber(numberOfPrisners,numberOfChocolates,startPointer));

	}

	private static int prisonerNumber(int numberOfPrisners, int numberOfChocolates, int pointer) {
		//first chocolate is always given to the first pointer
		for(int i=numberOfChocolates-1;i>0;i--){
			System.out.println("chocolate "+i);
			if(pointer == numberOfPrisners){
				pointer=1;
				continue;
				
			}
			pointer++;
			System.out.println(pointer);
		}
		return pointer;
	}

}
