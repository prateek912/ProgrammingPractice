package com.test.java.insertionsort;

import java.util.Scanner;

import com.java.fastIO.InputReader;
import com.java.fastIO.OutputWriter;

public class InsertionSort {

	/*
	 * Time complexity of this algorithm is again o(n*n)
	 * */
		
	public static void main(String[] args) {
		
		InputReader reader = new InputReader(System.in);
		OutputWriter writer = new OutputWriter(System.out);
		
		//Scanner sc = new Scanner(System.in);
		int size = reader.readInt();
		int[] arr = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.readInt();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					//Swap
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;			
				}
			}
		}
		
		for(int i : arr) {
			writer.write(i+" ");
			//System.out.print(i+" ");
		}
	}
}
