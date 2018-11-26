package com.java.scannerclassTest;

import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Taking initial time 
		Calendar starttime = Calendar.getInstance();
		System.out.println("Start time :"+starttime.getTime());;
		
		int startValue = 0;
		int endValue = 20;
		int sum=0;
		Scanner sc = new Scanner(System.in);
		while(startValue <= endValue) {
			sum =+ sc.nextInt();
			startValue++;
		}
		
		System.out.println("Total Sum :"+sum);
		Calendar endtime = Calendar.getInstance();
		System.out.println("Start time :"+endtime.getTime());;
		System.out.println("Time Difference is :"+ (endtime.getTimeInMillis() - starttime.getTimeInMillis()));
	}

}
