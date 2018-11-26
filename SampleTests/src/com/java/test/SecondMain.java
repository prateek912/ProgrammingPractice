package com.java.test;

import java.util.Scanner;

public class SecondMain {

	static int lastLow = 0;
	
	public static void main(String[] args) {
		int arr[] = { 15, 9, 13, 8, 7 };
		int number = 10;
		int low = 0;
		int high = arr.length - 1;
		// Sort the array before
		quick_sort(arr, 0, arr.length - 1);
		printArray(arr);
		System.out.println(binarySearch(arr, number, low, high));
	}

	// For searching
	public static int binarySearch(int[] arr, int value, int low, int high) {
		System.out.println("Initial high :" + high + " Initial low :" + low);
		while (low <= high) {
			int middle = (low + high) >>> 1;
			System.out.println("comparing :" + arr[middle] + " and " + value);
			if (value > arr[middle]) {
				low = middle + 1;
			} else if (value < arr[middle]) {
				high = middle - 1;
			} else {
				return middle;
			}
		}
		return -1;
	}

	// Recursive function
	public static void quick_sort(int arr[], int start, int end) {
		// Condition for recursive algorithm function
		if (start < end) {
			// Find random pivot element and swapping it with the first element
			int pivot = partition(arr, start, end);
			quick_sort(arr, start, pivot - 1);
			// Sorting right side of pivot, should not include pivot element
			quick_sort(arr, pivot + 1, end);
		}
	}

	public static int partition(int arr[], int start, int end) {

		// Taking last element of array as pivot
		int pivot = arr[end];
		// for keeping index of where to swap pivot after one iteration
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (arr[j] <= pivot) {
				i++; // This will finally will give place to put pivot value after one iteration
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// Putting pivot at its place after putting all small element on left with help
		// of i variable
		int temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;

		// returning the new position of pivot after replacements
		return i + 1;
	}

	public static void printArray(int arr[]) {
		for (int i : arr) {
			// writer.write(i+" ");
			System.out.print(i + " ");
		}
	}

}
