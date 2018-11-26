package com.circularQueue.prac;

import java.util.Scanner;

public class MainConcept {

	public static void main(String[] args) {
		char[] circularQueue = new char[5];
		Scanner sc = new Scanner(System.in);
		
		// Setting front, rear and count variable
		int front = 0, rear = 0, count = 0;
		
		// For infinite loop
		while(true) {
			System.out.println("Enter 1 for insertion and 2 for deletion operation...");
			int option = sc.nextInt();
			if(option == 1) {
				// Perform insertion
				System.out.println("Enter char to put in Data structure ...");
				char c = sc.next().charAt(0);
				boolean overflow = pushToQueue(circularQueue,rear,front,circularQueue.length,c);
				if(overflow) {
					System.out.println("Queue is Full cannot insert anymore...please delete some element first");
				}else {
					System.out.println("Inserted element :"+c);
					count++;
					rear++;
				}
				printArray(circularQueue);
			}else if(option == 2) {
				// Perform deletion
				System.out.println("Enter R for deleting from rear side and F for delelting from Front side....");
				char ch = sc.next().charAt(0);
				boolean underFlow = popFromQueue(circularQueue,rear,front,circularQueue.length,ch,count);
				if(underFlow) {
					System.out.println("Queue is empty, please insert some element first...");
				}else {
					if(ch == 'R') {
						rear--;
					}else if(ch == 'F') {
						front++;
					}
					count--;
				}
				printArray(circularQueue);
			}else {
				System.out.println("Invalid Operation seleted");
			}
			System.out.println("Front Position :"+front+" raer position :"+rear);
		}
	}
	
	public static boolean popFromQueue(char[] queue, int rear, int front, int size, char ch,int count) {
		boolean underFlow = false;
		// Check if it is already empty
		if(count != 0) {
			if(ch == 'R') {
				// Deleting from rear side
				// making empty area filled with -1 for now
				queue[--rear] = (char) -1; 
			}else if(ch == 'F') {
				// making empty area filled with -1 for now
				queue[front] = (char) -1; 
			}else {
				System.out.println("Invalid option selected..");
			}
		}else {
			System.out.println("Queue is already empty!!!");
			underFlow = true;
		}
		return underFlow;
	}
	
	public static boolean pushToQueue(char[] queue, int rear, int front, int size, char c) {
		// Check if it already full
		boolean overflow = false;
		if(rear != size) {
			queue[rear] = c; 
		}else {
			System.out.println("Queue is full, checking to insert from other end...");
			// Code to check if we can insert from front
			try {
				if(queue[front] == -1 || queue[front] == ' ') {
					queue[front] = c;
				}else {
					overflow = true;
				}
			}catch(NullPointerException e) {
				System.out.println("Null Pointer Occured!!!");
			}
		}
		return overflow;
	}
	
	public static void printArray(char[] queue) {
		System.out.println("");
		for(char c : queue) {
			System.out.print(c+" ");
		}
	}

}
