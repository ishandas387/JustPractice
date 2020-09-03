package com.leetfree;
/**
 * Sort Adjecent.
 * a b can be swapped
 * b c can be swapped.
 * 
 * a c cannot be swapped
 * 
 * input string will only have abc 
 * 
 * input
 * abaacbac
 * 
 * ans
 * aaabbcac
 */
public class WorkdayStringSort {
    public static void main(String[] args) {
       // String input = "abaacbac";
        String input = "ababbaab";

        char[] c = input.toCharArray();

        int i=0;
        int j =i+1;

        //for(int k =0; k<c.length;k++){
         while(j<c.length){
                if(c[i] > c[j]){
                    if(c[i] =='c' && c[j] =='a'){
                    } else {
                        swap(c,i,j);
                        
                    } 
                }
                i++;
                j++;
            } 
        //}

        //int n = arr.length; 
  
    /*     // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>0; i--) 
        { 
            // Move current root to end 
            char temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 

        System.out.println(new String(arr));
    }
    static void heapify(char arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        if(arr[l] == 'c' && arr[r] =='a'){
            return;
        }
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            char swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        }  */
    } 

    private static void swap(char[] c, int i, int j) {
        char temp = c[j];
        c[j] = c[i];
        c[i] = temp;
    }
}