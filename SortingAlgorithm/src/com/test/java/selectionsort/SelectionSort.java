package com.test.java.selectionsort;

import java.util.Scanner;

public class SelectionSort {

	
	/*
	 *  Idea of Selection sort is to find minimum/maximum (according to requirement) in each iteration
	 *  and them replace it with the element at the first place in array
	 *  Time complexity of this algorithm is again o(n*n)
	 * 
	 * */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		//For question
		int iteration = sc.nextInt();
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int j=0; j<arr.length; j++) {
			if(iteration == count) {
				System.out.println("Final array after rotaiton :");
				printArray(arr);
				break;
			}else {
				// Find smallest number in array
				int temp = smallestNumber(j,arr);
				System.out.println("Returned smallest number is :"+arr[temp]);
				arr=swapNumber(temp,j,arr);
				printArray(arr);
				count++;
			}	
		}
	}
	
	public static int smallestNumber(int j,int[] arr) {
		// Take the first number and start comparing with other
		int temp=j;
		for (int i = j; i < arr.length; i++) {
			if(arr[i] < arr[temp]) {
				temp = i;
			}
		}
		return temp;
	}
	
	public static int[] swapNumber(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void printArray(int[] arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
