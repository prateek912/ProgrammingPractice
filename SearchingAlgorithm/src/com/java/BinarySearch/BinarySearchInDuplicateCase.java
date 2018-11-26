package com.java.BinarySearch;

import java.util.Scanner;

import com.java.fastIO.InputReader;

public class BinarySearchInDuplicateCase {

	public static void main(String arg[]) {
		//Scanner sc = new Scanner(System.in);
		InputReader reader= new InputReader(System.in);
		int testcases = reader.readInt();
		String vowels = "AEIOUaeiou";
		char[] vowelsArray = vowels.toCharArray();
		while (testcases > 0) {
			int count = 0;
			String str = reader.readString();
			char[] strArray = str.toCharArray();

			// sort the character array
			quick_sort(strArray,0,strArray.length-1);
			for(char c : strArray) {
				System.out.print(c+" ");
			}
			for(char c : vowelsArray) {
				// Search for character
				 int result = binary_serach(strArray,c,0,strArray.length-1);
				 count+=result;
			}
			System.out.println(count);
			testcases--;
		}
	}
	
	public static int binary_serach(char[] arr,char value, int low, int high) {
		int count =0;
		while (low <= high) {
			int middle = (low + high) >>> 1;
			if (value > arr[middle]) {
				low = middle + 1;
			} else if (value < arr[middle]) {
				high = middle-1;
			} else {
				// move to left
				int left = middle;
				while(low <= left) {
					if(value == arr[left]) {
						count++;
					}else {
						break;
					}
					left--;
				}
				
				// move to right
				int right = middle+1;
				while(high >= right) {
					if(value == arr[right]) {
						count++;
					}else {
						break;
					}
					right++;
				}
				return count;
			}
		}
		return count;
	}


	// Recursive function
	public static void quick_sort(char arr[], int start, int end) {
		// Condition for recursive algorithm function
		if (start < end) {
			// Find random pivot element and swapping it with the first element
			int pivot = partition(arr, start, end);
			quick_sort(arr, start, pivot - 1);
			// Sorting right side of pivot, should not include pivot element
			quick_sort(arr, pivot + 1, end);
		}
	}

	public static int partition(char arr[], int start, int end) {

		// Taking last element of array as pivot
		int pivot = arr[end];
		// for keeping index of where to swap pivot after one iteration
		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (arr[j] <= pivot) {
				i++; // This will finally will give place to put pivot value after one iteration
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// Putting pivot at its place after putting all small element on left with help
		// of i variable
		char temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;

		// returning the new position of pivot after replacements
		return i + 1;
	}
}
