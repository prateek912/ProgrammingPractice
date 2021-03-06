package com.java.prac;

import java.util.Scanner;

public class Main {

	static char[] queue = null;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int steps = sc.nextInt();
		String str = sc.next();
		
		queue = new char[100];
		char[] chArray = str.toCharArray();
		
		int front = 0;
		int rear = 0;
		
		for(char c : chArray) {
			pushToQueue(c,rear,queue.length);
			rear++;
		}
		
		while(steps > 0) {
			System.out.println("Front :"+front+" and rear :"+rear);
			popFromQueue(front,rear,queue.length);
			front++;
			rear++;
			steps--;
		}
		
		// To Print Final Array
		int temp = front;
		while(temp < rear) {
			System.out.print(queue[temp]+" ");
			temp++;
		}
		
	}
	
	public static void popFromQueue(int front, int rear,int size) {
		// Check to see if it is already empty or not
		if(front != rear) {
			char c = queue[front];
			
			// Now placed it at last
			queue[rear] = c;
			
		}else {
			System.out.println("Queue is UnderFlowed!!");
		}
	}

	public static void pushToQueue(char c, int rear, int size) {
		// Check to see if it is full 
		if(rear != size) {
			queue[rear] = c;
		}else {
			System.out.println("Queue is OverFlowed!!");
		}
	}
	
}
