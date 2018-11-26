package com.test.java.bubblesort;

import com.java.fastIO.InputReader;
import com.java.fastIO.OutputWriter;

public class BubbleSort {

	static InputReader reader = new InputReader(System.in);
	static OutputWriter writer = new OutputWriter(System.out);
	
	public static void main(String[] args) {
		
		/*
		 *  In Bubble Sort, after first iteration largest value will be at last
		 *  at second iteration second largest values will be at second last and so on...
		 *  so we will after every iteration we will ignore number last value that are equal to number of iteration,
		 *  i.e (size -i -1), this will avoid duplicate comparison
		 * 
		 *  Complexity of this algorithm is o(n*n) for non-sorted array as well as sorted array,
		 *  we can tweak to bring down complexity of sorted array to o(n)
		 * 
		 * */
	
		//Scanner sc = new Scanner(System.in);
		int size = reader.readInt();
		int[] arr = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.readInt();
		}
		//int swapcount =0;
		//int comparison=0;
		//Swapping
		for(int i=0; i<size; i++) {
			
			// This variable is for confirming already sorted array
			boolean flag = false;
			
			for(int j=0; j<size-i-1; j++) {
				//comparison++;
				//System.out.println("Comparing value :"+arr[j]+" and "+arr[j+1]);
				
				if(arr[j] > arr[j+1]) {
					//Swap
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					//swapcount++;
					//System.out.println("Swapping above comapring value...");
					//System.out.println("Array after swapping ..");
					//printArray(arr);
					flag = true;
				}
			}
			// If no swapping happened in first iteration this mean array is already sorted
			// This will reduce complexity of this algorithm to o(n)
			if(!flag) {
				// break the loop
				//System.out.println("Array is already sorted...");
				break;
			}
		}
		printArray(arr);
		//System.out.println("Swap Count :"+swapcount);
		//System.out.println("Comparision Count :"+comparison);
		
	}

	
	public static void printArray(int[] arr) {
		for(int i : arr) {
			writer.write(i+" ");
			//System.out.print(i+" ");
		}
		System.out.println();
	}
}
