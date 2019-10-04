package com.random.stuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two array considering array one is villan and arry 2 is heroes , if arry 1 [2,5,7,3,1]
 * arry2 [3,5,8,22,10] heroes win.
 * User entry number of test case
 * 2
 * then 
 * 
 * 
Input Format
The first line of input consist of number of test cases, T.

The first line of each test case consist of number of villains and player, N.

The second line of each test case consist of the N space separated strengths of Villains.

The third line of each test case consist of N space separated energy of players.


Constraints
1<= T <=10

1<= N <=1000

1<= strength , energy <=100000


 * @author ishan
 *
 */
public class TwoArrays {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter number of tc");
		String readLine = br.readLine();
		
		int n = Integer.parseInt(readLine);
		System.out.println("number of players");
		int numberOfPlayers = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		List<List<String>> listOfTestCase = new ArrayList<>();
		for(int i=0;i<n;i++){
			System.out.println("insert list of V for "+(i+1)+"TC");
			list.add(br.readLine());
			System.out.println("insert list of H for "+(i+1)+"TC");
			list.add(br.readLine());
			listOfTestCase.add(list);
		}
		
		System.out.println(list.size());
		
		list.stream().forEach(System.out :: println);
		
		
		for(int i =0; i<listOfTestCase.size();i++){
			List<String> tc = listOfTestCase.get(0);
			check(tc,numberOfPlayers);
		}
		

	}

	private static void check(List<String> tc, int numberOfPlayers) {
		int[] vl = new int[numberOfPlayers];
		int [] hrs = new int[numberOfPlayers];
		String[] vs = tc.get(0).split(" ");
		String[] hr = tc.get(1).split(" ");
		for(int j =0;j<numberOfPlayers;j++){
			vl[j] =Integer.parseInt(vs[j]);
			hrs[j] = Integer.parseInt(hr[j]);
		}
		Arrays.sort(vl);
		Arrays.sort(hrs);
		boolean b= true;
		for(int vv : vl){
			int pos = 0;
			pos = scanHrFromPos(hrs,vv,pos);
			if(pos ==-1){
				b= false;
				break;
			}
		}
		if(b){
			System.out.println("WIN");
		}else{
			System.out.println("LOSE");
		}
		
	}

	private static int scanHrFromPos(int[] hrs, int vv, int pos) {
		for(int j =pos ; j<hrs.length;j++){
			if(hrs[j]> vv){
				return j;
			}
		}
		return -1;
	}

}
