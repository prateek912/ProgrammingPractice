package com.java.scannerclassTest;

import java.util.Scanner;

public class NextLineMethodIssue {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        System.out.println("Enter an integer");
        int a = scn.nextInt();
        System.out.println("Enter a String");
        String b = scn.nextLine();
        System.out.printf("You have entered:- "
                + a + " " + "and name as " + b);
        
        
        /*
         * In Scanner class if we call nextLine() method after any one of the seven nextXXX() method then the nextLine() DOES 			NOT READ VALUES.
         * */
	}

}
