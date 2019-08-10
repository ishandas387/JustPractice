package com.ms;

/**
 * Find element in rotated sorted array.
 * Find the pivot and do a binary search in the two sub arrays. 
 *
 */
public class RotatedSortedArry {

	public static void main(String[] args) {
		
		int[] arr = {5,6,7,8,9,10,1,2,3,4};
		 // get element 
		int e=9;
		getElement(arr,e);
	}

	private static void getElement(int[] arr, int e) {
		//find the pivot point
		int key =9;
		int p =getPivot(arr,0,arr.length-1);
		if(p==-1){
			System.out.println(binarySearch(arr, 0,arr.length-1, key));
		}
		if(arr[p] == key){
			System.out.println(p);
		}
		if(arr[0]<=key){
			System.out.println(binarySearch(arr, 0,p-1, key));
		}else{
			System.out.println(binarySearch(arr, p,arr.length-1, key));
		}
	}

	private static int getPivot(int[] arr, int low, int high) {
		//base case
		if(high <low){
			return -1;
		}
		if(high == low){
			return low;
		}
		
		int mid = (high+low)/2;
		if(mid<high && arr[mid]> arr[mid+1]){
			return mid;
		}
		if(mid > low && arr[mid]  <arr[mid-1]){
			return (mid-1);
			
		}
		if(arr[low]>=arr[mid]){
			 return getPivot(arr, low, mid-1);
		}
		return getPivot(arr, mid+1, high);
	}
	
	private static int binarySearch(int[] arr, int low, int high, int key){
		if(high< low){
			return -1;
		}
		int mid = (low+high)/2;
		if(key == arr[mid]){
			return mid;
		}
		if(key < arr[mid]){
			return binarySearch(arr, low, mid-1, key);
		}else{
			return binarySearch(arr, mid+1, high, key);
		}
	}

}
