package com.java.prac;

import java.util.Scanner;

public class EuclidsAlgorithmForGCD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gcd = 0;
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
				
			System.out.println("Recursive :"+findGCDRecursive(a, b));
			System.out.println("Iterative :"+findGCDIterative(a, b));
			System.out.println("Binary :"+findGCDBinary(a, b));
		}

	}

	// Recursive method
	private static int findGCDRecursive(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return findGCDRecursive(b, a % b);
		}

	}

	// Iterative Method
	private static int findGCDIterative(int a, int b) {
		if (b == 0)
			return a;
		if (b == 1)
			return 1;
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	// Binary Approach Most Efficient one
	private static int findGCDBinary(int a, int b) {
		if (b == 0)
			return a;
		
		// Have to find common multiple of 2 in both
		int commonMultiple = 1;
		while ((a & 1) == 0 && (b & 1) == 0) {
			// commonMultiple *= 2;
			commonMultiple = commonMultiple << 1; // This is equal to multiplying by 2
			a = a >> 1; // This is equal to dividing by 2
			b = b >> 1;
		}

		// If b is not even then
		while ((a & 1) == 0) {
			a = a >> 1;
		}
		// After this loop a will be odd

		while (b != 0) {
			while( (b & 1) == 0) {
				b = b >> 1;
			}
			
			// At this point both a and b are odd
			int temp = a-b;
			a = b;
			b = temp;
			if( a < b) {
				int tempSwap = a;
				a = b;
				b = tempSwap;
			}
		}
		
		return a*commonMultiple;
	}

}
