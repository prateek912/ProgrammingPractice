package com.java.LinearSearch;

import com.java.fastIO.InputReader;

public class LinearSearch {

	public static void main(String[] args) {
	
		//Scanner sc = new Scanner(System.in);
		InputReader reader = new InputReader(System.in);
		int size = reader.readInt();
		int arr[] = new int[size];
		int number = reader.readInt();
		
		int temp = 0;
		
		for(int i=0; i < arr.length; i++) {
			arr[i] = reader.readInt();
			if(arr[i] == number) {
				temp = i;
			}
		}
		
		System.out.println(temp+1);
		
	}

}
