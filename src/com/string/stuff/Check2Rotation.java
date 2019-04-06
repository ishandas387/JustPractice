package com.string.stuff;

public class Check2Rotation {

	public static void main(String[] args) {

		//amazon
		//azonam
		
		String s1 = "amazon";
		String s2 = "azonam";
		String s3 = "onamaz";
		
		boolean isRotated = isRotated(s1,s2,s3);
		System.out.println(isRotated);
	}

	private static boolean isRotated(String s1, String s2, String s3) {
		if(s1.length()!=s2.length()){
			return false;
		}
		String rotatedClock= "";
		String rotatedAnt="";
		rotatedClock = s2.substring(s2.length()-2, s2.length())+s2.substring(0,s2.length()-2);
		rotatedAnt = s3.substring(2,s3.length())+s3.substring(0,2);
		System.out.println(rotatedAnt);
		
		return (rotatedClock.equalsIgnoreCase(s1) || rotatedAnt.equalsIgnoreCase(s1));
	
	}

}
