package com.test.java.mergesort;

import com.java.fastIO.InputReader;
import com.java.fastIO.OutputWriter;

public class MergeSort {
	
	//static long count=0;
	static InputReader reader = new InputReader(System.in);
	static OutputWriter writer = new OutputWriter(System.out);
	
	public static void main(String args[]){  
		
		//Scanner sc = new Scanner(System.in);
		int size = reader.readInt();
		int arr[] = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.readInt();
		}
		sort(arr, 0, arr.length-1);  
		  
		//System.out.print(count);
		printArray(arr);
	}
	
	public static void merge(int arr[], int beg, int mid, int end){  
		  
		int leftArrSize = mid - beg + 1;  
		int rightArrSize = end - mid;  
		  
		int LeftArray[] = new int [leftArrSize];  
		int RightArray[] = new int [rightArrSize];  
		 
		//Copying data from original array to left sub array
		for (int i=0; i<leftArrSize; ++i) {
			LeftArray[i] = arr[beg + i];
		} 
		 
		//Copying data from original array to right sub array
		for (int j=0; j < rightArrSize; ++j)  {
			RightArray[j] = arr[mid + 1+ j];
		}
		
		int i = 0, j = 0;  
		int k = beg; 

		// While both array contain element
		while (i < leftArrSize && j < rightArrSize) {		
			if (LeftArray[i] <= RightArray[j]){
				arr[k] = LeftArray[i];  
				i++;  
			} else {  
				arr[k] = RightArray[j];  
				j++;  
				//count = count + (leftArrSize-i);
			}  
		  k++;  
		}  	
		while (i < leftArrSize) {  			
			arr[k] = LeftArray[i];  
			i++;  
			k++;  
		}  
		  
		while (j < rightArrSize)  {  
			arr[k] = RightArray[j];  
			j++;  
			k++;  
		}  
	}  
	  
	public static void sort(int arr[], int beg, int end) {  
		if (beg < end)  {  
			int mid = (beg+end)/2;  
			sort(arr, beg, mid);  
			sort(arr , mid+1, end);  
			merge(arr, beg, mid, end);  
		}	
	}  
	 
	public static void printArray(int arr[]) {
		for(int i : arr) {
			writer.write(i+" ");
			//System.out.print(i+" ");
		}
		//System.out.println();
	}
}
