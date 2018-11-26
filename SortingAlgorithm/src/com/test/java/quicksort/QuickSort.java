package com.test.java.quicksort;

import com.java.fastIO.InputReader;
import com.java.fastIO.OutputWriter;

public class QuickSort {

	static InputReader reader = new InputReader(System.in);
	static OutputWriter writer = new OutputWriter(System.out);
	
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		int size = reader.readInt();
		int arr[] = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.readInt();
		}
		
		
		// selecting a pivot randomly
		int start = 0; 
		int end = arr.length; 
		// As taking last element as pivot by default
		quick_sort(arr,start,end-1);
		
		//System.out.println("Final sorted array ...");
		printArray(arr);
		
		writer.close();
	}
	
	// Recursive function
	public static void quick_sort(int arr[],int start,int end) {
		// Condition for recursive algorithm function
		if(start < end) {
			// Find random pivot element and swapping it with the first element  
			int pivot = partition(arr, start, end);
			quick_sort(arr,start,pivot-1);
			// Sorting right side of pivot, should not include pivot element
			quick_sort(arr,pivot+1,end);
		}
	}
	
	public static int partition(int arr[], int start, int end) {
		
		// Taking last element of array as pivot
		int pivot = arr[end];
		// for keeping index of where to swap pivot after one iteration
		int i = start -1;
		
		for(int j=start; j<end; j++) {
			if(arr[j] <= pivot) {
				i++; // This will finally will give place to put pivot value after one iteration
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		// Putting pivot at its place after putting all small element on left with help of i variable
		int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;
		
		// returning the new position of pivot after replacements
		return i+1;
	}
	
	public static void printArray(int arr[]) {
		for(int i : arr) {
			writer.write(i+" ");
			//System.out.print(i+" ");
		} 
	}
}
