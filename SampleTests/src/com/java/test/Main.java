package com.java.test;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String arg[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Integer.MAX_VALUE);
		
		long mountains = sc.nextLong();
		long queries = sc.nextLong();
		
		long lowest = 0;
		long highest =0;
		
		while(mountains > 0) {
			long l = sc.nextLong();
			if(lowest == 0) {
				lowest = l;
			}else if(l < lowest){
				lowest = l;
			}
			long r = sc.nextLong();
			if(highest == 0) {
				highest = r;
			}else if(r > highest) {
				highest = r;
			}
			
			mountains--;
		}
		
		System.out.println("Lowest is :"+lowest);
		System.out.println("Highest is :"+highest);
		
		
		while(queries > 0) {
			long x = sc.nextLong();
			System.out.println((lowest-1)+x);
			queries--;
		}
	
		
	}
}
