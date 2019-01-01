package com.java.prac;

import java.math.BigInteger;
import java.util.Date;
import java.util.Scanner;

public class ModuloExponential {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Date startTime = new Date();
		System.out.println("Start Time :"+startTime);
		
		long base = sc.nextLong();
		int exp = sc.nextInt();
		
		long result = calculateExponential(base,exp);
		System.out.println("Result is :"+result);
		
		Date endTime = new Date();
		System.out.println("End Time :"+startTime);
		
		System.out.println("Total Time taken  :"+(endTime.getTime() - startTime.getTime())+" nano seconds");
	
	}
	
	// Normal Recursive approach 
	/*public static long calculateExponential(int base, int exp) {
		if(exp == 0)
			return 1;
		
		return base*calculateExponential(base, exp-1);
	}*/
	
	
	// Normal Iterative approach
	/*public static long calculateExponential(int base, int exp) {
		long result = 1;
		while(exp > 0) {
			result = result*base;
			exp--;
		}
		return result;
	}*/
	
	
	// BinaryExponentation
	/*public static long calculateExponential(int base, int exp) {
		if(exp == 0) {
			return 1;
		}else	if(exp%2 == 0) {				// n is even
			return calculateExponential(base*base, exp/2);
		}else {
			return calculateExponential(base*base, (exp-1)/2);
		}
		
	}*/
	
	// Modular BinaryExponentation
	public static long calculateExponential(long base, int exp) {
		final long M = 1000000007L;
		long result = 1L;
		while(exp > 0) {
			if(exp % 2 != 0) {
				// For one extra result
				result = (result *base)% M;
			}
			
			base = (base * base)%M;
			// As we have already taken care the odd case
			exp /=2;
		}
		return result;
	}
	

}
