package com.java.bufferedreaderClassTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		//Taking initial time 
		Calendar starttime = Calendar.getInstance();
		System.out.println("Start time :"+starttime.getTime());;
		
		int startValue = 0;
		int endValue = 20;
		int sum=0;
		while(startValue <= endValue) {
			int temp = Integer.parseInt(br.readLine());
			//System.out.println("Inserted value :"+temp);
			sum =+ temp;
			startValue++;
		}

		System.out.println("Total Sum :"+sum);
		Calendar endtime = Calendar.getInstance();
		System.out.println("Start time :"+endtime.getTime());;
		
		System.out.println("Time Difference is :"+ (endtime.getTimeInMillis() - starttime.getTimeInMillis()));
		
	}

}
