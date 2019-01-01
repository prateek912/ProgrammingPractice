package com.java.prac;

import java.util.Scanner;

public class ModularMultiplicativeInverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		//int B = sc.nextInt();
		int M = sc.nextInt();
		
		
		System.out.println(findInverseModulo(A,M));
		
	}
	
	private static int findInverseModulo(int A,int M) {
		int B = 1;
		while(B < M) {
			if((A*B)%M == 1) {
				return B;
			}
			B++;
		}
		return B;
	}

}
