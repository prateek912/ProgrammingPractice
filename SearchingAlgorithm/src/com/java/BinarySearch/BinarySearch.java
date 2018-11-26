package com.java.BinarySearch;

import com.java.fastIO.InputReader;

public class BinarySearch {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		InputReader reader = new InputReader(System.in);
		int size = reader.readInt();
		int arr[] = new int[size];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.readInt();
		}

		int queries = reader.readInt();
		int low = 0;
		int high = size;

		// sort the array
		sort(arr, low, high - 1);
		//printArray(arr);
		while (queries > 0) {
			int value = reader.readInt();
			int result = binarySearch(arr, value, low, high);
			if (result == -1) {
				System.out.println("-1");
			} else {
				System.out.println(result + 1);
			}
			queries--;
		}
	}

	public static int binarySearch(int[] arr, int value, int low, int high) {
		while (low <= high) {
			int middle = (((low + high) / 2));
			if (value > arr[middle]) {
				low = middle + 1;
			} else if (value < arr[middle]) {
				high = middle;
			} else {
				return middle;
			}
		}
		return -1;
	}

	public static void sort(int arr[], int start, int end) {
		// Condition to terminate recursive function
		if (start < end) {
			// Find random pivot element and swapping it with the first element
			int pivot = partition(arr, start, end);
			sort(arr, start, pivot - 1);
			// Sorting right side of pivot, should not include pivot element
			sort(arr, pivot + 1, end);
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
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
}
